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
import com.example.apirest.model.contas.CPagar;
import com.example.apirest.model.contas.CReceber;
import com.example.apirest.utils.GetMask;

import java.util.List;

public class AdapterInformacaoContaParcelasCP extends RecyclerView.Adapter<AdapterInformacaoContaParcelasCP.MyViewHolder> {

    private List<CPagar> cPagarList;
    private Context context;

    ItemClickListener itemClickListener;


    public AdapterInformacaoContaParcelasCP(List<CPagar> cReceberList, Context context, ItemClickListener onClickListener) {
        this.cPagarList = cReceberList;
        this.context = context;
        this.itemClickListener = onClickListener;
    }

    public List<CPagar> getcPagarList() {
        return cPagarList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_de_contas_receber_parcela_adapter, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CPagar cPagar = cPagarList.get(position);

        holder.posicaoProduto.setText(Integer.toString(position + 1) + ".");
        holder.docReceber.setText(("Doc " + cPagar.getDoc()));
        if (cPagar.getSituacao().equals("T")) {
            holder.statusReceber.setText("Liquidado");
            holder.valorPagoTotalReceber.setText("Quitado: R$" + GetMask.getValor(((cPagar.getValor() + cPagar.getJuros()) - cPagar.getDesconto()) - cPagar.getVlpago()));

        } else {
            holder.statusReceber.setText("Em aberto");
            holder.valorPagoTotalReceber.setText("Valor Restante: R$" + GetMask.getValor(((cPagar.getValor() + cPagar.getJuros()) - cPagar.getDesconto()) - cPagar.getVlpago()));
        }

        holder.dataReceber.setText((cPagar.getDtvencimento()));
        holder.valorParcelaReceber.setText("R$" + GetMask.getValor(cPagar.getValor()));
        holder.valorPagoReceber.setText("R$" + GetMask.getValor(cPagar.getVlpago()));
        holder.valorDesconto.setText("R$" + GetMask.getValor(cPagar.getDesconto()));
        holder.valorJuros.setText("R$" + GetMask.getValor(cPagar.getJuros()));

        holder.itemView.setOnClickListener(view -> itemClickListener.onClick(cPagar));

    }

    @Override
    public int getItemCount() {
        return cPagarList.size();
    }

    public interface ItemClickListener {
        void onClick ( CPagar relatorioVendas );
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView docReceber, statusReceber, dataReceber, valorParcelaReceber, valorPagoReceber, valorPagoTotalReceber, posicaoProduto, valorDesconto, valorJuros;
        ImageView imagemStatus;

        ConstraintLayout constraintLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            docReceber = itemView.findViewById(R.id.textView16);
            statusReceber = itemView.findViewById(R.id.textViewCodigoBarra);
            dataReceber = itemView.findViewById(R.id.textViewReferencia);

            valorParcelaReceber = itemView.findViewById(R.id.textView46);
            valorPagoReceber = itemView.findViewById(R.id.valorPagoTextView);
            valorPagoTotalReceber = itemView.findViewById(R.id.textViewValorProduto);
            valorDesconto = itemView.findViewById(R.id.valorDescontoTextView);
            valorJuros = itemView.findViewById(R.id.valorJurosTextView);

            posicaoProduto = itemView.findViewById(R.id.textView45);
        }
    }
}
