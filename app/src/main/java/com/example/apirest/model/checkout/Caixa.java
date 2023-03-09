package com.example.apirest.model.checkout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Caixa implements Serializable {
    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;
    @SerializedName(value = "emissao", alternate = "EMISSAO")
    @Expose
    private String emissao;
    @SerializedName(value = "doc", alternate = "DOC")
    @Expose
    private String doc;
    @SerializedName(value = "fkplano", alternate = "FKPLANO")
    @Expose
    private int fkplano;
    @SerializedName(value = "fkconta", alternate = "FKCONTA")
    @Expose
    private int fkconta;
    @SerializedName(value = "historico", alternate = "HISTORICO")
    @Expose
    private String historico;
    @SerializedName(value = "entrada", alternate = "ENTRADA")
    @Expose
    private Double entrada;
    @SerializedName(value = "saida", alternate = "SAIDA")
    @Expose
    private Double saida;
    @SerializedName(value = "saldo", alternate = "SALDO")
    @Expose
    private Double saldo;
    @SerializedName(value = "fkvenda", alternate = "FKVENDA")
    @Expose
    private int fkvenda;
    @SerializedName(value = "fkcompra", alternate = "FKCOMPRA")
    @Expose
    private int fkcompra;
    @SerializedName(value = "fkpagar", alternate = "FKPAGAR")
    @Expose
    private int fkpagar;
    @SerializedName(value = "fkreceber", alternate = "FKRECEBER")
    @Expose
    private int fkreceber;
    @SerializedName(value = "transferencia", alternate = "TRANSFERENCIA")
    @Expose
    private int transferencia;
    @SerializedName(value = "bloqueado", alternate = "BLOQUEADO")
    @Expose
    private String bloqueado;
    @SerializedName(value = "fk_conta1", alternate = "FK_CONTA1")
    @Expose
    private int fk_conta1;
    @SerializedName(value = "fk_pai", alternate = "FK_PAI")
    @Expose
    private int fk_pai;
    @SerializedName(value = "hora_emissao", alternate = "HORA_EMISSAO")
    @Expose
    private String hora_emissao;
    @SerializedName(value = "ecartao", alternate = "ECARTAO")
    @Expose
    private String ecartao;
    @SerializedName(value = "id_usuario", alternate = "ID_USUARIO")
    @Expose
    private int id_usuario;
    @SerializedName(value = "empresa", alternate = "EMPRESA")
    @Expose
    private int empresa;
    @SerializedName(value = "fk_ficha_cli", alternate = "FK_FICHA_CLI")
    @Expose
    private int fk_ficha_cli;
    @SerializedName(value = "visivel", alternate = "VISIVEL")
    @Expose
    private String  visivel;
    @SerializedName(value = "dt_cadastro", alternate = "DT_CADASTRO")
    @Expose
    private String  dt_cadastro;
    @SerializedName(value = "fk_devolucao", alternate = "FK_DEVOLUCAO")
    @Expose
    private int fk_devolucao;
    @SerializedName(value = "fk_cartao", alternate = "FK_CARTAO")
    @Expose
    private int fk_cartao;
    @SerializedName(value = "tipo_movimento", alternate = "TIPO_MOVIMENTO")
    @Expose
    private String  tipo_movimento;
    @SerializedName(value = "id_subcaixa", alternate = "ID_SUBCAIXA")
    @Expose
    private int id_subcaixa;
    @SerializedName(value = "fk_os", alternate = "FK_OS")
    @Expose
    private int fk_os;
    @SerializedName(value = "fpg", alternate = "FPG")
    @Expose
    private int fpg;
    @SerializedName(value = "resumo_caixa", alternate = "RESUMO_CAIXA")
    @Expose
    private String resumo_caixa;
    @SerializedName(value = "fk_nfe", alternate = "FK_NFE")
    @Expose
    private int fk_nfe;

    public Caixa() {

    }

    public Caixa(int codigo, String emissao, String doc, int fkplano, int fkconta, String historico, Double entrada, Double saida, Double saldo, int fkvenda, int fkcompra, int fkpagar, int fkreceber, int transferencia, String bloqueado, int fk_conta1, int fk_pai, String hora_emissao, String ecartao, int id_usuario, int empresa, int fk_ficha_cli, String visivel, String dt_cadastro, int fk_devolucao, int fk_cartao, String tipo_movimento, int id_subcaixa, int fk_os, int fpg, String resumo_caixa, int fk_nfe) {
        this.codigo = codigo;
        this.emissao = emissao;
        this.doc = doc;
        this.fkplano = fkplano;
        this.fkconta = fkconta;
        this.historico = historico;
        this.entrada = entrada;
        this.saida = saida;
        this.saldo = saldo;
        this.fkvenda = fkvenda;
        this.fkcompra = fkcompra;
        this.fkpagar = fkpagar;
        this.fkreceber = fkreceber;
        this.transferencia = transferencia;
        this.bloqueado = bloqueado;
        this.fk_conta1 = fk_conta1;
        this.fk_pai = fk_pai;
        this.hora_emissao = hora_emissao;
        this.ecartao = ecartao;
        this.id_usuario = id_usuario;
        this.empresa = empresa;
        this.fk_ficha_cli = fk_ficha_cli;
        this.visivel = visivel;
        this.dt_cadastro = dt_cadastro;
        this.fk_devolucao = fk_devolucao;
        this.fk_cartao = fk_cartao;
        this.tipo_movimento = tipo_movimento;
        this.id_subcaixa = id_subcaixa;
        this.fk_os = fk_os;
        this.fpg = fpg;
        this.resumo_caixa = resumo_caixa;
        this.fk_nfe = fk_nfe;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmissao() {
        return emissao;
    }

    public void setEmissao(String emissao) {
        this.emissao = emissao;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public int getFkplano() {
        return fkplano;
    }

    public void setFkplano(int fkplano) {
        this.fkplano = fkplano;
    }

    public int getFkconta() {
        return fkconta;
    }

    public void setFkconta(int fkconta) {
        this.fkconta = fkconta;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getFkvenda() {
        return fkvenda;
    }

    public void setFkvenda(int fkvenda) {
        this.fkvenda = fkvenda;
    }

    public int getFkcompra() {
        return fkcompra;
    }

    public void setFkcompra(int fkcompra) {
        this.fkcompra = fkcompra;
    }

    public int getFkpagar() {
        return fkpagar;
    }

    public void setFkpagar(int fkpagar) {
        this.fkpagar = fkpagar;
    }

    public int getFkreceber() {
        return fkreceber;
    }

    public void setFkreceber(int fkreceber) {
        this.fkreceber = fkreceber;
    }

    public int getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(int transferencia) {
        this.transferencia = transferencia;
    }

    public String getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(String bloqueado) {
        this.bloqueado = bloqueado;
    }

    public int getFk_conta1() {
        return fk_conta1;
    }

    public void setFk_conta1(int fk_conta1) {
        this.fk_conta1 = fk_conta1;
    }

    public int getFk_pai() {
        return fk_pai;
    }

    public void setFk_pai(int fk_pai) {
        this.fk_pai = fk_pai;
    }

    public String getHora_emissao() {
        return hora_emissao;
    }

    public void setHora_emissao(String hora_emissao) {
        this.hora_emissao = hora_emissao;
    }

    public String getEcartao() {
        return ecartao;
    }

    public void setEcartao(String ecartao) {
        this.ecartao = ecartao;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getFk_ficha_cli() {
        return fk_ficha_cli;
    }

    public void setFk_ficha_cli(int fk_ficha_cli) {
        this.fk_ficha_cli = fk_ficha_cli;
    }

    public String getVisivel() {
        return visivel;
    }

    public void setVisivel(String visivel) {
        this.visivel = visivel;
    }

    public String getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(String dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public int getFk_devolucao() {
        return fk_devolucao;
    }

    public void setFk_devolucao(int fk_devolucao) {
        this.fk_devolucao = fk_devolucao;
    }

    public int getFk_cartao() {
        return fk_cartao;
    }

    public void setFk_cartao(int fk_cartao) {
        this.fk_cartao = fk_cartao;
    }

    public String getTipo_movimento() {
        return tipo_movimento;
    }

    public void setTipo_movimento(String tipo_movimento) {
        this.tipo_movimento = tipo_movimento;
    }

    public int getId_subcaixa() {
        return id_subcaixa;
    }

    public void setId_subcaixa(int id_subcaixa) {
        this.id_subcaixa = id_subcaixa;
    }

    public int getFk_os() {
        return fk_os;
    }

    public void setFk_os(int fk_os) {
        this.fk_os = fk_os;
    }

    public int getFpg() {
        return fpg;
    }

    public void setFpg(int fpg) {
        this.fpg = fpg;
    }

    public String getResumo_caixa() {
        return resumo_caixa;
    }

    public void setResumo_caixa(String resumo_caixa) {
        this.resumo_caixa = resumo_caixa;
    }

    public int getFk_nfe() {
        return fk_nfe;
    }

    public void setFk_nfe(int fk_nfe) {
        this.fk_nfe = fk_nfe;
    }
}
