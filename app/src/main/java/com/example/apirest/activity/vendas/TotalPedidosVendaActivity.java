package com.example.apirest.activity.vendas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.adapter.vendas.AdapterTotalPedidoVenda;
import com.example.apirest.model.RelatorioVendas;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.GetMask;
import com.example.apirest.utils.VendasMasterService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TotalPedidosVendaActivity extends AppCompatActivity implements AdapterTotalPedidoVenda.ItemClickListener {

    /**
     * Atributos da inicialização do recyclerView do totalPedidosVendas
     */
    private RecyclerView recyclerViewRelatorioProdutos;
    private AdapterTotalPedidoVenda adapterTotalPedidoVenda;
    ArrayList<RelatorioVendas> relatorioVendas = new ArrayList<>();

    /**
     * Atributos dos textView da activity totalPedidosVendas
     */
    private TextView textViewDataRelatorio, textviewNumeroPedidos, textViewValorVendas;
    private TextView textViewListaVazia;


    /**
     * Atributos que irao receber o popular as classes VendasMaster
     */
    VendasMasterService vendasMasterService;
    List<VendasMaster> listTotalPedidos = new ArrayList<>();

    /**
     * Atributos variddos do layout totalPedidosVendas
     */
    private Double valorTotalPedido = 0.0;
    private ProgressBar progressBar, progressBarPedidos, progressBarValorPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_pedidos_venda);

        inicializaComponentes();
        RecuperaListVendasMaster();
        inicializaRecyclerView();
    }

    /**
     * Método que inicializa o recycler view do totalPedidosVendas
     */
    private void inicializaRecyclerView() {
        recyclerViewRelatorioProdutos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRelatorioProdutos.setHasFixedSize(true);
        adapterTotalPedidoVenda = new AdapterTotalPedidoVenda(listTotalPedidos, this, this);
        recyclerViewRelatorioProdutos.setAdapter(adapterTotalPedidoVenda);
    }

    /**
     * Método que recupera do banco de dados MySQl os dados que iram ser preenchidos na classe vendas_master.
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
                        if (vendasMaster1.getTotal() > 0 && vendasMaster1.getNome() != null) {
                            listTotalPedidos.add(vendasMaster1);
                            valorTotalPedido +=vendasMaster1.getTotal();
                        }
                    }

                    progressBar.setVisibility(View.GONE);
                    progressBarPedidos.setVisibility(View.GONE);
                    progressBarValorPedidos.setVisibility(View.GONE);

                    adapterTotalPedidoVenda.notifyDataSetChanged();
                    textviewNumeroPedidos.setText(Integer.toString(listTotalPedidos.size()) + " pedidos");
                    textViewValorVendas.setText("R$ " + GetMask.getValor(valorTotalPedido));
                }
            }

            @Override
            public void onFailure(Call<List<VendasMaster>> call, Throwable t) {
                Log.e("Error:",t.getMessage());

                progressBar.setVisibility(View.GONE);
                progressBarPedidos.setVisibility(View.GONE);
                progressBarValorPedidos.setVisibility(View.GONE);

                textViewListaVazia.setVisibility(View.VISIBLE);
                textViewListaVazia.setText("Nenhuma venda realizada");

                textviewNumeroPedidos.setText(Integer.toString(0) + " pedidos");
                textViewValorVendas.setText("R$ " + GetMask.getValor(0.0));

            }
        });

    }


    private void inicializaComponentes() {
        recyclerViewRelatorioProdutos = findViewById(R.id.recyclerViewRelatorioProdutos);
        textViewDataRelatorio = findViewById(R.id.textViewDataRelatorio);
        textviewNumeroPedidos = findViewById(R.id.textviewNumeroPedidos);
        textViewValorVendas = findViewById(R.id.textViewValorVendas);

        progressBar = findViewById(R.id.progressBar);
        progressBarPedidos = findViewById(R.id.progressBarPedidos);
        progressBarValorPedidos = findViewById(R.id.progressBarValorPedidos);

        textViewListaVazia = findViewById(R.id.textListaVazia);

    }

    @Override
    public void onClick(VendasMaster relatorioVendas) {
        Intent intent = new Intent(TotalPedidosVendaActivity.this, InformacoesPedidoActivity.class);
        intent.putExtra("relatorioTotalPedido", relatorioVendas);
        startActivity(intent);
    }
}