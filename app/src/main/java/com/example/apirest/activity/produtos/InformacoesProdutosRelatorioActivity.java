package com.example.apirest.activity.produtos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.model.vendas.VendasDetalhes;


public class InformacoesProdutosRelatorioActivity extends AppCompatActivity {

    private TextView nomeProdutoTextView, idProdutoTextView, idProdutoTextView2, nomeEmpresaTextView,
            unidadeTextView, tipoGrupoTextView, corProdutoTextView, tamanhoProdutoTextView, qtdProdutotextView,
            dataCadastroTextView, marcaProdutoTextView, percentualVendidoTextView;

    VendasDetalhes vendasDetalhes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_produtos_relatorio);
        Bundle bundle = getIntent().getExtras();
        vendasDetalhes = (VendasDetalhes) bundle.getSerializable("relatorioProdutoSelecionados");
        inicializacomponentes();
        exibeComponentes();
        Log.i("",""+ vendasDetalhes);

    }

    public void exibeComponentes () {
        nomeProdutoTextView.setText(vendasDetalhes.getNomeProduto());
        nomeEmpresaTextView.setText(vendasDetalhes.getNomeEmpresa());
        idProdutoTextView.setText("#" + Integer.toString(vendasDetalhes.getCodigo()));
        idProdutoTextView2.setText("#" + Integer.toString(vendasDetalhes.getCodigo()));
        unidadeTextView.setText((vendasDetalhes.getUnidade()));
        tipoGrupoTextView.setText((vendasDetalhes.getNomeGrupo()));
        qtdProdutotextView.setText(Double.toString(vendasDetalhes.getQtd()));
        dataCadastroTextView.setText((vendasDetalhes.getDataCadastroProduto()));
    }

    public void inicializacomponentes() {
        nomeProdutoTextView = findViewById(R.id.textView68);
        idProdutoTextView = findViewById(R.id.textView67);
        idProdutoTextView2 = findViewById(R.id.textView73);
        nomeEmpresaTextView = findViewById(R.id.textView74);
        unidadeTextView = findViewById(R.id.unidadeTextView);
        tipoGrupoTextView = findViewById(R.id.tipoGrupoTextView);
        corProdutoTextView = findViewById(R.id.corProdutoTextView);
        tamanhoProdutoTextView = findViewById(R.id.tamanhoProdutoTextView);
        qtdProdutotextView = findViewById(R.id.qtdProdutotextView);
        dataCadastroTextView = findViewById(R.id.dataCadastroTextView);
        marcaProdutoTextView = findViewById(R.id.marcaProdutoTextView);
        percentualVendidoTextView = findViewById(R.id.percentualVendidoTextView);
    }
}