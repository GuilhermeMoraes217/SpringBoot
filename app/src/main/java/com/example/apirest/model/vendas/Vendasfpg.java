package com.example.apirest.model.vendas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Vendasfpg implements Serializable {

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;

    @SerializedName(value = "vendas_master", alternate = "VENDAS_MASTER")
    @Expose
    private int vendas_master;

    @SerializedName(value = "id_forma", alternate = "ID_FORMA")
    @Expose
    private int id_forma;

    @SerializedName(value = "valor", alternate = "VALOR")
    @Expose
    private double valor;

    @SerializedName(value = "fk_usuario", alternate = "FK_USUARIO")
    @Expose
    private int fk_usuario;

    @SerializedName(value = "situacao", alternate = "SITUACAO")
    @Expose
    private String situacao;

    @SerializedName(value = "tipo", alternate = "TIPO")
    @Expose
    private String tipo;

    @SerializedName(value = "troco", alternate = "TROCO")
    @Expose
    private Double troco;

    @SerializedName(value = "indice", alternate = "INDICE")
    @Expose
    private String indice;

    @SerializedName(value = "fez_tef", alternate = "FEZ_TEF")
    @Expose
    private String fez_tef;

    @SerializedName(value = "nsu", alternate = "NSU")
    @Expose
    private String nsu;

    @SerializedName(value = "rede", alternate = "REDE")
    @Expose
    private String rede;

    @SerializedName(value = "redecnpj", alternate = "REDECNPJ")
    @Expose
    private String redecnpj;

    @SerializedName(value = "total", alternate = "TOTAL")
    @Expose
    private Double total;

    @SerializedName(value = "codigoautorizacao", alternate = "CODIGOAUTORIZACAO")
    @Expose
    private String codigoautorizacao;

    @SerializedName(value = "bin", alternate = "BIN")
    @Expose
    private String bin;

    @SerializedName(value = "donocartao", alternate = "DONOCARTAO")
    @Expose
    private String donocartao;

    @SerializedName(value = "dataexpedicao", alternate = "DATAEXPIRACAO")
    @Expose
    private String dataexpedicao;

    @SerializedName(value = "parcelas", alternate = "PARCELAS")
    @Expose
    private int parcelas;

    @SerializedName(value = "codigopagamento", alternate = "CODIGOPAGAMENTO")
    @Expose
    private int codigopagamento;

    @SerializedName(value = "valorpagamento", alternate = "VALORPAGAMENTO")
    @Expose
    private Double valorpagamento;

    @SerializedName(value = "id_fila", alternate = "ID_FILA")
    @Expose
    private int id_fila;

    @SerializedName(value = "tipo_tef", alternate = "TIPO_TEF")
    @Expose
    private String tipo_tef;

    @SerializedName(value = "ultimosquatrodigitos", alternate = "ULTIMOSQUATRODIGITOS")
    @Expose
    private String ultimosquatrodigitos;

    public Vendasfpg() {

    }

    public Vendasfpg(int codigo, int vendas_master, int id_forma, double valor, int fk_usuario, String situacao, String tipo, Double troco, String indice, String fez_tef, String nsu, String rede, String redecnpj, Double total, String codigoautorizacao, String bin, String donocartao, String dataexpedicao, int parcelas, int codigopagamento, Double valorpagamento, int id_fila, String tipo_tef, String ultimosquatrodigitos) {
        this.codigo = codigo;
        this.vendas_master = vendas_master;
        this.id_forma = id_forma;
        this.valor = valor;
        this.fk_usuario = fk_usuario;
        this.situacao = situacao;
        this.tipo = tipo;
        this.troco = troco;
        this.indice = indice;
        this.fez_tef = fez_tef;
        this.nsu = nsu;
        this.rede = rede;
        this.redecnpj = redecnpj;
        this.total = total;
        this.codigoautorizacao = codigoautorizacao;
        this.bin = bin;
        this.donocartao = donocartao;
        this.dataexpedicao = dataexpedicao;
        this.parcelas = parcelas;
        this.codigopagamento = codigopagamento;
        this.valorpagamento = valorpagamento;
        this.id_fila = id_fila;
        this.tipo_tef = tipo_tef;
        this.ultimosquatrodigitos = ultimosquatrodigitos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getVendas_master() {
        return vendas_master;
    }

    public void setVendas_master(int vendas_master) {
        this.vendas_master = vendas_master;
    }

    public int getId_forma() {
        return id_forma;
    }

    public void setId_forma(int id_forma) {
        this.id_forma = id_forma;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getFez_tef() {
        return fez_tef;
    }

    public void setFez_tef(String fez_tef) {
        this.fez_tef = fez_tef;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getRede() {
        return rede;
    }

    public void setRede(String rede) {
        this.rede = rede;
    }

    public String getRedecnpj() {
        return redecnpj;
    }

    public void setRedecnpj(String redecnpj) {
        this.redecnpj = redecnpj;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCodigoautorizacao() {
        return codigoautorizacao;
    }

    public void setCodigoautorizacao(String codigoautorizacao) {
        this.codigoautorizacao = codigoautorizacao;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getDonocartao() {
        return donocartao;
    }

    public void setDonocartao(String donocartao) {
        this.donocartao = donocartao;
    }

    public String getDataexpedicao() {
        return dataexpedicao;
    }

    public void setDataexpedicao(String dataexpedicao) {
        this.dataexpedicao = dataexpedicao;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public int getCodigopagamento() {
        return codigopagamento;
    }

    public void setCodigopagamento(int codigopagamento) {
        this.codigopagamento = codigopagamento;
    }

    public Double getValorpagamento() {
        return valorpagamento;
    }

    public void setValorpagamento(Double valorpagamento) {
        this.valorpagamento = valorpagamento;
    }

    public int getId_fila() {
        return id_fila;
    }

    public void setId_fila(int id_fila) {
        this.id_fila = id_fila;
    }

    public String getTipo_tef() {
        return tipo_tef;
    }

    public void setTipo_tef(String tipo_tef) {
        this.tipo_tef = tipo_tef;
    }

    public String getUltimosquatrodigitos() {
        return ultimosquatrodigitos;
    }

    public void setUltimosquatrodigitos(String ultimosquatrodigitos) {
        this.ultimosquatrodigitos = ultimosquatrodigitos;
    }
}
