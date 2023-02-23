package com.example.apirest.fragments.vendas;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.apirest.activity.vendas.dia.PedidosCanceladosVendaDiaActivity;
import com.example.apirest.activity.vendas.dia.RelatorioDeVendasDiaActivity;
import com.example.apirest.activity.vendas.dia.TotalPedidosVendaDiaActivity;
import com.example.apirest.adapter.PersonaAdapter;
import com.example.apirest.activity.empresa.PersonaActivity;
import com.example.apirest.model.Persona;
import com.example.apirest.R;
import com.example.apirest.model.vendas.FormaPagamento;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.model.vendas.Vendasfpg;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.FormaPagamentoService;
import com.example.apirest.utils.GetMask;
import com.example.apirest.utils.PersonaService;
import com.example.apirest.utils.VendasMasterService;
import com.example.apirest.utils.VendasfpgService;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VendasDiaFragment extends Fragment {

    /**
     * Atributos que irao receber o popular as classes Personas
     */
    PersonaService personaService;
    List<Persona> listPersona = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes VendasMaster
     */
    VendasMasterService vendasMasterServiceDia;
    List<VendasMaster> listVendasMasterDia = new ArrayList<>();
    List<VendasMaster> listTotalDePedidosDia = new ArrayList<>();

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
     * Atributos variados do layout vendas dia fragment
     */
    ListView listView;
    TextView textListaVazia;
    ProgressBar progressBar;
    ConstraintLayout verProdutosVendas;
    FloatingActionButton fab;

    /**
     * Barchat list
     */
    BarChart barChart;
    ArrayList<BarEntry> barChartsDate = new ArrayList<>();

    private TextView valorGeralVendas, totaldePedidos, totalPedidosCancelados, ticketMedio, totalFaturado;
    Double valorVendasDia = 0.0;
    Double valorFaturadoDia = 0.0;

    int pedidosCancelados = 0;
    int pedidosFaturadosBaixados = 0;
    int totalNumeroPedidos;

    private ProgressBar progressBarValorGeral, progressBarTotalPedido, progressBarTotalPedidoCancelados, progressBarTicketMedio, progressBarTotalFaturado;

    private ConstraintLayout totalDePedisoConstrant, pedidosCanceladosContrant;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vendas_dia, container, false);
        inicializaComponentes(view);
        InitCliques(view);

        listPersons();
        RecuperaListVendasMaster();

        return view;
    }

    private void limpandoComponetes () {
        valorVendasDia = 0.0;
        valorFaturadoDia = 0.0;
        pedidosCancelados = 0;
        pedidosFaturadosBaixados = 0;
        totalNumeroPedidos = 0;
    }

    private void ExibirComponentes() {
        limpandoComponetes();
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDateAtual = df.format(d);


        for (VendasMaster vendasMaster : listVendasMasterDia) {
            /**
             * recupera o total do numero de pedidos
             */

            if (vendasMaster.getData_emissao().equals(formattedDateAtual)) {

                if (vendasMaster.getTotal() > 0 && vendasMaster.getNome() != null) {
                    totalNumeroPedidos++;
                }

                /**
                 * recupera o total de pedidos cancelados
                 */
                if (vendasMaster.getSituacao().equals("C")) {
                    pedidosCancelados++;
                }

                /**
                 * recupera o total de pedidos faturados e baixados
                 */
                if (vendasMaster.getTotal() > 0 && vendasMaster.getSituacao().equals("F")) {
                    pedidosFaturadosBaixados++;
                }
                for (Vendasfpg vendasfpg : listvendasfpgDia) {
                    for (FormaPagamento formaPagamento : listformaPagamentoDia) {
                        if (vendasfpg.getVendas_master() == vendasMaster.getCodigo()) {
                            if (vendasfpg.getId_forma() == formaPagamento.getCodigo()) {
                                if (vendasMaster.getTotal() > 0 && vendasMaster.getSituacao().equals("F")) {
                                    /**
                                     * recupera o valor de vendas
                                     */
                                    valorVendasDia += vendasfpg.getValor();
                                    if (vendasMaster.getNecf() > 0) {
                                        /**
                                         * recupera o valor da fatura
                                         */
                                        valorFaturadoDia += vendasfpg.getValor();
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else {
                progressBarValorGeral.setVisibility(View.GONE);
                progressBarTotalPedido.setVisibility(View.GONE);
                progressBarTotalPedidoCancelados.setVisibility(View.GONE);
                progressBarTicketMedio.setVisibility(View.GONE);
                progressBarTotalFaturado.setVisibility(View.GONE);


                totaldePedidos.setText(Integer.toString(0));
                totalPedidosCancelados.setText(Integer.toString(0));
                valorGeralVendas.setText("R$ " + GetMask.getValor(0.0));
                totalFaturado.setText("Faturado " + "R$ " + GetMask.getValor(0.0));
                ticketMedio.setText("R$ 0,00");
            }

        }

        progressBarValorGeral.setVisibility(View.GONE);
        progressBarTotalPedido.setVisibility(View.GONE);
        progressBarTotalPedidoCancelados.setVisibility(View.GONE);
        progressBarTicketMedio.setVisibility(View.GONE);
        progressBarTotalFaturado.setVisibility(View.GONE);


        totaldePedidos.setText(Integer.toString(totalNumeroPedidos));
        totalPedidosCancelados.setText(Integer.toString(pedidosCancelados));
        valorGeralVendas.setText("R$ " + GetMask.getValor(valorVendasDia));
        totalFaturado.setText("Faturado " + "R$ " + GetMask.getValor(valorFaturadoDia));
        ticketMedio.setText("R$ " + GetMask.getValor(valorVendasDia / pedidosFaturadosBaixados));

    }

    public void InitCliques(View view) {
        fab.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), PersonaActivity.class);
            intent.putExtra("ID", "");
            intent.putExtra("NOMBRE", "");
            intent.putExtra("APELLIDO", "");
            startActivity(intent);
        });
        verProdutosVendas.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), RelatorioDeVendasDiaActivity.class);
            startActivity(intent);
        });

        totalDePedisoConstrant.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), TotalPedidosVendaDiaActivity.class);
            startActivity(intent);
        });

        pedidosCanceladosContrant.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), PedidosCanceladosVendaDiaActivity.class);
            startActivity(intent);
        });

    }

    public void listPersons() {
        personaService = Apis.getPersonaService();
        Call<List<Persona>> call = personaService.getPersonas();
        call.enqueue(new Callback<List<Persona>>() {
            @Override
            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
                if (response.isSuccessful()) {
                    listPersona = response.body();
                    listView.setAdapter(new PersonaAdapter(getActivity(), R.layout.content_main, listPersona));
                    textListaVazia.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Persona>> call, Throwable t) {
                Log.e("Error:", t.getMessage());
                progressBar.setVisibility(View.GONE);
                textListaVazia.setVisibility(View.VISIBLE);
            }
        });

    }

    public void RecuperaListVendasMaster() {
        vendasMasterServiceDia = Apis.getVendasMasterService();
        Call<List<VendasMaster>> call = vendasMasterServiceDia.getVendasMaster();
        call.enqueue(new Callback<List<VendasMaster>>() {
            @Override
            public void onResponse(Call<List<VendasMaster>> call, Response<List<VendasMaster>> response) {
                listVendasMasterDia.clear();
                listTotalDePedidosDia.clear();
                if (response.isSuccessful()) {
                    listVendasMasterDia = response.body(); // PARA SER UMA LISTA PARA LISTAR AS VENDAS FATURADAS E BAIXADAS
                    listTotalDePedidosDia = response.body(); // PARA SER UMA LISTA QUE RETORNE O NUMERO DE PEDIDOS FEITOS
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
                ExibirComponentes();
            }

            @Override
            public void onFailure(Call<List<FormaPagamento>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void inicializaComponentes(View view) {
        listView = view.findViewById(R.id.listView);
        textListaVazia = view.findViewById(R.id.textListaVazia);
        fab = view.findViewById(R.id.fabe);
        barChart = view.findViewById(R.id.barChat);

        barChartsDate.add(new BarEntry(2014, 420));
        barChartsDate.add(new BarEntry(2015, 520));
        barChartsDate.add(new BarEntry(2016, 620));
        barChartsDate.add(new BarEntry(2017, 720));
        barChartsDate.add(new BarEntry(2018, 820));

        BarDataSet barDataSet = new BarDataSet(barChartsDate, "Datas");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(android.R.color.black);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.getXAxis().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setEnabled(false);
        barChart.animateY(1000);

        //CONSTRANTS
        totalDePedisoConstrant = view.findViewById(R.id.constraintLayout2);
        pedidosCanceladosContrant = view.findViewById(R.id.constraintLayout);

        //TEXTVIEW
        verProdutosVendas = view.findViewById(R.id.VerProdutosVendas);
        valorGeralVendas = view.findViewById(R.id.textView2);
        totaldePedidos = view.findViewById(R.id.textView4);
        ticketMedio = view.findViewById(R.id.textView5);
        totalFaturado = view.findViewById(R.id.textView3);
        totalPedidosCancelados = view.findViewById(R.id.textView6);

        //PROGRESS BAR
        progressBar = view.findViewById(R.id.progressBar);
        progressBarValorGeral = view.findViewById(R.id.progressBarValorGeral);
        progressBarTotalPedido = view.findViewById(R.id.progressBarTotalPedido);
        progressBarTotalPedidoCancelados = view.findViewById(R.id.progressBarTotalPedidoCancelados);
        progressBarTicketMedio = view.findViewById(R.id.progressBarTicketMedio);
        progressBarTotalFaturado = view.findViewById(R.id.progressBarTotalFaturado);

    }

}