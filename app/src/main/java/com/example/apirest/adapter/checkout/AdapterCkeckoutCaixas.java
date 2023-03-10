package com.example.apirest.adapter.checkout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apirest.R;
import com.example.apirest.model.checkout.Contas;
import com.example.apirest.model.checkout.ResumoCaixa;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.GetMask;

import java.util.List;

public class AdapterCkeckoutCaixas extends RecyclerView.Adapter<AdapterCkeckoutCaixas.MyViewHolder> {

    private List<Contas> contasList;
    private List<ResumoCaixa> resumoCaixaList;
    private Context context;

    private Double valorTotalCaixaEntrada = 0.0;
    private Double valorTotalCaixaSaida = 0.0;


    ItemClickListener itemClickListener;


    public AdapterCkeckoutCaixas(List<Contas> contasList, List<ResumoCaixa> resumoCaixaList, Context context, ItemClickListener onClickListener) {
        this.contasList = contasList;
        this.resumoCaixaList = resumoCaixaList;
        this.context = context;
        this.itemClickListener = onClickListener;
    }

    public List<Contas> getContasList() {
        return contasList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_de_relatorio_checkout_adapter, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contas contas = contasList.get(position);

        if (contas.getTipoCaixa().equals("D") && !contas.getFlagCaixa().equals("B")) {
            valorTotalCaixaEntrada = contas.getValorTotalCaixa();
            valorTotalCaixaSaida = contas.getValorTotalCaixaSaida();
        }

        holder.imagemStatus.setBackgroundResource(R.drawable.status_verde);
        holder.idCaixa.setText("#" + Integer.toString(contas.getCodigo()) + " CAIXA");
        holder.usuarioCaixa.setText(contas.getNomeUsuarioCaixa());
        holder.nomeEmpresa.setText((contas.getNomeEmpresaCaixa()));
        holder.valorTotalCaixa.setText("R$" + GetMask.getValor(valorTotalCaixaEntrada - valorTotalCaixaSaida));
        holder.dataHoraCaixa.setText(contas.getDataHoraCaixa());
        holder.statusCaixa.setText("Aberto");

        holder.itemView.setOnClickListener(view -> itemClickListener.onClick(contas));

    }

    @Override
    public int getItemCount() {
        return contasList.size();
    }

    public interface ItemClickListener {
        void onClick(Contas contas);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idCaixa, usuarioCaixa, nomeEmpresa, dataHoraCaixa, valorTotalCaixa, statusCaixa;
        ImageView imagemStatus;


        public MyViewHolder(View itemView) {
            super(itemView);

            idCaixa = itemView.findViewById(R.id.textView18);
            usuarioCaixa = itemView.findViewById(R.id.textView19);
            nomeEmpresa = itemView.findViewById(R.id.textView66);
            dataHoraCaixa = itemView.findViewById(R.id.dataHoraTextView);
            valorTotalCaixa = itemView.findViewById(R.id.textView22);
            statusCaixa = itemView.findViewById(R.id.textView20);
            imagemStatus = itemView.findViewById(R.id.imageView4);

        }
    }
}
