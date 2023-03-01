package com.example.apirest.activity.produtos.semana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.adapter.produtos.AdapterInformacaoGrupoItensProdutos;
import com.example.apirest.model.Grupos;
import com.example.apirest.model.Produtos;
import com.example.apirest.model.RelatorioProdutos;
import com.example.apirest.model.vendas.FormaPagamento;
import com.example.apirest.model.vendas.VendasDetalhes;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.model.vendas.Vendasfpg;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.FormaPagamentoService;
import com.example.apirest.utils.ProdutosService;
import com.example.apirest.utils.VendasDetalhesService;
import com.example.apirest.utils.VendasMasterService;
import com.example.apirest.utils.VendasfpgService;

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

public class InformacoesGrupoItensProdutosSemanaActivity extends AppCompatActivity implements AdapterInformacaoGrupoItensProdutos.ItemClickListener {
    /**
     * Atributos que irao receber o popular as classes Empresas
     */
    VendasDetalhesService vendasDetalhesService;
    List<VendasDetalhes> vendasDetalhesList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes VendasMaster
     */
    VendasMasterService vendasMasterService;
    List<VendasMaster> listVendasMaster = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes Produtos
     */
    ProdutosService produtosService;
    List<Produtos> vendasProdutosList = new ArrayList<>();

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
     * Atributos da inicialização do recyclerView do relatorio de produtos
     */
    private RecyclerView recyclerViewRelatorioProdutos;
    private AdapterInformacaoGrupoItensProdutos adapterInformacaoGrupoItensProdutos;
    ArrayList<RelatorioProdutos> relatorioProdutos = new ArrayList<>();

    /**
     * Atributos dos textView da activity relatorio_de_Produtos
     */
    private TextView textViewPorcentagemGeral, textviewPorcentagemGeral2;
    private TextView textViewListaVazia, porcentagemItensVendidosTexteView, totalItensVendidoTexteView;
    private ProgressBar progressBar;
    static List<String> stringsData = new ArrayList<>();

    Grupos informacoesGrupoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_grupo_itens_produtos_semana);
        Bundle bundle = getIntent().getExtras();
        informacoesGrupoSelecionado = (Grupos) bundle.getSerializable("informacoesGrupoSelecionado");

        inicializaComponentes();
        recuperaDataSemana();
        RecuperaListProdutos();
        inicializaRecyclerView();

    }

    /**
     * Método que inicializa o recycler view do relatorio de Produtos
     */
    private void inicializaRecyclerView( ) {
        recyclerViewRelatorioProdutos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRelatorioProdutos.setHasFixedSize(true);
        adapterInformacaoGrupoItensProdutos = new AdapterInformacaoGrupoItensProdutos(vendasDetalhesList, this, this);
        recyclerViewRelatorioProdutos.setAdapter(adapterInformacaoGrupoItensProdutos);
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

    /**
     * Método que recupera do banco de dados MySQl os dados que iram ser preenchidos na classe RelatorioProdutos.
     */
    public void RecuperaListProdutos() {
        produtosService = Apis.getProdutos();
        Call<List<Produtos>> call = produtosService.getProdutosService();
        call.enqueue(new Callback<List<Produtos>>() {
            @Override
            public void onResponse(Call<List<Produtos>> call, Response<List<Produtos>> response) {
                vendasProdutosList.clear();
                if (response.isSuccessful()) {
                    vendasProdutosList = response.body();
                }
                RecuperaListVendasMaster();
            }

            @Override
            public void onFailure(Call<List<Produtos>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });
    }

    public void RecuperaListVendasMaster() {
        vendasMasterService = Apis.getVendasMasterService();
        Call<List<VendasMaster>> call = vendasMasterService.getVendasMaster();
        call.enqueue(new Callback<List<VendasMaster>>() {
            @Override
            public void onResponse(Call<List<VendasMaster>> call, Response<List<VendasMaster>> response) {
                listVendasMaster.clear();
                if (response.isSuccessful()) {
                    listVendasMaster = response.body();
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
                RecuperaListVendasDetalhes();
            }

            @Override
            public void onFailure(Call<List<FormaPagamento>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    public void RecuperaListVendasDetalhes() {
        vendasDetalhesService = Apis.getVendasDetalhesService();
        Call<List<VendasDetalhes>> call = vendasDetalhesService.getVendasDetalhes();
        call.enqueue(new Callback<List<VendasDetalhes>>() {
            @Override
            public void onResponse(Call<List<VendasDetalhes>> call, Response<List<VendasDetalhes>> response) {
                vendasDetalhesList.clear();
                Double contadorItensVendido = 0.0;
                if (response.isSuccessful()) {
                    List<VendasDetalhes> vendasDetalhesList1 = response.body();

                    for (VendasMaster vendasMaster1 : listVendasMaster) {
                        for (String localDate : stringsData) {
                            if (localDate.equals(vendasMaster1.getData_emissao())) {
                                for (VendasDetalhes vendasDetalhes : vendasDetalhesList1) {
                                    for (Produtos produtos : vendasProdutosList) {
                                        if (vendasDetalhes.getFkvenda() == vendasMaster1.getCodigo() && vendasDetalhes.getId_produto() == produtos.getCodigo()) {
                                            if (vendasMaster1.getTotal() > 0 && vendasMaster1.getSituacao().equals("F") && informacoesGrupoSelecionado.getCodigo() == produtos.getGrupo()) {
                                                vendasDetalhes.setNomeProduto(produtos.getDescricao());
                                                vendasDetalhes.setReferenciaProduto(produtos.getReferencia());
                                                contadorItensVendido += vendasDetalhes.getQtd();
                                                vendasDetalhesList.add(vendasDetalhes);
                                            }

                                        }
                                    }
                                }
                            }else{
                                progressBar.setVisibility(View.GONE);
                                textViewListaVazia.setVisibility(View.VISIBLE);
                                textViewListaVazia.setText("Nenhum item vendido");
                                porcentagemItensVendidosTexteView.setText("0%");
                                totalItensVendidoTexteView.setText("0");
                            }
                        }
                    }
                }
                if (!vendasDetalhesList.isEmpty()) {
                    progressBar.setVisibility(View.GONE);
                    textViewListaVazia.setVisibility(View.GONE);
                    textViewListaVazia.setText(null);
                    porcentagemItensVendidosTexteView.setText("100%");
                    totalItensVendidoTexteView.setText(Double.toString(contadorItensVendido));
                }
                adapterInformacaoGrupoItensProdutos.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<VendasDetalhes>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });
    }

    private void inicializaComponentes() {
        recyclerViewRelatorioProdutos = findViewById(R.id.recyclerViewRelatorioProdutos);
        textViewPorcentagemGeral = findViewById(R.id.text2);
        textviewPorcentagemGeral2 = findViewById(R.id.textView15);
        textViewListaVazia = findViewById(R.id.textListaVazia);
        porcentagemItensVendidosTexteView = findViewById(R.id.text2);
        totalItensVendidoTexteView = findViewById(R.id.textView15);
        progressBar = findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(VendasDetalhes relatorioProdutos) {

    }
}