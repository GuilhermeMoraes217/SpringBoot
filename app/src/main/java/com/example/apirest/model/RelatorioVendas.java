package com.example.apirest.model;

import android.widget.ImageView;

import java.io.Serializable;

public class RelatorioVendas implements Serializable {

    private ImageView imagemStatus;
    private String idRelatorio, textConsumidor, textEmpresa, textStatusFatura,
            textTabelaPreco, textTabelaPedido, textDataEmissao, textDataPrevisao,
            textDataSaida, textHorarioVenda, textPagamentoPVD, textUsuario;
    private Double textValorFaturado, textDinheiro;

    public RelatorioVendas( ) {

    }

    public RelatorioVendas(String idRelatorio, String textConsumidor, String textEmpresa, String textStatusFatura, String textTabelaPreco, String textTabelaPedido, String textDataEmissao, String textDataPrevisao, String textDataSaida, String textHorarioVenda, String textPagamentoPVD, String textUsuario, Double textValorFaturado, Double textDinheiro) {
        this.idRelatorio = idRelatorio;
        this.textConsumidor = textConsumidor;
        this.textEmpresa = textEmpresa;
        this.textStatusFatura = textStatusFatura;
        this.textTabelaPreco = textTabelaPreco;
        this.textTabelaPedido = textTabelaPedido;
        this.textDataEmissao = textDataEmissao;
        this.textDataPrevisao = textDataPrevisao;
        this.textDataSaida = textDataSaida;
        this.textHorarioVenda = textHorarioVenda;
        this.textPagamentoPVD = textPagamentoPVD;
        this.textUsuario = textUsuario;
        this.textValorFaturado = textValorFaturado;
        this.textDinheiro = textDinheiro;
    }

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

    public String getTextStatusFatura() {
        return textStatusFatura;
    }

    public void setTextStatusFatura(String textStatusFatura) {
        this.textStatusFatura = textStatusFatura;
    }

    public String getTextTabelaPreco() {
        return textTabelaPreco;
    }

    public void setTextTabelaPreco(String textTabelaPreco) {
        this.textTabelaPreco = textTabelaPreco;
    }

    public String getTextTabelaPedido() {
        return textTabelaPedido;
    }

    public void setTextTabelaPedido(String textTabelaPedido) {
        this.textTabelaPedido = textTabelaPedido;
    }

    public String getTextDataEmissao() {
        return textDataEmissao;
    }

    public void setTextDataEmissao(String textDataEmissao) {
        this.textDataEmissao = textDataEmissao;
    }

    public String getTextDataPrevisao() {
        return textDataPrevisao;
    }

    public void setTextDataPrevisao(String textDataPrevisao) {
        this.textDataPrevisao = textDataPrevisao;
    }

    public String getTextDataSaida() {
        return textDataSaida;
    }

    public void setTextDataSaida(String textDataSaida) {
        this.textDataSaida = textDataSaida;
    }

    public String getTextHorarioVenda() {
        return textHorarioVenda;
    }

    public void setTextHorarioVenda(String textHorarioVenda) {
        this.textHorarioVenda = textHorarioVenda;
    }

    public String getTextPagamentoPVD() {
        return textPagamentoPVD;
    }

    public void setTextPagamentoPVD(String textPagamentoPVD) {
        this.textPagamentoPVD = textPagamentoPVD;
    }

    public Double getTextValorFaturado() {
        return textValorFaturado;
    }

    public void setTextValorFaturado(Double textValorFaturado) {
        this.textValorFaturado = textValorFaturado;
    }

    public Double getTextDinheiro() {
        return textDinheiro;
    }

    public void setTextDinheiro(Double textDinheiro) {
        this.textDinheiro = textDinheiro;
    }

    public String getTextUsuario() {
        return textUsuario;
    }

    public void setTextUsuario(String textUsuario) {
        this.textUsuario = textUsuario;
    }
}
