package com.example.apirest.fragments.vendas.totalpedidos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apirest.R;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.GetMask;

public class InformacaoTotalPedidoVendaFragment extends Fragment {

    VendasMaster relatorioVendas;

    /**
     * Atribudos variados da layout de informacoes vendas
     */

    private TextView nomeConsumidorFinal, nomeEmpresa, statusVenda, tabelaPreco, tipoPedido, usuario, dataEmissao, dataPrevissao, dataSaida, pdv, dinheiro;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacao_total_pedido_venda, container, false);

        Bundle bundle = getActivity().getIntent().getExtras();
        relatorioVendas = (VendasMaster) bundle.getSerializable("relatorioTotalPedido");
        inicializaComponentes(view);

        exibirComponentes();

        return view;
    }

    private void exibirComponentes() {
        nomeConsumidorFinal.setText("#" + relatorioVendas.getNome());
        nomeEmpresa.setText(relatorioVendas.getNomeEmpresa());
        if (relatorioVendas.getSituacao().equals("F")) {
            if (relatorioVendas.getNecf() == 0) {
                statusVenda.setText("Baixado");
            } else {
                statusVenda.setText("Faturado");
            }

        } else if (relatorioVendas.getSituacao().equals("C")) {
            statusVenda.setText("Cancelado");
        } else if (relatorioVendas.getSituacao().equals("A")) {
            statusVenda.setText("Aberto");
        }
        tabelaPreco.setText("#" + relatorioVendas.getFk_tabela() + " Tabela");
        usuario.setText("#" + relatorioVendas.getFk_usuario() + " Tabela");
        dataEmissao.setText(relatorioVendas.getData_emissao());
        dataSaida.setText(relatorioVendas.getData_saida());
        pdv.setText(relatorioVendas.getTela());
        dinheiro.setText("R$ " + GetMask.getValor(relatorioVendas.getTotal()));

    }

    private void inicializaComponentes(View view) {

        nomeConsumidorFinal = view.findViewById(R.id.textView23);
        nomeEmpresa = view.findViewById(R.id.textView24);
        statusVenda = view.findViewById(R.id.textviewStatus);
        tabelaPreco = view.findViewById(R.id.textView27);
        tipoPedido = view.findViewById(R.id.text2);
        usuario = view.findViewById(R.id.textViewUsuario);
        dataEmissao = view.findViewById(R.id.textView51);
        dataPrevissao = view.findViewById(R.id.textViewDataPrevissao);
        dataSaida = view.findViewById(R.id.textViewDataSaida);
        pdv = view.findViewById(R.id.textView71);
        dinheiro = view.findViewById(R.id.textViewDinheiro);
    }
}