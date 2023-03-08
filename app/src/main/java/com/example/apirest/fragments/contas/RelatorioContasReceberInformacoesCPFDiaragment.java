package com.example.apirest.fragments.contas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.model.contas.CCompra;


public class RelatorioContasReceberInformacoesCPFDiaragment extends Fragment {
    /**
     * Atributos Variados do Layout
     */
    private TextView codigoNomePessoaReceberTextView, nomeEmpresaTextView, idStatusTextView, idDocumento, idDataEmissao, idFormaPagamento, idHistorico;
    CCompra receberSelecionado;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relatorio_contas_receber_informacoes_c_p, container, false);
        Bundle bundle = getActivity().getIntent().getExtras();
        receberSelecionado = (CCompra) bundle.getSerializable("RelatorioContasReceberSelecionado");
        inicializaComponentes(view);
        exibiComponentes();
        return view;
    }
    public void exibiComponentes () {
        codigoNomePessoaReceberTextView.setText("#" + receberSelecionado.getCodigoCPagar() + " - " + receberSelecionado.getNomeEmpresaCPagar());
        nomeEmpresaTextView.setText(receberSelecionado.getNomeEmpresaDevendoCPagar());
        idStatusTextView.setText("Status - Em aberto");

        idDocumento.setText(receberSelecionado.getDocCPagar());
        idDataEmissao.setText(receberSelecionado.getDataCPagar());
        idFormaPagamento.setText("*****");
        idHistorico.setText(receberSelecionado.getHistoricoCPagar());
    }

    public void inicializaComponentes(View view) {
        codigoNomePessoaReceberTextView = view.findViewById(R.id.codigoNomePessoaReceber);
        nomeEmpresaTextView = view.findViewById(R.id.nomeEmpresa);
        idStatusTextView = view.findViewById(R.id.idStatus);
        idDocumento = view.findViewById(R.id.idDocumento);
        idDataEmissao = view.findViewById(R.id.idDataEmissao);
        idFormaPagamento = view.findViewById(R.id.idFormaPagamento);
        idHistorico = view.findViewById(R.id.idHistorico);
    }
}