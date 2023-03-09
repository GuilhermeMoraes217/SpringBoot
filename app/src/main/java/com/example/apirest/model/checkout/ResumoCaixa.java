package com.example.apirest.model.checkout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResumoCaixa implements Serializable {

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;
    @SerializedName(value = "lote", alternate = "LOTE")
    @Expose
    private int lote;
    @SerializedName(value = "fpg", alternate = "FPG")
    @Expose
    private int fpg;
    @SerializedName(value = "usuario", alternate = "USUARIO")
    @Expose
    private int usuario;
    @SerializedName(value = "caixa", alternate = "CAIXA")
    @Expose
    private int caixa;
    @SerializedName(value = "data_hora", alternate = "DATA_HORA")
    @Expose
    private String data_hora;
    @SerializedName(value = "tipo", alternate = "TIPO")
    @Expose
    private String tipo;
    @SerializedName(value = "historico", alternate = "HISTORICO")
    @Expose
    private String historico;
    @SerializedName(value = "flag", alternate = "FLAG")
    @Expose
    private String flag;
    @SerializedName(value = "entrada", alternate = "ENTRADA")
    @Expose
    private Double entrada;
    @SerializedName(value = "saida", alternate = "SAIDA")
    @Expose
    private Double saida;
    @SerializedName(value = "fkempresa", alternate = "FKEMPRESA")
    @Expose
    private int fkempresa;

    public ResumoCaixa() {
    }

    public ResumoCaixa(int codigo, int lote, int fpg, int usuario, int caixa, String data_hora, String tipo, String historico, String flag, Double entrada, Double saida, int fkempresa) {
        this.codigo = codigo;
        this.lote = lote;
        this.fpg = fpg;
        this.usuario = usuario;
        this.caixa = caixa;
        this.data_hora = data_hora;
        this.tipo = tipo;
        this.historico = historico;
        this.flag = flag;
        this.entrada = entrada;
        this.saida = saida;
        this.fkempresa = fkempresa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public int getFpg() {
        return fpg;
    }

    public void setFpg(int fpg) {
        this.fpg = fpg;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getCaixa() {
        return caixa;
    }

    public void setCaixa(int caixa) {
        this.caixa = caixa;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public int getFkempresa() {
        return fkempresa;
    }

    public void setFkempresa(int fkempresa) {
        this.fkempresa = fkempresa;
    }
}
