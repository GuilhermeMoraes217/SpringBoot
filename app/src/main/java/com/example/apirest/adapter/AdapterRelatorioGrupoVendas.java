package com.example.apirest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apirest.R;
import com.example.apirest.model.Grupos;

import java.util.List;

public class AdapterRelatorioGrupoVendas extends RecyclerView.Adapter<AdapterRelatorioGrupoVendas.MyViewHolder> {

    private List<Grupos> gruposList;
    private Context context;

    ItemClickListener itemClickListener;


    public AdapterRelatorioGrupoVendas(List<Grupos> gruposList, Context context, ItemClickListener onClickListener) {
        this.gruposList = gruposList;
        this.context = context;
        this.itemClickListener = onClickListener;
    }

    public List<Grupos> getRelaorioProdutos() {
        return gruposList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_de_grupos_vendas_adapter, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Grupos grupos = gruposList.get(position);

        //RECUPERANDO A QUANTIDADE TOTAL DE PRODUTOS VENTIDOS
        Double aux = 0.0;


        for (Grupos vendasDetalhes : gruposList) {
            //aux += vendasDetalhes.getQtd();
        }

        holder.idItens.setText("#" + Integer.toString(grupos.getCodigo()));
        holder.nomeGrupo.setText(grupos.getDescricao());
        holder.quantidadeitem.setText(Integer.toString(grupos.getCodigo()));
        holder.porcentagemGrupo.setText(Integer.toString(grupos.getCodigo()) + "%");



        holder.itemView.setOnClickListener(view -> itemClickListener.onClick(grupos));

        //holder.imagemStatus.setChecked(bairroEntregaLoja.isSelected());

    }

    @Override
    public int getItemCount() {
        return gruposList.size();
    }

    public interface ItemClickListener {
        void onClick ( Grupos grupos);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idItens, nomeGrupo, porcentagemGrupo, quantidadeitem;

        public MyViewHolder(View itemView) {
            super(itemView);


            idItens = itemView.findViewById(R.id.textView16);
            nomeGrupo = itemView.findViewById(R.id.textView18);
            porcentagemGrupo = itemView.findViewById(R.id.textView20);
            quantidadeitem = itemView.findViewById(R.id.textView22);

        }
    }
}
