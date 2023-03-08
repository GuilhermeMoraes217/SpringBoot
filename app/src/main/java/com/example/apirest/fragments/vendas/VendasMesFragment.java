package com.example.apirest.fragments.vendas;

import android.content.Intent;
import android.os.Build;
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

import com.example.apirest.R;
import com.example.apirest.activity.empresa.PersonaActivity;
import com.example.apirest.activity.vendas.mes.PedidosCanceladosVendaMesActivity;
import com.example.apirest.activity.vendas.mes.RelatorioDeVendasMesActivity;
import com.example.apirest.activity.vendas.mes.TotalPedidosVendaMesActivity;
import com.example.apirest.adapter.PersonaAdapter;
import com.example.apirest.model.Persona;
import com.example.apirest.model.vendas.FormaPagamento;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.model.vendas.Vendasfpg;
import com.example.apirest.utils.Apis;
import com.example.apirest.interfaces.FormaPagamentoService;
import com.example.apirest.utils.GetMask;
import com.example.apirest.interfaces.PersonaService;
import com.example.apirest.interfaces.VendasMasterService;
import com.example.apirest.interfaces.VendasfpgService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VendasMesFragment extends Fragment {

    /**
     * Atributos que irao receber o popular as classes Personas
     */
    PersonaService personaService;
    List<Persona> listPersona = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes VendasMaster
     */
    VendasMasterService vendasMasterServiceMes;
    List<VendasMaster> listVendasMasterMes = new ArrayList<>();
    List<VendasMaster> listTotalDePedidosMes = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes Vendasfpg
     */
    VendasfpgService vendasfpgServiceMes;
    List<Vendasfpg> listvendasfpgMes = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes FormaPagamento
     */
    FormaPagamentoService formaPagamentoServiceMes;
    List<FormaPagamento> listformaPagamentoMes = new ArrayList<>();

    /**
     * Atributos variados do layout vendas dia fragment
     */
    List<LocalDate> lastWeek = new ArrayList<>();
    static Calendar cal;

    static List<String> stringsData = new ArrayList<>();
    ListView listView;
    TextView textListaVazia;
    ProgressBar progressBar;
    ConstraintLayout verProdutosVendas;
    FloatingActionButton fab;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vendas_mes, container, false);

        InitComponentes(view);
        recuperaDataSemana();
        InitCliques(view);

        listPersons();
        RecuperaListVendasMaster();

        return view;
    }

    private static List<LocalDate> weekStarting(LocalDate date) {
        // Might want to validate that date.getDayOfWeek() == DayOfWeek.SUNDAY
        List<LocalDate> week = new ArrayList<>(7);
        for (int day = 0; day <= 7; day++) {
            week.add(date);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                date = date.plusDays(1);
            }
        }
        return week;
    }

    private void inicializaData() {
        LocalDate today = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            today = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
        }
        LocalDate weekStart = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            weekStart = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        }
        List<LocalDate> thisWeek = weekStarting(weekStart);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            lastWeek = weekStarting(weekStart.minusWeeks(1));

        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            List<LocalDate> twoWeeksAgo = weekStarting(weekStart.minusWeeks(2));
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            List<LocalDate> threeWeeksAgo = weekStarting(weekStart.minusWeeks(3));
        }


    }

    public static void printDatesInMonth(int year, int month, int day) {
        stringsData.clear();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, 0); // alteracao aqui para listar O PADRAO É IGUAL A (0 ZERO)
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < day ; i++) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            stringsData.add(fmt.format(cal.getTime()));
        }
        Log.i("", "" + stringsData);

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

    private void limpandoComponetes () {
        valorVendasDia = 0.0;
        valorFaturadoDia = 0.0;
        pedidosCancelados = 0;
        pedidosFaturadosBaixados = 0;
        totalNumeroPedidos = 0;
    }
    private void ExibirComponentes() {
        limpandoComponetes();

        for (VendasMaster vendasMaster : listVendasMasterMes) {
            /**
             * recupera o total do numero de pedidos
             */

            for (String localDate : stringsData) {

                if (localDate.equals(vendasMaster.getData_emissao())) {

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
                    for (Vendasfpg vendasfpg : listvendasfpgMes) {
                        for (FormaPagamento formaPagamento : listformaPagamentoMes) {
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
            Intent intent = new Intent(getActivity(), RelatorioDeVendasMesActivity.class);
            startActivity(intent);
        });

        totalDePedisoConstrant.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), TotalPedidosVendaMesActivity.class);
            startActivity(intent);
        });

        pedidosCanceladosContrant.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), PedidosCanceladosVendaMesActivity.class);
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
        vendasMasterServiceMes = Apis.getVendasMasterService();
        Call<List<VendasMaster>> call = vendasMasterServiceMes.getVendasMaster();
        call.enqueue(new Callback<List<VendasMaster>>() {
            @Override
            public void onResponse(Call<List<VendasMaster>> call, Response<List<VendasMaster>> response) {
                listVendasMasterMes.clear();
                listTotalDePedidosMes.clear();
                if (response.isSuccessful()) {
                    listVendasMasterMes = response.body(); // PARA SER UMA LISTA PARA LISTAR AS VENDAS FATURADAS E BAIXADAS
                    listTotalDePedidosMes = response.body(); // PARA SER UMA LISTA QUE RETORNE O NUMERO DE PEDIDOS FEITOS
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
        vendasfpgServiceMes = Apis.getVendasfpgService();
        Call<List<Vendasfpg>> call = vendasfpgServiceMes.getVendasfpg();
        call.enqueue(new Callback<List<Vendasfpg>>() {
            @Override
            public void onResponse(Call<List<Vendasfpg>> call, Response<List<Vendasfpg>> response) {
                listvendasfpgMes.clear();
                if (response.isSuccessful()) {
                    listvendasfpgMes = response.body();
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
        formaPagamentoServiceMes = Apis.getFormaPagamentoService();
        Call<List<FormaPagamento>> call = formaPagamentoServiceMes.getFormaPagamento();
        call.enqueue(new Callback<List<FormaPagamento>>() {
            @Override
            public void onResponse(Call<List<FormaPagamento>> call, Response<List<FormaPagamento>> response) {
                listformaPagamentoMes.clear();
                if (response.isSuccessful()) {
                    listformaPagamentoMes = response.body();
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

    public void InitComponentes(View view) {
        listView = view.findViewById(R.id.listView);
        textListaVazia = view.findViewById(R.id.textListaVazia);
        fab = view.findViewById(R.id.fabe);

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