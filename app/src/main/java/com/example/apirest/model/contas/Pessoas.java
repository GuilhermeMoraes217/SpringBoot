package com.example.apirest.model.contas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pessoas {

    @SerializedName(value = "empresa", alternate = "EMPRESA")
    @Expose
    private int empresa;

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;

    @SerializedName(value = "tipo", alternate = "TIPO")
    @Expose
    private String tipo ;

    @SerializedName(value = "cnpj", alternate = "CNPJ")
    @Expose
    private String cnpj ;

    @SerializedName(value = "ie", alternate = "IE")
    @Expose
    private String ie ;

    @SerializedName(value = "fantasia", alternate = "FANTASIA")
    @Expose
    private String fantasia ;

    @SerializedName(value = "endereco", alternate = "ENDERECO")
    @Expose
    private String endereco ;

    @SerializedName(value = "numero", alternate = "NUMERO")
    @Expose
    private String numero ;

    @SerializedName(value = "complemento", alternate = "COMPLEMENTO")
    @Expose
    private String complemento ;

    @SerializedName(value = "codmun", alternate = "CODMUN")
    @Expose
    private int codmun ;

    @SerializedName(value = "municipio", alternate = "MUNICIPIO")
    @Expose
    private String municipio ;

    @SerializedName(value = "bairro", alternate = "BAIRRO")
    @Expose
    private String bairro ;

    @SerializedName(value = "uf", alternate = "UF")
    @Expose
    private String uf ;

    @SerializedName(value = "cep", alternate = "CEP")
    @Expose
    private String cep ;

    @SerializedName(value = "fone1", alternate = "FONE1")
    @Expose
    private String fone1 ;

    @SerializedName(value = "fone2", alternate = "FONE2")
    @Expose
    private String fone2 ;

    @SerializedName(value = "celular1", alternate = "CELULAR1")
    @Expose
    private String celular1 ;

    @SerializedName(value = "celular2", alternate = "CELULAR2")
    @Expose
    private String celular2 ;

    @SerializedName(value = "email1", alternate = "EMAIL1")
    @Expose
    private String email1 ;

    @SerializedName(value = "email2", alternate = "EMAIL2")
    @Expose
    private String email2 ;

    @SerializedName(value = "foto", alternate = "FOTO")
    @Expose
    private String foto ;

    @SerializedName(value = "sexo", alternate = "SEXO")
    @Expose
    private String sexo ;

    @SerializedName(value = "dt_nasc", alternate = "DT_NASC")
    @Expose
    private String dt_nasc ;

    @SerializedName(value = "ecivil", alternate = "ECIVIL")
    @Expose
    private String ecivil ;

    @SerializedName(value = "limite", alternate = "LIMITE")
    @Expose
    private Double limite ;

    @SerializedName(value = "dia_pgto", alternate = "DIA_PGTO")
    @Expose
    private int dia_pgto ;

    @SerializedName(value = "obs", alternate = "OBS")
    @Expose
    private String obs ;

    @SerializedName(value = "num_usu", alternate = "NUM_USU")
    @Expose
    private String num_usu ;

    @SerializedName(value = "fatura", alternate = "FATURA")
    @Expose
    private String fatura ;

    @SerializedName(value = "cheque", alternate = "CHEQUE")
    @Expose
    private String cheque ;

    @SerializedName(value = "ccf", alternate = "CCF")
    @Expose
    private String ccf ;

    @SerializedName(value = "spc", alternate = "SPC")
    @Expose
    private String spc ;

    @SerializedName(value = "isento", alternate = "ISENTO")
    @Expose
    private String isento ;

    @SerializedName(value = "forn", alternate = "FORN")
    @Expose
    private String forn ;

    @SerializedName(value = "fun", alternate = "FUN")
    @Expose
    private String fun ;

    @SerializedName(value = "cli", alternate = "CLI")
    @Expose
    private String cli ;

    @SerializedName(value = "fab", alternate = "FAB")
    @Expose
    private String fab ;

    @SerializedName(value = "tran", alternate = "TRAN")
    @Expose
    private String tran ;

    @SerializedName(value = "adm", alternate = "ADM")
    @Expose
    private String adm ;

    @SerializedName(value = "ativo", alternate = "ATIVO")
    @Expose
    private String ativo ;

    @SerializedName(value = "dt_admissao", alternate = "DT_ADMISSAO")
    @Expose
    private String dt_admissao ;

    @SerializedName(value = "dt_demissao", alternate = "DT_DEMISSAO")
    @Expose
    private String dt_demissao ;

    @SerializedName(value = "salario", alternate = "SALARIO")
    @Expose
    private Double salario ;

    @SerializedName(value = "pai", alternate = "PAI")
    @Expose
    private String pai ;

    @SerializedName(value = "mae", alternate = "MAE")
    @Expose
    private String mae ;

    @SerializedName(value = "banco", alternate = "BANCO")
    @Expose
    private String banco ;

    @SerializedName(value = "agencia", alternate = "AGENCIA")
    @Expose
    private String agencia ;

    @SerializedName(value = "gerente", alternate = "GERENTE")
    @Expose
    private String gerente ;

    @SerializedName(value = "fone_gerente", alternate = "FONE_GERENTE")
    @Expose
    private String fone_gerente ;

    @SerializedName(value = "propriedade", alternate = "PROPRIEDADE")
    @Expose
    private String propriedade ;

    @SerializedName(value = "dt_cadastro", alternate = "DT_CADASTRO")
    @Expose
    private String dt_cadastro ;

    @SerializedName(value = "tecnico", alternate = "TECNICO")
    @Expose
    private String tecnico ;

    @SerializedName(value = "atendente", alternate = "ATENDENTE")
    @Expose
    private String atendente ;

    @SerializedName(value = "codigo_web", alternate = "CODIGO_WEB")
    @Expose
    private int codigo_web ;

    @SerializedName(value = "referencia", alternate = "REFERENCIA")
    @Expose
    private int referencia ;

    @SerializedName(value = "flag", alternate = "FLAG")
    @Expose
    private String flag ;

    @SerializedName(value = "tipo_recebimento", alternate = "TIPO_RECEBIMENTO")
    @Expose
    private String tipo_recebimento ;

    @SerializedName(value = "parc", alternate = "PARC")
    @Expose
    private String parc ;

    @SerializedName(value = "regime_tributario", alternate = "REGIME_TRIBUTARIO")
    @Expose
    private String regime_tributario ;

    @SerializedName(value = "whatsapp", alternate = "WHATSAPP")
    @Expose
    private String whatsapp ;

    @SerializedName(value = "razao", alternate = "RAZAO")
    @Expose
    private String razao ;

    public Pessoas(){

    }

    public Pessoas(int empresa, int codigo, String tipo, String cnpj, String ie, String fantasia, String endereco, String numero, String complemento, int codmun, String municipio, String bairro, String uf, String cep, String fone1, String fone2, String celular1, String celular2, String email1, String email2, String foto, String sexo, String dt_nasc, String ecivil, Double limite, int dia_pgto, String obs, String num_usu, String fatura, String cheque, String ccf, String spc, String isento, String forn, String fun, String cli, String fab, String tran, String adm, String ativo, String dt_admissao, String dt_demissao, Double salario, String pai, String mae, String banco, String agencia, String gerente, String fone_gerente, String propriedade, String dt_cadastro, String tecnico, String atendente, int codigo_web, int referencia, String flag, String tipo_recebimento, String parc, String regime_tributario, String whatsapp, String razao) {
        this.empresa = empresa;
        this.codigo = codigo;
        this.tipo = tipo;
        this.cnpj = cnpj;
        this.ie = ie;
        this.fantasia = fantasia;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.codmun = codmun;
        this.municipio = municipio;
        this.bairro = bairro;
        this.uf = uf;
        this.cep = cep;
        this.fone1 = fone1;
        this.fone2 = fone2;
        this.celular1 = celular1;
        this.celular2 = celular2;
        this.email1 = email1;
        this.email2 = email2;
        this.foto = foto;
        this.sexo = sexo;
        this.dt_nasc = dt_nasc;
        this.ecivil = ecivil;
        this.limite = limite;
        this.dia_pgto = dia_pgto;
        this.obs = obs;
        this.num_usu = num_usu;
        this.fatura = fatura;
        this.cheque = cheque;
        this.ccf = ccf;
        this.spc = spc;
        this.isento = isento;
        this.forn = forn;
        this.fun = fun;
        this.cli = cli;
        this.fab = fab;
        this.tran = tran;
        this.adm = adm;
        this.ativo = ativo;
        this.dt_admissao = dt_admissao;
        this.dt_demissao = dt_demissao;
        this.salario = salario;
        this.pai = pai;
        this.mae = mae;
        this.banco = banco;
        this.agencia = agencia;
        this.gerente = gerente;
        this.fone_gerente = fone_gerente;
        this.propriedade = propriedade;
        this.dt_cadastro = dt_cadastro;
        this.tecnico = tecnico;
        this.atendente = atendente;
        this.codigo_web = codigo_web;
        this.referencia = referencia;
        this.flag = flag;
        this.tipo_recebimento = tipo_recebimento;
        this.parc = parc;
        this.regime_tributario = regime_tributario;
        this.whatsapp = whatsapp;
        this.razao = razao;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCodmun() {
        return codmun;
    }

    public void setCodmun(int codmun) {
        this.codmun = codmun;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFone1() {
        return fone1;
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }

    public String getCelular1() {
        return celular1;
    }

    public void setCelular1(String celular1) {
        this.celular1 = celular1;
    }

    public String getCelular2() {
        return celular2;
    }

    public void setCelular2(String celular2) {
        this.celular2 = celular2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(String dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public String getEcivil() {
        return ecivil;
    }

    public void setEcivil(String ecivil) {
        this.ecivil = ecivil;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public int getDia_pgto() {
        return dia_pgto;
    }

    public void setDia_pgto(int dia_pgto) {
        this.dia_pgto = dia_pgto;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getNum_usu() {
        return num_usu;
    }

    public void setNum_usu(String num_usu) {
        this.num_usu = num_usu;
    }

    public String getFatura() {
        return fatura;
    }

    public void setFatura(String fatura) {
        this.fatura = fatura;
    }

    public String getCheque() {
        return cheque;
    }

    public void setCheque(String cheque) {
        this.cheque = cheque;
    }

    public String getCcf() {
        return ccf;
    }

    public void setCcf(String ccf) {
        this.ccf = ccf;
    }

    public String getSpc() {
        return spc;
    }

    public void setSpc(String spc) {
        this.spc = spc;
    }

    public String getIsento() {
        return isento;
    }

    public void setIsento(String isento) {
        this.isento = isento;
    }

    public String getForn() {
        return forn;
    }

    public void setForn(String forn) {
        this.forn = forn;
    }

    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun;
    }

    public String getCli() {
        return cli;
    }

    public void setCli(String cli) {
        this.cli = cli;
    }

    public String getFab() {
        return fab;
    }

    public void setFab(String fab) {
        this.fab = fab;
    }

    public String getTran() {
        return tran;
    }

    public void setTran(String tran) {
        this.tran = tran;
    }

    public String getAdm() {
        return adm;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getDt_admissao() {
        return dt_admissao;
    }

    public void setDt_admissao(String dt_admissao) {
        this.dt_admissao = dt_admissao;
    }

    public String getDt_demissao() {
        return dt_demissao;
    }

    public void setDt_demissao(String dt_demissao) {
        this.dt_demissao = dt_demissao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getFone_gerente() {
        return fone_gerente;
    }

    public void setFone_gerente(String fone_gerente) {
        this.fone_gerente = fone_gerente;
    }

    public String getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(String propriedade) {
        this.propriedade = propriedade;
    }

    public String getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(String dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public int getCodigo_web() {
        return codigo_web;
    }

    public void setCodigo_web(int codigo_web) {
        this.codigo_web = codigo_web;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTipo_recebimento() {
        return tipo_recebimento;
    }

    public void setTipo_recebimento(String tipo_recebimento) {
        this.tipo_recebimento = tipo_recebimento;
    }

    public String getParc() {
        return parc;
    }

    public void setParc(String parc) {
        this.parc = parc;
    }

    public String getRegime_tributario() {
        return regime_tributario;
    }

    public void setRegime_tributario(String regime_tributario) {
        this.regime_tributario = regime_tributario;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }
}
