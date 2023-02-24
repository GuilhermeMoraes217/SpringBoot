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
import com.example.apirest.model.RelatorioProdutos;
import com.example.apirest.model.vendas.VendasDetalhes;
import com.example.apirest.utils.GetMask;

import java.util.List;

public class AdapterRelatorioProdutos extends RecyclerView.Adapter<AdapterRelatorioProdutos.MyViewHolder> {

    private List<VendasDetalhes> relatorioProdutos;
    private Context context;

    ItemClickListener itemClickListener;


    public AdapterRelatorioProdutos(List<VendasDetalhes> relatorioProdutos, Context context, ItemClickListener onClickListener) {
        this.relatorioProdutos = relatorioProdutos;
        this.context = context;
        this.itemClickListener = onClickListener;
    }

    public List<VendasDetalhes> getRelaorioProdutos() {
        return relatorioProdutos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_de_produtos_adapter, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        VendasDetalhes relatorioProdutos1 = relatorioProdutos.get(position);

        //RECUPERANDO A QUANTIDADE TOTAL DE PRODUTOS VENTIDOS
        Double aux = 0.0;


        for (VendasDetalhes vendasDetalhes : relatorioProdutos) {
            aux += vendasDetalhes.getQtd();
        }

        holder.idRelatorio.setText("#" + Double.toString(aux));
        holder.idRelatorio_R.setText("#" + Integer.toString(relatorioProdutos1.getCodigo()));
        holder.idGeral.setText("#" + Integer.toString(relatorioProdutos1.getCodigo()));
        holder.nomeProduto.setText(relatorioProdutos1.getNomeProduto());

        holder.preco_1.setText("R$" + GetMask.getValor(relatorioProdutos1.getPreco()));
        holder.preco_2.setText("R$" + GetMask.getValor(relatorioProdutos1.getQtd()));

        holder.porcentagem_1.setText(GetMask.getValorPorcentagem((((relatorioProdutos1.getQtd() * 100)) / aux )) + "%");
        holder.porcentagem_2.setText(Double.toString(relatorioProdutos1.getQtd()));

        holder.itemView.setOnClickListener(view -> itemClickListener.onClick(relatorioProdutos1));

        //holder.imagemStatus.setChecked(bairroEntregaLoja.isSelected());

    }

    @Override
    public int getItemCount() {
        return relatorioProdutos.size();
    }

    public interface ItemClickListener {
        void onClick ( VendasDetalhes relatorioProdutos);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idRelatorio, idRelatorio_R, idGeral,
                nomeProduto, preco_1, preco_2, porcentagem_1, porcentagem_2;
        ImageView imagemStatus;

        public MyViewHolder(View itemView) {
            super(itemView);

            imagemStatus = itemView.findViewById(R.id.status);

            idRelatorio = itemView.findViewById(R.id.textView16);
            idRelatorio_R = itemView.findViewById(R.id.textView21);
            idGeral = itemView.findViewById(R.id.textView18);
            nomeProduto = itemView.findViewById(R.id.textView19);

            preco_1 = itemView.findViewById(R.id.textView17);
            preco_2 = itemView.findViewById(R.id.textView10);
            porcentagem_1 = itemView.findViewById(R.id.textView20);
            porcentagem_2 = itemView.findViewById(R.id.textView22);

        }
    }
}
