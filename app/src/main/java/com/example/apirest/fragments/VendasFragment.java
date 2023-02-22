package com.example.apirest.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.adapter.ViewPagerAdapter;
import com.example.apirest.fragments.produtos.ProdutosDiaFragment;
import com.example.apirest.fragments.vendas.VendasAnoFragment;
import com.example.apirest.fragments.vendas.VendasDiaFragment;
import com.example.apirest.fragments.vendas.VendasMesFragment;
import com.example.apirest.fragments.vendas.VendasSemanaFragment;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Date;


public class VendasFragment extends Fragment {

    private TabLayout tab_Layout;
    private ViewPager view_Pager;

    private String formattedDateAtual;

    private TextView text_toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vendas, container, false);

        inicializarComponentes(view);
        recuperandoData();
        configTabsLayout();
        configCliques(view);


        return view;
    }

    private void configCliques(View view) {
        //view.findViewById(R.id.ib_Voltar).setOnClickListener(view1 ->startActivity(new Intent(getContext(), HomeActivity.class)));
    }

    public void recuperandoData() {
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        formattedDateAtual = df.format(d);

        text_toolbar.setText(formattedDateAtual);
    }


    private void configTabsLayout() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new VendasDiaFragment(), "Dia");
        viewPagerAdapter.addFragment(new VendasSemanaFragment(), "Semana");
        viewPagerAdapter.addFragment(new VendasMesFragment(), "Mes");
        viewPagerAdapter.addFragment(new VendasAnoFragment(), "Ano");

        view_Pager.setAdapter(viewPagerAdapter);
        view_Pager.setSaveEnabled(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tab_Layout.setElevation(0);
        }
        tab_Layout.setupWithViewPager(view_Pager);
    }

    private void inicializarComponentes(View view) {
        view_Pager = view.findViewById(R.id.view_pager);
        tab_Layout = view.findViewById(R.id.tab_Layout);

        text_toolbar = view.findViewById(R.id.txtToobarData);

    }
}