package com.example.apirest.model.contas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CCompra {

    @SerializedName(value = "id", alternate = "ID")
    @Expose
    private int id;

    @SerializedName(value = "id_empresa", alternate = "ID_EMPRESA")
    @Expose
    private int id_empresa;
    @SerializedName(value = "dtentrada", alternate = "DTENTRADA")
    @Expose
    private String dtentrada;
    @SerializedName(value = "dtemissao", alternate = "DTEMISSAO")
    @Expose
    private String dtemissao;
    @SerializedName(value = "fornecedor", alternate = "FORNECEDOR")
    @Expose
    private int fornecedor;
    @SerializedName(value = "modelo", alternate = "MODELO")
    @Expose
    private String modelo;
    @SerializedName(value = "serie", alternate = "SERIE")
    @Expose
    private String serie;
    @SerializedName(value = "chave", alternate = "CHAVE")
    @Expose
    private String chave;
    @SerializedName(value = "nr_nota", alternate = "NR_NOTA")
    @Expose
    private String nr_nota;
    @SerializedName(value = "subtotal", alternate = "SUBTOTAL")
    @Expose
    private Double subtotal;
    @SerializedName(value = "frete", alternate = "FRETE")
    @Expose
    private Double frete;
    @SerializedName(value = "despesas", alternate = "DESPESAS")
    @Expose
    private Double despesas;
    @SerializedName(value = "seguro", alternate = "SEGURO")
    @Expose
    private Double seguro;
    @SerializedName(value = "desconto", alternate = "DESCONTO")
    @Expose
    private Double desconto;
    @SerializedName(value = "base_ipi", alternate = "BASE_IPI")
    @Expose
    private Double base_ipi;
    @SerializedName(value = "total_ipi", alternate = "TOTAL_IPI")
    @Expose
    private Double total_ipi;
    @SerializedName(value = "base_icm", alternate = "BASE_ICM")
    @Expose
    private Double base_icm;
    @SerializedName(value = "total_icm", alternate = "TOTAL_ICM")
    @Expose
    private Double total_icm;
    @SerializedName(value = "base_st", alternate = "BASE_ST")
    @Expose
    private Double base_st;
    @SerializedName(value = "total_st", alternate = "TOTAL_ST")
    @Expose
    private Double total_st;
    @SerializedName(value = "base_pis", alternate = "BASE_PIS")
    @Expose
    private Double base_pis;
    @SerializedName(value = "total_pis", alternate = "TOTAL_PIS")
    @Expose
    private Double total_pis;
    @SerializedName(value = "base_cof", alternate = "BASE_COF")
    @Expose
    private Double base_cof;
    @SerializedName(value = "total_cof", alternate = "TOTAL_COF")
    @Expose
    private Double total_cof;
    @SerializedName(value = "total", alternate = "TOTAL")
    @Expose
    private Double total;
    @SerializedName(value = "gera_cp", alternate = "GERA_CP")
    @Expose
    private String gera_cp;
    @SerializedName(value = "gera_es", alternate = "GERA_ES")
    @Expose
    private String gera_es;
    @SerializedName(value = "ajusta_pc", alternate = "AJUSTA_PC")
    @Expose
    private String ajusta_pc;
    @SerializedName(value = "ajusta_pv", alternate = "AJUSTA_PV")
    @Expose
    private String ajusta_pv;
    @SerializedName(value = "ehfiscal", alternate = "EHFISCAL")
    @Expose
    private String ehfiscal;
    @SerializedName(value = "leuxml", alternate = "LEUXML")
    @Expose
    private String leuxml;
    @SerializedName(value = "status", alternate = "STATUS")
    @Expose
    private String status;
    @SerializedName(value = "xml", alternate = "XML")
    @Expose
    private String xml;
    @SerializedName(value = "tipo", alternate = "TIPO")
    @Expose
    private String tipo;
    @SerializedName(value = "leu_duplicada", alternate = "LEU_DUPLICATA")
    @Expose
    private String leu_duplicada;
    @SerializedName(value = "nome", alternate = "NOME")
    @Expose
    private String nome;
    @SerializedName(value = "base_fcp", alternate = "BASE_FCP")
    @Expose
    private Double base_fcp;

    public CCompra(){

    }

    public CCompra(int id, int id_empresa, String dtentrada, String dtemissao, int fornecedor, String modelo, String serie, String chave, String nr_nota, Double subtotal, Double frete, Double despesas, Double seguro, Double desconto, Double base_ipi, Double total_ipi, Double base_icm, Double total_icm, Double base_st, Double total_st, Double base_pis, Double total_pis, Double base_cof, Double total_cof, Double total, String gera_cp, String gera_es, String ajusta_pc, String ajusta_pv, String ehfiscal, String leuxml, String status, String xml, String tipo, String leu_duplicada, String nome, Double base_fcp) {
        this.id = id;
        this.id_empresa = id_empresa;
        this.dtentrada = dtentrada;
        this.dtemissao = dtemissao;
        this.fornecedor = fornecedor;
        this.modelo = modelo;
        this.serie = serie;
        this.chave = chave;
        this.nr_nota = nr_nota;
        this.subtotal = subtotal;
        this.frete = frete;
        this.despesas = despesas;
        this.seguro = seguro;
        this.desconto = desconto;
        this.base_ipi = base_ipi;
        this.total_ipi = total_ipi;
        this.base_icm = base_icm;
        this.total_icm = total_icm;
        this.base_st = base_st;
        this.total_st = total_st;
        this.base_pis = base_pis;
        this.total_pis = total_pis;
        this.base_cof = base_cof;
        this.total_cof = total_cof;
        this.total = total;
        this.gera_cp = gera_cp;
        this.gera_es = gera_es;
        this.ajusta_pc = ajusta_pc;
        this.ajusta_pv = ajusta_pv;
        this.ehfiscal = ehfiscal;
        this.leuxml = leuxml;
        this.status = status;
        this.xml = xml;
        this.tipo = tipo;
        this.leu_duplicada = leu_duplicada;
        this.nome = nome;
        this.base_fcp = base_fcp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getDtentrada() {
        return dtentrada;
    }

    public void setDtentrada(String dtentrada) {
        this.dtentrada = dtentrada;
    }

    public String getDtemissao() {
        return dtemissao;
    }

    public void setDtemissao(String dtemissao) {
        this.dtemissao = dtemissao;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getNr_nota() {
        return nr_nota;
    }

    public void setNr_nota(String nr_nota) {
        this.nr_nota = nr_nota;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public Double getDespesas() {
        return despesas;
    }

    public void setDespesas(Double despesas) {
        this.despesas = despesas;
    }

    public Double getSeguro() {
        return seguro;
    }

    public void setSeguro(Double seguro) {
        this.seguro = seguro;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getBase_ipi() {
        return base_ipi;
    }

    public void setBase_ipi(Double base_ipi) {
        this.base_ipi = base_ipi;
    }

    public Double getTotal_ipi() {
        return total_ipi;
    }

    public void setTotal_ipi(Double total_ipi) {
        this.total_ipi = total_ipi;
    }

    public Double getBase_icm() {
        return base_icm;
    }

    public void setBase_icm(Double base_icm) {
        this.base_icm = base_icm;
    }

    public Double getTotal_icm() {
        return total_icm;
    }

    public void setTotal_icm(Double total_icm) {
        this.total_icm = total_icm;
    }

    public Double getBase_st() {
        return base_st;
    }

    public void setBase_st(Double base_st) {
        this.base_st = base_st;
    }

    public Double getTotal_st() {
        return total_st;
    }

    public void setTotal_st(Double total_st) {
        this.total_st = total_st;
    }

    public Double getBase_pis() {
        return base_pis;
    }

    public void setBase_pis(Double base_pis) {
        this.base_pis = base_pis;
    }

    public Double getTotal_pis() {
        return total_pis;
    }

    public void setTotal_pis(Double total_pis) {
        this.total_pis = total_pis;
    }

    public Double getBase_cof() {
        return base_cof;
    }

    public void setBase_cof(Double base_cof) {
        this.base_cof = base_cof;
    }

    public Double getTotal_cof() {
        return total_cof;
    }

    public void setTotal_cof(Double total_cof) {
        this.total_cof = total_cof;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getGera_cp() {
        return gera_cp;
    }

    public void setGera_cp(String gera_cp) {
        this.gera_cp = gera_cp;
    }

    public String getGera_es() {
        return gera_es;
    }

    public void setGera_es(String gera_es) {
        this.gera_es = gera_es;
    }

    public String getAjusta_pc() {
        return ajusta_pc;
    }

    public void setAjusta_pc(String ajusta_pc) {
        this.ajusta_pc = ajusta_pc;
    }

    public String getAjusta_pv() {
        return ajusta_pv;
    }

    public void setAjusta_pv(String ajusta_pv) {
        this.ajusta_pv = ajusta_pv;
    }

    public String getEhfiscal() {
        return ehfiscal;
    }

    public void setEhfiscal(String ehfiscal) {
        this.ehfiscal = ehfiscal;
    }

    public String getLeuxml() {
        return leuxml;
    }

    public void setLeuxml(String leuxml) {
        this.leuxml = leuxml;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLeu_duplicada() {
        return leu_duplicada;
    }

    public void setLeu_duplicada(String leu_duplicada) {
        this.leu_duplicada = leu_duplicada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getBase_fcp() {
        return base_fcp;
    }

    public void setBase_fcp(Double base_fcp) {
        this.base_fcp = base_fcp;
    }
}
