package com.example.apirest.fragments.contas.ano;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.activity.contas.ano.RelatorioContasAnoActivity;
import com.example.apirest.activity.contas.dia.RelatorioContasDiaActivity;
import com.example.apirest.interfaces.CPagarService;
import com.example.apirest.interfaces.CReceberService;
import com.example.apirest.model.contas.CPagar;
import com.example.apirest.model.contas.CReceber;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.GetMask;

import java.text.ParseException;
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


public class ContasAnoFragment extends Fragment {

    /**
     * Atributos que irao receber o popular as classes CCompra
     */
    CPagarService cPagarService;
    List<CPagar> cPagarList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes CReceber
     */
    CReceberService cReceberService;
    List<CReceber> cRecebers = new ArrayList<>();

    /**
     * Atributos variados do layout
     */
    static List<String> stringsData = new ArrayList<>();
    private TextView textRelatorioContas, textTotalContasReceber, valorTotalAbertoText, valorTotalVencidoText,
            valorTotalLiquidadoText, valorTotalAbertoPagarText, valorTotalVencidoPagarText, valorTotalLiquidadoPagarText, valorTotalContasPagar;

    //ATRIBUTOS DE VALORES A RECEBER
    private Double valorReceber = 0.0;
    private Double valorAbertoReceber = 0.0;
    private Double valorVencidoReceber = 0.0;
    private Double valorLiquidadoReceber = 0.0;

    //ATRIBUTOS DOS VALORES A PAGAR
    private Double valorPagar = 0.0;
    private Double valorAbertoPagar = 0.0;
    private Double valorVencidoPagar = 0.0;
    private Double valorLiquidadoPagar = 0.0;

    private ProgressBar progressBarValorReceber, progressBarAberto, progressBarVencido, progressBarLiquidado, progressBarValorPagar, progressBarAbertoPagar, progressBarVencidoPagar, progressBarLiquidadoPagar;

    Date date1 = null;
    Date date2 = null;
    String formattedDateAtual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contas_ano, container, false);

        inicializaComponentes(view);
        recuperaDataSemana();
        listCReceber();
        listCCompra();
        iniciaCliques(view);

        return  view;
    }

    public static void printDatesInMonth(int year, int month, int day) {
        stringsData.clear();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, 0, 0); // alteracao aqui para listar O PADRAO É IGUAL A (0 ZERO)
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 0; j < month; j++) {
            for (int i = 0; i < daysInMonth; i++) {
                cal.add(Calendar.DAY_OF_YEAR, 1);
                stringsData.add(fmt.format(cal.getTime()));
            }
        }

        Log.i("", "" + stringsData);

    }

    private void recuperaDataSemana() {
        int year = 0;
        int month = 0;
        int day = 0;

        Date date = new Date();
        LocalDate date1 = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            date1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            year = date1.getYear();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            month = date1.getMonthValue();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            day = date1.getDayOfMonth();
        }

        printDatesInMonth(year, month, day);
    }

    public void convertendoStringInDate(String dataVecimento) {
        // FUNCAO QUE RECUPERA A DATA ATUAL E DATA DE VENCIMENTO DO BANCO E CONVERTE DE STRING PARA DATE

        //PEGANDO O VALOR DA DATA ATUAL
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formattedDateAtual = df.format(d);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date1 = sdf.parse(formattedDateAtual);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try {
            date2 = sdf.parse(dataVecimento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public void zerandoValoresContas() {
        //ZERANDO OS VALORES
        valorReceber = 0.0;
        valorAbertoReceber = 0.0;
        valorVencidoReceber = 0.0;
        valorLiquidadoReceber = 0.0;

        valorPagar = 0.0;
        valorAbertoPagar = 0.0;
        valorVencidoPagar = 0.0;
        valorLiquidadoPagar = 0.0;
    }

    public void listCReceber() {
        cReceberService = Apis.getCReceberService();
        Call<List<CReceber>> call = cReceberService.getrebecer();
        call.enqueue(new Callback<List<CReceber>>() {
            @Override
            public void onResponse(Call<List<CReceber>> call, Response<List<CReceber>> response) {
                if (response.isSuccessful()) {
                    zerandoValoresContas(); // ZERANDO OS VALORES DAS CONTAS

                    List<CReceber> cRecebers1 = response.body();

                    for (CReceber cReceber : cRecebers1) {
                        convertendoStringInDate(cReceber.getDtvencimento()); // RECEBENDOS AS DATAS EM FORMATO DATE
                        for (String dataPagar : stringsData) {
                            if (dataPagar.equals(cReceber.getData())) {
                                if (!cReceber.getSituacao().equals("T")) {
                                    valorReceber += cReceber.getVl_restante();
                                    valorAbertoReceber += cReceber.getVl_restante();
                                }

                                if (cReceber.getSituacao().equals("T")) {
                                    valorLiquidadoReceber += cReceber.getVrecebido();
                                }

                                if (date1.compareTo(date2) > 0 && !cReceber.getSituacao().equals("T")) {
                                    System.out.println("Date1 is after Date2");
                                    valorVencidoReceber += cReceber.getVl_restante();

                                }
                            } else {
                                progressBarValorReceber.setVisibility(View.GONE);
                                progressBarAberto.setVisibility(View.GONE);
                                progressBarVencido.setVisibility(View.GONE);
                                progressBarLiquidado.setVisibility(View.GONE);

                                textTotalContasReceber.setText("R$ " + GetMask.getValor(0.0));
                                valorTotalAbertoText.setText("R$ " + GetMask.getValor(0.0));
                                valorTotalVencidoText.setText("R$ " + GetMask.getValor(0.0));
                                valorTotalLiquidadoText.setText("R$ " + GetMask.getValor(0.0));
                            }
                        }
                    }
                }
                progressBarValorReceber.setVisibility(View.GONE);
                progressBarAberto.setVisibility(View.GONE);
                progressBarVencido.setVisibility(View.GONE);
                progressBarLiquidado.setVisibility(View.GONE);

                textTotalContasReceber.setText("R$ " + GetMask.getValor(valorReceber));
                valorTotalAbertoText.setText("R$ " + GetMask.getValor(valorAbertoReceber));
                valorTotalVencidoText.setText("R$ " + GetMask.getValor(valorVencidoReceber));
                valorTotalLiquidadoText.setText("R$ " + GetMask.getValor(valorLiquidadoReceber));
            }

            @Override
            public void onFailure(Call<List<CReceber>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void listCCompra() {
        cPagarService = Apis.getCPagarService();
        Call<List<CPagar>> call = cPagarService.getCpagar();
        call.enqueue(new Callback<List<CPagar>>() {
            @Override
            public void onResponse(Call<List<CPagar>> call, Response<List<CPagar>> response) {
                if (response.isSuccessful()) {
                    zerandoValoresContas(); // ZERANDO OS VALORES DAS CONTAS

                    List<CPagar> pagarList = response.body();

                    for (CPagar cPagar : pagarList) {
                        convertendoStringInDate(cPagar.getDtvencimento()); // RECEBENDOS AS DATAS EM FORMATO DATE
                        for(String dataPagar : stringsData) {
                            if (dataPagar.equals(cPagar.getData())) {
                                if (!cPagar.getSituacao().equals("T")) {
                                    /**
                                     * VALORES A PAGAR E VALORES A PAGAR ABERTOS
                                     */
                                    valorPagar += cPagar.getVl_restante();
                                    valorAbertoPagar += cPagar.getVl_restante();
                                }

                                if (cPagar.getSituacao().equals("T")) {
                                    /**
                                     * VALORES LIQUIDADOS
                                     */
                                    valorLiquidadoPagar += cPagar.getVlpago();
                                }

                                if (date1.compareTo(date2) > 0 && !cPagar.getSituacao().equals("T")) {
                                    System.out.println("Date1 is after Date2");
                                    /**
                                     * VALORES VENCIDOS
                                     */
                                    valorVencidoPagar += cPagar.getVl_restante();
                                }
                            } else {

                                progressBarValorPagar.setVisibility(View.GONE);
                                progressBarAbertoPagar.setVisibility(View.GONE);
                                progressBarVencidoPagar.setVisibility(View.GONE);
                                progressBarLiquidadoPagar.setVisibility(View.GONE);


                                valorTotalContasPagar.setText("R$ " + GetMask.getValor(0.0));
                                valorTotalAbertoPagarText.setText("R$ " + GetMask.getValor(0.0));
                                valorTotalVencidoPagarText.setText("R$ " + GetMask.getValor(0.0));
                                valorTotalLiquidadoPagarText.setText("R$ " + GetMask.getValor(0.0));
                            }
                        }
                    }
                }
                progressBarValorPagar.setVisibility(View.GONE);
                progressBarAbertoPagar.setVisibility(View.GONE);
                progressBarVencidoPagar.setVisibility(View.GONE);
                progressBarLiquidadoPagar.setVisibility(View.GONE);

                valorTotalContasPagar.setText("R$ " + GetMask.getValor(valorPagar));
                valorTotalAbertoPagarText.setText("R$ " + GetMask.getValor(valorAbertoPagar));
                valorTotalVencidoPagarText.setText("R$ " + GetMask.getValor(valorVencidoPagar));
                valorTotalLiquidadoPagarText.setText("R$ " + GetMask.getValor(valorLiquidadoPagar));
            }

            @Override
            public void onFailure(Call<List<CPagar>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    private void iniciaCliques(View view) {

        textRelatorioContas.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), RelatorioContasAnoActivity.class);
            startActivity(intent);
        });
    }

    private void inicializaComponentes(View view) {

        textRelatorioContas = view.findViewById(R.id.textRelatorioContas);
        textTotalContasReceber = view.findViewById(R.id.textView2);
        valorTotalAbertoText = view.findViewById(R.id.valorTotalAbertoText);
        valorTotalVencidoText = view.findViewById(R.id.valorTotalVencidoText);
        valorTotalLiquidadoText = view.findViewById(R.id.valorTotalLiquidadoText);

        valorTotalContasPagar = view.findViewById(R.id.textView98);
        valorTotalAbertoPagarText = view.findViewById(R.id.valorTotalAbertoPagarText);
        valorTotalVencidoPagarText = view.findViewById(R.id.valorTotalVencidoPagarText);
        valorTotalLiquidadoPagarText = view.findViewById(R.id.valorTotalLiquidadoPagarText);

        progressBarValorReceber = view.findViewById(R.id.progressBarValorReceber);
        progressBarAberto = view.findViewById(R.id.progressBarAberto);
        progressBarVencido = view.findViewById(R.id.progressBarVencido);
        progressBarLiquidado = view.findViewById(R.id.progressBarLiquidado);

        progressBarValorPagar = view.findViewById(R.id.progressBarValorPagar);
        progressBarAbertoPagar = view.findViewById(R.id.progressBarAbertoPagar);
        progressBarVencidoPagar = view.findViewById(R.id.progressBarVencidoPagar);
        progressBarLiquidadoPagar = view.findViewById(R.id.progressBarLiquidadoPagar);

    }
}