package com.example.apirest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.apirest.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int tempoDeEspera = 1000 * 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verificaAcesso();

    }

    private void verificaAcesso( ){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), NavetagionActivity.class));
                finish();
            }
        }, tempoDeEspera);

    }

}
