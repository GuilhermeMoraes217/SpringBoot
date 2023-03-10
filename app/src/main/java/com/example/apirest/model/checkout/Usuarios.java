package com.example.apirest.model.checkout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Usuarios implements Serializable {
    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;
    @SerializedName(value = "senha", alternate = "SENHA")
    @Expose
    private String senha;
    @SerializedName(value = "hierarquia", alternate = "HIERARQUIA")
    @Expose
    private int hierarquia;
    @SerializedName(value = "ecaixa", alternate = "ECAIXA")
    @Expose
    private String ecaixa;
    @SerializedName(value = "supervisor", alternate = "SUPERVISOR")
    @Expose
    private String supervisor;
    @SerializedName(value = "ativo", alternate = "ATIVO")
    @Expose
    private String ativo;
    @SerializedName(value = "ultimo_pedido", alternate = "ULTIMO_PEDIDO")
    @Expose
    private String ultimo_pedido;
    @SerializedName(value = "ultima_venda", alternate = "ULTIMA_VENDA")
    @Expose
    private String  ultima_venda;
    @SerializedName(value = "senha_app", alternate = "SENHA_APP")
    @Expose
    private String senha_app;
    @SerializedName(value = "app_senha", alternate = "APP_SENHA")
    @Expose
    private String app_senha;
    @SerializedName(value = "fk_vendedor", alternate = "FK_VENDEDOR")
    @Expose
    private int fk_vendedor;
    @SerializedName(value = "flag", alternate = "FLAG")
    @Expose
    private String flag;
    @SerializedName(value = "login", alternate = "LOGIN")
    @Expose
    private String login;

    public Usuarios() {
    }

    public Usuarios(int codigo, String senha, int hierarquia, String ecaixa, String supervisor, String ativo, String ultimo_pedido, String ultima_venda, String senha_app, String app_senha, int fk_vendedor, String flag, String login) {
        this.codigo = codigo;
        this.senha = senha;
        this.hierarquia = hierarquia;
        this.ecaixa = ecaixa;
        this.supervisor = supervisor;
        this.ativo = ativo;
        this.ultimo_pedido = ultimo_pedido;
        this.ultima_venda = ultima_venda;
        this.senha_app = senha_app;
        this.app_senha = app_senha;
        this.fk_vendedor = fk_vendedor;
        this.flag = flag;
        this.login = login;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getHierarquia() {
        return hierarquia;
    }

    public void setHierarquia(int hierarquia) {
        this.hierarquia = hierarquia;
    }

    public String getEcaixa() {
        return ecaixa;
    }

    public void setEcaixa(String ecaixa) {
        this.ecaixa = ecaixa;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getUltimo_pedido() {
        return ultimo_pedido;
    }

    public void setUltimo_pedido(String ultimo_pedido) {
        this.ultimo_pedido = ultimo_pedido;
    }

    public String getUltima_venda() {
        return ultima_venda;
    }

    public void setUltima_venda(String ultima_venda) {
        this.ultima_venda = ultima_venda;
    }

    public String getSenha_app() {
        return senha_app;
    }

    public void setSenha_app(String senha_app) {
        this.senha_app = senha_app;
    }

    public String getApp_senha() {
        return app_senha;
    }

    public void setApp_senha(String app_senha) {
        this.app_senha = app_senha;
    }

    public int getFk_vendedor() {
        return fk_vendedor;
    }

    public void setFk_vendedor(int fk_vendedor) {
        this.fk_vendedor = fk_vendedor;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
