package com.example.apirest.fragments.vendas;

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

import com.example.apirest.activity.vendas.RelatorioDeVendasActivity;
import com.example.apirest.adapter.PersonaAdapter;
import com.example.apirest.activity.empresa.PersonaActivity;
import com.example.apirest.model.Persona;
import com.example.apirest.R;
import com.example.apirest.model.vendas.FormaPagamento;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.model.vendas.Vendasfpg;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.FormaPagamentoService;
import com.example.apirest.utils.GetMask;
import com.example.apirest.utils.PersonaService;
import com.example.apirest.utils.VendasMasterService;
import com.example.apirest.utils.VendasfpgService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VendasDiaFragment extends Fragment {

    /**
     * Atributos que irao receber o popular as classes Personas
     */
    PersonaService personaService;
    List<Persona> listPersona=new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes VendasMaster
     */
    VendasMasterService vendasMasterService;
    List<VendasMaster> listVendasMaster = new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes Vendasfpg
     */
    VendasfpgService vendasfpgService;
    List<Vendasfpg> listvendasfpg=new ArrayList<>();

    /**
     * Atributos que irao receber o popular as classes FormaPagamento
     */
    FormaPagamentoService formaPagamentoService;
    List<FormaPagamento> listformaPagamento=new ArrayList<>();


    ListView listView;
    TextView textListaVazia;
    ProgressBar progressBar;
    ConstraintLayout verProdutosVendas;
    FloatingActionButton fab;

    private TextView valorGeralVendas, totaldePedidos, totalPedidosCancelados;
    Double valorVendasDia = 0.0;

    int pedidosCancelados = 0;
    String totalNumeroPedidos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vendas_dia, container, false);
        InitComponentes(view);
        InitCliques(view);

        listPersons();
        RecuperaListVendasMaster();

        return view;
    }

    private void ExibirComponentes() {

        totalNumeroPedidos=Integer.toString(listVendasMaster.size());
        for (VendasMaster vendasMaster : listVendasMaster) {
            if (vendasMaster.getSituacao().equals("C")) {
                pedidosCancelados++;
            }
            for (Vendasfpg vendasfpg : listvendasfpg) {
                for (FormaPagamento formaPagamento : listformaPagamento) {
                    if ( vendasfpg.getVendas_master() == vendasMaster.getCodigo()) {
                        if (vendasfpg.getId_forma() == formaPagamento.getCodigo()){
                            if (vendasMaster.getSituacao().equals("F") && !formaPagamento.getGeracr().equals("R")){
                                valorVendasDia += vendasfpg.getValor();
                            }

                        }
                    }
                }
            }
        }

        totaldePedidos.setText(totalNumeroPedidos);
        totalPedidosCancelados.setText(Integer.toString(pedidosCancelados));
        valorGeralVendas.setText( "R$ " + GetMask.getValor(valorVendasDia));

    }

    public void InitCliques (View view) {
        fab.setOnClickListener(view1 -> {
            Intent intent=new Intent(getActivity(), PersonaActivity.class);
            intent.putExtra("ID","");
            intent.putExtra("NOMBRE","");
            intent.putExtra("APELLIDO","");
            startActivity(intent);
        });
        verProdutosVendas.setOnClickListener(view1 -> {
            Intent intent=new Intent(getActivity(), RelatorioDeVendasActivity.class);
            startActivity(intent);
        });

    }
    public void listPersons(){
        personaService= Apis.getPersonaService();
        Call<List<Persona>> call=personaService.getPersonas();
        call.enqueue(new Callback<List<Persona>>() {
            @Override
            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
                if(response.isSuccessful()) {
                    listPersona = response.body();
                    listView.setAdapter(new PersonaAdapter(getActivity(),R.layout.content_main,listPersona));
                    textListaVazia.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Persona>> call, Throwable t) {
                Log.e("Error:",t.getMessage());
                progressBar.setVisibility(View.GONE);
                textListaVazia.setVisibility(View.VISIBLE);
            }
        });

    }
    public void RecuperaListVendasMaster(){
        vendasMasterService= Apis.getVendasMasterService();
        Call<List<VendasMaster>> call=vendasMasterService.getVendasMaster();
        call.enqueue(new Callback<List<VendasMaster>>() {
            @Override
            public void onResponse(Call<List<VendasMaster>> call, Response<List<VendasMaster>> response) {
                if(response.isSuccessful()) {
                    listVendasMaster = response.body();
                }
                RecuperalistVendasfpg();

            }

            @Override
            public void onFailure(Call<List<VendasMaster>> call, Throwable t) {
                Log.e("Error:",t.getMessage());

            }
        });

    }
    public void RecuperalistVendasfpg(){
        vendasfpgService= Apis.getVendasfpgService();
        Call<List<Vendasfpg>> call=vendasfpgService.getVendasfpg();
        call.enqueue(new Callback<List<Vendasfpg>>() {
            @Override
            public void onResponse(Call<List<Vendasfpg>> call, Response<List<Vendasfpg>> response) {
                if(response.isSuccessful()) {
                    listvendasfpg = response.body();
                }
                RecuperalistFormaPagamento();

            }

            @Override
            public void onFailure(Call<List<Vendasfpg>> call, Throwable t) {
                Log.e("Error:",t.getMessage());

            }
        });

    }
    public void RecuperalistFormaPagamento(){
        formaPagamentoService= Apis.getFormaPagamentoService();
        Call<List<FormaPagamento>> call= formaPagamentoService.getFormaPagamento();
        call.enqueue(new Callback<List<FormaPagamento>>() {
            @Override
            public void onResponse(Call<List<FormaPagamento>> call, Response<List<FormaPagamento>> response) {
                if(response.isSuccessful()) {
                    listformaPagamento = response.body();
                }
                ExibirComponentes();
            }

            @Override
            public void onFailure(Call<List<FormaPagamento>> call, Throwable t) {
                Log.e("Error:",t.getMessage());

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

    public void InitComponentes (View view) {
        listView=view.findViewById(R.id.listView);
        textListaVazia=view.findViewById(R.id.textListaVazia);
        progressBar=view.findViewById(R.id.progressBar);
        fab = view.findViewById(R.id.fabe);
        verProdutosVendas = view.findViewById(R.id.VerProdutosVendas);
        valorGeralVendas = view.findViewById(R.id.textView2);
        totaldePedidos = view.findViewById(R.id.textView4);
        totalPedidosCancelados = view.findViewById(R.id.textView6);

    }
}