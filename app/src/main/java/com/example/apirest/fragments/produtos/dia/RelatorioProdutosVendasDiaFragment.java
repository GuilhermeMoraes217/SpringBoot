package com.example.apirest.fragments.produtos.dia;

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
import com.example.apirest.activity.produtos.InformacoesProdutosRelatorioActivity;
import com.example.apirest.adapter.AdapterRelatorioProdutos;
import com.example.apirest.model.Produtos;
import com.example.apirest.model.RelatorioProdutos;
import com.example.apirest.model.vendas.FormaPagamento;
import com.example.apirest.model.vendas.VendasDetalhes;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.model.vendas.Vendasfpg;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.FormaPagamentoService;
import com.example.apirest.utils.ProdutosService;
import com.example.apirest.utils.VendasDetalhesService;
import com.example.apirest.utils.VendasMasterService;
import com.example.apirest.utils.VendasfpgService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RelatorioProdutosVendasDiaFragment extends Fragment implements AdapterRelatorioProdutos.ItemClickListener {

    /**
     * Atributos que irao receber o popular as classes Empresas
     */
    VendasDetalhesService vendasDetalhesService;
    List<VendasDetalhes> vendasDetalhesList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes VendasMaster
     */
    VendasMasterService vendasMasterService;
    List<VendasMaster> listVendasMaster = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes Produtos
     */
    ProdutosService produtosService;
    List<Produtos> vendasProdutosList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes Vendasfpg
     */
    VendasfpgService vendasfpgServiceDia;
    List<Vendasfpg> listvendasfpgDia = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes FormaPagamento
     */
    FormaPagamentoService formaPagamentoServiceDia;
    List<FormaPagamento> listformaPagamentoDia = new ArrayList<>();

    /**
     * Atributos da inicialização do recyclerView do relatorio de produtos
     */
    private RecyclerView recyclerViewRelatorioProdutos;
    private AdapterRelatorioProdutos adapterRelatorioProdutos;
    ArrayList<RelatorioProdutos> relatorioProdutos = new ArrayList<>();

    /**
     * Atributos dos textView da activity relatorio_de_Produtos
     */
    private TextView textViewPorcentagemGeral, textviewPorcentagemGeral2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relatorio_produtos_vendas, container, false);

        inicializaComponentes(view);
        RecuperaListProdutos();
        inicializaRecyclerView(view);

        return view;
    }

    /**
     * Método que inicializa o recycler view do relatorio de Produtos
     */
    private void inicializaRecyclerView(View view) {
        recyclerViewRelatorioProdutos.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewRelatorioProdutos.setHasFixedSize(true);
        adapterRelatorioProdutos = new AdapterRelatorioProdutos(vendasDetalhesList, getContext(), this);
        recyclerViewRelatorioProdutos.setAdapter(adapterRelatorioProdutos);
    }

    /**
     * Método que recupera do banco de dados MySQl os dados que iram ser preenchidos na classe RelatorioProdutos.
     */
    public void RecuperaListProdutos() {
        produtosService = Apis.getProdutos();
        Call<List<Produtos>> call = produtosService.getProdutosService();
        call.enqueue(new Callback<List<Produtos>>() {
            @Override
            public void onResponse(Call<List<Produtos>> call, Response<List<Produtos>> response) {
                vendasProdutosList.clear();
                if (response.isSuccessful()) {
                    vendasProdutosList = response.body();
                }
                RecuperaListVendasMaster();
            }

            @Override
            public void onFailure(Call<List<Produtos>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });
    }

    public void RecuperaListVendasMaster() {
        vendasMasterService = Apis.getVendasMasterService();
        Call<List<VendasMaster>> call = vendasMasterService.getVendasMaster();
        call.enqueue(new Callback<List<VendasMaster>>() {
            @Override
            public void onResponse(Call<List<VendasMaster>> call, Response<List<VendasMaster>> response) {
                listVendasMaster.clear();
                if (response.isSuccessful()) {
                    listVendasMaster = response.body();
                }
                RecuperalistVendasfpg();
            }

            @Override
            public void onFailure(Call<List<VendasMaster>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void RecuperalistVendasfpg() {
        vendasfpgServiceDia = Apis.getVendasfpgService();
        Call<List<Vendasfpg>> call = vendasfpgServiceDia.getVendasfpg();
        call.enqueue(new Callback<List<Vendasfpg>>() {
            @Override
            public void onResponse(Call<List<Vendasfpg>> call, Response<List<Vendasfpg>> response) {
                listvendasfpgDia.clear();
                if (response.isSuccessful()) {
                    listvendasfpgDia = response.body();
                }
                RecuperalistFormaPagamento();

            }

            @Override
            public void onFailure(Call<List<Vendasfpg>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void RecuperalistFormaPagamento() {
        formaPagamentoServiceDia = Apis.getFormaPagamentoService();
        Call<List<FormaPagamento>> call = formaPagamentoServiceDia.getFormaPagamento();
        call.enqueue(new Callback<List<FormaPagamento>>() {
            @Override
            public void onResponse(Call<List<FormaPagamento>> call, Response<List<FormaPagamento>> response) {
                listformaPagamentoDia.clear();
                if (response.isSuccessful()) {
                    listformaPagamentoDia = response.body();
                }
                RecuperaListVendasDetalhes();
            }

            @Override
            public void onFailure(Call<List<FormaPagamento>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void RecuperaListVendasDetalhes() {
        vendasDetalhesService = Apis.getVendasDetalhesService();
        Call<List<VendasDetalhes>> call = vendasDetalhesService.getVendasDetalhes();
        call.enqueue(new Callback<List<VendasDetalhes>>() {
            @Override
            public void onResponse(Call<List<VendasDetalhes>> call, Response<List<VendasDetalhes>> response) {
                vendasDetalhesList.clear();
                if (response.isSuccessful()) {
                    List<VendasDetalhes> vendasDetalhesList1 = response.body();

                    /**
                     * LIMITANTO A DATA PARA SOMENTE PARA DATA ATUAL
                     */
                    Date d = new Date();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDateAtual = df.format(d);

                    for (VendasMaster vendasMaster1 : listVendasMaster) {
                        if (vendasMaster1.getData_emissao().equals(formattedDateAtual)) {
                            for (VendasDetalhes vendasDetalhes : vendasDetalhesList1) {
                                for (Produtos produtos : vendasProdutosList) {
                                    if (vendasDetalhes.getFkvenda() == vendasMaster1.getCodigo() && vendasDetalhes.getId_produto() == produtos.getCodigo()) {
                                        if (vendasMaster1.getTotal() > 0 && vendasMaster1.getSituacao().equals("F")) {
                                            vendasDetalhes.setNomeProduto(produtos.getDescricao());
                                            vendasDetalhes.setReferenciaProduto(produtos.getReferencia());
                                            vendasDetalhesList.add(vendasDetalhes);
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
                adapterRelatorioProdutos.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<VendasDetalhes>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });
    }

    private void inicializaComponentes(View view) {
        recyclerViewRelatorioProdutos = view.findViewById(R.id.recyclerViewRelatorioProdutos);
        textViewPorcentagemGeral = view.findViewById(R.id.text2);
        textviewPorcentagemGeral2 = view.findViewById(R.id.textView15);

    }

    @Override
    public void onClick(VendasDetalhes relatorioProdutos) {
        Intent intent = new Intent(getActivity(), InformacoesProdutosRelatorioActivity.class);
        intent.putExtra("relatorioProdutoSelecionados", relatorioProdutos);
        startActivity(intent);
    }
}