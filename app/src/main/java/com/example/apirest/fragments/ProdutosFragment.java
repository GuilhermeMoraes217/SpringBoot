package com.example.apirest.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apirest.R;
import com.example.apirest.adapter.ViewPagerAdapter;
import com.example.apirest.fragments.produtos.ProdutosAnoFragment;
import com.example.apirest.fragments.produtos.ProdutosDiaFragment;
import com.example.apirest.fragments.produtos.ProdutosMesFragment;
import com.example.apirest.fragments.produtos.ProdutosSemanaFragment;
import com.example.apirest.fragments.vendas.VendasDiaFragment;
import com.google.android.material.tabs.TabLayout;


public class ProdutosFragment extends Fragment {

    private TabLayout tab_Layout;
    private ViewPager view_Pager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produtos, container, false);

        inicializarComponentes(view);
        configTabsLayout();
        configCliques(view);

        return view;
    }


    private void configCliques(View view){
        //view.findViewById(R.id.ib_Voltar).setOnClickListener(view1 ->startActivity(new Intent(getContext(), HomeActivity.class)));
    }


    private void configTabsLayout(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new ProdutosDiaFragment(), "Dia");
        viewPagerAdapter.addFragment(new ProdutosSemanaFragment(), "Semana");
        viewPagerAdapter.addFragment(new ProdutosMesFragment(), "Mes");
        viewPagerAdapter.addFragment(new ProdutosAnoFragment(), "Ano");

        view_Pager.setAdapter(viewPagerAdapter);
        view_Pager.setSaveEnabled(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tab_Layout.setElevation(0);
        }
        tab_Layout.setupWithViewPager(view_Pager);
    }

    private void inicializarComponentes(View view){
        view_Pager =  view.findViewById(R.id.view_pager);
        tab_Layout =  view.findViewById(R.id.tab_Layout);

    }
}