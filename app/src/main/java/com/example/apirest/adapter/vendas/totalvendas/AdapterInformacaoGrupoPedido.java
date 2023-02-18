package com.example.apirest.adapter.vendas.totalvendas;

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
import com.example.apirest.model.vendas.VendasDetalhes;
import com.example.apirest.utils.GetMask;

import java.util.List;

public class AdapterInformacaoGrupoPedido extends RecyclerView.Adapter<AdapterInformacaoGrupoPedido.MyViewHolder> {

    private List<VendasDetalhes> vendasDetalhes;
    private Context context;

    ItemClickListener itemClickListener;


    public AdapterInformacaoGrupoPedido(List<VendasDetalhes> vendasDetalhes, Context context, ItemClickListener onClickListener) {
        this.vendasDetalhes = vendasDetalhes;
        this.context = context;
        this.itemClickListener = onClickListener;
    }

    public List<VendasDetalhes> getVendasDetalhes() {
        return vendasDetalhes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_de_pedidos_infor_adapter, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        VendasDetalhes vendasDetalhes1 = vendasDetalhes.get(position);

        holder.posicaoProduto.setText(Integer.toString(position + 1) + ".");
        holder.nomeProduto.setText((vendasDetalhes1.getNomeProduto()));
        holder.codigoBarra.setText(vendasDetalhes1.getCod_barra());
        holder.referencia.setText((vendasDetalhes1.getReferenciaProduto()));

        holder.valorCada.setText("R$" + GetMask.getValor(vendasDetalhes1.getPreco()) + " cada • ");
        holder.valorunidade.setText(Double.toString(vendasDetalhes1.getQtd()) + " Unidade");
        holder.textViewValorProduto.setText("R$" + GetMask.getValor(vendasDetalhes1.getValor_item()));

        holder.itemView.setOnClickListener(view -> itemClickListener.onClick(vendasDetalhes1));

    }

    @Override
    public int getItemCount() {
        return vendasDetalhes.size();
    }

    public interface ItemClickListener {
        void onClick ( VendasDetalhes relatorioVendas );
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nomeProduto, codigoBarra, referencia, valorCada, valorunidade, textViewValorProduto, posicaoProduto;
        ImageView imagemStatus;

        ConstraintLayout constraintLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            nomeProduto = itemView.findViewById(R.id.textView16);
            codigoBarra = itemView.findViewById(R.id.textViewCodigoBarra);
            referencia = itemView.findViewById(R.id.textViewReferencia);

            valorCada = itemView.findViewById(R.id.textView17);
            valorunidade = itemView.findViewById(R.id.textView46);
            textViewValorProduto = itemView.findViewById(R.id.textViewValorProduto);
            posicaoProduto = itemView.findViewById(R.id.textView45);
        }
    }
}
