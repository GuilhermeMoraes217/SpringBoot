package com.example.apirest.activity.produtos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.apirest.R;
import com.example.apirest.model.Grupos;
import com.example.apirest.model.vendas.VendasMaster;

public class InformacoesGrupoItensProdutosActivity extends AppCompatActivity {

    Grupos informacoesGrupoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_grupo_itens_produtos);
        Bundle bundle = new Bundle();
        informacoesGrupoSelecionado = (Grupos) bundle.getSerializable("informacoesGrupoSelecionado");

        Log.i("",""+informacoesGrupoSelecionado);
    }
}