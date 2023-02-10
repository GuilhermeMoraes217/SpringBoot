package com.example.apirest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.apirest.R;
import com.example.apirest.model.RelatorioVendas;
import com.example.apirest.utils.GetMask;

import java.util.ArrayList;
import java.util.List;

public class AdapterRelatorioVendas extends RecyclerView.Adapter<AdapterRelatorioVendas.MyViewHolder> {

    private List<RelatorioVendas> relatorioVendas;
    private Context context;

    ItemClickListener itemClickListener;


    public AdapterRelatorioVendas(List<RelatorioVendas> relatorioVendas, Context context, ItemClickListener onClickListener) {
        this.relatorioVendas = relatorioVendas;
        this.context = context;
        this.itemClickListener = onClickListener;
    }

    public List<RelatorioVendas> getRelatorioVendas() {
        return relatorioVendas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_de_vendas_adapter, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RelatorioVendas relatorioVendasLoja = relatorioVendas.get(position);
        holder.idRelatorio.setText(relatorioVendasLoja.getIdRelatorio());
        holder.textConsumidor.setText(relatorioVendasLoja.getTextConsumidor());
        holder.textEmpresa.setText(relatorioVendasLoja.getTextEmpresa());
        holder.textValorFaturado.setText("R$" + GetMask.getValor(relatorioVendasLoja.getTextValorFaturado()));
        holder.textFatura.setText(relatorioVendasLoja.getTextStatusFatura());

        holder.itemView.setOnClickListener(view -> itemClickListener.onClick(relatorioVendasLoja));

        //holder.imagemStatus.setChecked(bairroEntregaLoja.isSelected());

    }

    @Override
    public int getItemCount() {
        return relatorioVendas.size();
    }

    public interface ItemClickListener {
        void onClick ( RelatorioVendas relatorioVendas );
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idRelatorio, textConsumidor, textEmpresa, textValorFaturado, textFatura;
        ImageView imagemStatus;

        public MyViewHolder(View itemView) {
            super(itemView);

            idRelatorio = itemView.findViewById(R.id.idRelatorio);
            textConsumidor = itemView.findViewById(R.id.textConsumidor);
            textEmpresa = itemView.findViewById(R.id.textEmpresa);
            textValorFaturado = itemView.findViewById(R.id.textValorFaturado);
            textFatura = itemView.findViewById(R.id.textStatusFatura);
            imagemStatus = itemView.findViewById(R.id.imagemStatus);

        }
    }
}
