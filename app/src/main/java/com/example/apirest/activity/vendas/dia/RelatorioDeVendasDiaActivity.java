package com.example.apirest.activity.vendas.dia;

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
import com.example.apirest.activity.vendas.InformacoesPedidoVendaActivity;
import com.example.apirest.adapter.vendas.totalvendas.AdapterRelatorioVendas;
import com.example.apirest.model.Empresas;
import com.example.apirest.model.RelatorioVendas;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.Apis;
import com.example.apirest.interfaces.EmpresasService;
import com.example.apirest.utils.GetMask;
import com.example.apirest.interfaces.VendasMasterService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RelatorioDeVendasDiaActivity extends AppCompatActivity implements AdapterRelatorioVendas.ItemClickListener {
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
    private TextView textViewListaVazia;


    /**
     * Atributos que irao receber o popular as classes VendasMaster
     */
    VendasMasterService vendasMasterService;
    List<VendasMaster> listVendasMaster = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes Empresas
     */
    EmpresasService empresasService;
    List<Empresas> empresasList = new ArrayList<>();

    /**
     * Atributos variddos do layout
     */
    private Double valorVendas = 0.0;
    private ProgressBar progressBar, progressBarPedidos, progressBarValorPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_de_vendas_dia);

        inicializaComponentes();
        RecuperaListEmpresas();
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
    public void RecuperaListVendasMaster() {
        vendasMasterService = Apis.getVendasMasterService();
        Call<List<VendasMaster>> call = vendasMasterService.getVendasMaster();
        call.enqueue(new Callback<List<VendasMaster>>() {
            @Override
            public void onResponse(Call<List<VendasMaster>> call, Response<List<VendasMaster>> response) {
                if (response.isSuccessful()) {
                    List<VendasMaster> vendasMaster = response.body();

                    /**
                     * LIMITANTO A DATA PARA SOMENTE PARA DATA ATUAL
                     */
                    Date d = new Date();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDateAtual = df.format(d);

                    for (VendasMaster vendasMaster1 : vendasMaster) {
                        if (vendasMaster1.getData_emissao().equals(formattedDateAtual)) {
                            for (Empresas empresas : empresasList) {
                                if (vendasMaster1.getTotal() > 0 && vendasMaster1.getSituacao().equals("F") && empresas.getCodigo() == vendasMaster1.getFkempresa()) {
                                    vendasMaster1.setNomeEmpresa(empresas.getRazao());
                                    listVendasMaster.add(vendasMaster1);
                                    valorVendas += vendasMaster1.getTotal();
                                }
                            }
                        } else {
                            progressBar.setVisibility(View.GONE);
                            progressBarPedidos.setVisibility(View.GONE);
                            progressBarValorPedidos.setVisibility(View.GONE);

                            textViewListaVazia.setVisibility(View.VISIBLE);
                            textViewListaVazia.setText("Nenhuma venda realizada");

                            textviewNumeroPedidos.setText(Integer.toString(0) + " pedidos");
                            textViewValorVendas.setText("R$ " + GetMask.getValor(0.0));
                        }
                    }

                    if (listVendasMaster.size() > 0) {
                        progressBar.setVisibility(View.GONE);
                        progressBarPedidos.setVisibility(View.GONE);
                        progressBarValorPedidos.setVisibility(View.GONE);

                        textViewListaVazia.setVisibility(View.GONE);
                        textViewListaVazia.setText(null);

                        adapterRelatorioVendas.notifyDataSetChanged();
                        textviewNumeroPedidos.setText(Integer.toString(listVendasMaster.size()) + " pedidos");
                        textViewValorVendas.setText("R$ " + GetMask.getValor(valorVendas));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<VendasMaster>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

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

    /**
     * Método que recupera do banco de dados MySQl os dados que iram ser preenchidos na classe empresas.
     */
    public void RecuperaListEmpresas() {
        empresasService = Apis.getEmpresasService();
        Call<List<Empresas>> call = empresasService.getEmpresas();
        call.enqueue(new Callback<List<Empresas>>() {
            @Override
            public void onResponse(Call<List<Empresas>> call, Response<List<Empresas>> response) {
                if (response.isSuccessful()) {
                    empresasList = response.body();
                }
                RecuperaListVendasMaster();
            }

            @Override
            public void onFailure(Call<List<Empresas>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }


    private void inicializaComponentes() {
        recyclerViewRelatorioProdutos = findViewById(R.id.recyclerViewRelatorioProdutos);

        //TEXTEVIEW
        textViewDataRelatorio = findViewById(R.id.textViewDataRelatorio);
        textviewNumeroPedidos = findViewById(R.id.textviewNumeroPedidos);
        textViewValorVendas = findViewById(R.id.textViewValorVendas);
        textViewListaVazia = findViewById(R.id.textListaVazia);

        //PROGRESS BAR
        progressBar = findViewById(R.id.progressBar);
        progressBarPedidos = findViewById(R.id.progressBarPedidos);
        progressBarValorPedidos = findViewById(R.id.progressBarValorPedidos);

    }

    @Override
    public void onClick(VendasMaster relatorioVendas) {
        Intent intent = new Intent(RelatorioDeVendasDiaActivity.this, InformacoesPedidoVendaActivity.class);
        intent.putExtra("relatorioVendasSelecionados", relatorioVendas);
        startActivity(intent);
    }
}