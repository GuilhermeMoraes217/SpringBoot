package com.example.apirest.adapter.contas;

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
import com.example.apirest.model.contas.CCompra;
import com.example.apirest.model.contas.CPagar;
import com.example.apirest.model.contas.CReceber;
import com.example.apirest.utils.GetMask;

import java.util.List;

public class AdapterRelatorioContasPagarDia extends RecyclerView.Adapter<AdapterRelatorioContasPagarDia.MyViewHolder> {

    private List<CCompra> cCompraList;
    private List<CPagar> cPgarDAO;

    private Double valorTotalContaReceber = 0.0;

    private Context context;

    ItemClickListener itemClickListener;


    public AdapterRelatorioContasPagarDia(List<CCompra> cCompraList, List<CPagar> cPgarDAO, Context context, ItemClickListener onClickListener) {
        this.cCompraList = cCompraList;
        this.cPgarDAO = cPgarDAO;
        this.context = context;
        this.itemClickListener = onClickListener;
    }

    public List<CCompra> getcCompraList() {
        return cCompraList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_de_relatorio_contas_pagar_adapter, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CCompra cCompra = cCompraList.get(position);
        for (CPagar cPagar : cPgarDAO) {
            valorTotalContaReceber += cPagar.getVl_restante();
        }

        holder.imagemStatus.setBackgroundResource(R.drawable.status_amarelo);
        holder.idContaAbertaTextView.setText( "#" + cCompra.getCodigoCPagar() + " - "+ cCompra.getHistoricoCPagar());
        holder.nomeEmpresaTextView.setText(cCompra.getNomeEmpresaCPagar());
        holder.nomePessoasContaReceberTextView.setText(cCompra.getNomeEmpresaDevendoCPagar());
        holder.valorContaRceberTextView.setText("R$ " + GetMask.getValor(valorTotalContaReceber));
        holder.statusTexView.setText("Em aberto");

        holder.itemView.setOnClickListener(view -> itemClickListener.onClick(cCompra));

    }

    @Override
    public int getItemCount() {
        return cCompraList.size();
    }

    public interface ItemClickListener {
        void onClick ( CCompra cCompra );
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idContaAbertaTextView, nomePessoasContaReceberTextView, nomeEmpresaTextView, valorContaRceberTextView, statusTexView;
        ImageView imagemStatus;

        ConstraintLayout constraintLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            idContaAbertaTextView = itemView.findViewById(R.id.textView18);
            nomePessoasContaReceberTextView = itemView.findViewById(R.id.textView19);
            nomeEmpresaTextView = itemView.findViewById(R.id.nomeEmpresaTextView);
            valorContaRceberTextView = itemView.findViewById(R.id.textView22);
            statusTexView = itemView.findViewById(R.id.textView20);
            imagemStatus = itemView.findViewById(R.id.imageView4);

        }
    }
}
