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
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.activity.contas.ContasReceberInformacoesActivity;
import com.example.apirest.adapter.contas.AdapterRelatorioContasReceberDia;
import com.example.apirest.adapter.vendas.totalvendas.AdapterRelatorioVendas;
import com.example.apirest.interfaces.CReceberService;
import com.example.apirest.interfaces.EmpresasService;
import com.example.apirest.interfaces.FormaPagamentoService;
import com.example.apirest.interfaces.PessoasService;
import com.example.apirest.model.Empresas;
import com.example.apirest.model.contas.CReceber;
import com.example.apirest.model.contas.Pessoas;
import com.example.apirest.model.vendas.FormaPagamento;
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


public class RelatorioContasReceberDiaFragment extends Fragment implements AdapterRelatorioContasReceberDia.ItemClickListener {

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

    /**
     * Atributos que irao receber o popular as classes Pessoas
     */
    PessoasService pessoasService;
    List<Pessoas> pessoasList = new ArrayList<>();


    /**
     * ATRIBUTOS ALEATORIOS DO LAYOUT
     */
    private TextView totalContasAbertoTextView, valorTotalContasAbertasTextView;
    private RecyclerView recyclerViewContasAbertas;

    AdapterRelatorioContasReceberDia adapterRelatorioContasReceberDia;

    Date date1 = null;
    Date date2 = null;
    String formattedDateAtual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relatorio_contas_receber, container, false);

        inicializaComponentes(view);
        listFormaPagamento();
        inicializaRecyclerView();

        return view;
    }

    /**
     * Método que inicializa o recycler view do relatorio de vendas
     */
    private void inicializaRecyclerView() {
        recyclerViewContasAbertas.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewContasAbertas.setHasFixedSize(true);
        adapterRelatorioContasReceberDia = new AdapterRelatorioContasReceberDia(cRecebersList, getContext(), this);
        recyclerViewContasAbertas.setAdapter(adapterRelatorioContasReceberDia);
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
                        if (formattedDateAtual.equals(cReceber.getData())) {
                            for (Pessoas pessoas : pessoasList) {
                                for (FormaPagamento formaPagamento : formaPagamentoList) {
                                    for (Empresas empresas : empresasList) {
                                        if (cReceber.getFpg_venda() == formaPagamento.getCodigo() && empresas.getCodigo() == cReceber.getFkempresa() && cReceber.getFkcliente() == pessoas.getCodigo() && !cReceber.getSituacao().equals("T")) {
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

                    if (cRecebersList.size() > 0) {
                        totalContasAbertoTextView.setText(Integer.toString(cRecebersList.size()) + " contas");
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
    }

    @Override
    public void onClick(CReceber cReceber) {
        Intent intent = new Intent(getActivity(), ContasReceberInformacoesActivity.class);
        intent.putExtra("RelatorioContasReceberSelecionado", cReceber);
        startActivity(intent);
    }
}