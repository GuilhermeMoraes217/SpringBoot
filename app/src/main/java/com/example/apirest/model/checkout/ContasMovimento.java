package com.example.apirest.model.checkout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ContasMovimento implements Serializable {

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;
    @SerializedName(value = "id_conta_caixa", alternate = "ID_CONTA_CAIXA")
    @Expose
    private int id_conta_caixa;
    @SerializedName(value = "id_usuario", alternate = "ID_USUARIO")
    @Expose
    private int id_usuario;
    @SerializedName(value = "historico", alternate = "HISTORICO")
    @Expose
    private String historico;
    @SerializedName(value = "data", alternate = "DATA")
    @Expose
    private String data;
    @SerializedName(value = "hora", alternate = "HORA")
    @Expose
    private String hora;
    @SerializedName(value = "entrada", alternate = "ENTRADA")
    @Expose
    private Double entrada;
    @SerializedName(value = "saida", alternate = "SAIDA")
    @Expose
    private Double saida;
    @SerializedName(value = "fkvenda", alternate = "FKVENDA")
    @Expose
    private int fkvenda;
    @SerializedName(value = "lote", alternate = "LOTE")
    @Expose
    private int lote;
    @SerializedName(value = "troca", alternate = "TROCA")
    @Expose
    private Double troca;
    @SerializedName(value = "saldo", alternate = "SALDO")
    @Expose
    private Double saldo;
    @SerializedName(value = "troco", alternate = "TROCO")
    @Expose
    private Double troco;

    public ContasMovimento() {
    }

    public ContasMovimento(int codigo, int id_conta_caixa, int id_usuario, String historico, String data, String hora, Double entrada, Double saida, int fkvenda, int lote, Double troca, Double saldo, Double troco) {
        this.codigo = codigo;
        this.id_conta_caixa = id_conta_caixa;
        this.id_usuario = id_usuario;
        this.historico = historico;
        this.data = data;
        this.hora = hora;
        this.entrada = entrada;
        this.saida = saida;
        this.fkvenda = fkvenda;
        this.lote = lote;
        this.troca = troca;
        this.saldo = saldo;
        this.troco = troco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getId_conta_caixa() {
        return id_conta_caixa;
    }

    public void setId_conta_caixa(int id_conta_caixa) {
        this.id_conta_caixa = id_conta_caixa;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Double getEntrada() {
        return entrada;
    }

    public void setEntrada(Double entrada) {
        this.entrada = entrada;
    }

    public Double getSaida() {
        return saida;
    }

    public void setSaida(Double saida) {
        this.saida = saida;
    }

    public int getFkvenda() {
        return fkvenda;
    }

    public void setFkvenda(int fkvenda) {
        this.fkvenda = fkvenda;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public Double getTroca() {
        return troca;
    }

    public void setTroca(Double troca) {
        this.troca = troca;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }
}
