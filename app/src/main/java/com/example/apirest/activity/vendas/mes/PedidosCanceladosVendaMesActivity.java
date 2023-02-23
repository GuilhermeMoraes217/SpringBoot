package com.example.apirest.activity.vendas.mes;

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
import com.example.apirest.activity.vendas.InformacoesPedidosCanceladoVendaActivity;
import com.example.apirest.adapter.vendas.totalcancelado.AdapterPedidosCanceladoVenda;
import com.example.apirest.model.Empresas;
import com.example.apirest.model.RelatorioVendas;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.EmpresasService;
import com.example.apirest.utils.GetMask;
import com.example.apirest.utils.VendasMasterService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PedidosCanceladosVendaMesActivity extends AppCompatActivity implements AdapterPedidosCanceladoVenda.ItemClickListener {

    /**
     * Atributos da inicialização do recyclerView do PedidosCanceladosVendaActivity
     */
    private RecyclerView recyclerViewRelatorioProdutos;
    private AdapterPedidosCanceladoVenda adapterPedidosCanceladoVenda;
    ArrayList<RelatorioVendas> relatorioVendas = new ArrayList<>();

    /**
     * Atributos dos textView da activity PedidosCanceladosVendaActivity
     */
    private TextView textViewDataRelatorio, textviewNumeroPedidosCancelados, textViewValorPedidoCancelado;
    private TextView textViewListaVazia;


    /**
     * Atributos que irao receber o popular as classes VendasMaster
     */
    VendasMasterService vendasMasterService;
    List<VendasMaster> listPedidosCancelados = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes Empresas
     */
    EmpresasService empresasService;
    List<Empresas> empresasList = new ArrayList<>();

    /**
     * Atributos variddos do layout PedidosCanceladosVendaActivity
     */
    static List<String> stringsData = new ArrayList<>();

    private Double valorTotalPedido = 0.0;

    private ProgressBar progressBar, progressBarPedidos, progressBarValorPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_cancelados_venda_mes);

        inicializaComponentes();
        recuperaDataSemana();
        RecuperaListEmpresas();
        inicializaRecyclerView();
    }

    /**
     * Método que inicializa o recycler view do totalPedidosVendas
     */
    private void inicializaRecyclerView() {
        recyclerViewRelatorioProdutos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRelatorioProdutos.setHasFixedSize(true);
        adapterPedidosCanceladoVenda = new AdapterPedidosCanceladoVenda(listPedidosCancelados, this, this);
        recyclerViewRelatorioProdutos.setAdapter(adapterPedidosCanceladoVenda);
    }

    private void recuperaDataSemana () {
        int year= 0;
        int month=0;
        int day=0;

        Date date = new Date();
        LocalDate date1 = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            date1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            year  = date1.getYear();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            month = date1.getMonthValue();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            day   = date1.getDayOfMonth();
        }

        printDatesInMonth( year,  month,  day);
    }
    public static void printDatesInMonth(int year, int month, int day) {
        stringsData.clear();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, 0); // alteracao aqui para listar O PADRAO É IGUAL A (0 ZERO)
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < day ; i++) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            stringsData.add(fmt.format(cal.getTime()));
        }
        Log.i("", "" + stringsData);

    }

    /**
     * Método que recupera do banco de dados MySQl os dados que iram ser preenchidos na classe vendas_master.
     */
    public void RecuperaListVendasMaster() {
        vendasMasterService = Apis.getVendasMasterService();
        Call<List<VendasMaster>> call = vendasMasterService.getVendasMaster();
        call.enqueue(new Callback<List<VendasMaster>>() {
            @Override
            public void onResponse(Call<List<VendasMaster>> call, Response<List<VendasMaster>> response) {
                if (response.isSuccessful()) {
                    List<VendasMaster> vendasMaster = response.body();

                    for (VendasMaster vendasMaster1 : vendasMaster) {
                        for (String localDate : stringsData) {
                            if (localDate.equals(vendasMaster1.getData_emissao())) {
                                for (Empresas empresas : empresasList) {
                                    if (vendasMaster1.getSituacao().equals("C") && empresas.getCodigo() == vendasMaster1.getFkempresa()) {
                                        vendasMaster1.setNomeEmpresa(empresas.getRazao());
                                        listPedidosCancelados.add(vendasMaster1);
                                        valorTotalPedido += vendasMaster1.getTotal();
                                    }
                                }
                            } else {
                                progressBar.setVisibility(View.GONE);
                                progressBarPedidos.setVisibility(View.GONE);
                                progressBarValorPedidos.setVisibility(View.GONE);

                                textViewListaVazia.setVisibility(View.VISIBLE);
                                textViewListaVazia.setText("Nenhum pedido cancelado");

                                textviewNumeroPedidosCancelados.setText(Integer.toString(0) + " pedidos");
                                textViewValorPedidoCancelado.setText("R$ " + GetMask.getValor(0.0));
                            }
                        }
                    }

                    if (listPedidosCancelados.size() > 0) {
                        progressBar.setVisibility(View.GONE);
                        progressBarPedidos.setVisibility(View.GONE);
                        progressBarValorPedidos.setVisibility(View.GONE);

                        textViewListaVazia.setVisibility(View.GONE);
                        textViewListaVazia.setText(null);

                        adapterPedidosCanceladoVenda.notifyDataSetChanged();
                        textviewNumeroPedidosCancelados.setText(Integer.toString(listPedidosCancelados.size()) + " pedidos");
                        textViewValorPedidoCancelado.setText("R$ " + GetMask.getValor(valorTotalPedido));
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
                textViewListaVazia.setText("Nenhum pedido cancelado");

                textviewNumeroPedidosCancelados.setText(Integer.toString(0) + " pedidos");
                textViewValorPedidoCancelado.setText("R$ " + GetMask.getValor(0.0));

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

        //TEXTVIEW
        textViewDataRelatorio = findViewById(R.id.textViewDataRelatorio);
        textviewNumeroPedidosCancelados = findViewById(R.id.textviewNumeroPedidos);
        textViewValorPedidoCancelado = findViewById(R.id.textViewValorVendas);
        textViewListaVazia = findViewById(R.id.textListaVazia);

        //PROGRESS BAR
        progressBar = findViewById(R.id.progressBar);
        progressBarPedidos = findViewById(R.id.progressBarPedidos);
        progressBarValorPedidos = findViewById(R.id.progressBarValorPedidos);

    }

    @Override
    public void onClick(VendasMaster relatorioVendas) {
        Intent intent = new Intent(PedidosCanceladosVendaMesActivity.this, InformacoesPedidosCanceladoVendaActivity.class);
        intent.putExtra("relatorioPedidoCancelado", relatorioVendas);
        startActivity(intent);
    }
}