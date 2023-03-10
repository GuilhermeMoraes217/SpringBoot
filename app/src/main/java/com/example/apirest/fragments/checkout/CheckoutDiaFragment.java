package com.example.apirest.fragments.checkout;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.activity.checkout.RelatorioCheckoutActivity;
import com.example.apirest.interfaces.ContasService;
import com.example.apirest.interfaces.FormaPagamentoService;
import com.example.apirest.interfaces.ResumoCaixaService;
import com.example.apirest.interfaces.VendasMasterService;
import com.example.apirest.interfaces.VendasfpgService;
import com.example.apirest.model.checkout.Contas;
import com.example.apirest.model.checkout.ResumoCaixa;
import com.example.apirest.model.vendas.FormaPagamento;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.model.vendas.Vendasfpg;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.GetMask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CheckoutDiaFragment extends Fragment {
    /**
     * Atributos que irao receber o popular as classes CONTAS
     */
    ContasService contasService;
    List<Contas> contasList = new ArrayList<>();
    List<Contas> qtdTotalCaixa = new ArrayList<>();
    List<Contas> qtdCaixaAberto = new ArrayList<>();
    List<Contas> qtdCaixaFechado = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes RESUMO_CAIXA
     */
    ResumoCaixaService resumoCaixaService;
    List<ResumoCaixa> resumoCaixaList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes VENDAS_MASTER
     */
    VendasMasterService vendasMasterService;
    List<VendasMaster> vendasMasterList = new ArrayList<>();

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
     * Atributos variados do layout
     */
    Double valorTotalVendasCaixa = 0.0, valorTotalSaida = 0.0;
    Date date2;
    String formattedDateAtual;
    String dataBanco;

    private TextView textCaixas, valorTotalCaixaTextView, qtdTotalCaixaTextView, qtdTotalCaixaAbertoTextView, qtdTotalCaixaFechadoTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_checkout_dia, container, false);

        inicializaComponentes(view);
        RecuperaListContas();
        RecuperaListResumoCaixa();

        RecuperalistFormaPagamento();
        inicializaCliques();


        return view;
    }

    public void RecuperaVendasMaster() {
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

                    for (VendasMaster vendasMaster : listVendasMasterDia) {
                        /**
                         * recupera o total do numero de pedidos
                         */

                        if (vendasMaster.getData_emissao().equals(formattedDateAtual)) {

                            for (Vendasfpg vendasfpg : listvendasfpgDia) {
                                for (FormaPagamento formaPagamento : listformaPagamentoDia) {
                                    if (vendasfpg.getVendas_master() == vendasMaster.getCodigo()) {
                                        if (vendasfpg.getId_forma() == formaPagamento.getCodigo()) {
                                            if (vendasMaster.getTotal() > 0 && vendasMaster.getSituacao().equals("F")) {
                                                /**
                                                 * recupera o valor de vendas
                                                 */
                                                valorTotalVendasCaixa += vendasfpg.getValor();

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    valorTotalCaixaTextView.setText("R$ " + GetMask.getValor(valorTotalVendasCaixa));

                }
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
                RecuperaVendasMaster();

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
                RecuperalistVendasfpg();
            }

            @Override
            public void onFailure(Call<List<FormaPagamento>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    private void inicializaCliques() {
        textCaixas.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), RelatorioCheckoutActivity.class);
            startActivity(intent);
        });
    }

    public void formatandoDataHora(String rc) {
        //DATA ATUAL
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formattedDateAtual = df.format(d);

        //DATA DO BANCO
        String sDate2 = rc;
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date2 = formatter2.parse(sDate2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        Date db = date2;
        SimpleDateFormat fdb = new SimpleDateFormat("yyyy-MM-dd");
        dataBanco = fdb.format(db);
    }

    public void RecuperaListVendasMaster() {
        vendasMasterService = Apis.getVendasMasterService();
        Call<List<VendasMaster>> call = vendasMasterService.getVendasMaster();
        call.enqueue(new Callback<List<VendasMaster>>() {
            @Override
            public void onResponse(Call<List<VendasMaster>> call, Response<List<VendasMaster>> response) {
                vendasMasterList.clear();

                if (response.isSuccessful()) {
                    vendasMasterList = response.body();
                }

            }

            @Override
            public void onFailure(Call<List<VendasMaster>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void RecuperaListContas() {
        contasService = Apis.getContasService();
        Call<List<Contas>> call = contasService.getContas();
        call.enqueue(new Callback<List<Contas>>() {
            @Override
            public void onResponse(Call<List<Contas>> call, Response<List<Contas>> response) {
                contasList.clear();
                qtdTotalCaixa.clear();
                qtdCaixaAberto.clear();
                qtdCaixaFechado.clear();
                if (response.isSuccessful()) {
                    List<Contas> contas = response.body(); // PARA SER UMA LISTA PARA LISTAR AS VENDAS FATURADAS E BAIXADAS
                    for (Contas c : contas) {

                        if (c.getTipo().equals("S")) {
                            //QUANTIDADE TOTAL DE CAIXAS
                            qtdTotalCaixa.add(c);
                        }

                        if (c.getTipo().equals("S") && c.getSituacao().equals("A")) {
                            //ABERTO
                            qtdCaixaAberto.add(c);
                        }

                        if (c.getTipo().equals("S") && !c.getSituacao().equals("A")) {
                            //ABERTO
                            qtdCaixaFechado.add(c);
                        }
                    }
                }

                qtdTotalCaixaTextView.setText(Integer.toString(qtdTotalCaixa.size()));
                qtdTotalCaixaAbertoTextView.setText(Integer.toString(qtdCaixaAberto.size()));
                qtdTotalCaixaFechadoTextView.setText(Integer.toString(qtdCaixaFechado.size()));
            }

            @Override
            public void onFailure(Call<List<Contas>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void RecuperaListResumoCaixa() {
        resumoCaixaService = Apis.getResumoCaixaService();
        Call<List<ResumoCaixa>> call = resumoCaixaService.getResumoCaixa();
        call.enqueue(new Callback<List<ResumoCaixa>>() {
            @Override
            public void onResponse(Call<List<ResumoCaixa>> call, Response<List<ResumoCaixa>> response) {
                resumoCaixaList.clear();
                valorTotalVendasCaixa = 0.0;
                valorTotalSaida = 0.0;
                if (response.isSuccessful()) {
                    List<ResumoCaixa> resumoCaixas = response.body(); // PARA SER UMA LISTA PARA LISTAR AS VENDAS FATURADAS E BAIXADAS
                    for (ResumoCaixa rc : resumoCaixas) {
                        formatandoDataHora(rc.getData_hora());
                        if (formattedDateAtual.equals(dataBanco)) {
                            //conversa, pegar valores abertos e fechados
                            if (rc.getTipo().equals("D") && !rc.getFlag().equals("B")) {
                                valorTotalVendasCaixa += rc.getEntrada();
                                valorTotalSaida += rc.getSaida();
                            }
                        }
                    }
                }
                qtdTotalCaixaTextView.setText(Integer.toString(qtdTotalCaixa.size()));
                qtdTotalCaixaAbertoTextView.setText(Integer.toString(qtdCaixaAberto.size()));
                qtdTotalCaixaFechadoTextView.setText(Integer.toString(qtdCaixaFechado.size()));
            }

            @Override
            public void onFailure(Call<List<ResumoCaixa>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    private void inicializaComponentes(View view) {
        textCaixas = view.findViewById(R.id.textCaixas);
        valorTotalCaixaTextView = view.findViewById(R.id.textView2);
        qtdTotalCaixaTextView = view.findViewById(R.id.textView4);
        qtdTotalCaixaAbertoTextView = view.findViewById(R.id.textView5);
        qtdTotalCaixaFechadoTextView = view.findViewById(R.id.textView6);
    }
}