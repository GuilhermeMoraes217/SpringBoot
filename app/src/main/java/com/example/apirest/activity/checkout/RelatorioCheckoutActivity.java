package com.example.apirest.activity.checkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.adapter.checkout.AdapterCkeckoutCaixas;
import com.example.apirest.interfaces.ContasService;
import com.example.apirest.interfaces.EmpresasService;
import com.example.apirest.interfaces.ResumoCaixaService;
import com.example.apirest.interfaces.UsuariosService;
import com.example.apirest.model.Empresas;
import com.example.apirest.model.checkout.Contas;
import com.example.apirest.model.checkout.ResumoCaixa;
import com.example.apirest.model.checkout.Usuarios;
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

public class RelatorioCheckoutActivity extends AppCompatActivity implements AdapterCkeckoutCaixas.ItemClickListener {

    /**
     * Atributos que irao receber o popular as classes RESUMO_CAIXA
     */
    ResumoCaixaService resumoCaixaService;
    List<ResumoCaixa> resumoCaixaList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes CONTAS
     */
    ContasService contasService;
    List<Contas> contasList = new ArrayList<>();
    List<Contas> updateContasList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes USUARIOS
     */
    UsuariosService usuariosService;
    List<Usuarios> usuariosList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes EMPRESA
     */
    EmpresasService empresasService;
    List<Empresas> empresasList = new ArrayList<>();

    /**
     *ATRIBUTOS VARIADOS DO LAYOUT
     */
    private TextView datalayoutTextView, totalValorCaixasTextView, qtdCaixasTextView;
    private Double totalValorCaixasEntrada = 0.0, totalValorCaixasSaida = 0.0;
    private int qtdCaixas = 0;
    private RecyclerView recyclerViewCaixa;
    AdapterCkeckoutCaixas adapterCkeckoutCaixas;
    Date date2;
    String formattedDateAtual;
    String dataBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_checkout);

        inicializaComponentes();
        RecuperaListEmpresa();
        inicializaRecyclerView();
    }

    /**
     * Método que inicializa o recycler view
     */
    private void inicializaRecyclerView() {
        recyclerViewCaixa.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCaixa.setHasFixedSize(true);
        adapterCkeckoutCaixas = new AdapterCkeckoutCaixas(updateContasList, resumoCaixaList, this, this);
        recyclerViewCaixa.setAdapter(adapterCkeckoutCaixas);
    }

    public void RecuperaListEmpresa() {
        empresasService = Apis.getEmpresasService();
        Call<List<Empresas>> call = empresasService.getEmpresas();
        call.enqueue(new Callback<List<Empresas>>() {
            @Override
            public void onResponse(Call<List<Empresas>> call, Response<List<Empresas>> response) {
                empresasList.clear();

                if (response.isSuccessful()) {
                    empresasList = response.body();
                }
                RecuperaListResumoUsuarios();
            }

            @Override
            public void onFailure(Call<List<Empresas>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void RecuperaListResumoUsuarios() {
        usuariosService = Apis.getUsuariosService();
        Call<List<Usuarios>> call = usuariosService.getUsuarios();
        call.enqueue(new Callback<List<Usuarios>>() {
            @Override
            public void onResponse(Call<List<Usuarios>> call, Response<List<Usuarios>> response) {
                usuariosList.clear();

                if (response.isSuccessful()) {
                    usuariosList = response.body();
                }
                RecuperaListResumoCaixa();
            }

            @Override
            public void onFailure(Call<List<Usuarios>> call, Throwable t) {
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

                if (response.isSuccessful()) {
                    resumoCaixaList = response.body();
                }

                RecuperaListContas();
            }

            @Override
            public void onFailure(Call<List<ResumoCaixa>> call, Throwable t) {
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
                //DATA ATUAL
                Date d = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                //String formattedDateAtual = df.format(d);
                String formattedDateAtual = "2023-03-02";

                //ZERANDO VALORES DO QUANTIDADE CAIXAS E VALORES
                qtdCaixas = 0;
                totalValorCaixasEntrada = 0.0;
                totalValorCaixasSaida = 0.0;

                if (response.isSuccessful()) {
                    List<Contas> contas = response.body();

                    for (Contas c : contas) {
                        if (formattedDateAtual.equals(c.getData_abertura())) {
                            for (Empresas e : empresasList) {
                                for (Usuarios u : usuariosList) {
                                    for (ResumoCaixa rc : resumoCaixaList) {
                                        if (c.getId_usuario() == u.getCodigo() && rc.getFkempresa() == e.getCodigo() &&
                                                rc.getCaixa() == c.getCodigo() && rc.getUsuario() == u.getCodigo()) {

                                            c.setNomeUsuarioCaixa(u.getLogin());
                                            c.setNomeEmpresaCaixa(e.getRazao());
                                            c.setDataHoraCaixa(rc.getData_hora());

                                            c.setValorTotalCaixa(rc.getEntrada());
                                            c.setValorTotalCaixaSaida(rc.getSaida());
                                            c.setFlagCaixa(rc.getFlag());
                                            c.setTipoCaixa(rc.getTipo());

                                            contasList.add(c);
                                        }

                                        //RECUPERANDO OS VALORES TOTAL DOS CAIXAS
                                        formatandoDataHora(rc.getData_hora());
                                        if (formattedDateAtual.equals(dataBanco)) {
                                            //conversa, pegar valores abertos e fechados
                                            if (rc.getTipo().equals("D") && !rc.getFlag().equals("B")) {
                                                totalValorCaixasEntrada += rc.getEntrada();
                                                totalValorCaixasSaida += rc.getSaida();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    for(Contas contas1 : contasList) {
                        if (!updateContasList.contains(contas1)) {
                            updateContasList.add(contas1);
                        }
                    }

                    if (updateContasList.size() > 0) {
                        qtdCaixasTextView.setText(Integer.toString(updateContasList.size()));
                        totalValorCaixasTextView.setText("R$ " + GetMask.getValor(totalValorCaixasEntrada - totalValorCaixasSaida));
                    }

                    adapterCkeckoutCaixas.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Contas>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });
    }

    public void formatandoDataHora(String rc) {
        //DATA ATUAL
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formattedDateAtual = df.format(d);

        //DATA DO BANCO
        String sDate2 = rc;
        SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");
        try {
            date2=formatter2.parse(sDate2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        Date db = date2;
        SimpleDateFormat fdb = new SimpleDateFormat("yyyy-MM-dd");
        dataBanco = fdb.format(db);
    }

    public void inicializaComponentes() {
        recyclerViewCaixa = findViewById(R.id.recyclerViewCaixa);
        datalayoutTextView = findViewById(R.id.textView14);
        qtdCaixasTextView = findViewById(R.id.totalCaixasTextView);
        totalValorCaixasTextView = findViewById(R.id.textView15);
    }

    @Override
    public void onClick(Contas contas) {

    }
}