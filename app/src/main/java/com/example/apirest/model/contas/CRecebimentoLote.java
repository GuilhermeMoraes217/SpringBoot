package com.example.apirest.model.contas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CRecebimentoLote {

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;

    @SerializedName(value = "data", alternate = "DATA")
    @Expose
    private String data;

    @SerializedName(value = "fk_plano", alternate = "FK_PLANO")
    @Expose
    private int fk_plano;

    @SerializedName(value = "fk_fpg", alternate = "FK_FPG")
    @Expose
    private int fk_fpg;

    @SerializedName(value = "fk_conta", alternate = "FK_CONTA")
    @Expose
    private int fk_conta;

    @SerializedName(value = "saldo", alternate = "SALDO")
    @Expose
    private Double saldo;

    @SerializedName(value = "juros_perc", alternate = "JUROS_PERC")
    @Expose
    private Double juros_perc;

    @SerializedName(value = "juros_valor", alternate = "JUROS_VALOR")
    @Expose
    private Double juros_valor;

    @SerializedName(value = "total_c_juros", alternate = "TOTAL_C_JUROS")
    @Expose
    private Double total_c_juros;

    @SerializedName(value = "desconto_perc", alternate = "DESCONTO_PERC")
    @Expose
    private Double desconto_perc;

    @SerializedName(value = "desconto_valor", alternate = "DESCONTO_VALOR")
    @Expose
    private Double desconto_valor;

    @SerializedName(value = "total_final", alternate = "TOTAL_FINAL")
    @Expose
    private Double total_final;

    @SerializedName(value = "fk_empresa", alternate = "FK_EMPRESA")
    @Expose
    private int fk_empresa;

    @SerializedName(value = "fk_usuario", alternate = "FK_USUARIO")
    @Expose
    private int fk_usuario;

    @SerializedName(value = "total_recebido", alternate = "TOTAL_RECEBIDO")
    @Expose
    private Double total_recebido;

    @SerializedName(value = "restante", alternate = "RESTANTE")
    @Expose
    private Double restante;


    public CRecebimentoLote(){

    }

    public CRecebimentoLote(int codigo, String data, int fk_plano, int fk_fpg, int fk_conta, Double saldo, Double juros_perc, Double juros_valor, Double total_c_juros, Double desconto_perc, Double desconto_valor, Double total_final, int fk_empresa, int fk_usuario, Double total_recebido, Double restante) {
        this.codigo = codigo;
        this.data = data;
        this.fk_plano = fk_plano;
        this.fk_fpg = fk_fpg;
        this.fk_conta = fk_conta;
        this.saldo = saldo;
        this.juros_perc = juros_perc;
        this.juros_valor = juros_valor;
        this.total_c_juros = total_c_juros;
        this.desconto_perc = desconto_perc;
        this.desconto_valor = desconto_valor;
        this.total_final = total_final;
        this.fk_empresa = fk_empresa;
        this.fk_usuario = fk_usuario;
        this.total_recebido = total_recebido;
        this.restante = restante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getFk_plano() {
        return fk_plano;
    }

    public void setFk_plano(int fk_plano) {
        this.fk_plano = fk_plano;
    }

    public int getFk_fpg() {
        return fk_fpg;
    }

    public void setFk_fpg(int fk_fpg) {
        this.fk_fpg = fk_fpg;
    }

    public int getFk_conta() {
        return fk_conta;
    }

    public void setFk_conta(int fk_conta) {
        this.fk_conta = fk_conta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getJuros_perc() {
        return juros_perc;
    }

    public void setJuros_perc(Double juros_perc) {
        this.juros_perc = juros_perc;
    }

    public Double getJuros_valor() {
        return juros_valor;
    }

    public void setJuros_valor(Double juros_valor) {
        this.juros_valor = juros_valor;
    }

    public Double getTotal_c_juros() {
        return total_c_juros;
    }

    public void setTotal_c_juros(Double total_c_juros) {
        this.total_c_juros = total_c_juros;
    }

    public Double getDesconto_perc() {
        return desconto_perc;
    }

    public void setDesconto_perc(Double desconto_perc) {
        this.desconto_perc = desconto_perc;
    }

    public Double getDesconto_valor() {
        return desconto_valor;
    }

    public void setDesconto_valor(Double desconto_valor) {
        this.desconto_valor = desconto_valor;
    }

    public Double getTotal_final() {
        return total_final;
    }

    public void setTotal_final(Double total_final) {
        this.total_final = total_final;
    }

    public int getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(int fk_empresa) {
        this.fk_empresa = fk_empresa;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public Double getTotal_recebido() {
        return total_recebido;
    }

    public void setTotal_recebido(Double total_recebido) {
        this.total_recebido = total_recebido;
    }

    public Double getRestante() {
        return restante;
    }

    public void setRestante(Double restante) {
        this.restante = restante;
    }
}
