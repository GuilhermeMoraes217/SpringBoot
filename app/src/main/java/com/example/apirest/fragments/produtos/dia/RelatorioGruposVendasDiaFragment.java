package com.example.apirest.fragments.produtos.dia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apirest.R;
import com.example.apirest.adapter.AdapterRelatorioGrupoVendas;
import com.example.apirest.adapter.vendas.totalvendas.AdapterRelatorioVendas;
import com.example.apirest.model.Grupos;
import com.example.apirest.model.Produtos;
import com.example.apirest.model.vendas.VendasDetalhes;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.GruposService;
import com.example.apirest.utils.ProdutosService;
import com.example.apirest.utils.VendasDetalhesService;
import com.example.apirest.utils.VendasMasterService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RelatorioGruposVendasDiaFragment extends Fragment implements AdapterRelatorioGrupoVendas.ItemClickListener {

    /**
     * Atributos que irao receber o popular as classes Empresas
     */
    GruposService gruposService;
    List<Grupos> gruposList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes VendasMaster
     */
    ProdutosService produtosService;
    List<Produtos> produtosList = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes VendasMaster
     */
    VendasMasterService vendasMasterServiceDia;
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
    private AdapterRelatorioGrupoVendas adapterRelatorioGrupoVendas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relatorio_grupos_vendas, container, false);

        inicializaComponentes(view);
        inicializaRecyclerView();
        RecuperaListVendasMaster();

        return view;
    }

    /**
     * Método que inicializa o recycler view do relatorio de vendas
     */
    private void inicializaRecyclerView() {
        recyclerViewGrupoList.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewGrupoList.setHasFixedSize(true);
        adapterRelatorioGrupoVendas = new AdapterRelatorioGrupoVendas(gruposList, getContext(), this);
        recyclerViewGrupoList.setAdapter(adapterRelatorioGrupoVendas);
    }

    public void RecuperaListVendasMaster() {
        vendasMasterServiceDia = Apis.getVendasMasterService();
        Call<List<VendasMaster>> call = vendasMasterServiceDia.getVendasMaster();
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
     * VENDAS_MASTER VM
     * INNER JOIN vendas_detalhe vd on vd.fkvenda = vm.codigo
     * INNER JOIN produto p on p.codigo = vd.id_produto
     * INNER JOIN grupo g on g.codigo = p.grupo
     */
    public void RecuperaListGrupos() {
        gruposService = Apis.getGruposService();
        Call<List<Grupos>> call = gruposService.getGrupos();
        call.enqueue(new Callback<List<Grupos>>() {
            @Override
            public void onResponse(Call<List<Grupos>> call, Response<List<Grupos>> response) {
                gruposList.clear();
                if (response.isSuccessful()) {
                    List<Grupos> gruposList1 = response.body();

                    for (Grupos g : gruposList1) {
                        gruposList.add(g);
                        for (VendasMaster vm : listVendasMaster) {
                            for (VendasDetalhes vd : vendasDetalhesList) {
                                for (Produtos p : produtosList) {
                                    if (vd.getFkvenda() == vm.getCodigo()) {
                                        if (p.getCodigo() == vd.getId_produto()) {
                                            if (g.getCodigo() == p.getGrupo()) {

                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                    Log.i("", "" + gruposList);
                    adapterRelatorioGrupoVendas.notifyDataSetChanged();
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
    }

    @Override
    public void onClick(Grupos grupos) {

    }
}