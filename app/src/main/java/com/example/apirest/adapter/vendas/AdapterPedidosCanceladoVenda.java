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

public class AdapterPedidosCanceladoVenda extends RecyclerView.Adapter<AdapterPedidosCanceladoVenda.MyViewHolder> {

    private List<VendasMaster> relatorioVendas;
    private Context context;

    ItemClickListener itemClickListener;


    public AdapterPedidosCanceladoVenda(List<VendasMaster> relatorioVendas, Context context, ItemClickListener onClickListener) {
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
        VendasMaster relatorioPedidosCancelados = relatorioVendas.get(position);

        holder.imagemStatus.setBackgroundResource(R.drawable.status_vermelho);
        holder.idRelatorio.setText( "#" + Integer.toString(relatorioPedidosCancelados.getCodigo()));
        holder.textConsumidor.setText(relatorioPedidosCancelados.getNome());
        holder.textEmpresa.setText(relatorioPedidosCancelados.getNomeEmpresa());
        holder.textValorFaturado.setText("R$" + GetMask.getValor(relatorioPedidosCancelados.getTotal()));
        holder.textFatura.setText("cancelado");

        holder.itemView.setOnClickListener(view -> itemClickListener.onClick(relatorioPedidosCancelados));
        //holder.imagemStatus.setChecked(bairroEntregaLoja.isSelected());

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
