package com.example.apirest.model.contas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CPagamento {

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;

    @SerializedName(value = "fkpagar", alternate = "FKPAGAR")
    @Expose
    private int fkpagar;

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

    @SerializedName(value = "valor_recebimento", alternate = "VALOR_RECEBIDO")
    @Expose
    private Double valor_recebimento;

    @SerializedName(value = "fkplano", alternate = "FKPLANO")
    @Expose
    private int fkplano;

    @SerializedName(value = "fkusuario", alternate = "FKUSUARIO")
    @Expose
    private int fkusuario;

    @SerializedName(value = "fkkempresa", alternate = "FKKEMPRESA")
    @Expose
    private int fkkempresa;

    @SerializedName(value = "fkconta", alternate = "FKCONTA")
    @Expose
    private int fkconta;

    @SerializedName(value = "fk_forma_pgto", alternate = "FK_FORMA_PGTO")
    @Expose
    private int fk_forma_pgto;

    @SerializedName(value = "numero_cheque", alternate = "NUMERO_CHEQUE")
    @Expose
    private int numero_cheque;

    @SerializedName(value = "fkfornecedor", alternate = "FKFORNECEDOR")
    @Expose
    private int fkfornecedor;

    @SerializedName(value = "fk_lote", alternate = "FK_LOTE")
    @Expose
    private int fk_lote;

    public CPagamento(){

    }

    public CPagamento(int codigo, int fkpagar, String data, Double valor_parcela, Double perc_juros, Double juros, Double perc_desconto, Double desconto, Double valor_recebimento, int fkplano, int fkusuario, int fkkempresa, int fkconta, int fk_forma_pgto, int numero_cheque, int fkfornecedor, int fk_lote) {
        this.codigo = codigo;
        this.fkpagar = fkpagar;
        this.data = data;
        this.valor_parcela = valor_parcela;
        this.perc_juros = perc_juros;
        this.juros = juros;
        this.perc_desconto = perc_desconto;
        this.desconto = desconto;
        this.valor_recebimento = valor_recebimento;
        this.fkplano = fkplano;
        this.fkusuario = fkusuario;
        this.fkkempresa = fkkempresa;
        this.fkconta = fkconta;
        this.fk_forma_pgto = fk_forma_pgto;
        this.numero_cheque = numero_cheque;
        this.fkfornecedor = fkfornecedor;
        this.fk_lote = fk_lote;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getFkpagar() {
        return fkpagar;
    }

    public void setFkpagar(int fkpagar) {
        this.fkpagar = fkpagar;
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

    public Double getValor_recebimento() {
        return valor_recebimento;
    }

    public void setValor_recebimento(Double valor_recebimento) {
        this.valor_recebimento = valor_recebimento;
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

    public int getFkkempresa() {
        return fkkempresa;
    }

    public void setFkkempresa(int fkkempresa) {
        this.fkkempresa = fkkempresa;
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

    public int getFkfornecedor() {
        return fkfornecedor;
    }

    public void setFkfornecedor(int fkfornecedor) {
        this.fkfornecedor = fkfornecedor;
    }

    public int getFk_lote() {
        return fk_lote;
    }

    public void setFk_lote(int fk_lote) {
        this.fk_lote = fk_lote;
    }
}
