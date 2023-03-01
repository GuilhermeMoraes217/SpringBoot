package com.example.apirest.model.contas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CPagar {

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;

    @SerializedName(value = "data", alternate = "DATA")
    @Expose
    private String data;

    @SerializedName(value = "fkfornece", alternate = "FKFORNECE")
    @Expose
    private int fkfornece;

    @SerializedName(value = "doc", alternate = "DOC")
    @Expose
    private String doc;

    @SerializedName(value = "valor", alternate = "VALOR")
    @Expose
    private Double valor;

    @SerializedName(value = "dtvencimento", alternate = "DTVENCIMENTO")
    @Expose
    private String dtvencimento;

    @SerializedName(value = "historico", alternate = "HISTORICO")
    @Expose
    private String historico;

    @SerializedName(value = "data_pagamento", alternate = "DATA_PAGAMENTO")
    @Expose
    private String data_pagamento;

    @SerializedName(value = "desconto", alternate = "DESCONTO")
    @Expose
    private Double desconto;

    @SerializedName(value = "juros", alternate = "JUROS")
    @Expose
    private Double juros;

    @SerializedName(value = "vlpago", alternate = "VLPAGO")
    @Expose
    private Double vlpago;

    @SerializedName(value = "vl_restante", alternate = "VL_RESTANTE")
    @Expose
    private Double vl_restante;

    @SerializedName(value = "situacao", alternate = "SITUACAO")
    @Expose
    private String situacao;

    @SerializedName(value = "fkempresa", alternate = "FKEMPRESA")
    @Expose
    private int fkempresa;

    @SerializedName(value = "fk_compra", alternate = "FK_COMPRA")
    @Expose
    private int fk_compra;

    @SerializedName(value = "flag", alternate = "FLAG")
    @Expose
    private String flag;

    @SerializedName(value = "fk_usuario", alternate = "FK_USUARIO")
    @Expose
    private int fk_usuario;

    @SerializedName(value = "fk_fpg", alternate = "FK_FPG")
    @Expose
    private int fk_fpg;

    public CPagar(){

    }

    public CPagar(int codigo, String data, int fkfornece, String doc, Double valor, String dtvencimento, String historico, String data_pagamento, Double desconto, Double juros, Double vlpago, Double vl_restante, String situacao, int fkempresa, int fk_compra, String flag, int fk_usuario, int fk_fpg) {
        this.codigo = codigo;
        this.data = data;
        this.fkfornece = fkfornece;
        this.doc = doc;
        this.valor = valor;
        this.dtvencimento = dtvencimento;
        this.historico = historico;
        this.data_pagamento = data_pagamento;
        this.desconto = desconto;
        this.juros = juros;
        this.vlpago = vlpago;
        this.vl_restante = vl_restante;
        this.situacao = situacao;
        this.fkempresa = fkempresa;
        this.fk_compra = fk_compra;
        this.flag = flag;
        this.fk_usuario = fk_usuario;
        this.fk_fpg = fk_fpg;
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

    public int getFkfornece() {
        return fkfornece;
    }

    public void setFkfornece(int fkfornece) {
        this.fkfornece = fkfornece;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDtvencimento() {
        return dtvencimento;
    }

    public void setDtvencimento(String dtvencimento) {
        this.dtvencimento = dtvencimento;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Double getVlpago() {
        return vlpago;
    }

    public void setVlpago(Double vlpago) {
        this.vlpago = vlpago;
    }

    public Double getVl_restante() {
        return vl_restante;
    }

    public void setVl_restante(Double vl_restante) {
        this.vl_restante = vl_restante;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getFkempresa() {
        return fkempresa;
    }

    public void setFkempresa(int fkempresa) {
        this.fkempresa = fkempresa;
    }

    public int getFk_compra() {
        return fk_compra;
    }

    public void setFk_compra(int fk_compra) {
        this.fk_compra = fk_compra;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public int getFk_fpg() {
        return fk_fpg;
    }

    public void setFk_fpg(int fk_fpg) {
        this.fk_fpg = fk_fpg;
    }
}
