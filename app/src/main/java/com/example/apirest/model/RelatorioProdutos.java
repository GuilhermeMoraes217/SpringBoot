package com.example.apirest.model;

import android.widget.ImageView;

import java.io.Serializable;

public class RelatorioProdutos implements Serializable {

    private ImageView imagemStatus;
    private String idRelatorio, idRelatorio_R, idGeral, nomeProduto;
    private Double preco_1, preco_2, porcentagem_1;
    private int porcentagem_2;

    public RelatorioProdutos() {

    }

    public RelatorioProdutos(String idRelatorio, String idRelatorio_R, String idGeral, String nomeProduto, Double preco_1, Double preco_2, Double porcentagem_1, int porcentagem_2) {
        this.idRelatorio = idRelatorio;
        this.idRelatorio_R = idRelatorio_R;
        this.idGeral = idGeral;
        this.nomeProduto = nomeProduto;
        this.preco_1 = preco_1;
        this.preco_2 = preco_2;
        this.porcentagem_1 = porcentagem_1;
        this.porcentagem_2 = porcentagem_2;
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

    public String getIdRelatorio_R() {
        return idRelatorio_R;
    }

    public void setIdRelatorio_R(String idRelatorio_R) {
        this.idRelatorio_R = idRelatorio_R;
    }

    public String getIdGeral() {
        return idGeral;
    }

    public void setIdGeral(String idGeral) {
        this.idGeral = idGeral;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPreco_1() {
        return preco_1;
    }

    public void setPreco_1(Double preco_1) {
        this.preco_1 = preco_1;
    }

    public Double getPreco_2() {
        return preco_2;
    }

    public void setPreco_2(Double preco_2) {
        this.preco_2 = preco_2;
    }

    public Double getPorcentagem_1() {
        return porcentagem_1;
    }

    public void setPorcentagem_1(Double porcentagem_1) {
        this.porcentagem_1 = porcentagem_1;
    }

    public int getPorcentagem_2() {
        return porcentagem_2;
    }

    public void setPorcentagem_2(int porcentagem_2) {
        this.porcentagem_2 = porcentagem_2;
    }
}
