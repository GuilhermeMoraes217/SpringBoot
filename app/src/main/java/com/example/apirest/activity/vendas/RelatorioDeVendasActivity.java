package com.example.apirest.activity.vendas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.adapter.AdapterRelatorioVendas;
import com.example.apirest.fragments.vendas.InformacaoPedidoFragment;
import com.example.apirest.fragments.vendas.RelatorioVendasFragment;
import com.example.apirest.model.RelatorioVendas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RelatorioDeVendasActivity extends AppCompatActivity implements AdapterRelatorioVendas.ItemClickListener {
    /**
     * Atributos da inicialização do recyclerView do relatorio de vendas
     */
    private RecyclerView recyclerViewRelatorioProdutos;
    private AdapterRelatorioVendas adapterRelatorioVendas;
    ArrayList<RelatorioVendas> relatorioVendas = new ArrayList<>();

    /**
     * Atributos dos textView da activity relatorio_de_vendas
     */
    private TextView textViewDataRelatorio, textviewNumeroPedidos, textViewValorVendas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_de_vendas);

        inicializaComponentes();
        recuperaRelatoriosVendas();
        inicializaRecyclerView();

    }

    /**
     * Método que inicializa o recycler view do relatorio de vendas
     */
    private void inicializaRecyclerView() {
        recyclerViewRelatorioProdutos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRelatorioProdutos.setHasFixedSize(true);
        adapterRelatorioVendas = new AdapterRelatorioVendas(relatorioVendas, this, this);
        recyclerViewRelatorioProdutos.setAdapter(adapterRelatorioVendas);
    }

    /**
     * Método que recupera do banco de dados MySQl os dados que iram ser preenchidos na classe RelatorioVendas.
     */
    private void recuperaRelatoriosVendas () {
        RelatorioVendas relatorioVendas1 = new RelatorioVendas();
        relatorioVendas1.setIdRelatorio("12345678");
        relatorioVendas1.setTextConsumidor("CONSUMIDOR");
        relatorioVendas1.setTextEmpresa("Sigatec Sistemas");
        relatorioVendas1.setTextStatusFatura("Faturado");
        relatorioVendas1.setTextValorFaturado(100.0);
        relatorioVendas1.setTextTabelaPreco("#1 TABELA DE PREÇOS");
        relatorioVendas1.setTextTabelaPedido("#1 TABELA DE PEDIDOS");
        relatorioVendas1.setTextUsuario("Guilherme Moraes");
        relatorioVendas1.setTextDataEmissao("10/02/2023");
        relatorioVendas1.setTextDataPrevisao("10/02/2023");
        relatorioVendas1.setTextDataSaida("10/02/2023");
        relatorioVendas1.setTextHorarioVenda("10/02/2023, 10:26");
        relatorioVendas1.setTextPagamentoPVD("########");
        relatorioVendas1.setTextDinheiro(100.0);

        relatorioVendas.add(relatorioVendas1);
    }

    private void inicializaComponentes() {
        recyclerViewRelatorioProdutos = findViewById(R.id.recyclerViewRelatorioProdutos);
        textViewDataRelatorio = findViewById(R.id.textViewDataRelatorio);
        textviewNumeroPedidos = findViewById(R.id.textviewNumeroPedidos);
        textViewValorVendas = findViewById(R.id.textViewValorVendas);

    }

    @Override
    public void onClick(RelatorioVendas relatorioVendas) {
        Intent intent = new Intent(RelatorioDeVendasActivity.this, InformacoesPedidoActivity.class);
        intent.putExtra("relatorioVendasSelecionados", relatorioVendas);
        startActivity(intent);
    }
}