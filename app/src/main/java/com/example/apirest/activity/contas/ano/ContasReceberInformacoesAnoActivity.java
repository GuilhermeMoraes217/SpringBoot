package com.example.apirest.activity.contas.ano;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;

import com.example.apirest.R;
import com.example.apirest.adapter.ViewPagerAdapter;
import com.example.apirest.fragments.contas.ano.RelatorioContasReceberInformacoesVMAnoFragment;
import com.example.apirest.fragments.contas.ano.RelatorioContasReceberParcelaVMAnoFragment;
import com.example.apirest.fragments.contas.mes.RelatorioContasReceberInformacoesVMMesFragment;
import com.example.apirest.fragments.contas.mes.RelatorioContasReceberParcelaVMMesFragment;
import com.google.android.material.tabs.TabLayout;

public class ContasReceberInformacoesAnoActivity extends AppCompatActivity {

    private TabLayout tab_Layout;
    private ViewPager view_Pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contas_receber_informacoes_ano);

        initializerComponent();
        configTabsLayout();
        configCliques();
    }

    private void configCliques(){
        //view.findViewById(R.id.ib_Voltar).setOnClickListener(view1 ->startActivity(new Intent(getContext(), HomeActivity.class)));
    }


    private void configTabsLayout(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new RelatorioContasReceberInformacoesVMAnoFragment(), "Informações");
        viewPagerAdapter.addFragment(new RelatorioContasReceberParcelaVMAnoFragment(), "Parcelas");

        view_Pager.setAdapter(viewPagerAdapter);
        view_Pager.setSaveEnabled(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tab_Layout.setElevation(0);
        }
        tab_Layout.setupWithViewPager(view_Pager);
    }

    private void initializerComponent(){
        view_Pager =  findViewById(R.id.view_pager);
        tab_Layout =  findViewById(R.id.tab_Layout);

    }
}