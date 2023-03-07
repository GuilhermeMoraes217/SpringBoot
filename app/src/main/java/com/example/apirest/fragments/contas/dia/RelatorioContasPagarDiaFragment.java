package com.example.apirest.fragments.contas.dia;

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
import com.example.apirest.activity.contas.ContasPagarInformacoesActivity;
import com.example.apirest.activity.contas.ContasReceberInformacoesActivity;
import com.example.apirest.adapter.contas.AdapterRelatorioContasPagarDia;
import com.example.apirest.interfaces.CCompraService;
import com.example.apirest.interfaces.CPagarService;
import com.example.apirest.interfaces.EmpresasService;
import com.example.apirest.interfaces.FormaPagamentoService;
import com.example.apirest.interfaces.PessoasService;
import com.example.apirest.model.Empresas;
import com.example.apirest.model.contas.CCompra;
import com.example.apirest.model.contas.CPagar;
import com.example.apirest.model.contas.CReceber;
import com.example.apirest.model.contas.Pessoas;
import com.example.apirest.model.vendas.FormaPagamento;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.GetMask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RelatorioContasPagarDiaFragment extends Fragment implements AdapterRelatorioContasPagarDia.ItemClickListener {
    /**
     * Atributos que irao receber o popular as classes Forma de Pagamento
     */
    FormaPagamentoService formaPagamentoService;
    List<FormaPagamento> formaPagamentoList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes CComprar
     */
    CCompraService cCompraService;
    List<CCompra> cCompraList = new ArrayList<>();
    List<CCompra> updatecCompraList1 = new ArrayList<>();
    List<CCompra> updatecCompraList2 = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes Empresa
     */
    EmpresasService empresasService;
    List<Empresas> empresasList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes CPagar
     */
    CPagarService cPagarService;
    List<CPagar> cPagarList = new ArrayList<>();
    List<CPagar> updateListCPagar = new ArrayList<>();
    /**
     * Atributos que irao receber o popular as classes Pessoas
     */
    PessoasService pessoasService;
    List<Pessoas> pessoasList = new ArrayList<>();

    /**
     * ATRIBUTOS ALEATORIOS DO LAYOUT
     */
    private TextView totalContasAbertoTextView, valorTotalContasAbertasTextView, textInfo;
    private RecyclerView recyclerViewContasAbertas;
    private ProgressBar progressBar2;
    AdapterRelatorioContasPagarDia adapterRelatorioContasPagarDia;

    Date date1 = null;
    Date date2 = null;
    String formattedDateAtual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relatorio_contas_pagar, container, false);

        inicializaComponentes(view);
        listCCompra();
        inicializaRecyclerView();

        return view;
    }

    /**
     * Método que inicializa o recycler view do relatorio de vendas e Creceber
     */
    private void inicializaRecyclerView() {
        recyclerViewContasAbertas.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewContasAbertas.setHasFixedSize(true);
        adapterRelatorioContasPagarDia = new AdapterRelatorioContasPagarDia(updatecCompraList2, cPagarList, getContext(), this);
        recyclerViewContasAbertas.setAdapter(adapterRelatorioContasPagarDia);
    }

    public void listCCompra() {
        cCompraService = Apis.getCCompraService();
        Call<List<CCompra>> call = cCompraService.getCcompra();
        call.enqueue(new Callback<List<CCompra>>() {
            @Override
            public void onResponse(Call<List<CCompra>> call, Response<List<CCompra>> response) {
                cCompraList.clear();
                if (response.isSuccessful()) {
                    cCompraList = response.body();
                }
                listFormaPagamento();
            }

            @Override
            public void onFailure(Call<List<CCompra>> call, Throwable t) {
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
                listCPagar();

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
        //formattedDateAtual = df.format(d);
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

    public void listCPagar() {
        cPagarService = Apis.getCPagarService();
        Call<List<CPagar>> call = cPagarService.getCpagar();
        call.enqueue(new Callback<List<CPagar>>() {
            @Override
            public void onResponse(Call<List<CPagar>> call, Response<List<CPagar>> response) {
                cPagarList.clear();
                if (response.isSuccessful()) {
                    Double valorTotalContasReceber = 0.0;
                    List<CPagar> cPagars = response.body();

                    for (CPagar cPagar : cPagars) {
                        convertendoStringInDate(cPagar.getDtvencimento()); // RECEBENDOS AS DATAS EM FORMATO DATE
                        if (formattedDateAtual.equals(cPagar.getData())) {
                            for (Empresas empresas : empresasList) {
                                for (CCompra cCompra : cCompraList) {
                                    if (cCompra.getId() == cPagar.getFk_compra() &&
                                            empresas.getCodigo() == cPagar.getFkempresa() &&
                                            !cPagar.getSituacao().equals("T")) {

                                        // && cPagar.getFpg_venda() == formaPagamento.getCodigo()
                                        //cCompra.setFormapagamentoCRecerber(formaPagamento.getDescricao());
                                        valorTotalContasReceber += cPagar.getVl_restante();

                                        cCompra.setCodigoCPagar(cCompra.getId());
                                        cCompra.setNomeEmpresaCPagar(empresas.getRazao());
                                        cCompra.setNomeEmpresaDevendoCPagar(cCompra.getNome());
                                        cCompra.setHistoricoCPagar(cPagar.getHistorico());
                                        cCompra.setDocCPagar(cPagar.getDoc());
                                        cCompra.setDataCPagar(cPagar.getData());

                                        cPagarList.add(cPagar);
                                        updatecCompraList1.add(cCompra);

                                    }
                                }
                            }
                        } else {
                            progressBar2.setVisibility(View.GONE);
                            textInfo.setText("Nenhuma conta a receber");

                            totalContasAbertoTextView.setText(" 0 contas");
                            valorTotalContasAbertasTextView.setText("R$ " + GetMask.getValor(0.0));
                        }
                    }

                    for (CCompra cCompra : updatecCompraList1) {
                        if (!updatecCompraList2.contains(cCompra)) {
                            updatecCompraList2.add(cCompra);
                        }
                    }

                    if (updatecCompraList2.size() > 0) {
                        progressBar2.setVisibility(View.GONE);
                        textInfo.setText(null);

                        totalContasAbertoTextView.setText(Integer.toString(updatecCompraList2.size()) + " contas");
                        valorTotalContasAbertasTextView.setText("R$ " + GetMask.getValor(valorTotalContasReceber));
                    }

                    adapterRelatorioContasPagarDia.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<CPagar>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void inicializaComponentes(View view) {
        totalContasAbertoTextView = view.findViewById(R.id.totalContasTextView);
        valorTotalContasAbertasTextView = view.findViewById(R.id.textView15);
        recyclerViewContasAbertas = view.findViewById(R.id.recyclerViewContasPagar);
        textInfo = view.findViewById(R.id.textInfo);
        progressBar2 = view.findViewById(R.id.progressBar2);
    }

    @Override
    public void onClick(CCompra cCompra) {
        Intent intent = new Intent(getActivity(), ContasPagarInformacoesActivity.class);
        intent.putExtra("RelatorioContasReceberSelecionado", cCompra);
        startActivity(intent);
    }
}