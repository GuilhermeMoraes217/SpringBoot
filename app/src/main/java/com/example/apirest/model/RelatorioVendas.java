package com.example.apirest.model;

import android.widget.ImageView;

import java.io.Serializable;

public class RelatorioVendas implements Serializable {

    private ImageView imagemStatus;
    private String idRelatorio, textConsumidor, textEmpresa, textFatura;
    private Double textValorFaturado;


    public ImageView getImagemStatus() {
        return imagemStatus;
    }

    public void setImagemStatus(ImageView imagemStatus) {
        this.imagemStatus = imagemStatus;
    }

    public String getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(String idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public String getTextConsumidor() {
        return textConsumidor;
    }

    public void setTextConsumidor(String textConsumidor) {
        this.textConsumidor = textConsumidor;
    }

    public String getTextEmpresa() {
        return textEmpresa;
    }

    public void setTextEmpresa(String textEmpresa) {
        this.textEmpresa = textEmpresa;
    }

    public String getTextFatura() {
        return textFatura;
    }

    public void setTextFatura(String textFatura) {
        this.textFatura = textFatura;
    }

    public Double getTextValorFaturado() {
        return textValorFaturado;
    }

    public void setTextValorFaturado(Double textValorFaturado) {
        this.textValorFaturado = textValorFaturado;
    }
}
