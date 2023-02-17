package com.example.apirest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Produtos implements Serializable {

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;
    @SerializedName(value = "tipo", alternate = "TIPO")
    @Expose
    private String tipo;
    @SerializedName(value = "codbarra", alternate = "CODBARRA")
    @Expose
    private String codbarra;
    @SerializedName(value = "referencia", alternate = "REFERENCIA")
    @Expose
    private String referencia;
    @SerializedName(value = "grupo", alternate = "GRUPO")
    @Expose
    private int grupo;
    @SerializedName(value = "unidade", alternate = "UNIDADE")
    @Expose
    private String unidade;
    @SerializedName(value = "ultforn", alternate = "ULTFORN")
    @Expose
    private int ultforn;
    @SerializedName(value = "localizacao", alternate = "LOCALIZACAO")
    @Expose
    private String localizacao;
    @SerializedName(value = "aliq_icm", alternate = "ALIQ_ICM")
    @Expose
    private Double aliq_icm;
    @SerializedName(value = "aliq_pis", alternate = "ALIQ_PIS")
    @Expose
    private Double aliq_pis;

    @SerializedName(value = "aliq_cof", alternate = "ALIQ_COF")
    @Expose
    private Double aliq_cof;
    @SerializedName(value = "pr_custo", alternate = "PR_CUSTO")
    @Expose
    private Double pr_custo;
    @SerializedName(value = "margem", alternate = "MARGEM")
    @Expose
    private Double margem;
    @SerializedName(value = "pr_venda", alternate = "PR_VENDA")
    @Expose
    private Double pr_venda;
    @SerializedName(value = "qtd_atual", alternate = "QTD_ATUAL")
    @Expose
    private Double qtd_atual;
    @SerializedName(value = "qtd_min", alternate = "QTD_MIN")
    @Expose
    private Double qtd_min;
    @SerializedName(value = "e_medio", alternate = "E_MEDIO")
    @Expose
    private Double e_medio;
    @SerializedName(value = "csticms", alternate = "CSTICMS")
    @Expose
        private String csticms;
    @SerializedName(value = "cste", alternate = "CSTE")
    @Expose
    private String cste;
    @SerializedName(value = "csts", alternate = "CSTS")
    @Expose
    private String csts;

    @SerializedName(value = "cstipi", alternate = "CSTIPI")
    @Expose
    private String cstipi;
    @SerializedName(value = "csosn", alternate = "CSOSN")
    @Expose
    private String csosn;
    @SerializedName(value = "ncm", alternate = "NCM")
    @Expose
    private String ncm;
    @SerializedName(value = "comissao", alternate = "COMISSAO")
    @Expose
    private Double comissao;
    @SerializedName(value = "desconto", alternate = "DESCONTO")
    @Expose
    private Double desconto;
    @SerializedName(value = "foto", alternate = "FOTO")
    @Expose
    private String foto;
    @SerializedName(value = "ativo", alternate = "ATIVO")
    @Expose
    private String ativo;
    @SerializedName(value = "cfop", alternate = "CFOP")
    @Expose
    private String cfop;
    @SerializedName(value = "pr_custo_anterior", alternate = "PR_CUSTO_ANTERIOR")
    @Expose
    private Double pr_custo_anterior;
    @SerializedName(value = "pr_venda_anterior", alternate = "PR_VENDA_ANTERIOR")
    @Expose
    private Double pr_venda_anterior;

    @SerializedName(value = "ult_compra", alternate = "ULT_COMPRA")
    @Expose
    private int ult_compra;
    @SerializedName(value = "ult_compra_anterior", alternate = "ULT_COMPRA_ANTERIOR")
    @Expose
    private int ult_compra_anterior;
    @SerializedName(value = "preco_atacado", alternate = "PRECO_ATACADO")
    @Expose
    private Double preco_atacado;
    @SerializedName(value = "qtd_atacado", alternate = "QTD_ATACADO")
    @Expose
    private Double qtd_atacado;
    @SerializedName(value = "cod_barra_atacado", alternate = "COD_BARRA_ATACADO")
    @Expose
    private String cod_barra_atacado;
    @SerializedName(value = "aliq_ipi", alternate = "ALIQ_IPI")
    @Expose
    private Double aliq_ipi;
    @SerializedName(value = "empresa", alternate = "EMPRESA")
    @Expose
    private int empresa;
    @SerializedName(value = "cest", alternate = "CEST")
    @Expose
    private String cest;
    @SerializedName(value = "id", alternate = "ID")
    @Expose
    private String id;
    @SerializedName(value = "grade", alternate = "GRADE")
    @Expose
    private String grade;

    @SerializedName(value = "efiscal", alternate = "EFISCAL")
    @Expose
    private String efiscal;
    @SerializedName(value = "paga_comissao", alternate = "PAGA_COMISSAO")
    @Expose
    private String paga_comissao;
    @SerializedName(value = "peso", alternate = "PESO")
    @Expose
    private Double peso;
    @SerializedName(value = "composicao", alternate = "COMPOSICAO")
    @Expose
    private String composicao;
    @SerializedName(value = "preco_promo_atacado", alternate = "PRECO_PROMO_ATACADO")
    @Expose
    private Double preco_promo_atacado;
    @SerializedName(value = "preco_promo_varejo", alternate = "PRECO_PROMO_VAREJO")
    @Expose
    private Double preco_promo_varejo;
    @SerializedName(value = "inicio_promocao", alternate = "INICIO_PROMOCAO")
    @Expose
    private String inicio_promocao;
    @SerializedName(value = "fim_promocao", alternate = "FIM_PROMOCAO")
    @Expose
    private String fim_promocao;
    @SerializedName(value = "estoque_inicial", alternate = "ESTOQUE_INICIAL")
    @Expose
    private Double estoque_inicial;
    @SerializedName(value = "pr_venda_prazo", alternate = "PR_VENDA_PRAZO")
    @Expose
    private Double pr_venda_prazo;

    @SerializedName(value = "preco_variavel", alternate = "PRECO_VARIAVEL")
    @Expose
    private String preco_variavel;
    @SerializedName(value = "aplicacao", alternate = "APLICACAO")
    @Expose
    private String aplicacao;
    @SerializedName(value = "reducao_base", alternate = "REDUCAO_BASE")
    @Expose
    private Double reducao_base;
    @SerializedName(value = "mva", alternate = "MVA")
    @Expose
    private Double mva;
    @SerializedName(value = "fcp", alternate = "FCP")
    @Expose
    private Double fcp;
    @SerializedName(value = "servico", alternate = "SERVICO")
    @Expose
    private String servico;
    @SerializedName(value = "produto_pesado", alternate = "PRODUTO_PESADO")
    @Expose
    private String produto_pesado;
    @SerializedName(value = "dt_cadastro", alternate = "DT_CADASTRO")
    @Expose
    private String dt_cadastro;
    @SerializedName(value = "descricao", alternate = "DESCRICAO")
    @Expose
    private String descricao;
    @SerializedName(value = "pr_custo2", alternate = "PR_CUSTO2")
    @Expose
    private Double pr_custo2;

    @SerializedName(value = "perc_custo", alternate = "PERC_CUSTO")
    @Expose
    private Double perc_custo;
    @SerializedName(value = "restaurante", alternate = "RESTAUTANTE")
    @Expose
    private String restaurante;
    @SerializedName(value = "tempo_espera", alternate = "TEMPO_ESPERA")
    @Expose
    private int tempo_espera;
    @SerializedName(value = "complemento", alternate = "COMPLEMENTO")
    @Expose
    private String complemento;
    @SerializedName(value = "fk_marca", alternate = "FK_MARCA")
    @Expose
    private int fk_marca;
    @SerializedName(value = "prefixo_balanca", alternate = "PREFIXO_BALANCA")
    @Expose
    private String prefixo_balanca;
    @SerializedName(value = "fk_principio_ativo", alternate = "FK_PRINCIPIO_ATIVO")
    @Expose
    private int fk_principio_ativo;
    @SerializedName(value = "remedio", alternate = "REMEDIO")
    @Expose
    private String remedio;
    @SerializedName(value = "tipo_restaurante", alternate = "TIPO_RESTAURANTE")
    @Expose
    private String tipo_restaurante;
    @SerializedName(value = "fk_tecido", alternate = "FK_TECIDO")
    @Expose
    private String fk_tecido;

    @SerializedName(value = "cfop_externo", alternate = "CFOP_EXTERNO")
    @Expose
    private int cfop_externo;
    @SerializedName(value = "etq", alternate = "ETQ")
    @Expose
    private String etq;
    @SerializedName(value = "csosn_externo", alternate = "CSOSN_EXTERNO")
    @Expose
    private String csosn_externo;
    @SerializedName(value = "cst_externo", alternate = "CST_EXTERNO")
    @Expose
    private String cst_externo;
    @SerializedName(value = "aliq_icms_externo", alternate = "ALIQ_ICMS_EXTERNO")
    @Expose
    private Double aliq_icms_externo;
    @SerializedName(value = "origem", alternate = "ORIGEM")
    @Expose
    private int origem;
    @SerializedName(value = "glp", alternate = "GLP")
    @Expose
    private Double glp;
    @SerializedName(value = "gnn", alternate = "GNN")
    @Expose
    private Double gnn;
    @SerializedName(value = "gni", alternate = "GNI")
    @Expose
    private Double gni;
    @SerializedName(value = "peso_liq", alternate = "PESO_LIQ")
    @Expose
    private Double peso_liq;

    @SerializedName(value = "anp", alternate = "ANP")
    @Expose
    private String anp;
    @SerializedName(value = "combustivel", alternate = "COMBUSTIVEL")
    @Expose
    private String combustivel;
    @SerializedName(value = "fk_lcp", alternate = "FK_LCP")
    @Expose
    private String fk_lcp;
    @SerializedName(value = "issqn", alternate = "ISSQN")
    @Expose
    private Double issqn;
    @SerializedName(value = "tipo_tributacao", alternate = "TIPO_TRIBUTACAO")
    @Expose
    private String tipo_tributacao;
    @SerializedName(value = "qtd_fiscal", alternate = "QTD_FISCAL")
    @Expose
    private Double qtd_fiscal;
    @SerializedName(value = "id_produto_similar", alternate = "ID_PRODUTO_SIMILAR")
    @Expose
    private int id_produto_similar;
    @SerializedName(value = "data_preco", alternate = "DATA_PRECO")
    @Expose
    private String data_preco;
    @SerializedName(value = "tributacao_monofasica", alternate = "TRIBUTACAO_MONOFASICA")
    @Expose
    private String tributacao_monofasica;
    @SerializedName(value = "id_menu", alternate = "ID_MENU")
    @Expose
    private int id_menu;

    @SerializedName(value = "valor_pequena", alternate = "VALOR_PEQUENA")
    @Expose
    private Double valor_pequena;
    @SerializedName(value = "valor_media", alternate = "VALOR_MEDIA")
    @Expose
    private Double valor_media ;
    @SerializedName(value = "valor_grande", alternate = "VALOR_GRANDE")
    @Expose
    private Double valor_grande;
    @SerializedName(value = "tipo_alimento", alternate = "TIPO_ALIMENTO")
    @Expose
    private String tipo_alimento;
    @SerializedName(value = "serial", alternate = "SERIAL")
    @Expose
    private String serial;
    @SerializedName(value = "mva_normal", alternate = "MVA_NORMAL")
    @Expose
    private Double mva_normal;
    @SerializedName(value = "imprime_ticket", alternate = "IMPRIME_TICKET")
    @Expose
    private String imprime_ticket;
    @SerializedName(value = "icms_diferido", alternate = "ICMS_DIFERIDO")
    @Expose
    private Double icms_diferido;
    @SerializedName(value = "qtd_sabores", alternate = "QTD_SABORES")
    @Expose
        private int qtd_sabores;
    @SerializedName(value = "cod_enq_ipi", alternate = "COD_ENQ_IPI")
    @Expose
    private String cod_enq_ipi;
    @SerializedName(value = "aliq_deson", alternate = "ALIQ_DESON")
    @Expose
    private Double aliq_deson;
    @SerializedName(value = "motivo_desoneracao", alternate = "MOTIVO_DESONERACAO")
    @Expose
    private int motivo_desoneracao;
    @SerializedName(value = "cod_beneficio", alternate = "COD_BENEFICIO")
    @Expose
    private String cod_beneficio;
    @SerializedName(value = "fabricado", alternate = "FABRICADO")
    @Expose
    private String fabricado;
    @SerializedName(value = "peso_l", alternate = "PESO_L")
    @Expose
    private Double peso_l;
    @SerializedName(value = "peso_b", alternate = "PESO_B")
    @Expose
    private Double peso_b;
    @SerializedName(value = "chatboot", alternate = "CHATBOOT")
    @Expose
    private String chatboot;

    public Produtos() {

    }

    public Produtos(int codigo, String tipo, String codbarra, String referencia, int grupo, String unidade, int ultforn, String localizacao, Double aliq_icm, Double aliq_pis, Double aliq_cof, Double pr_custo, Double margem, Double pr_venda, Double qtd_atual, Double qtd_min, Double e_medio, String csticms, String cste, String csts, String cstipi, String csosn, String ncm, Double comissao, Double desconto, String foto, String ativo, String cfop, Double pr_custo_anterior, Double pr_venda_anterior, int ult_compra, int ult_compra_anterior, Double preco_atacado, Double qtd_atacado, String cod_barra_atacado, Double aliq_ipi, int empresa, String cest, String id, String grade, String efiscal, String paga_comissao, Double peso, String composicao, Double preco_promo_atacado, Double preco_promo_varejo, String inicio_promocao, String fim_promocao, Double estoque_inicial, Double pr_venda_prazo, String preco_variavel, String aplicacao, Double reducao_base, Double mva, Double fcp, String servico, String produto_pesado, String dt_cadastro, String descricao, Double pr_custo2, Double perc_custo, String restaurante, int tempo_espera, String complemento, int fk_marca, String prefixo_balanca, int fk_principio_ativo, String remedio, String tipo_restaurante, String fk_tecido, int cfop_externo, String etq, String csosn_externo, String cst_externo, Double aliq_icms_externo, int origem, Double glp, Double gnn, Double gni, Double peso_liq, String anp, String combustivel, String fk_lcp, Double issqn, String tipo_tributacao, Double qtd_fiscal, int id_produto_similar, String data_preco, String tributacao_monofasica, int id_menu, Double valor_pequena, Double valor_media, Double valor_grande, String tipo_alimento, String serial, Double mva_normal, String imprime_ticket, Double icms_diferido, int qtd_sabores, String cod_enq_ipi, Double aliq_deson, int motivo_desoneracao, String cod_beneficio, String fabricado, Double peso_l, Double peso_b, String chatboot) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.codbarra = codbarra;
        this.referencia = referencia;
        this.grupo = grupo;
        this.unidade = unidade;
        this.ultforn = ultforn;
        this.localizacao = localizacao;
        this.aliq_icm = aliq_icm;
        this.aliq_pis = aliq_pis;
        this.aliq_cof = aliq_cof;
        this.pr_custo = pr_custo;
        this.margem = margem;
        this.pr_venda = pr_venda;
        this.qtd_atual = qtd_atual;
        this.qtd_min = qtd_min;
        this.e_medio = e_medio;
        this.csticms = csticms;
        this.cste = cste;
        this.csts = csts;
        this.cstipi = cstipi;
        this.csosn = csosn;
        this.ncm = ncm;
        this.comissao = comissao;
        this.desconto = desconto;
        this.foto = foto;
        this.ativo = ativo;
        this.cfop = cfop;
        this.pr_custo_anterior = pr_custo_anterior;
        this.pr_venda_anterior = pr_venda_anterior;
        this.ult_compra = ult_compra;
        this.ult_compra_anterior = ult_compra_anterior;
        this.preco_atacado = preco_atacado;
        this.qtd_atacado = qtd_atacado;
        this.cod_barra_atacado = cod_barra_atacado;
        this.aliq_ipi = aliq_ipi;
        this.empresa = empresa;
        this.cest = cest;
        this.id = id;
        this.grade = grade;
        this.efiscal = efiscal;
        this.paga_comissao = paga_comissao;
        this.peso = peso;
        this.composicao = composicao;
        this.preco_promo_atacado = preco_promo_atacado;
        this.preco_promo_varejo = preco_promo_varejo;
        this.inicio_promocao = inicio_promocao;
        this.fim_promocao = fim_promocao;
        this.estoque_inicial = estoque_inicial;
        this.pr_venda_prazo = pr_venda_prazo;
        this.preco_variavel = preco_variavel;
        this.aplicacao = aplicacao;
        this.reducao_base = reducao_base;
        this.mva = mva;
        this.fcp = fcp;
        this.servico = servico;
        this.produto_pesado = produto_pesado;
        this.dt_cadastro = dt_cadastro;
        this.descricao = descricao;
        this.pr_custo2 = pr_custo2;
        this.perc_custo = perc_custo;
        this.restaurante = restaurante;
        this.tempo_espera = tempo_espera;
        this.complemento = complemento;
        this.fk_marca = fk_marca;
        this.prefixo_balanca = prefixo_balanca;
        this.fk_principio_ativo = fk_principio_ativo;
        this.remedio = remedio;
        this.tipo_restaurante = tipo_restaurante;
        this.fk_tecido = fk_tecido;
        this.cfop_externo = cfop_externo;
        this.etq = etq;
        this.csosn_externo = csosn_externo;
        this.cst_externo = cst_externo;
        this.aliq_icms_externo = aliq_icms_externo;
        this.origem = origem;
        this.glp = glp;
        this.gnn = gnn;
        this.gni = gni;
        this.peso_liq = peso_liq;
        this.anp = anp;
        this.combustivel = combustivel;
        this.fk_lcp = fk_lcp;
        this.issqn = issqn;
        this.tipo_tributacao = tipo_tributacao;
        this.qtd_fiscal = qtd_fiscal;
        this.id_produto_similar = id_produto_similar;
        this.data_preco = data_preco;
        this.tributacao_monofasica = tributacao_monofasica;
        this.id_menu = id_menu;
        this.valor_pequena = valor_pequena;
        this.valor_media = valor_media;
        this.valor_grande = valor_grande;
        this.tipo_alimento = tipo_alimento;
        this.serial = serial;
        this.mva_normal = mva_normal;
        this.imprime_ticket = imprime_ticket;
        this.icms_diferido = icms_diferido;
        this.qtd_sabores = qtd_sabores;
        this.cod_enq_ipi = cod_enq_ipi;
        this.aliq_deson = aliq_deson;
        this.motivo_desoneracao = motivo_desoneracao;
        this.cod_beneficio = cod_beneficio;
        this.fabricado = fabricado;
        this.peso_l = peso_l;
        this.peso_b = peso_b;
        this.chatboot = chatboot;
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

    public String getCodbarra() {
        return codbarra;
    }

    public void setCodbarra(String codbarra) {
        this.codbarra = codbarra;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getUltforn() {
        return ultforn;
    }

    public void setUltforn(int ultforn) {
        this.ultforn = ultforn;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Double getAliq_icm() {
        return aliq_icm;
    }

    public void setAliq_icm(Double aliq_icm) {
        this.aliq_icm = aliq_icm;
    }

    public Double getAliq_pis() {
        return aliq_pis;
    }

    public void setAliq_pis(Double aliq_pis) {
        this.aliq_pis = aliq_pis;
    }

    public Double getAliq_cof() {
        return aliq_cof;
    }

    public void setAliq_cof(Double aliq_cof) {
        this.aliq_cof = aliq_cof;
    }

    public Double getPr_custo() {
        return pr_custo;
    }

    public void setPr_custo(Double pr_custo) {
        this.pr_custo = pr_custo;
    }

    public Double getMargem() {
        return margem;
    }

    public void setMargem(Double margem) {
        this.margem = margem;
    }

    public Double getPr_venda() {
        return pr_venda;
    }

    public void setPr_venda(Double pr_venda) {
        this.pr_venda = pr_venda;
    }

    public Double getQtd_atual() {
        return qtd_atual;
    }

    public void setQtd_atual(Double qtd_atual) {
        this.qtd_atual = qtd_atual;
    }

    public Double getQtd_min() {
        return qtd_min;
    }

    public void setQtd_min(Double qtd_min) {
        this.qtd_min = qtd_min;
    }

    public Double getE_medio() {
        return e_medio;
    }

    public void setE_medio(Double e_medio) {
        this.e_medio = e_medio;
    }

    public String getCsticms() {
        return csticms;
    }

    public void setCsticms(String csticms) {
        this.csticms = csticms;
    }

    public String getCste() {
        return cste;
    }

    public void setCste(String cste) {
        this.cste = cste;
    }

    public String getCsts() {
        return csts;
    }

    public void setCsts(String csts) {
        this.csts = csts;
    }

    public String getCstipi() {
        return cstipi;
    }

    public void setCstipi(String cstipi) {
        this.cstipi = cstipi;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public Double getPr_custo_anterior() {
        return pr_custo_anterior;
    }

    public void setPr_custo_anterior(Double pr_custo_anterior) {
        this.pr_custo_anterior = pr_custo_anterior;
    }

    public Double getPr_venda_anterior() {
        return pr_venda_anterior;
    }

    public void setPr_venda_anterior(Double pr_venda_anterior) {
        this.pr_venda_anterior = pr_venda_anterior;
    }

    public int getUlt_compra() {
        return ult_compra;
    }

    public void setUlt_compra(int ult_compra) {
        this.ult_compra = ult_compra;
    }

    public int getUlt_compra_anterior() {
        return ult_compra_anterior;
    }

    public void setUlt_compra_anterior(int ult_compra_anterior) {
        this.ult_compra_anterior = ult_compra_anterior;
    }

    public Double getPreco_atacado() {
        return preco_atacado;
    }

    public void setPreco_atacado(Double preco_atacado) {
        this.preco_atacado = preco_atacado;
    }

    public Double getQtd_atacado() {
        return qtd_atacado;
    }

    public void setQtd_atacado(Double qtd_atacado) {
        this.qtd_atacado = qtd_atacado;
    }

    public String getCod_barra_atacado() {
        return cod_barra_atacado;
    }

    public void setCod_barra_atacado(String cod_barra_atacado) {
        this.cod_barra_atacado = cod_barra_atacado;
    }

    public Double getAliq_ipi() {
        return aliq_ipi;
    }

    public void setAliq_ipi(Double aliq_ipi) {
        this.aliq_ipi = aliq_ipi;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEfiscal() {
        return efiscal;
    }

    public void setEfiscal(String efiscal) {
        this.efiscal = efiscal;
    }

    public String getPaga_comissao() {
        return paga_comissao;
    }

    public void setPaga_comissao(String paga_comissao) {
        this.paga_comissao = paga_comissao;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public Double getPreco_promo_atacado() {
        return preco_promo_atacado;
    }

    public void setPreco_promo_atacado(Double preco_promo_atacado) {
        this.preco_promo_atacado = preco_promo_atacado;
    }

    public Double getPreco_promo_varejo() {
        return preco_promo_varejo;
    }

    public void setPreco_promo_varejo(Double preco_promo_varejo) {
        this.preco_promo_varejo = preco_promo_varejo;
    }

    public String getInicio_promocao() {
        return inicio_promocao;
    }

    public void setInicio_promocao(String inicio_promocao) {
        this.inicio_promocao = inicio_promocao;
    }

    public String getFim_promocao() {
        return fim_promocao;
    }

    public void setFim_promocao(String fim_promocao) {
        this.fim_promocao = fim_promocao;
    }

    public Double getEstoque_inicial() {
        return estoque_inicial;
    }

    public void setEstoque_inicial(Double estoque_inicial) {
        this.estoque_inicial = estoque_inicial;
    }

    public Double getPr_venda_prazo() {
        return pr_venda_prazo;
    }

    public void setPr_venda_prazo(Double pr_venda_prazo) {
        this.pr_venda_prazo = pr_venda_prazo;
    }

    public String getPreco_variavel() {
        return preco_variavel;
    }

    public void setPreco_variavel(String preco_variavel) {
        this.preco_variavel = preco_variavel;
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        this.aplicacao = aplicacao;
    }

    public Double getReducao_base() {
        return reducao_base;
    }

    public void setReducao_base(Double reducao_base) {
        this.reducao_base = reducao_base;
    }

    public Double getMva() {
        return mva;
    }

    public void setMva(Double mva) {
        this.mva = mva;
    }

    public Double getFcp() {
        return fcp;
    }

    public void setFcp(Double fcp) {
        this.fcp = fcp;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getProduto_pesado() {
        return produto_pesado;
    }

    public void setProduto_pesado(String produto_pesado) {
        this.produto_pesado = produto_pesado;
    }

    public String getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(String dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPr_custo2() {
        return pr_custo2;
    }

    public void setPr_custo2(Double pr_custo2) {
        this.pr_custo2 = pr_custo2;
    }

    public Double getPerc_custo() {
        return perc_custo;
    }

    public void setPerc_custo(Double perc_custo) {
        this.perc_custo = perc_custo;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public int getTempo_espera() {
        return tempo_espera;
    }

    public void setTempo_espera(int tempo_espera) {
        this.tempo_espera = tempo_espera;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getFk_marca() {
        return fk_marca;
    }

    public void setFk_marca(int fk_marca) {
        this.fk_marca = fk_marca;
    }

    public String getPrefixo_balanca() {
        return prefixo_balanca;
    }

    public void setPrefixo_balanca(String prefixo_balanca) {
        this.prefixo_balanca = prefixo_balanca;
    }

    public int getFk_principio_ativo() {
        return fk_principio_ativo;
    }

    public void setFk_principio_ativo(int fk_principio_ativo) {
        this.fk_principio_ativo = fk_principio_ativo;
    }

    public String getRemedio() {
        return remedio;
    }

    public void setRemedio(String remedio) {
        this.remedio = remedio;
    }

    public String getTipo_restaurante() {
        return tipo_restaurante;
    }

    public void setTipo_restaurante(String tipo_restaurante) {
        this.tipo_restaurante = tipo_restaurante;
    }

    public String getFk_tecido() {
        return fk_tecido;
    }

    public void setFk_tecido(String fk_tecido) {
        this.fk_tecido = fk_tecido;
    }

    public int getCfop_externo() {
        return cfop_externo;
    }

    public void setCfop_externo(int cfop_externo) {
        this.cfop_externo = cfop_externo;
    }

    public String getEtq() {
        return etq;
    }

    public void setEtq(String etq) {
        this.etq = etq;
    }

    public String getCsosn_externo() {
        return csosn_externo;
    }

    public void setCsosn_externo(String csosn_externo) {
        this.csosn_externo = csosn_externo;
    }

    public String getCst_externo() {
        return cst_externo;
    }

    public void setCst_externo(String cst_externo) {
        this.cst_externo = cst_externo;
    }

    public Double getAliq_icms_externo() {
        return aliq_icms_externo;
    }

    public void setAliq_icms_externo(Double aliq_icms_externo) {
        this.aliq_icms_externo = aliq_icms_externo;
    }

    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public Double getGlp() {
        return glp;
    }

    public void setGlp(Double glp) {
        this.glp = glp;
    }

    public Double getGnn() {
        return gnn;
    }

    public void setGnn(Double gnn) {
        this.gnn = gnn;
    }

    public Double getGni() {
        return gni;
    }

    public void setGni(Double gni) {
        this.gni = gni;
    }

    public Double getPeso_liq() {
        return peso_liq;
    }

    public void setPeso_liq(Double peso_liq) {
        this.peso_liq = peso_liq;
    }

    public String getAnp() {
        return anp;
    }

    public void setAnp(String anp) {
        this.anp = anp;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getFk_lcp() {
        return fk_lcp;
    }

    public void setFk_lcp(String fk_lcp) {
        this.fk_lcp = fk_lcp;
    }

    public Double getIssqn() {
        return issqn;
    }

    public void setIssqn(Double issqn) {
        this.issqn = issqn;
    }

    public String getTipo_tributacao() {
        return tipo_tributacao;
    }

    public void setTipo_tributacao(String tipo_tributacao) {
        this.tipo_tributacao = tipo_tributacao;
    }

    public Double getQtd_fiscal() {
        return qtd_fiscal;
    }

    public void setQtd_fiscal(Double qtd_fiscal) {
        this.qtd_fiscal = qtd_fiscal;
    }

    public int getId_produto_similar() {
        return id_produto_similar;
    }

    public void setId_produto_similar(int id_produto_similar) {
        this.id_produto_similar = id_produto_similar;
    }

    public String getData_preco() {
        return data_preco;
    }

    public void setData_preco(String data_preco) {
        this.data_preco = data_preco;
    }

    public String getTributacao_monofasica() {
        return tributacao_monofasica;
    }

    public void setTributacao_monofasica(String tributacao_monofasica) {
        this.tributacao_monofasica = tributacao_monofasica;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public Double getValor_pequena() {
        return valor_pequena;
    }

    public void setValor_pequena(Double valor_pequena) {
        this.valor_pequena = valor_pequena;
    }

    public Double getValor_media() {
        return valor_media;
    }

    public void setValor_media(Double valor_media) {
        this.valor_media = valor_media;
    }

    public Double getValor_grande() {
        return valor_grande;
    }

    public void setValor_grande(Double valor_grande) {
        this.valor_grande = valor_grande;
    }

    public String getTipo_alimento() {
        return tipo_alimento;
    }

    public void setTipo_alimento(String tipo_alimento) {
        this.tipo_alimento = tipo_alimento;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Double getMva_normal() {
        return mva_normal;
    }

    public void setMva_normal(Double mva_normal) {
        this.mva_normal = mva_normal;
    }

    public String getImprime_ticket() {
        return imprime_ticket;
    }

    public void setImprime_ticket(String imprime_ticket) {
        this.imprime_ticket = imprime_ticket;
    }

    public Double getIcms_diferido() {
        return icms_diferido;
    }

    public void setIcms_diferido(Double icms_diferido) {
        this.icms_diferido = icms_diferido;
    }

    public int getQtd_sabores() {
        return qtd_sabores;
    }

    public void setQtd_sabores(int qtd_sabores) {
        this.qtd_sabores = qtd_sabores;
    }

    public String getCod_enq_ipi() {
        return cod_enq_ipi;
    }

    public void setCod_enq_ipi(String cod_enq_ipi) {
        this.cod_enq_ipi = cod_enq_ipi;
    }

    public Double getAliq_deson() {
        return aliq_deson;
    }

    public void setAliq_deson(Double aliq_deson) {
        this.aliq_deson = aliq_deson;
    }

    public int getMotivo_desoneracao() {
        return motivo_desoneracao;
    }

    public void setMotivo_desoneracao(int motivo_desoneracao) {
        this.motivo_desoneracao = motivo_desoneracao;
    }

    public String getCod_beneficio() {
        return cod_beneficio;
    }

    public void setCod_beneficio(String cod_beneficio) {
        this.cod_beneficio = cod_beneficio;
    }

    public String getFabricado() {
        return fabricado;
    }

    public void setFabricado(String fabricado) {
        this.fabricado = fabricado;
    }

    public Double getPeso_l() {
        return peso_l;
    }

    public void setPeso_l(Double peso_l) {
        this.peso_l = peso_l;
    }

    public Double getPeso_b() {
        return peso_b;
    }

    public void setPeso_b(Double peso_b) {
        this.peso_b = peso_b;
    }

    public String getChatboot() {
        return chatboot;
    }

    public void setChatboot(String chatboot) {
        this.chatboot = chatboot;
    }
}
