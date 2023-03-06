package com.example.apirest.fragments.contas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.model.contas.CReceber;


public class RelatorioContasReceberInformacoesFragment extends Fragment {

    /**
     * Atributos Variados do Layout
     */
    private TextView codigoNomePessoaReceberTextView, nomeEmpresaTextView, idStatusTextView, idDocumento, idDataEmissao, idFormaPagamento, idHistorico;
    CReceber receberSelecionado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relatorio_contas_receber_informacoes, container, false);
        Bundle bundle = getActivity().getIntent().getExtras();
        receberSelecionado = (CReceber) bundle.getSerializable("RelatorioContasReceberSelecionado");
        inicializaComponentes(view);
        exibiComponentes();
        return view;
    }

    public void exibiComponentes () {
        codigoNomePessoaReceberTextView.setText("#" + receberSelecionado.getCodigo() + " - " + receberSelecionado.getNomePessaReceber());
        nomeEmpresaTextView.setText(receberSelecionado.getNomeEmpresa());
        idStatusTextView.setText("Status - Em aberto");

        idDocumento.setText(receberSelecionado.getDoc());
        idDataEmissao.setText(receberSelecionado.getData());
        idFormaPagamento.setText(receberSelecionado.getFormaPagamento());
        idHistorico.setText(receberSelecionado.getHistorico());
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