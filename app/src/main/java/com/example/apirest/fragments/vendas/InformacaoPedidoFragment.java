package com.example.apirest.fragments.vendas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apirest.R;
import com.example.apirest.model.RelatorioVendas;
import com.example.apirest.model.vendas.VendasMaster;

import java.util.ArrayList;


public class InformacaoPedidoFragment extends Fragment {

    VendasMaster relatorioVendas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacao_pedido, container, false);
        Bundle bundle = getActivity().getIntent().getExtras();
        relatorioVendas = (VendasMaster) bundle.getSerializable("relatorioVendasSelecionados");


        return view;
    }
}