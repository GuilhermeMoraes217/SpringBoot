package com.example.apirest.fragments.produtos.semana;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.activity.produtos.InformacoesGrupoItensProdutosActivity;
import com.example.apirest.adapter.produtos.AdapterRelatorioGrupoVendasSemana;
import com.example.apirest.model.Grupos;
import com.example.apirest.model.Produtos;
import com.example.apirest.model.vendas.VendasDetalhes;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.GruposService;
import com.example.apirest.utils.ProdutosService;
import com.example.apirest.utils.VendasDetalhesService;
import com.example.apirest.utils.VendasMasterService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RelatorioGruposVendasSemanaFragment extends Fragment implements AdapterRelatorioGrupoVendasSemana.ItemClickListener {

    /**
     * Atributos que irao receber o popular as classes Grupos
     */
    GruposService gruposService;
    List<Grupos> gruposList = new ArrayList<>();
    List<Grupos> updateListGrupo = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes Produtos
     */
    ProdutosService produtosService;
    List<Produtos> produtosList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes VendasMaster
     */
    VendasMasterService vendasMasterService;
    List<VendasMaster> listVendasMaster = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes VendasDetalhes
     */
    VendasDetalhesService vendasDetalhesService;
    List<VendasDetalhes> vendasDetalhesList = new ArrayList<>();

    /**
     * Atributos aleatorios do layout
     */
    private RecyclerView recyclerViewGrupoList;
    private AdapterRelatorioGrupoVendasSemana adapterRelatorioGrupoVendasSemana;

    private TextView totalItens, porcentagemTotalItens, textListaVazia;

    private ProgressBar progressBar;

    static List<String> stringsData = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relatorio_grupos_vendas_semana, container, false);

        inicializaComponentes(view);
        recuperaDataSemana();
        RecuperaListVendasMaster();

        return view;
    }

    /**
     * Método que inicializa o recycler view do relatorio de vendas
     */
    private void inicializaRecyclerView() {
        recyclerViewGrupoList.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewGrupoList.setHasFixedSize(true);
        adapterRelatorioGrupoVendasSemana = new AdapterRelatorioGrupoVendasSemana(updateListGrupo, vendasDetalhesList, produtosList, listVendasMaster, getContext(), this);
        recyclerViewGrupoList.setAdapter(adapterRelatorioGrupoVendasSemana);
    }

    public static void printDatesInMonth(int year, int month, int day) {
        stringsData.clear();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day - 7); // alteracao aqui para listar O PADRAO É IGUAL A (0 ZERO)
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = day - 7; i < day; i++) {
            //System.out.println(fmt.format(cal.getTime()));
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
                RecuperaListProdutos();
            }

            @Override
            public void onFailure(Call<List<VendasMaster>> call, Throwable t) {
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
                if (response.isSuccessful()) {
                    vendasDetalhesList = response.body();
                }
                RecuperaListGrupos();
            }

            @Override
            public void onFailure(Call<List<VendasDetalhes>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });

    }

    /**
     * Método que recupera do banco de dados MySQl os dados que iram ser preenchidos na classe Produtos.
     */
    public void RecuperaListProdutos() {
        produtosService = Apis.getProdutos();
        Call<List<Produtos>> call = produtosService.getProdutosService();
        call.enqueue(new Callback<List<Produtos>>() {
            @Override
            public void onResponse(Call<List<Produtos>> call, Response<List<Produtos>> response) {
                produtosList.clear();
                if (response.isSuccessful()) {
                    produtosList = response.body();
                }
                RecuperaListVendasDetalhes();
            }

            @Override
            public void onFailure(Call<List<Produtos>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });
    }

    /**
     * Método que recupera do banco de dados MySQl os dados que iram ser preenchidos na classe GRUPOS.
     */
    public void RecuperaListGrupos() {
        gruposService = Apis.getGruposService();
        Call<List<Grupos>> call = gruposService.getGrupos();
        call.enqueue(new Callback<List<Grupos>>() {
            @Override
            public void onResponse(Call<List<Grupos>> call, Response<List<Grupos>> response) {
                gruposList.clear();
                double auxTotalItem = 0.0;
                if (response.isSuccessful()) {
                    List<Grupos> gruposList1 = response.body();
                    for (VendasMaster vm : listVendasMaster) {
                        for (String localDate : stringsData) {
                            if (localDate.equals(vm.getData_emissao())) {
                                for (VendasDetalhes vd : vendasDetalhesList) {
                                    for (Produtos p : produtosList) {
                                        for (Grupos g : gruposList1) {
                                            if (vd.getFkvenda() == vm.getCodigo() && p.getCodigo() == vd.getId_produto() && g.getCodigo() == p.getGrupo()) {
                                                if (vm.getTotal() > 0 && vm.getSituacao().equals("F")) {
                                                    auxTotalItem += vd.getQtd();
                                                    g.setData_emissao(vm.getData_emissao());
                                                    gruposList.add(g);
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                progressBar.setVisibility(View.GONE);
                                textListaVazia.setVisibility(View.VISIBLE);
                                textListaVazia.setText("Nenhum grupo de produto vendido");
                                totalItens.setText("0");
                            }
                        }
                    }

                    for (Grupos grupos : gruposList) {
                        if (!updateListGrupo.contains(grupos)) {
                            updateListGrupo.add(grupos);
                        }

                    }

                    if (!gruposList.isEmpty()) {
                        progressBar.setVisibility(View.GONE);
                        textListaVazia.setVisibility(View.GONE);
                        textListaVazia.setText(null);
                        totalItens.setText(Double.toString(auxTotalItem));
                    }

                    Log.i("", "" + updateListGrupo);
                    inicializaRecyclerView();
                    Collections.reverse(updateListGrupo);
                    adapterRelatorioGrupoVendasSemana.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<List<Grupos>> call, Throwable t) {
                Log.e("Error:", t.getMessage());

            }
        });
    }

    public void inicializaComponentes(View view) {
        recyclerViewGrupoList = view.findViewById(R.id.recyclerViewGrupoList);
        porcentagemTotalItens = view.findViewById(R.id.textView2);
        textListaVazia = view.findViewById(R.id.textListaVazia);
        progressBar = view.findViewById(R.id.progressBar);
        totalItens = view.findViewById(R.id.textView53);
    }


    @Override
    public void onClick(Grupos grupos) {
        Intent intent = new Intent(getActivity(), InformacoesGrupoItensProdutosActivity.class);
        intent.putExtra("informacoesGrupoSelecionado", grupos);
        startActivity(intent);
    }
}