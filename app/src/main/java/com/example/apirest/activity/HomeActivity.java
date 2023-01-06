package com.example.apirest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.apirest.fragments.PedidosEmAndamentoFragment;
import com.example.apirest.R;
import com.example.apirest.fragments.PedidosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private long contTime;
    private BottomNavigationView bottomMenuHome;

    private final Fragment
            fragmentHome = new PedidosFragment(),
            fragmentPesquisa = new PedidosFragment(),
            fragmentPedidos = new PedidosFragment(),
            fragmentPerfil = new PedidosFragment();

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
                case R.id.item_home:
                    showFragment(fragmentHome);
                    return true;
                case R.id.item_busca:
                    showFragment(fragmentPesquisa);
                    return true;
                case R.id.item_pedidos:
                    showFragment(fragmentPedidos);
                    return true;
                case R.id.item_perfil:
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
        if(bottomMenuHome.getSelectedItemId() == R.id.item_home){
            if (contTime + 2000 > System.currentTimeMillis()){
                super.onBackPressed();
                return;
            } else {
                Toast.makeText(this, "Aperte voltar novamente para sair", Toast.LENGTH_SHORT).show();
            }

            contTime = System.currentTimeMillis();
        } else {
            bottomMenuHome.setSelectedItemId(R.id.item_home);
        }

    }

    private void inicializarComponentes() {
        bottomMenuHome = findViewById(R.id.bottomMenuHome);
    }
}