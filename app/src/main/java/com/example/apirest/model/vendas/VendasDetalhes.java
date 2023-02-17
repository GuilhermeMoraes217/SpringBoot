package com.example.apirest.model.vendas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VendasDetalhes implements Serializable {

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;

    @SerializedName(value = "fkvenda", alternate = "FKVENDA")
    @Expose
    private int fkvenda;

    @SerializedName(value = "id_produto", alternate = "ID_PRODUTO")
    @Expose
    private int id_produto;

    @SerializedName(value = "item", alternate = "ITEM")
    @Expose
    private int item;

    @SerializedName(value = "cod_barra", alternate = "COD_BARRA")
    @Expose
    private String cod_barra;

    @SerializedName(value = "qtd", alternate = "QTD")
    @Expose
    private Double qtd;

    @SerializedName(value = "e_medio", alternate = "E_MEDIO")
    @Expose
    private Double e_medio;

    @SerializedName(value = "preco", alternate = "PRECO")
    @Expose
    private Double preco;

    @SerializedName(value = "valor_item", alternate = "VALOR_ITEM")
    @Expose
    private Double valor_item;

    @SerializedName(value = "vdesconto", alternate = "VDESCONTO")
    @Expose
    private Double vdesconto;

    @SerializedName(value = "total", alternate = "TOTAL")
    @Expose
    private Double total;

    @SerializedName(value = "situacao", alternate = "SITUACAO")
    @Expose
    private String situacao;

    @SerializedName(value = "unidade", alternate = "UNIDADE")
    @Expose
    private String unidade;

    @SerializedName(value = "qtd_devolvida", alternate = "QTD_DEVOLVIDA")
    @Expose
    private Double qtd_devolvida;

    @SerializedName(value = "acrescimo", alternate = "ACRESCIMO")
    @Expose
    private Double acrescimo;

    @SerializedName(value = "os", alternate = "OS")
    @Expose
    private String os;

    @SerializedName(value = "fk_grande", alternate = "FK_GRADE")
    @Expose
    private int fk_grande;

    @SerializedName(value = "id_produto_similar", alternate = "ID_PRODUTO_SIMILAR")
    @Expose
    private int id_produto_similar;

    @SerializedName(value = "id_serial", alternate = "ID_SERIAL")
    @Expose
    private int id_serial;

    @SerializedName(value = "fk_mesa", alternate = "FK_MESA")
    @Expose
    private int fk_mesa;

    @SerializedName(value = "qtd_restante", alternate = "QTD_RESTANTE")
    @Expose
    private Double qtd_restante;

    @SerializedName(value = "observacao", alternate = "OBSERVACAO")
    @Expose
    private String observacao;

    private String nomeProduto;

    private String referenciaProduto;


    public VendasDetalhes() {

    }

    public VendasDetalhes(int codigo, int fkvenda, int id_produto, int item, String cod_barra, Double qtd, Double e_medio, Double preco, Double valor_item, Double vdesconto, Double total, String situacao, String unidade, Double qtd_devolvida, Double acrescimo, String os, int fk_grande, int id_produto_similar, int id_serial, int fk_mesa, Double qtd_restante, String observacao) {
        this.codigo = codigo;
        this.fkvenda = fkvenda;
        this.id_produto = id_produto;
        this.item = item;
        this.cod_barra = cod_barra;
        this.qtd = qtd;
        this.e_medio = e_medio;
        this.preco = preco;
        this.valor_item = valor_item;
        this.vdesconto = vdesconto;
        this.total = total;
        this.situacao = situacao;
        this.unidade = unidade;
        this.qtd_devolvida = qtd_devolvida;
        this.acrescimo = acrescimo;
        this.os = os;
        this.fk_grande = fk_grande;
        this.id_produto_similar = id_produto_similar;
        this.id_serial = id_serial;
        this.fk_mesa = fk_mesa;
        this.qtd_restante = qtd_restante;
        this.observacao = observacao;
    }

    public String getReferenciaProduto() {
        return referenciaProduto;
    }

    public void setReferenciaProduto(String referenciaProduto) {
        this.referenciaProduto = referenciaProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getFkvenda() {
        return fkvenda;
    }

    public void setFkvenda(int fkvenda) {
        this.fkvenda = fkvenda;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getCod_barra() {
        return cod_barra;
    }

    public void setCod_barra(String cod_barra) {
        this.cod_barra = cod_barra;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }

    public Double getE_medio() {
        return e_medio;
    }

    public void setE_medio(Double e_medio) {
        this.e_medio = e_medio;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getValor_item() {
        return valor_item;
    }

    public void setValor_item(Double valor_item) {
        this.valor_item = valor_item;
    }

    public Double getVdesconto() {
        return vdesconto;
    }

    public void setVdesconto(Double vdesconto) {
        this.vdesconto = vdesconto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getQtd_devolvida() {
        return qtd_devolvida;
    }

    public void setQtd_devolvida(Double qtd_devolvida) {
        this.qtd_devolvida = qtd_devolvida;
    }

    public Double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getFk_grande() {
        return fk_grande;
    }

    public void setFk_grande(int fk_grande) {
        this.fk_grande = fk_grande;
    }

    public int getId_produto_similar() {
        return id_produto_similar;
    }

    public void setId_produto_similar(int id_produto_similar) {
        this.id_produto_similar = id_produto_similar;
    }

    public int getId_serial() {
        return id_serial;
    }

    public void setId_serial(int id_serial) {
        this.id_serial = id_serial;
    }

    public int getFk_mesa() {
        return fk_mesa;
    }

    public void setFk_mesa(int fk_mesa) {
        this.fk_mesa = fk_mesa;
    }

    public Double getQtd_restante() {
        return qtd_restante;
    }

    public void setQtd_restante(Double qtd_restante) {
        this.qtd_restante = qtd_restante;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
