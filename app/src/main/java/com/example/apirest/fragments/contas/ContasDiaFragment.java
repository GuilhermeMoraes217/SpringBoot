package com.example.apirest.fragments.contas;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.activity.contas.RelatorioContasActivity;


public class ContasDiaFragment extends Fragment {
    private TextView textRelatorioContas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contas_dia, container, false);

        inicializaComponentes(view);
        iniciaCliques(view);


        return view;
    }

    private void iniciaCliques(View view) {

        textRelatorioContas.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), RelatorioContasActivity.class);
            startActivity(intent);
        });
    }

    private void inicializaComponentes(View view) {

        textRelatorioContas = view.findViewById(R.id.textRelatorioContas);
    }
}