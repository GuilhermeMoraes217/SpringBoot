package com.example.apirest.fragments.produtos;

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

import com.example.apirest.R;
import com.example.apirest.activity.empresa.PersonaActivity;
import com.example.apirest.activity.produtos.mes.RelatorioDeProdutosVendasMesActivity;
import com.example.apirest.activity.produtos.mes.TotalPedidosProdutosMesActivity;
import com.example.apirest.activity.produtos.semana.TotalPedidosProdutosSemanaActivity;
import com.example.apirest.adapter.PersonaAdapter;
import com.example.apirest.model.Persona;
import com.example.apirest.model.Produtos;
import com.example.apirest.model.vendas.FormaPagamento;
import com.example.apirest.model.vendas.VendasDetalhes;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.model.vendas.Vendasfpg;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.FormaPagamentoService;
import com.example.apirest.utils.GetMask;
import com.example.apirest.utils.PersonaService;
import com.example.apirest.utils.ProdutosService;
import com.example.apirest.utils.VendasDetalhesService;
import com.example.apirest.utils.VendasMasterService;
import com.example.apirest.utils.VendasfpgService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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


public class ProdutosMesFragment extends Fragment {
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
     * Atributos variados do layout produtos
     */
    static List<String> stringsData = new ArrayList<>();


    ProgressBar progressBarTotalPedido, progressBarMediaItens, progressBarItensVendido;

    TextView valortotalItensVendidoTextView, totalIPedidosTextView, mediaItensPedidoTextView;

    int valortotalItensVendido = 0;
    int totalIPedidos = 0;
    int mediaItensPedido = 0;
    PersonaService personaService;
    List<Persona> listPersona = new ArrayList<>();
    ListView listView;
    TextView textListaVazia;
    ProgressBar progressBar;
    ConstraintLayout totalItensVendidosProdutos, totalPedidosProdutos;
    FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produtos_mes, container, false);

        inicializaComponentes(view);
        recuperaDataSemana();
        inicializaCliques(view);
        RecuperaListProdutos();
        listPersons();

        return  view;
    }

    public void inicializaCliques(View view) {
        FloatingActionButton fab = view.findViewById(R.id.fabe);
        fab.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), PersonaActivity.class);
            intent.putExtra("ID", "");
            intent.putExtra("NOMBRE", "");
            intent.putExtra("APELLIDO", "");
            startActivity(intent);
        });

        fab.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), PersonaActivity.class);
            intent.putExtra("ID", "");
            intent.putExtra("NOMBRE", "");
            intent.putExtra("APELLIDO", "");
            startActivity(intent);
        });
        totalItensVendidosProdutos.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), RelatorioDeProdutosVendasMesActivity.class);
            startActivity(intent);
        });

        totalPedidosProdutos.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), TotalPedidosProdutosMesActivity.class);
            startActivity(intent);
        });

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
    private void limpandoComponetes () {
        totalIPedidos = 0;

    }

    public void RecuperaListVendasDetalhes() {
        limpandoComponetes();
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
                                if (vendasMaster1.getTotal() > 0 && vendasMaster1.getNome() != null) {
                                    totalIPedidos++;
                                }
                                for (VendasDetalhes vendasDetalhes : vendasDetalhesList1) {
                                    for (Produtos produtos : vendasProdutosList) {
                                        if (vendasDetalhes.getFkvenda() == vendasMaster1.getCodigo() && vendasDetalhes.getId_produto() == produtos.getCodigo()) {
                                            if (vendasMaster1.getTotal() > 0 && vendasMaster1.getSituacao().equals("F")) {
                                                vendasDetalhes.setNomeProduto(produtos.getDescricao());
                                                vendasDetalhes.setReferenciaProduto(produtos.getReferencia());
                                                contadorItensVendido+=vendasDetalhes.getQtd();
                                                vendasDetalhesList.add(vendasDetalhes);
                                            }

                                        }
                                    }
                                }
                            } else {
                                progressBar.setVisibility(View.GONE);
                                progressBarItensVendido.setVisibility(View.GONE);
                                progressBarTotalPedido.setVisibility(View.GONE);
                                progressBarMediaItens.setVisibility(View.GONE);

                                totalIPedidosTextView.setText(Integer.toString(0));
                                valortotalItensVendidoTextView.setText(Integer.toString(0));
                                mediaItensPedidoTextView.setText(Integer.toString(0));
                            }
                        }

                    }
                    if (vendasDetalhesList.size() > 0) {
                        progressBar.setVisibility(View.GONE);
                        progressBarItensVendido.setVisibility(View.GONE);
                        progressBarTotalPedido.setVisibility(View.GONE);
                        progressBarMediaItens.setVisibility(View.GONE);

                        valortotalItensVendidoTextView.setText(Integer.toString(GetMask.getValorDoubleForInt(contadorItensVendido)));
                        totalIPedidosTextView.setText(Integer.toString(totalIPedidos));
                        mediaItensPedidoTextView.setText(Double.toString(contadorItensVendido / totalIPedidos));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<VendasDetalhes>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
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

    @Override
    public void onResume() {
        listPersons();
        super.onResume();
    }

    public void inicializaComponentes(View view) {
        listView = view.findViewById(R.id.listView);
        textListaVazia = view.findViewById(R.id.textListaVazia);
        progressBar = view.findViewById(R.id.progressBar);
        fab = view.findViewById(R.id.fabe);
        totalItensVendidosProdutos = view.findViewById(R.id.VerProdutosProdutos);
        totalPedidosProdutos = view.findViewById(R.id.constraintLayout2);

        progressBarTotalPedido = view.findViewById(R.id.progressBarTotalPedido);
        progressBarMediaItens = view.findViewById(R.id.progressBarMediaItens);
        progressBarItensVendido = view.findViewById(R.id.progressBarItensVendido);

        valortotalItensVendidoTextView = view.findViewById(R.id.textView2);
        totalIPedidosTextView = view.findViewById(R.id.textView4);
        mediaItensPedidoTextView = view.findViewById(R.id.textView5);

    }
}