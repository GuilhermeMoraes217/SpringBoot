package com.example.apirest;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.apirest.Adapter.PersonaAdapter;
import com.example.apirest.Adapter.ViewPagerAdapter;
import com.example.apirest.Empresa.PersonaActivity;
import com.example.apirest.Fragments.PedidosEmAndamentoFragment;
import com.example.apirest.Model.Persona;
import com.example.apirest.Utils.Apis;
import com.example.apirest.Utils.PersonaService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab_Layout;
    private ViewPager view_Pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciaComponets();
        configTabsLayout();

    }

    private void configTabsLayout(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new PedidosEmAndamentoFragment(), "Pedidos andamentos");
        viewPagerAdapter.addFragment(new PedidosEmAndamentoFragment(), "Finalizados");

        view_Pager.setAdapter(viewPagerAdapter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tab_Layout.setElevation(0);
        }
        tab_Layout.setupWithViewPager(view_Pager);
    }

    private void iniciaComponets( ){

        view_Pager =  findViewById(R.id.view_Pager);
        tab_Layout =  findViewById(R.id.tab_Layout);

    }
}
