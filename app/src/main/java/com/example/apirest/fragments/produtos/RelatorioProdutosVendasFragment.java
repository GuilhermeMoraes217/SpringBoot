package com.example.apirest.fragments.produtos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.activity.produtos.InformacoesProdutosRelatorioActivity;
import com.example.apirest.adapter.AdapterRelatorioProdutos;
import com.example.apirest.model.RelatorioProdutos;

import java.util.ArrayList;


public class RelatorioProdutosVendasFragment extends Fragment implements AdapterRelatorioProdutos.ItemClickListener {

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
        recuperaRelatoriosVendas(view);
        inicializaRecyclerView(view);

        return view;
    }

    /**
     * Método que inicializa o recycler view do relatorio de Produtos
     */
    private void inicializaRecyclerView(View view) {
        recyclerViewRelatorioProdutos.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewRelatorioProdutos.setHasFixedSize(true);
        adapterRelatorioProdutos = new AdapterRelatorioProdutos(relatorioProdutos, getContext(), this);
        recyclerViewRelatorioProdutos.setAdapter(adapterRelatorioProdutos);
    }

    /**
     * Método que recupera do banco de dados MySQl os dados que iram ser preenchidos na classe RelatorioProdutos.
     */
    private void recuperaRelatoriosVendas (View view) {
        RelatorioProdutos relatorioProdutos1 = new RelatorioProdutos();
        relatorioProdutos1.setIdRelatorio("#777");
        relatorioProdutos1.setIdRelatorio_R("#777-R");
        relatorioProdutos1.setIdGeral("#77777777");
        relatorioProdutos1.setNomeProduto("Palmito da Sigatec Sistemas");
        relatorioProdutos1.setPreco_1(15.50);
        relatorioProdutos1.setPreco_2(25.50);
        relatorioProdutos1.setPorcentagem_1(7.57);
        relatorioProdutos1.setPorcentagem_2(10);

        relatorioProdutos.add(relatorioProdutos1);
    }

    private void inicializaComponentes(View view) {
        recyclerViewRelatorioProdutos = view.findViewById(R.id.recyclerViewRelatorioProdutos);
        textViewPorcentagemGeral = view.findViewById(R.id.text2);
        textviewPorcentagemGeral2 = view.findViewById(R.id.textView15);

    }

    @Override
    public void onClick(RelatorioProdutos relatorioProdutos) {
        Intent intent = new Intent(getActivity(), InformacoesProdutosRelatorioActivity.class);
        intent.putExtra("relatorioProdutoSelecionados", relatorioProdutos);
        startActivity(intent);
    }
}