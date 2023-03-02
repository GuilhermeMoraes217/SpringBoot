package com.example.apirest.fragments.contas.dia;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.activity.contas.RelatorioContasDiaActivity;
import com.example.apirest.interfaces.CReceberService;
import com.example.apirest.model.contas.CReceber;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.GetMask;
import com.example.apirest.utils.HoraUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ContasDiaFragment extends Fragment {

    /**
     * Atributos que irao receber o popular as classes CReceber
     */
    CReceberService cReceberService;
    List<CReceber> cRecebers = new ArrayList<>();

    /**
     * Atributos variados do layout
     */
    private TextView textRelatorioContas, textTotalContasReceber, valorTotalAbertoText, valorTotalVencidoText, valorTotalLiquidadoText;
    private Double valorReceber = 0.0;
    private Double valorAberto = 0.0;
    private Double valorVencido = 0.0;
    private Double valorLiquidado = 0.0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contas_dia, container, false);

        inicializaComponentes(view);
        listCReceber();
        iniciaCliques(view);


        return view;
    }

    public void listCReceber() {
        cReceberService = Apis.getCReceberService();
        Call<List<CReceber>> call = cReceberService.getrebecer();
        call.enqueue(new Callback<List<CReceber>>() {
            @Override
            public void onResponse(Call<List<CReceber>> call, Response<List<CReceber>> response) {
                if (response.isSuccessful()) {
                    //ZERANDO OS VALORES
                    valorReceber = 0.0;
                    valorAberto = 0.0;
                    valorVencido = 0.0;
                    valorLiquidado = 0.0;

                    //PEGANDO O VALOR DA DATA ATUAL
                    Date d = new Date();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDateAtual = df.format(d);

                    List<CReceber> cRecebers1 = response.body();
                    for (CReceber cReceber : cRecebers1) {
                        if (formattedDateAtual.equals(cReceber.getData())) {
                            if (!cReceber.getSituacao().equals("T")) {
                                valorReceber += cReceber.getVl_restante();
                                valorAberto += cReceber.getVl_restante();
                            }

                            if (cReceber.getSituacao().equals("T")) {
                                valorLiquidado += cReceber.getVrecebido();
                            }

                            String data1= formattedDateAtual;
                            String data2=cReceber.getDtvencimento();
                            String data3=cReceber.getData();
                            Date dateAtual;
                            Date dateVencimento;
                            Date dateInicio;
                            try {
                                dateAtual=new SimpleDateFormat("yyyy-MM-dd").parse(data1);
                                dateVencimento=new SimpleDateFormat("yyyy-MM-dd").parse(data2);
                                dateInicio=new SimpleDateFormat("yyyy-MM-dd").parse(data3);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }

                            if(dateAtual.after(dateInicio) && dateVencimento.before(dateAtual)) {
                                /* historyDate <= todayDate <= futureDate */
                                valorAberto += cReceber.getVl_restante();

                            }

                        }
                    }
                }

                textTotalContasReceber.setText("R$ " + GetMask.getValor(valorReceber));

                valorTotalAbertoText.setText("R$ " + GetMask.getValor(valorAberto));
                valorTotalVencidoText.setText("R$ " + GetMask.getValor(valorVencido));
                valorTotalLiquidadoText.setText("R$ " + GetMask.getValor(valorLiquidado));
            }

            @Override
            public void onFailure(Call<List<CReceber>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    private void iniciaCliques(View view) {

        textRelatorioContas.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), RelatorioContasDiaActivity.class);
            startActivity(intent);
        });
    }

    private void inicializaComponentes(View view) {

        textRelatorioContas = view.findViewById(R.id.textRelatorioContas);
        textTotalContasReceber = view.findViewById(R.id.textView2);
        valorTotalAbertoText = view.findViewById(R.id.valorTotalAbertoText);
        valorTotalVencidoText = view.findViewById(R.id.valorTotalVencidoText);
        valorTotalLiquidadoText = view.findViewById(R.id.valorTotalLiquidadoText);
    }
}