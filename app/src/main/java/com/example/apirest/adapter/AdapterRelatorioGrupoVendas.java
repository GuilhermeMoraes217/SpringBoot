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
import com.example.apirest.model.Produtos;
import com.example.apirest.model.vendas.VendasDetalhes;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.GetMask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdapterRelatorioGrupoVendas extends RecyclerView.Adapter<AdapterRelatorioGrupoVendas.MyViewHolder> {

    private List<Grupos> gruposList;
    private List<VendasDetalhes> vendasDetalhesList;
    private List<Produtos> produtosList;
    private List<VendasMaster> vendasMasterList;
    private Context context;

    ItemClickListener itemClickListener;


    public AdapterRelatorioGrupoVendas(List<Grupos> gruposList, List<VendasDetalhes> vendasDetalhesList,
                                       List<Produtos> produtosList, List<VendasMaster> vendasMasterList, Context context, ItemClickListener onClickListener) {
        this.gruposList = gruposList;
        this.context = context;
        this.vendasDetalhesList = vendasDetalhesList;
        this.produtosList = produtosList;
        this.vendasMasterList = vendasMasterList;
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

        /**
         * LIMITANTO A DATA PARA SOMENTE PARA DATA ATUAL
         */
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDateAtual = df.format(d);
        //RECUPERANDO A QUANTIDADE TOTAL DE PRODUTOS VENTIDOS
        Double auxItemVendido = 0.0;
        Double auxTotalItemVendido = 0.0;


        for (Grupos grupos1 : gruposList) {
            for (Produtos produtos : produtosList) {
                for (VendasDetalhes vendasDetalhes : vendasDetalhesList) {
                    if (produtos.getGrupo() == grupos1.getCodigo() && produtos.getCodigo() == vendasDetalhes.getId_produto()) {
                        auxTotalItemVendido += vendasDetalhes.getQtd();
                    }
                    if (produtos.getGrupo() == grupos1.getCodigo() && produtos.getCodigo() == vendasDetalhes.getId_produto() && grupos.getDescricao() == grupos1.getDescricao()) {
                        auxItemVendido += vendasDetalhes.getQtd();
                    }
                }
            }
        }


        holder.idItens.setText("#" + Integer.toString(grupos.getCodigo()));
        holder.nomeGrupo.setText(grupos.getDescricao());
        holder.quantidadeitem.setText(Double.toString(auxItemVendido));
        holder.porcentagemGrupo.setText(GetMask.getValorPorcentagem((((auxItemVendido * 100)) / auxTotalItemVendido)) + "%");


        holder.itemView.setOnClickListener(view -> itemClickListener.onClick(grupos));

        //holder.imagemStatus.setChecked(bairroEntregaLoja.isSelected());

    }

    @Override
    public int getItemCount() {
        return gruposList.size();
    }

    public interface ItemClickListener {
        void onClick(Grupos grupos);
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
