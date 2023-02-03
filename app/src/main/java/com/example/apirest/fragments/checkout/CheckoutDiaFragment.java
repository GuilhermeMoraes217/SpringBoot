package com.example.apirest.fragments.checkout;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.activity.checkout.RelatorioCheckoutActivity;


public class CheckoutDiaFragment extends Fragment {

    private TextView textCaixas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_checkout_dia, container, false);

        inicializaComponentes(view);
        inicializaCliques();


        return view;
    }

    private void inicializaCliques() {
        textCaixas.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), RelatorioCheckoutActivity.class);
            startActivity(intent);
        });
    }

    private void inicializaComponentes(View view) {
        textCaixas = view.findViewById(R.id.textCaixas);
    }
}