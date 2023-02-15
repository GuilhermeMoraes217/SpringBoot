package com.example.apirest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.apirest.R;
import com.example.apirest.activity.empresa.PersonaActivity;
import com.example.apirest.model.Persona;
import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.utils.GetMask;

import java.util.List;

public class AdapterVendasMaster extends ArrayAdapter<VendasMaster> {

    private Context context;
    private  List<VendasMaster> vendasMasterList;

    public AdapterVendasMaster(@NonNull Context context, int resource, @NonNull List<VendasMaster> objects) {
        super(context, resource, objects);
        this.context = context;
        this.vendasMasterList = objects;
    }

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=layoutInflater.inflate(R.layout.lista_de_vendas_adapter,parent,false);

        /**
         * Inicializando os componentes da lista de vendas adapter
         */

        TextView idRelatorio = (TextView)rowView.findViewById(R.id.idRelatorio);
        TextView textConsumidor = (TextView)rowView.findViewById(R.id.textConsumidor);
        TextView textEmpresa = (TextView)rowView.findViewById(R.id.textEmpresa);
        TextView textValorFaturado = (TextView)rowView.findViewById(R.id.textValorFaturado);
        TextView textFatura = (TextView)rowView.findViewById(R.id.textStatusFatura);

        ImageView imagemStatus = (ImageView) rowView.findViewById(R.id.imagemStatus);
        ConstraintLayout constraintLayout = (ConstraintLayout) rowView.findViewById(R.id.constraintLayout);


        /**
         * Setando os componentes para serem visualizados
         */

        if (vendasMasterList.get(position).getFlag_nfce() == null && vendasMasterList.get(position).getTotal() > 0) {
            idRelatorio.setText((Integer.toString(vendasMasterList.get(position).getCodigo())));
            textConsumidor.setText((vendasMasterList.get(position).getNome()));
            textEmpresa.setText((Integer.toString(vendasMasterList.get(position).getFkempresa())));

            textValorFaturado.setText(("R$" + GetMask.getValor(vendasMasterList.get(position).getTotal())));
            textFatura.setText(("Baixado"));

        } else if (vendasMasterList.get(position).getTotal() > 0) {
            idRelatorio.setText((Integer.toString(vendasMasterList.get(position).getCodigo())));
            textConsumidor.setText((vendasMasterList.get(position).getNome()));
            textEmpresa.setText((Integer.toString(vendasMasterList.get(position).getFkempresa())));

            textValorFaturado.setText(("R$" + GetMask.getValor(vendasMasterList.get(position).getTotal())));
        }



       rowView.setOnClickListener(v -> {
           Intent intent=new Intent(context, PersonaActivity.class);
           intent.putExtra("relatorioVendasSelecionados", (vendasMasterList.get(position)));
           context.startActivity(intent);
        });

        return rowView;

    }

}
