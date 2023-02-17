package com.example.apirest.model.vendas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FormaPagamento implements Serializable {
    /*

FK_BANDEIRA
     */

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;

    @SerializedName(value = "descricao", alternate = "DESCRICAO")
    @Expose
    private String descricao;

    @SerializedName(value = "geracr", alternate = "GERACR")
    @Expose
    private String geracr;

    @SerializedName(value = "gerach", alternate = "GERACH")
    @Expose
    private String gerach;

    @SerializedName(value = "ecartao", alternate = "ECARTAO")
    @Expose
    private String ecartao;

    @SerializedName(value = "usavd", alternate = "USAVD")
    @Expose
    private String usavd;

    @SerializedName(value = "usacr", alternate = "USACR")
    @Expose
    private String usacr;

    @SerializedName(value = "ativo", alternate = "ATIVO")
    @Expose
    private String ativo;

    @SerializedName(value = "parcelas", alternate = "PARCELAS")
    @Expose
    private int parcelas;

    @SerializedName(value = "intervalo", alternate = "INTERVALO")
    @Expose
    private int intervalo;

    @SerializedName(value = "taxa", alternate = "TAXA")
    @Expose
    private Double taxa;

    @SerializedName(value = "entrada", alternate = "ENTRADA")
    @Expose
    private Double entrada;

    @SerializedName(value = "tipo", alternate = "TIPO")
    @Expose
    private String tipo;

    @SerializedName(value = "dias", alternate = "DIAS")
    @Expose
    private String dias;

    @SerializedName(value = "fkcontadestino", alternate = "FKCONTADESTINO")
    @Expose
    private int fkcontadestino;

    @SerializedName(value = "cod_bema", alternate = "COD_BEMA")
    @Expose
    private String cod_bema;

    @SerializedName(value = "cod_daru", alternate = "COD_DARU")
    @Expose
    private String cod_daru;

    @SerializedName(value = "cod_elgi", alternate = "COD_ELGI")
    @Expose
    private String cod_elgi;

    @SerializedName(value = "cod_epso", alternate = "COD_EPSO")
    @Expose
    private String cod_epso;

    @SerializedName(value = "geracc", alternate = "GERACC")
    @Expose
    private String geracc;

    @SerializedName(value = "geracx", alternate = "GERACX")
    @Expose
    private String geracx;

    @SerializedName(value = "fk_pessoa", alternate = "FK_PESSOA")
    @Expose
    private int fk_pessoa;

    @SerializedName(value = "usa_tef", alternate = "USA_TEF")
    @Expose
    private String usa_tef;

    @SerializedName(value = "fk_bandeira", alternate = "FK_BANDEIRA")
    @Expose
    private int fk_bandeira;

    public FormaPagamento() {

    }

    public FormaPagamento(int codigo, String descricao, String geracr, String gerach, String ecartao, String usavd, String usacr, String ativo, int parcelas, int intervalo, Double taxa, Double entrada, String tipo, String dias, int fkcontadestino, String cod_bema, String cod_daru, String cod_elgi, String cod_epso, String geracc, String geracx, int fk_pessoa, String usa_tef, int fk_bandeira) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.geracr = geracr;
        this.gerach = gerach;
        this.ecartao = ecartao;
        this.usavd = usavd;
        this.usacr = usacr;
        this.ativo = ativo;
        this.parcelas = parcelas;
        this.intervalo = intervalo;
        this.taxa = taxa;
        this.entrada = entrada;
        this.tipo = tipo;
        this.dias = dias;
        this.fkcontadestino = fkcontadestino;
        this.cod_bema = cod_bema;
        this.cod_daru = cod_daru;
        this.cod_elgi = cod_elgi;
        this.cod_epso = cod_epso;
        this.geracc = geracc;
        this.geracx = geracx;
        this.fk_pessoa = fk_pessoa;
        this.usa_tef = usa_tef;
        this.fk_bandeira = fk_bandeira;
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

    public String getGeracr() {
        return geracr;
    }

    public void setGeracr(String geracr) {
        this.geracr = geracr;
    }

    public String getGerach() {
        return gerach;
    }

    public void setGerach(String gerach) {
        this.gerach = gerach;
    }

    public String getEcartao() {
        return ecartao;
    }

    public void setEcartao(String ecartao) {
        this.ecartao = ecartao;
    }

    public String getUsavd() {
        return usavd;
    }

    public void setUsavd(String usavd) {
        this.usavd = usavd;
    }

    public String getUsacr() {
        return usacr;
    }

    public void setUsacr(String usacr) {
        this.usacr = usacr;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Double getEntrada() {
        return entrada;
    }

    public void setEntrada(Double entrada) {
        this.entrada = entrada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public int getFkcontadestino() {
        return fkcontadestino;
    }

    public void setFkcontadestino(int fkcontadestino) {
        this.fkcontadestino = fkcontadestino;
    }

    public String getCod_bema() {
        return cod_bema;
    }

    public void setCod_bema(String cod_bema) {
        this.cod_bema = cod_bema;
    }

    public String getCod_daru() {
        return cod_daru;
    }

    public void setCod_daru(String cod_daru) {
        this.cod_daru = cod_daru;
    }

    public String getCod_elgi() {
        return cod_elgi;
    }

    public void setCod_elgi(String cod_elgi) {
        this.cod_elgi = cod_elgi;
    }

    public String getCod_epso() {
        return cod_epso;
    }

    public void setCod_epso(String cod_epso) {
        this.cod_epso = cod_epso;
    }

    public String getGeracc() {
        return geracc;
    }

    public void setGeracc(String geracc) {
        this.geracc = geracc;
    }

    public String getGeracx() {
        return geracx;
    }

    public void setGeracx(String geracx) {
        this.geracx = geracx;
    }

    public int getFk_pessoa() {
        return fk_pessoa;
    }

    public void setFk_pessoa(int fk_pessoa) {
        this.fk_pessoa = fk_pessoa;
    }

    public String getUsa_tef() {
        return usa_tef;
    }

    public void setUsa_tef(String usa_tef) {
        this.usa_tef = usa_tef;
    }

    public int getFk_bandeira() {
        return fk_bandeira;
    }

    public void setFk_bandeira(int fk_bandeira) {
        this.fk_bandeira = fk_bandeira;
    }
}
