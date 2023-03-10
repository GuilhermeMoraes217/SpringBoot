package com.example.apirest.model.checkout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Contas implements Serializable {
    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;
    @SerializedName(value = "descricao", alternate = "DESCRICAO")
    @Expose
    private String descricao;
    @SerializedName(value = "tipo", alternate = "TIPO")
    @Expose
    private String tipo;
    @SerializedName(value = "data_abertura", alternate = "DATA_ABERTURA")
    @Expose
    private String data_abertura;
    @SerializedName(value = "id_usuario", alternate = "ID_USUARIO")
    @Expose
    private int id_usuario;
    @SerializedName(value = "empresa", alternate = "EMPRESA")
    @Expose
    private int empresa;
    @SerializedName(value = "lote", alternate = "LOTE")
    @Expose
    private int lote;
    @SerializedName(value = "situacao", alternate = "SITUACAO")
    @Expose
    private String situacao;
    @SerializedName(value = "ativo", alternate = "ATIVO")
    @Expose
    private String ativo;

    private String nomeUsuarioCaixa, nomeEmpresaCaixa, dataHoraCaixa, flagCaixa, TipoCaixa;
    private Double valorTotalCaixa, valorTotalCaixaSaida;

    public Contas() {
    }

    public Contas(int codigo, String descricao, String tipo, String data_abertura, int id_usuario, int empresa, int lote, String situacao, String ativo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.data_abertura = data_abertura;
        this.id_usuario = id_usuario;
        this.empresa = empresa;
        this.lote = lote;
        this.situacao = situacao;
        this.ativo = ativo;
    }


    public String getFlagCaixa() {
        return flagCaixa;
    }

    public void setFlagCaixa(String flagCaixa) {
        this.flagCaixa = flagCaixa;
    }

    public String getTipoCaixa() {
        return TipoCaixa;
    }

    public void setTipoCaixa(String tipoCaixa) {
        TipoCaixa = tipoCaixa;
    }

    public Double getValorTotalCaixaSaida() {
        return valorTotalCaixaSaida;
    }

    public void setValorTotalCaixaSaida(Double valorTotalCaixaSaida) {
        this.valorTotalCaixaSaida = valorTotalCaixaSaida;
    }

    public String getNomeUsuarioCaixa() {
        return nomeUsuarioCaixa;
    }

    public void setNomeUsuarioCaixa(String nomeUsuarioCaixa) {
        this.nomeUsuarioCaixa = nomeUsuarioCaixa;
    }

    public String getNomeEmpresaCaixa() {
        return nomeEmpresaCaixa;
    }

    public void setNomeEmpresaCaixa(String nomeEmpresaCaixa) {
        this.nomeEmpresaCaixa = nomeEmpresaCaixa;
    }

    public String getDataHoraCaixa() {
        return dataHoraCaixa;
    }

    public void setDataHoraCaixa(String dataHoraCaixa) {
        this.dataHoraCaixa = dataHoraCaixa;
    }

    public Double getValorTotalCaixa() {
        return valorTotalCaixa;
    }

    public void setValorTotalCaixa(Double valorTotalCaixa) {
        this.valorTotalCaixa = valorTotalCaixa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(String data_abertura) {
        this.data_abertura = data_abertura;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
