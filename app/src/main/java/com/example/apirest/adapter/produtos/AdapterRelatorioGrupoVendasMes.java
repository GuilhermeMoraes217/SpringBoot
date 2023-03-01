package com.example.apirest.adapter.produtos;

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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AdapterRelatorioGrupoVendasMes extends RecyclerView.Adapter<AdapterRelatorioGrupoVendasMes.MyViewHolder> {

    private List<Grupos> gruposList;
    private List<VendasDetalhes> vendasDetalhesList;
    private List<Produtos> produtosList;
    private List<VendasMaster> vendasMasterList;
    private Context context;
    static List<String> stringsData = new ArrayList<>();

    ItemClickListener itemClickListener;


    public AdapterRelatorioGrupoVendasMes(List<Grupos> gruposList, List<VendasDetalhes> vendasDetalhesList,
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

        //RECUPERANDO A QUANTIDADE TOTAL DE PRODUTOS VENTIDOS
        Double auxItemVendido = 0.0;
        Double auxTotalItemVendido = 0.0;

        int year = 0;
        int month = 0;
        int day = 0;

        Date date = new Date();
        LocalDate date1 = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            date1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            year = date1.getYear();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            month = date1.getMonthValue();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            day = date1.getDayOfMonth();
        }

        stringsData.clear();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.clear();
        if (day > 7) {
            cal.set(year, month - 1, day - 7);
            for (int i = day - 7; i < day; i++) {
                //System.out.println(fmt.format(cal.getTime()));
                cal.add(Calendar.DAY_OF_MONTH, 1);
                stringsData.add(fmt.format(cal.getTime()));
            }
        } else {
            cal.set(year, month - 1, 0);
            for (int i = 0; i < day ; i++) {
                //System.out.println(fmt.format(cal.getTime()));
                cal.add(Calendar.DAY_OF_MONTH, 1);
                stringsData.add(fmt.format(cal.getTime()));
            }
        }

        for (VendasMaster vm : vendasMasterList) {
            for (String localDate : stringsData) {
                if (localDate.equals(vm.getData_emissao())) {
                    for (VendasDetalhes vd : vendasDetalhesList) {
                        for (Produtos p : produtosList) {
                            for (Grupos g : gruposList) {
                                if (vd.getFkvenda() == vm.getCodigo() && p.getCodigo() == vd.getId_produto() && g.getCodigo() == p.getGrupo()) {
                                    auxTotalItemVendido += vd.getQtd();
                                    if (vd.getFkvenda() == vm.getCodigo() && p.getCodigo() == vd.getId_produto() && g.getCodigo() == p.getGrupo() && g.getDescricao() == grupos.getDescricao()) {
                                        if (vm.getTotal() > 0 && vm.getSituacao().equals("F")) {
                                            auxItemVendido += vd.getQtd();
                                        }
                                    }
                                }
                            }
                        }
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
