package com.example.apirest.adapter.vendas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apirest.R;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.GetMask;

import java.util.List;

public class AdapterTotalPedidoVenda extends RecyclerView.Adapter<AdapterTotalPedidoVenda.MyViewHolder> {

    private List<VendasMaster> relatorioVendas;
    private Context context;

    ItemClickListener itemClickListener;


    public AdapterTotalPedidoVenda(List<VendasMaster> relatorioVendas, Context context, ItemClickListener onClickListener) {
        this.relatorioVendas = relatorioVendas;
        this.context = context;
        this.itemClickListener = onClickListener;
    }

    public List<VendasMaster> getRelatorioVendas() {
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
        VendasMaster relatorioTotalPedidos = relatorioVendas.get(position);

        if (relatorioTotalPedidos.getSituacao().equals("F")) {
            if (relatorioTotalPedidos.getNecf() == 0) {
                holder.imagemStatus.setBackgroundResource(R.drawable.status_azul);
                holder.idRelatorio.setText( "#" + Integer.toString(relatorioTotalPedidos.getCodigo()));
                holder.textConsumidor.setText(relatorioTotalPedidos.getNome());
                holder.textEmpresa.setText(relatorioTotalPedidos.getNomeEmpresa());
                holder.textValorFaturado.setText("R$" + GetMask.getValor(relatorioTotalPedidos.getTotal()));
                holder.textFatura.setText("Baixado");
            } else {
                holder.imagemStatus.setBackgroundResource(R.drawable.status_verde);
                holder.idRelatorio.setText( "#" + Integer.toString(relatorioTotalPedidos.getCodigo()));
                holder.textConsumidor.setText(relatorioTotalPedidos.getNome());
                holder.textEmpresa.setText(relatorioTotalPedidos.getNomeEmpresa());
                holder.textValorFaturado.setText("R$" + GetMask.getValor(relatorioTotalPedidos.getTotal()));
                holder.textFatura.setText("Faturado");
            }
        } else if (relatorioTotalPedidos.getSituacao().equals("C")) {
            holder.imagemStatus.setBackgroundResource(R.drawable.status_vermelho);
            holder.idRelatorio.setText( "#" + Integer.toString(relatorioTotalPedidos.getCodigo()));
            holder.textConsumidor.setText(relatorioTotalPedidos.getNome());
            holder.textEmpresa.setText(relatorioTotalPedidos.getNomeEmpresa());
            holder.textValorFaturado.setText("R$" + GetMask.getValor(relatorioTotalPedidos.getTotal()));
            holder.textFatura.setText("Cancelado");
        } else if (relatorioTotalPedidos.getSituacao().equals("A")) {
            holder.imagemStatus.setBackgroundResource(R.drawable.status_amarelo);
            holder.idRelatorio.setText( "#" + Integer.toString(relatorioTotalPedidos.getCodigo()));
            holder.textConsumidor.setText(relatorioTotalPedidos.getNome());
            holder.textEmpresa.setText(relatorioTotalPedidos.getNomeEmpresa());
            holder.textValorFaturado.setText("R$" + GetMask.getValor(relatorioTotalPedidos.getTotal()));
            holder.textFatura.setText("Aberto");
        }


        holder.itemView.setOnClickListener(view -> itemClickListener.onClick(relatorioTotalPedidos));


    }

    @Override
    public int getItemCount() {
        return relatorioVendas.size();
    }

    public interface ItemClickListener {
        void onClick ( VendasMaster relatorioVendas );
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idRelatorio, textConsumidor, textEmpresa, textValorFaturado, textFatura;
        ImageView imagemStatus;

        ConstraintLayout constraintLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            idRelatorio = itemView.findViewById(R.id.idRelatorio);
            textConsumidor = itemView.findViewById(R.id.textConsumidor);
            textEmpresa = itemView.findViewById(R.id.textEmpresa);
            textValorFaturado = itemView.findViewById(R.id.textValorFaturado);
            textFatura = itemView.findViewById(R.id.textStatusFatura);
            imagemStatus = itemView.findViewById(R.id.imagemStatus);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);

        }
    }
}
