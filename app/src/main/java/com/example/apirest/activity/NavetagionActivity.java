package com.example.apirest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.apirest.R;
import com.example.apirest.databinding.ActivityNavetagionBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavetagionActivity extends AppCompatActivity {

    private ActivityNavetagionBinding binding;

    private NavHostFragment navHostFragment;
    private NavController navController;
    private long contTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavetagionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initNavigation();
    }

    private void initNavigation() {
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_Host_Fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);
    }


    @Override
    public void onBackPressed() {
        if (contTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, "Aperte voltar novamente para sair", Toast.LENGTH_SHORT).show();
        }

        contTime = System.currentTimeMillis();

    }
}