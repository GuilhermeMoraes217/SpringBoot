package com.example.apirest.adapter.produtos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apirest.R;
import com.example.apirest.model.vendas.VendasDetalhes;
import com.example.apirest.utils.GetMask;

import java.util.List;

public class AdapterInformacaoGrupoItensProdutos extends RecyclerView.Adapter<AdapterInformacaoGrupoItensProdutos.MyViewHolder> {

    private List<VendasDetalhes> relatorioProdutos;
    private Context context;

    ItemClickListener itemClickListener;


    public AdapterInformacaoGrupoItensProdutos(List<VendasDetalhes> relatorioProdutos, Context context, ItemClickListener onClickListener) {
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

        holder.valorUnitario.setText("R$" + GetMask.getValor(relatorioProdutos1.getPreco()));
        holder.valorxQtd.setText("R$" + GetMask.getValor( relatorioProdutos1.getPreco() * relatorioProdutos1.getQtd()));

        holder.porcentagemItensVendido.setText(GetMask.getValorPorcentagem((((relatorioProdutos1.getQtd() * 100)) / aux )) + "%");
        holder.totalItensVendido.setText(Double.toString(relatorioProdutos1.getQtd()));

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
                nomeProduto, valorUnitario, valorxQtd, porcentagemItensVendido, totalItensVendido;
        ImageView imagemStatus;

        public MyViewHolder(View itemView) {
            super(itemView);

            imagemStatus = itemView.findViewById(R.id.status);

            idRelatorio = itemView.findViewById(R.id.textView16);
            idRelatorio_R = itemView.findViewById(R.id.textView21);
            idGeral = itemView.findViewById(R.id.textView18);
            nomeProduto = itemView.findViewById(R.id.textView19);

            valorUnitario = itemView.findViewById(R.id.textView17);
            valorxQtd = itemView.findViewById(R.id.textView10);
            porcentagemItensVendido = itemView.findViewById(R.id.textView20);
            totalItensVendido = itemView.findViewById(R.id.textView22);

        }
    }
}
