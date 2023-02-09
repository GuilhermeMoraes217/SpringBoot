package com.example.apirest.activity.vendas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.adapter.AdapterRelatorioVendas;
import com.example.apirest.model.RelatorioVendas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RelatorioDeVendasActivity extends AppCompatActivity {
    /**
     * Atributos da inicialização do recyclerView do relatorio de vendas
     */
    private RecyclerView recyclerViewRelatorioProdutos;
    private AdapterRelatorioVendas adapterRelatorioVendas;
    ArrayList<RelatorioVendas> relatorioVendas;

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

    private void inicializaRecyclerView() {
        recyclerViewRelatorioProdutos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRelatorioProdutos.setHasFixedSize(true);
        adapterRelatorioVendas = new AdapterRelatorioVendas(relatorioVendas, this);
        recyclerViewRelatorioProdutos.setAdapter(adapterRelatorioVendas);
    }

    private void recuperaRelatoriosVendas () {
        /*List<String> dynamicText2Elements;
        dynamicText2Elements = new ArrayList<String>();
        dynamicText2Elements.add("element1 of text2");
        dynamicText2Elements.add("element2 of text2");
        dynamicText2Elements.add("element3 of text2");
        dynamicText2Elements.add("element4 of text2");
        dynamicText2Elements.add("element5 of text2");

        List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> element;

        int length = getResources().getStringArray(staticText1Elements).length;

        for (int i = 0; i < length; i++) {
            element = new HashMap<String, String>();
            element.put("text1", getResources().getStringArray(staticText1Elements)[i]);
            element.put("text2", dynamicText2Elements.get(i));
            dataList.add(element);
        }*/
    }

    private void inicializaComponentes() {
        recyclerViewRelatorioProdutos = findViewById(R.id.recyclerViewRelatorioProdutos);
        textViewDataRelatorio = findViewById(R.id.textViewDataRelatorio);
        textviewNumeroPedidos = findViewById(R.id.textviewNumeroPedidos);
        textViewValorVendas = findViewById(R.id.textViewValorVendas);

    }

}