package com.example.apirest.model.contas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CRecebimento {

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;

    @SerializedName(value = "fkcliente", alternate = "FKCLIENTE")
    @Expose
    private int fkcliente;

    @SerializedName(value = "fkreceber", alternate = "FKRECEBER")
    @Expose
    private int fkreceber;

    @SerializedName(value = "data", alternate = "DATA")
    @Expose
    private String data;

    @SerializedName(value = "valor_parcela", alternate = "VALOR_PARCELA")
    @Expose
    private Double valor_parcela;

    @SerializedName(value = "perc_juros", alternate = "PERC_JUROS")
    @Expose
    private Double perc_juros;

    @SerializedName(value = "juros", alternate = "JUROS")
    @Expose
    private Double juros;

    @SerializedName(value = "perc_desconto", alternate = "PERC_DESCONTO")
    @Expose
    private Double perc_desconto;

    @SerializedName(value = "desconto", alternate = "DESCONTO")
    @Expose
    private Double desconto;

    @SerializedName(value = "valor_recebido", alternate = "VALOR_RECEBIDO")
    @Expose
    private Double valor_recebido;

    @SerializedName(value = "fkplano", alternate = "FKPLANO")
    @Expose
    private int fkplano;

    @SerializedName(value = "fkusuario", alternate = "FKUSUARIO")
    @Expose
    private int fkusuario;

    @SerializedName(value = "fkempresa", alternate = "FKKEMPRESA")
    @Expose
    private int fkempresa;

    @SerializedName(value = "fkconta", alternate = "FKCONTA")
    @Expose
    private int fkconta;

    @SerializedName(value = "fk_forma_pgto", alternate = "FK_FORMA_PGTO")
    @Expose
    private int fk_forma_pgto;

    @SerializedName(value = "numero_cheque", alternate = "NUMERO_CHEQUE")
    @Expose
    private int numero_cheque;

    @SerializedName(value = "id_subcaixa", alternate = "ID_SUBCAIXA")
    @Expose
    private int id_subcaixa;

    @SerializedName(value = "fklote", alternate = "FKLOTE")
    @Expose
    private int fklote;

    public CRecebimento(){

    }

    public CRecebimento(int codigo, int fkcliente, int fkreceber, String data, Double valor_parcela, Double perc_juros, Double juros, Double perc_desconto, Double desconto, Double valor_recebido, int fkplano, int fkusuario, int fkempresa, int fkconta, int fk_forma_pgto, int numero_cheque, int id_subcaixa, int fklote) {
        this.codigo = codigo;
        this.fkcliente = fkcliente;
        this.fkreceber = fkreceber;
        this.data = data;
        this.valor_parcela = valor_parcela;
        this.perc_juros = perc_juros;
        this.juros = juros;
        this.perc_desconto = perc_desconto;
        this.desconto = desconto;
        this.valor_recebido = valor_recebido;
        this.fkplano = fkplano;
        this.fkusuario = fkusuario;
        this.fkempresa = fkempresa;
        this.fkconta = fkconta;
        this.fk_forma_pgto = fk_forma_pgto;
        this.numero_cheque = numero_cheque;
        this.id_subcaixa = id_subcaixa;
        this.fklote = fklote;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(int fkcliente) {
        this.fkcliente = fkcliente;
    }

    public int getFkreceber() {
        return fkreceber;
    }

    public void setFkreceber(int fkreceber) {
        this.fkreceber = fkreceber;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValor_parcela() {
        return valor_parcela;
    }

    public void setValor_parcela(Double valor_parcela) {
        this.valor_parcela = valor_parcela;
    }

    public Double getPerc_juros() {
        return perc_juros;
    }

    public void setPerc_juros(Double perc_juros) {
        this.perc_juros = perc_juros;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Double getPerc_desconto() {
        return perc_desconto;
    }

    public void setPerc_desconto(Double perc_desconto) {
        this.perc_desconto = perc_desconto;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getValor_recebido() {
        return valor_recebido;
    }

    public void setValor_recebido(Double valor_recebido) {
        this.valor_recebido = valor_recebido;
    }

    public int getFkplano() {
        return fkplano;
    }

    public void setFkplano(int fkplano) {
        this.fkplano = fkplano;
    }

    public int getFkusuario() {
        return fkusuario;
    }

    public void setFkusuario(int fkusuario) {
        this.fkusuario = fkusuario;
    }

    public int getFkempresa() {
        return fkempresa;
    }

    public void setFkempresa(int fkempresa) {
        this.fkempresa = fkempresa;
    }

    public int getFkconta() {
        return fkconta;
    }

    public void setFkconta(int fkconta) {
        this.fkconta = fkconta;
    }

    public int getFk_forma_pgto() {
        return fk_forma_pgto;
    }

    public void setFk_forma_pgto(int fk_forma_pgto) {
        this.fk_forma_pgto = fk_forma_pgto;
    }

    public int getNumero_cheque() {
        return numero_cheque;
    }

    public void setNumero_cheque(int numero_cheque) {
        this.numero_cheque = numero_cheque;
    }

    public int getId_subcaixa() {
        return id_subcaixa;
    }

    public void setId_subcaixa(int id_subcaixa) {
        this.id_subcaixa = id_subcaixa;
    }

    public int getFklote() {
        return fklote;
    }

    public void setFklote(int fklote) {
        this.fklote = fklote;
    }
}
