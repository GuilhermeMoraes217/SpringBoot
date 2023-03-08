package com.example.apirest.fragments.contas.ano;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.activity.contas.ano.ContasReceberInformacoesAnoActivity;
import com.example.apirest.activity.contas.mes.ContasReceberInformacoesMesActivity;
import com.example.apirest.adapter.contas.AdapterRelatorioContasReceberDia;
import com.example.apirest.interfaces.CReceberService;
import com.example.apirest.interfaces.EmpresasService;
import com.example.apirest.interfaces.FormaPagamentoService;
import com.example.apirest.interfaces.PessoasService;
import com.example.apirest.interfaces.VendasMasterService;
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


public class RelatorioContasReceberAnoFragment extends Fragment implements AdapterRelatorioContasReceberDia.ItemClickListener {

    /**
     * Atributos que irao receber o popular as classes Forma de Pagamento
     */
    FormaPagamentoService formaPagamentoService;
    List<FormaPagamento> formaPagamentoList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes Vendas Master
     */
    VendasMasterService vendasMasterService;
    List<VendasMaster> vendasMasterList = new ArrayList<>();
    List<VendasMaster> updateVendasMasterList = new ArrayList<>();
    List<VendasMaster> updateVendasMasterList2 = new ArrayList<>();

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
     * ATRIBUTOS ALEATORIOS DO LAYOUT
     */
    static List<String> stringsData = new ArrayList<>();

    private TextView totalContasAbertoTextView, valorTotalContasAbertasTextView, textInfo;
    private RecyclerView recyclerViewContasAbertas;
    private ProgressBar progressBar2;

    AdapterRelatorioContasReceberDia adapterRelatorioContasReceberDia;

    Date date1 = null;
    Date date2 = null;
    String formattedDateAtual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relatorio_contas_receber_ano, container, false);

        inicializaComponentes(view);
        recuperaDataSemana();
        listvendasMaster();
        inicializaRecyclerView();

        return view;
    }

    /**
     * Método que inicializa o recycler view do relatorio de vendas e Creceber
     */
    private void inicializaRecyclerView() {
        recyclerViewContasAbertas.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewContasAbertas.setHasFixedSize(true);
        adapterRelatorioContasReceberDia = new AdapterRelatorioContasReceberDia(updateVendasMasterList2, cRecebersList, getContext(), this);
        recyclerViewContasAbertas.setAdapter(adapterRelatorioContasReceberDia);
    }

    public void listvendasMaster() {
        vendasMasterService = Apis.getVendasMasterService();
        Call<List<VendasMaster>> call = vendasMasterService.getVendasMaster();
        call.enqueue(new Callback<List<VendasMaster>>() {
            @Override
            public void onResponse(Call<List<VendasMaster>> call, Response<List<VendasMaster>> response) {
                vendasMasterList.clear();
                if (response.isSuccessful()) {
                    vendasMasterList = response.body();
                }
                listFormaPagamento();
            }

            @Override
            public void onFailure(Call<List<VendasMaster>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

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

    public void convertendoStringInDate(String dataVecimento) {
        // FUNCAO QUE RECUPERA A DATA ATUAL E DATA DE VENCIMENTO DO BANCO E CONVERTE DE STRING PARA DATE

        //PEGANDO O VALOR DA DATA ATUAL
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formattedDateAtual = df.format(d);

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

    public static void printDatesInMonth(int year, int month, int day) {
        stringsData.clear();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, 0, 0); // alteracao aqui para listar O PADRAO É IGUAL A (0 ZERO)
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 0; j < month; j++) {
            for (int i = 0; i < daysInMonth; i++) {
                cal.add(Calendar.DAY_OF_YEAR, 1);
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
                                            for (VendasMaster vendasMaster : vendasMasterList) {
                                                if (vendasMaster.getCodigo() == cReceber.getFk_venda() && cReceber.getFpg_venda() == formaPagamento.getCodigo() && empresas.getCodigo() == cReceber.getFkempresa() && cReceber.getFkcliente() == pessoas.getCodigo() && !cReceber.getSituacao().equals("T")) {
                                                    valorTotalContasReceber += cReceber.getVl_restante();

                                                    vendasMaster.setNomeEmpresaCReceber(empresas.getRazao());
                                                    vendasMaster.setNomePessoasContaCReceber(pessoas.getFantasia());
                                                    vendasMaster.setFormapagamentoCRecerber(formaPagamento.getDescricao());
                                                    vendasMaster.setHistoricoCReceber(cReceber.getHistorico());
                                                    vendasMaster.setCodigoCreber(cReceber.getCodigo());
                                                    vendasMaster.setDocCReber(cReceber.getDoc());
                                                    vendasMaster.setDataCRecerber(cReceber.getData());

                                                    cRecebersList.add(cReceber);
                                                    updateVendasMasterList.add(vendasMaster);
                                                }
                                            }
                                        }
                                    }
                                }
                            }else{
                                progressBar2.setVisibility(View.GONE);
                                textInfo.setText("Nenhuma conta a receber");

                                totalContasAbertoTextView.setText(" 0 contas");
                                valorTotalContasAbertasTextView.setText("R$ " + GetMask.getValor(0.0));
                            }
                        }
                    }

                    for (VendasMaster vendasMaster : updateVendasMasterList) {
                        if (!updateVendasMasterList2.contains(vendasMaster)) {
                            updateVendasMasterList2.add(vendasMaster);
                        }
                    }

                    if (updateVendasMasterList2.size() > 0) {
                        progressBar2.setVisibility(View.GONE);
                        textInfo.setText(null);

                        totalContasAbertoTextView.setText(Integer.toString(updateVendasMasterList2.size()) + " contas");
                        valorTotalContasAbertasTextView.setText("R$ " + GetMask.getValor(valorTotalContasReceber));
                    }

                    adapterRelatorioContasReceberDia.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<CReceber>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void inicializaComponentes(View view) {
        totalContasAbertoTextView = view.findViewById(R.id.totalContasAbertoTextView);
        valorTotalContasAbertasTextView = view.findViewById(R.id.textView15);
        recyclerViewContasAbertas = view.findViewById(R.id.recyclerViewContasAbertas);
        textInfo = view.findViewById(R.id.textInfo);
        progressBar2 = view.findViewById(R.id.progressBar2);
    }

    @Override
    public void onClick(VendasMaster cReceber) {
        Intent intent = new Intent(getActivity(), ContasReceberInformacoesAnoActivity.class);
        intent.putExtra("RelatorioContasReceberSelecionado", cReceber);
        startActivity(intent);
    }
}