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
import com.example.apirest.model.contas.CReceber;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.GetMask;

import java.util.List;

public class AdapterRelatorioContasReceberDia extends RecyclerView.Adapter<AdapterRelatorioContasReceberDia.MyViewHolder> {

    private List<VendasMaster> cReceberList;
    private List<CReceber> cRecebersDAO;

    private Double valorTotalContaReceber = 0.0;

    private Context context;

    ItemClickListener itemClickListener;


    public AdapterRelatorioContasReceberDia(List<VendasMaster> cReceberList, List<CReceber> cRecebersDAO, Context context, ItemClickListener onClickListener) {
        this.cReceberList = cReceberList;
        this.cRecebersDAO = cRecebersDAO;
        this.context = context;
        this.itemClickListener = onClickListener;
    }

    public List<VendasMaster> getcReceberList() {
        return cReceberList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_de_relatorio_contas_adapter, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        VendasMaster cReceber = cReceberList.get(position);
        for (CReceber cReceber1 : cRecebersDAO) {
            valorTotalContaReceber += cReceber1.getVl_restante();
        }

        holder.imagemStatus.setBackgroundResource(R.drawable.status_amarelo);
        holder.idContaAbertaTextView.setText( "#" + cReceber.getCodigoCreber() + " - "+ cReceber.getHistoricoCReceber());
        holder.nomePessoasContaReceberTextView.setText(cReceber.getNomePessoasContaCReceber());
        holder.nomeEmpresaTextView.setText(cReceber.getNomeEmpresa());
        holder.valorContaRceberTextView.setText("R$ " + GetMask.getValor(valorTotalContaReceber));
        holder.statusTexView.setText("Em aberto");


        holder.itemView.setOnClickListener(view -> itemClickListener.onClick(cReceber));


    }

    @Override
    public int getItemCount() {
        return cReceberList.size();
    }

    public interface ItemClickListener {
        void onClick ( VendasMaster cReceber );
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
