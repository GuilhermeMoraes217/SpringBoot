package com.example.apirest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.apirest.R;
import com.example.apirest.fragments.VendasFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private long contTime;
    private BottomNavigationView bottomMenuHome;

    private final Fragment
            fragmentHome = new VendasFragment(),
            fragmentPesquisa = new VendasFragment(),
            fragmentPedidos = new VendasFragment(),
            fragmentPerfil = new VendasFragment();

    public BottomNavigationView getBottomMenuHome() {
        return bottomMenuHome;
    }

    public void setBottomMenuHome(BottomNavigationView bottomMenuHome) {
        this.bottomMenuHome = bottomMenuHome;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inicializarComponentes();

        bottomMenuHome.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.item_vendas:
                    showFragment(fragmentHome);
                    return true;
                case R.id.item_produtos:
                    showFragment(fragmentPesquisa);
                    return true;
                case R.id.item_contas:
                    showFragment(fragmentPedidos);
                    return true;
                case R.id.item_checkout:
                    showFragment(fragmentPerfil);
                    return true;
            }
            return false;
        });
        bottomMenuHome.setOnNavigationItemReselectedListener(item -> {});

    }

    private void showFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }

    @Override
    public void onBackPressed() {
        if(bottomMenuHome.getSelectedItemId() == R.id.item_vendas){
            if (contTime + 2000 > System.currentTimeMillis()){
                super.onBackPressed();
                return;
            } else {
                Toast.makeText(this, "Aperte voltar novamente para sair", Toast.LENGTH_SHORT).show();
            }

            contTime = System.currentTimeMillis();
        } else {
            bottomMenuHome.setSelectedItemId(R.id.item_vendas);
        }

    }

    private void inicializarComponentes() {
        bottomMenuHome = findViewById(R.id.bottomMenuHome);
    }
}