package com.example.apirest.fragments.vendas.totalcancelado;

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
import com.example.apirest.adapter.vendas.totalcancelado.AdapterInformacaoTotalGrupoPedidoCancelado;
import com.example.apirest.adapter.vendas.totalpedidos.AdapterInformacaoTotalGrupoPedidoVenda;
import com.example.apirest.model.Produtos;
import com.example.apirest.model.vendas.VendasDetalhes;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.GetMask;
import com.example.apirest.utils.ProdutosService;
import com.example.apirest.utils.VendasDetalhesService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InformacaoTotalGrupoPedidoCanceladoFragment extends Fragment implements AdapterInformacaoTotalGrupoPedidoCancelado.ItemClickListener {

    /**
     * Atributos que irao receber o popular as classes Empresas
     */
    VendasDetalhesService vendasDetalhesService;
    List<VendasDetalhes> vendasDetalhesList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes Produtos
     */
    ProdutosService produtosService;
    List<Produtos> vendasProdutosList = new ArrayList<>();

    /**
     *Atributos variados do layout informacaoGrupo
     */

    private RecyclerView recyclerViewListProdutos;
    private AdapterInformacaoTotalGrupoPedidoCancelado adapterInformacaoGrupoPedido;

    private TextView textViewValorTotal, textViewValorTotalProduto, textViewValorTotalAcrescimo, textViewValorTotalDesconto, textViewTotalPedido,
            textViewValorTotalSeguro, textViewValorTotalFrete, textViewValorTotalIPI, textViewValorTotalIcmsSt,
            textViewValorTotalFcpSt;


    VendasMaster relatorioVendas;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacao_total_grupo_pedido_cancelado, container, false);
        Bundle bundle = getActivity().getIntent().getExtras();
        relatorioVendas = (VendasMaster) bundle.getSerializable("relatorioPedidoCancelado");
        inicializaComponentes(view);
        exibeComponentes();
        RecuperaListProdutos();
        inicializaRecyclerView();


        return view;
    }

    private void exibeComponentes() {

        textViewValorTotal.setText("R$ " + GetMask.getValor(relatorioVendas.getTotal()));
        textViewValorTotalProduto.setText("R$ " + GetMask.getValor(relatorioVendas.getSubtotal()));
        textViewValorTotalAcrescimo.setText("R$ " + GetMask.getValor(relatorioVendas.getAcrescimo()));
        textViewValorTotalDesconto.setText("R$ " + GetMask.getValor(relatorioVendas.getDesconto()));

    }

    /**
     * Método que inicializa o recycler view do relatorio de vendas
     */
    private void inicializaRecyclerView() {
        recyclerViewListProdutos.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewListProdutos.setHasFixedSize(true);
        adapterInformacaoGrupoPedido = new AdapterInformacaoTotalGrupoPedidoCancelado(vendasDetalhesList, getContext(), this);
        recyclerViewListProdutos.setAdapter(adapterInformacaoGrupoPedido);
    }

    /**
     * Método que recupera do banco de dados MySQl os dados que iram ser preenchidos na classe vendasDetalhes.
     */
    public void RecuperaListVendasDetalhes(){
        vendasDetalhesService = Apis.getVendasDetalhesService();
        Call<List<VendasDetalhes>> call= vendasDetalhesService.getVendasDetalhes();
        call.enqueue(new Callback<List<VendasDetalhes>>() {
            @Override
            public void onResponse(Call<List<VendasDetalhes>> call, Response<List<VendasDetalhes>> response) {
                if(response.isSuccessful()) {
                    List <VendasDetalhes> vendasDetalhesList1 = response.body();

                    for (VendasDetalhes vendasDetalhes: vendasDetalhesList1) {
                        for (Produtos produtos: vendasProdutosList) {
                            if (vendasDetalhes.getFkvenda() == relatorioVendas.getCodigo() && vendasDetalhes.getId_produto() == produtos.getCodigo()) {
                                vendasDetalhes.setNomeProduto(produtos.getDescricao());
                                vendasDetalhes.setReferenciaProduto(produtos.getReferencia());
                                vendasDetalhesList.add(vendasDetalhes);
                            }
                        }
                    }

                    textViewTotalPedido.setText(vendasDetalhesList.size() + " itens no pedido");
                    adapterInformacaoGrupoPedido.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<VendasDetalhes>> call, Throwable t) {
                Log.e("Error:",t.getMessage());

            }
        });
    }

    public void RecuperaListProdutos(){
        produtosService = Apis.getProdutos();
        Call<List<Produtos>> call= produtosService.getProdutosService();
        call.enqueue(new Callback<List<Produtos>>() {
            @Override
            public void onResponse(Call<List<Produtos>> call, Response<List<Produtos>> response) {
                if(response.isSuccessful()) {
                    vendasProdutosList = response.body();
                }
                RecuperaListVendasDetalhes();
            }

            @Override
            public void onFailure(Call<List<Produtos>> call, Throwable t) {
                Log.e("Error:",t.getMessage());

            }
        });
    }


    private void inicializaComponentes(View view) {
        recyclerViewListProdutos = view.findViewById(R.id.recyclerView);


        //TEXTVIEW
        textViewValorTotal = view.findViewById(R.id.textViewValorTotal);
        textViewValorTotalProduto = view.findViewById(R.id.textView37);
        textViewValorTotalAcrescimo = view.findViewById(R.id.textView38);
        textViewValorTotalDesconto = view.findViewById(R.id.textView39);
        textViewValorTotalSeguro = view.findViewById(R.id.textView40);
        textViewValorTotalFrete = view.findViewById(R.id.textView41);
        textViewValorTotalIPI = view.findViewById(R.id.textView42);
        textViewValorTotalIcmsSt = view.findViewById(R.id.textView43);
        textViewValorTotalFcpSt = view.findViewById(R.id.textViewValorTotalFcp);
        textViewTotalPedido = view.findViewById(R.id.textView44);
    }

    @Override
    public void onClick(VendasDetalhes relatorioVendas) {

    }
}