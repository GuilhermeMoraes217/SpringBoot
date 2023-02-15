package com.example.apirest.activity.vendas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.adapter.AdapterRelatorioVendas;
import com.example.apirest.fragments.vendas.InformacaoPedidoFragment;
import com.example.apirest.fragments.vendas.RelatorioVendasFragment;
import com.example.apirest.model.RelatorioVendas;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.VendasMasterService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    /**
     * Atributos que irao receber o popular as classes VendasMaster
     */
    VendasMasterService vendasMasterService;
    List<VendasMaster> listVendasMaster = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_de_vendas);

        inicializaComponentes();
        RecuperaListVendasMaster();
        inicializaRecyclerView();

    }

    /**
     * Método que inicializa o recycler view do relatorio de vendas
     */
    private void inicializaRecyclerView() {
        recyclerViewRelatorioProdutos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRelatorioProdutos.setHasFixedSize(true);
        adapterRelatorioVendas = new AdapterRelatorioVendas(listVendasMaster, this, this);
        recyclerViewRelatorioProdutos.setAdapter(adapterRelatorioVendas);
    }

    /**
     * Método que recupera do banco de dados MySQl os dados que iram ser preenchidos na classe RelatorioVendas.
     */
    public void RecuperaListVendasMaster(){
        vendasMasterService= Apis.getVendasMasterService();
        Call<List<VendasMaster>> call=vendasMasterService.getVendasMaster();
        call.enqueue(new Callback<List<VendasMaster>>() {
            @Override
            public void onResponse(Call<List<VendasMaster>> call, Response<List<VendasMaster>> response) {
                if(response.isSuccessful()) {

                    List <VendasMaster> vendasMaster = response.body();

                    for (VendasMaster vendasMaster1 : vendasMaster) {
                        if (vendasMaster1.getTotal() > 0 && vendasMaster1.getSituacao().equals("F")) {
                            listVendasMaster.add(vendasMaster1);
                        }
                    }
                    adapterRelatorioVendas.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<VendasMaster>> call, Throwable t) {
                Log.e("Error:",t.getMessage());

            }
        });

    }


    private void inicializaComponentes() {
        recyclerViewRelatorioProdutos = findViewById(R.id.recyclerViewRelatorioProdutos);
        textViewDataRelatorio = findViewById(R.id.textViewDataRelatorio);
        textviewNumeroPedidos = findViewById(R.id.textviewNumeroPedidos);
        textViewValorVendas = findViewById(R.id.textViewValorVendas);

    }

    @Override
    public void onClick(VendasMaster relatorioVendas) {
        Intent intent = new Intent(RelatorioDeVendasActivity.this, InformacoesPedidoActivity.class);
        intent.putExtra("relatorioVendasSelecionados", relatorioVendas);
        startActivity(intent);
    }
}