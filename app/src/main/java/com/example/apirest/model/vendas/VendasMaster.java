package com.example.apirest.model.vendas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Comparator;

public class VendasMaster implements Serializable {

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;

    @SerializedName(value = "data_emissao", alternate = "DATA_EMISSAO")
    @Expose
    private String data_emissao;

    @SerializedName(value = "data_saida", alternate = "DATA_SAIDA")
    @Expose
    private String data_saida;

    @SerializedName(value = "id_cliente", alternate = "ID_CLIENTE")
    @Expose
    private int id_cliente;

    @SerializedName(value = "fk_usuario", alternate = "FK_USUARIO")
    @Expose
    private int fk_usuario;

    @SerializedName(value = "fk_caixa", alternate = "FK_CAIXA")
    @Expose
    private int fk_caixa;

    @SerializedName(value = "fk_vendedor", alternate = "FK_VENDEDOR")
    @Expose
    private int fk_vendedor;

    @SerializedName(value = "cpf_nota", alternate = "CPF_NOTA")
    @Expose
    private String cpf_nota;

    @SerializedName(value = "subtotal", alternate = "SUBTOTAL")
    @Expose
    private Double subtotal;

    @SerializedName(value = "tipo_desconto", alternate = "TIPO_DESCONTO")
    @Expose
    private String tipo_desconto;

    @SerializedName(value = "desconto", alternate = "DESCONTO")
    @Expose
    private Double desconto;

    @SerializedName(value = "troco", alternate = "TROCO")
    @Expose
    private Double troco;

    @SerializedName(value = "dinheiro", alternate = "DINHEIRO")
    @Expose
    private Double dinheiro;

    @SerializedName(value = "total", alternate = "TOTAL")
    @Expose
    private Double total;

    @SerializedName(value = "observacoes", alternate = "OBSERVACOES")
    @Expose
    private String observacoes;

    @SerializedName(value = "situacao", alternate = "SITUACAO")
    @Expose
    private String situacao;

    @SerializedName(value = "fkempresa", alternate = "FKEMPRESA")
    @Expose
    private int fkempresa;

    @SerializedName(value = "percentual", alternate = "PERCENTUAL")
    @Expose
    private Double percentual;

    @SerializedName(value = "tipo", alternate = "TIPO")
    @Expose
    private String tipo;

    @SerializedName(value = "necf", alternate = "NECF")
    @Expose
    private int necf;

    @SerializedName(value = "fkorcamento", alternate = "FKORCAMENTO")
    @Expose
    private int fkorcamento;

    @SerializedName(value = "lote", alternate = "LOTE")
    @Expose
    private int lote;

    @SerializedName(value = "gera_financeiro", alternate = "GERA_FINANCEIRO")
    @Expose
    private String gera_financeiro;

    @SerializedName(value = "percentual_acrescimo", alternate = "PERCENTUAL_ACRESCIMO")
    @Expose
    private Double percentual_acrescimo;

    @SerializedName(value = "acrescimo", alternate = "ACRESCIMO")
    @Expose
    private Double acrescimo;

    @SerializedName(value = "fk_tabela", alternate = "FK_TABELA")
    @Expose
    private int fk_tabela;

    @SerializedName(value = "pedido", alternate = "PEDIDO")
    @Expose
    private String pedido;

    @SerializedName(value = "os", alternate = "OS")
    @Expose
    private String os;

    @SerializedName(value = "fk_os", alternate = "FK_OS")
    @Expose
    private int fk_os;

    @SerializedName(value = "total_troca", alternate = "TOTAL_TROCA")
    @Expose
    private Double total_troca;

    @SerializedName(value = "forma_pagamento", alternate = "FORMA_PAGAMENTO")
    @Expose
    private String forma_pagamento;

    @SerializedName(value = "fk_entregador", alternate = "FK_ENTREGADOR")
    @Expose
    private int fk_entregador;

    @SerializedName(value = "flag_nfce", alternate = "FLAG_NFCE")
    @Expose
    private String flag_nfce;

    @SerializedName(value = "fk_mesa", alternate = "FK_MESA")
    @Expose
    private int fk_mesa;

    @SerializedName(value = "nome", alternate = "NOME")
    @Expose
    private String nome;

    @SerializedName(value = "tela", alternate = "TELA")
    @Expose
    private String tela;

    private String nomeEmpresa;


    public VendasMaster() {

    }

    public VendasMaster(int codigo, String data_emissao, String data_saida, int id_cliente, int fk_usuario, int fk_caixa, int fk_vendedor, String cpf_nota, Double subtotal, String tipo_desconto, Double desconto, Double troco, Double dinheiro, Double total, String observacoes, String situacao, int fkempresa, Double percentual, String tipo, int necf, int fkorcamento, int lote, String gera_financeiro, Double percentual_acrescimo, Double acrescimo, int fk_tabela, String pedido, String os, int fk_os, Double total_troca, String forma_pagamento, int fk_entregador, String flag_nfce, int fk_mesa, String nome, String tela) {
        this.codigo = codigo;
        this.data_emissao = data_emissao;
        this.data_saida = data_saida;
        this.id_cliente = id_cliente;
        this.fk_usuario = fk_usuario;
        this.fk_caixa = fk_caixa;
        this.fk_vendedor = fk_vendedor;
        this.cpf_nota = cpf_nota;
        this.subtotal = subtotal;
        this.tipo_desconto = tipo_desconto;
        this.desconto = desconto;
        this.troco = troco;
        this.dinheiro = dinheiro;
        this.total = total;
        this.observacoes = observacoes;
        this.situacao = situacao;
        this.fkempresa = fkempresa;
        this.percentual = percentual;
        this.tipo = tipo;
        this.necf = necf;
        this.fkorcamento = fkorcamento;
        this.lote = lote;
        this.gera_financeiro = gera_financeiro;
        this.percentual_acrescimo = percentual_acrescimo;
        this.acrescimo = acrescimo;
        this.fk_tabela = fk_tabela;
        this.pedido = pedido;
        this.os = os;
        this.fk_os = fk_os;
        this.total_troca = total_troca;
        this.forma_pagamento = forma_pagamento;
        this.fk_entregador = fk_entregador;
        this.flag_nfce = flag_nfce;
        this.fk_mesa = fk_mesa;
        this.nome = nome;
        this.tela = tela;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public String getData_saida() {
        return data_saida;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public int getFk_caixa() {
        return fk_caixa;
    }

    public void setFk_caixa(int fk_caixa) {
        this.fk_caixa = fk_caixa;
    }

    public int getFk_vendedor() {
        return fk_vendedor;
    }

    public void setFk_vendedor(int fk_vendedor) {
        this.fk_vendedor = fk_vendedor;
    }

    public String getCpf_nota() {
        return cpf_nota;
    }

    public void setCpf_nota(String cpf_nota) {
        this.cpf_nota = cpf_nota;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getTipo_desconto() {
        return tipo_desconto;
    }

    public void setTipo_desconto(String tipo_desconto) {
        this.tipo_desconto = tipo_desconto;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }

    public Double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNecf() {
        return necf;
    }

    public void setNecf(int necf) {
        this.necf = necf;
    }

    public int getFkorcamento() {
        return fkorcamento;
    }

    public void setFkorcamento(int fkorcamento) {
        this.fkorcamento = fkorcamento;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getGera_financeiro() {
        return gera_financeiro;
    }

    public void setGera_financeiro(String gera_financeiro) {
        this.gera_financeiro = gera_financeiro;
    }

    public Double getPercentual_acrescimo() {
        return percentual_acrescimo;
    }

    public void setPercentual_acrescimo(Double percentual_acrescimo) {
        this.percentual_acrescimo = percentual_acrescimo;
    }

    public Double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public int getFk_tabela() {
        return fk_tabela;
    }

    public void setFk_tabela(int fk_tabela) {
        this.fk_tabela = fk_tabela;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getFk_os() {
        return fk_os;
    }

    public void setFk_os(int fk_os) {
        this.fk_os = fk_os;
    }

    public Double getTotal_troca() {
        return total_troca;
    }

    public void setTotal_troca(Double total_troca) {
        this.total_troca = total_troca;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public int getFk_entregador() {
        return fk_entregador;
    }

    public void setFk_entregador(int fk_entregador) {
        this.fk_entregador = fk_entregador;
    }

    public String getFlag_nfce() {
        return flag_nfce;
    }

    public void setFlag_nfce(String flag_nfce) {
        this.flag_nfce = flag_nfce;
    }

    public int getFk_mesa() {
        return fk_mesa;
    }

    public void setFk_mesa(int fk_mesa) {
        this.fk_mesa = fk_mesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }
}
