package com.example.apirest.fragments.contas.semana;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.adapter.contas.AdapterInformacaoContaParcelas;
import com.example.apirest.interfaces.CReceberService;
import com.example.apirest.interfaces.EmpresasService;
import com.example.apirest.interfaces.FormaPagamentoService;
import com.example.apirest.interfaces.PessoasService;
import com.example.apirest.model.Empresas;
import com.example.apirest.model.contas.CReceber;
import com.example.apirest.model.contas.Pessoas;
import com.example.apirest.model.vendas.FormaPagamento;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.GetMask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RelatorioContasReceberParcelaVMSemanaFragment extends Fragment implements AdapterInformacaoContaParcelas.ItemClickListener {

    /**
     * Atributos que irao receber o popular as classes Forma de Pagamento
     */
    FormaPagamentoService formaPagamentoService;
    List<FormaPagamento> formaPagamentoList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes Empresa
     */
    EmpresasService empresasService;
    List<Empresas> empresasList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes CReceber
     */
    CReceberService cReceberService;
    List<CReceber> cRecebersList = new ArrayList<>();
    List<CReceber> updateListReceber = new ArrayList<>();
    /**
     * Atributos que irao receber o popular as classes Pessoas
     */
    PessoasService pessoasService;
    List<Pessoas> pessoasList = new ArrayList<>();

    /**
     * Atributos variados do layout
     */
    static List<String> stringsData = new ArrayList<>();

    VendasMaster receberSelecionado;
    private RecyclerView recyclerViewListParcelas;
    private TextView parcelasNaContaTextView, valorTotalAcrescimoTextView, valorTotalProdutoTextView, valorTotalNominalTextView,
            valorTotalPagoTextView, valorTotalDescontoTextView, valorTotalmultaTextView, valorTotalJurosTextView, valorTotalTaxaFinanceiraTextView, textViewValorTotalTextView;

    AdapterInformacaoContaParcelas adapterInformacaoContaParcelas;
    Double valorTotalContasReceber = 0.0;
    Date date1 = null;
    Date date2 = null;
    String formattedDateAtual;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relatorio_contas_receber_parcela_v_m_semana, container, false);

        Bundle bundle = getActivity().getIntent().getExtras();
        receberSelecionado = (VendasMaster) bundle.getSerializable("RelatorioContasReceberSelecionado");
        inicializaComponentes(view);
        recuperaDataSemana();
        listFormaPagamento();
        inicializaRecyclerView();

        return view;
    }

    /**
     * Método que inicializa o recycler view do relatorio de vendas e Creceber
     */
    private void inicializaRecyclerView() {
        recyclerViewListParcelas.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewListParcelas.setHasFixedSize(true);
        adapterInformacaoContaParcelas = new AdapterInformacaoContaParcelas(cRecebersList, getContext(), this);
        recyclerViewListParcelas.setAdapter(adapterInformacaoContaParcelas);
    }

    public void listFormaPagamento() {
        formaPagamentoService = Apis.getFormaPagamentoService();
        Call<List<FormaPagamento>> call = formaPagamentoService.getFormaPagamento();
        call.enqueue(new Callback<List<FormaPagamento>>() {
            @Override
            public void onResponse(Call<List<FormaPagamento>> call, Response<List<FormaPagamento>> response) {
                formaPagamentoList.clear();
                if (response.isSuccessful()) {
                    formaPagamentoList = response.body();
                }
                listEmpresas();
            }

            @Override
            public void onFailure(Call<List<FormaPagamento>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void listEmpresas() {
        empresasService = Apis.getEmpresasService();
        Call<List<Empresas>> call = empresasService.getEmpresas();
        call.enqueue(new Callback<List<Empresas>>() {
            @Override
            public void onResponse(Call<List<Empresas>> call, Response<List<Empresas>> response) {
                empresasList.clear();
                if (response.isSuccessful()) {
                    empresasList = response.body();
                }
                listPessoas();
            }

            @Override
            public void onFailure(Call<List<Empresas>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void listPessoas() {
        pessoasService = Apis.getPessoasService();
        Call<List<Pessoas>> call = pessoasService.getPessoas();
        call.enqueue(new Callback<List<Pessoas>>() {
            @Override
            public void onResponse(Call<List<Pessoas>> call, Response<List<Pessoas>> response) {
                pessoasList.clear();
                if (response.isSuccessful()) {
                    pessoasList = response.body();
                }
                listCReceber();

            }

            @Override
            public void onFailure(Call<List<Pessoas>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public static void printDatesInMonth(int year, int month, int day) {
        stringsData.clear();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.clear();
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (day > 7) {
            cal.set(year, month - 1, day - 7);
            for (int i = day - 7; i < day; i++) {
                //System.out.println(fmt.format(cal.getTime()));
                cal.add(Calendar.DAY_OF_MONTH, 1);
                stringsData.add(fmt.format(cal.getTime()));
            }
        } else {
            cal.set(year, month - 1, 0);
            for (int i = 0; i < day; i++) {
                //System.out.println(fmt.format(cal.getTime()));
                cal.add(Calendar.DAY_OF_MONTH, 1);
                stringsData.add(fmt.format(cal.getTime()));
            }
        }
        Log.i("", "" + stringsData);

    }

    private void recuperaDataSemana() {
        int year = 0;
        int month = 0;
        int day = 0;

        Date date = new Date();
        LocalDate date1 = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            date1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            year = date1.getYear();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            month = date1.getMonthValue();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            day = date1.getDayOfMonth();
        }

        printDatesInMonth(year, month, day);
    }

    public void convertendoStringInDate(String dataVecimento) {
        // FUNCAO QUE RECUPERA A DATA ATUAL E DATA DE VENCIMENTO DO BANCO E CONVERTE DE STRING PARA DATE

        //PEGANDO O VALOR DA DATA ATUAL
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //formattedDateAtual = df.format(d);
        formattedDateAtual = "2023-03-02";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date1 = sdf.parse(formattedDateAtual);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try {
            date2 = sdf.parse(dataVecimento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public void listCReceber() {
        cReceberService = Apis.getCReceberService();
        Call<List<CReceber>> call = cReceberService.getrebecer();
        call.enqueue(new Callback<List<CReceber>>() {
            @Override
            public void onResponse(Call<List<CReceber>> call, Response<List<CReceber>> response) {
                cRecebersList.clear();
                if (response.isSuccessful()) {
                    Double valorTotalContasReceber = 0.0;
                    List<CReceber> cRecebers1 = response.body();

                    for (CReceber cReceber : cRecebers1) {
                        convertendoStringInDate(cReceber.getDtvencimento()); // RECEBENDOS AS DATAS EM FORMATO DATE
                        for (String dataSemana : stringsData) {
                            if (dataSemana.equals(cReceber.getData())) {
                                for (Pessoas pessoas : pessoasList) {
                                    for (FormaPagamento formaPagamento : formaPagamentoList) {
                                        for (Empresas empresas : empresasList) {
                                            if (cReceber.getFpg_venda() == formaPagamento.getCodigo() && empresas.getCodigo() == cReceber.getFkempresa() && cReceber.getFkcliente() == pessoas.getCodigo()) {
                                                valorTotalContasReceber += cReceber.getVl_restante();

                                                cReceber.setNomeEmpresa(empresas.getRazao());
                                                cReceber.setNomePessaReceber(pessoas.getFantasia());
                                                cReceber.setFormaPagamento(formaPagamento.getDescricao());

                                                cRecebersList.add(cReceber);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (cRecebersList.size() > 0) {
                        parcelasNaContaTextView.setText(Integer.toString(cRecebersList.size()) + " parcelas na conta");
                        textViewValorTotalTextView.setText("R$ " + GetMask.getValor(valorTotalContasReceber));
                    }
                    adapterInformacaoContaParcelas.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<CReceber>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void inicializaComponentes(View view) {
        recyclerViewListParcelas = view.findViewById(R.id.recyclerView);
        parcelasNaContaTextView = view.findViewById(R.id.textView44);
        valorTotalProdutoTextView = view.findViewById(R.id.textView37);
        valorTotalNominalTextView = view.findViewById(R.id.textView38);
        valorTotalPagoTextView = view.findViewById(R.id.textView39);
        valorTotalAcrescimoTextView = view.findViewById(R.id.textView40);
        valorTotalDescontoTextView = view.findViewById(R.id.textView41);
        valorTotalmultaTextView = view.findViewById(R.id.textView42);
        valorTotalJurosTextView = view.findViewById(R.id.textView43);
        valorTotalTaxaFinanceiraTextView = view.findViewById(R.id.textViewValorTotalFcp);
        textViewValorTotalTextView = view.findViewById(R.id.textViewValorTotal);
    }

    @Override
    public void onClick(CReceber relatorioVendas) {

    }
}