package com.example.apirest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Grupos implements Serializable {

    @SerializedName(value = "empresa", alternate = "EMPRESA")
    @Expose
    private int empresa;

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;

    @SerializedName(value = "descricao", alternate = "DESCRICAO")
    @Expose
    private String descricao;

    @SerializedName(value = "ativo", alternate = "ATIVO")
    @Expose
    private String ativo;

    private String data_emissao;

    public Grupos(){

    }

    public Grupos(int empresa, int codigo, String descricao, String ativo) {
        this.empresa = empresa;
        this.codigo = codigo;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public String getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
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

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
