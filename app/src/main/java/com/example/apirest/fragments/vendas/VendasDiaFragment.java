package com.example.apirest.fragments.vendas;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
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

import com.example.apirest.activity.produtos.VerProdutosVendasActivity;
import com.example.apirest.adapter.PersonaAdapter;
import com.example.apirest.activity.empresa.PersonaActivity;
import com.example.apirest.model.Persona;
import com.example.apirest.R;
import com.example.apirest.utils.Apis;
import com.example.apirest.utils.PersonaService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VendasDiaFragment extends Fragment {

    PersonaService personaService;
    List<Persona> listPersona=new ArrayList<>();
    ListView listView;
    TextView textListaVazia;
    ProgressBar progressBar;
    ConstraintLayout VerProdutosVendas;
    FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vendas_dia, container, false);
        InitComponentes(view);
        InitCliques(view);

        listPersons();

        return view;
    }

    public void InitCliques (View view) {
        fab.setOnClickListener(view1 -> {
            Intent intent=new Intent(getActivity(), PersonaActivity.class);
            intent.putExtra("ID","");
            intent.putExtra("NOMBRE","");
            intent.putExtra("APELLIDO","");
            startActivity(intent);
        });
        VerProdutosVendas.setOnClickListener(view1 -> {
            Intent intent=new Intent(getActivity(), VerProdutosVendasActivity.class);
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
        VerProdutosVendas = view.findViewById(R.id.VerProdutosVendas);

    }
}