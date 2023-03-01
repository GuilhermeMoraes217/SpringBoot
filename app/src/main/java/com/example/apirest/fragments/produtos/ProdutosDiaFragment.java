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
import com.example.apirest.activity.produtos.dia.RelatorioDeProdutosVendasDiaActivity;
import com.example.apirest.activity.produtos.dia.TotalPedidosProdutosDiaActivity;
import com.example.apirest.adapter.PersonaAdapter;
import com.example.apirest.model.Persona;
import com.example.apirest.model.Produtos;
import com.example.apirest.model.vendas.FormaPagamento;
import com.example.apirest.model.vendas.VendasDetalhes;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.model.vendas.Vendasfpg;
import com.example.apirest.utils.Apis;
import com.example.apirest.interfaces.FormaPagamentoService;
import com.example.apirest.utils.GetMask;
import com.example.apirest.interfaces.PersonaService;
import com.example.apirest.interfaces.ProdutosService;
import com.example.apirest.interfaces.VendasDetalhesService;
import com.example.apirest.interfaces.VendasMasterService;
import com.example.apirest.interfaces.VendasfpgService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProdutosDiaFragment extends Fragment {
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
    ConstraintLayout totalitemProdutosVendido, totalPedido;
    FloatingActionButton fab;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produtos_dia, container, false);

        inicializaComponentes(view);
        inicializaCliques(view);
        RecuperaListProdutos();
        listPersons();

        return view;
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
        totalitemProdutosVendido.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), RelatorioDeProdutosVendasDiaActivity.class);
            startActivity(intent);
        });

        totalPedido.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), TotalPedidosProdutosDiaActivity.class);
            startActivity(intent);
        });

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

    public void RecuperaListVendasDetalhes() {
        limpandoComponetes();
        vendasDetalhesService = Apis.getVendasDetalhesService();
        Call<List<VendasDetalhes>> call = vendasDetalhesService.getVendasDetalhes();
        call.enqueue(new Callback<List<VendasDetalhes>>() {
            @Override
            public void onResponse(Call<List<VendasDetalhes>> call, Response<List<VendasDetalhes>> response) {
                vendasDetalhesList.clear();
                Double contadorItensVendido = 0.0;

                /**
                 * LIMITANTO A DATA PARA SOMENTE PARA DATA ATUAL
                 */
                Date d = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDateAtual = df.format(d);

                if (response.isSuccessful()) {
                    List<VendasDetalhes> vendasDetalhesList1 = response.body();

                    for (VendasMaster vendasMaster1 : listVendasMaster) {
                        if (vendasMaster1.getData_emissao().equals(formattedDateAtual)) {
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

                        } else{
                            progressBar.setVisibility(View.GONE);
                            progressBarItensVendido.setVisibility(View.GONE);
                            progressBarTotalPedido.setVisibility(View.GONE);
                            progressBarMediaItens.setVisibility(View.GONE);

                            totalIPedidosTextView.setText(Integer.toString(0));
                            valortotalItensVendidoTextView.setText(Integer.toString(0));
                            mediaItensPedidoTextView.setText(Integer.toString(0));
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

    private void limpandoComponetes () {
        totalIPedidos = 0;
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
        totalitemProdutosVendido = view.findViewById(R.id.VerProdutosProdutos);
        totalPedido = view.findViewById(R.id.constraintLayout2);

        progressBarTotalPedido = view.findViewById(R.id.progressBarTotalPedido);
        progressBarMediaItens = view.findViewById(R.id.progressBarMediaItens);
        progressBarItensVendido = view.findViewById(R.id.progressBarItensVendido);

        valortotalItensVendidoTextView = view.findViewById(R.id.textView2);
        totalIPedidosTextView = view.findViewById(R.id.textView4);
        mediaItensPedidoTextView = view.findViewById(R.id.textView5);

    }
}