package com.example.apirest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Empresas implements Serializable {

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;

    @SerializedName(value = "fantasia", alternate = "FANTASIA")
    @Expose
    private String fantasia;

    @SerializedName(value = "razao", alternate = "RAZAO")
    @Expose
    private String razao;

    @SerializedName(value = "tipo", alternate = "TIPO")
    @Expose
    private String tipo;

    @SerializedName(value = "cnpj", alternate = "CNPJ")
    @Expose
    private String cnpj;

    @SerializedName(value = "ie", alternate = "IE")
    @Expose
    private String ie;

    @SerializedName(value = "im", alternate = "IM")
    @Expose
    private String im;

    @SerializedName(value = "endereco", alternate = "ENDERECO")
    @Expose
    private String endereco;

    @SerializedName(value = "numero", alternate = "NUMERO")
    @Expose
    private String numero;

    @SerializedName(value = "complemento", alternate = "COMPLEMENTO")
    @Expose
    private String complemento;

    @SerializedName(value = "bairro", alternate = "BAIRRO")
    @Expose
    private String bairro;

    @SerializedName(value = "cidade", alternate = "CIDADE")
    @Expose
    private String cidade;

    @SerializedName(value = "uf", alternate = "UF")
    @Expose
    private String uf;

    @SerializedName(value = "cep", alternate = "CEP")
    @Expose
    private String cep;

    @SerializedName(value = "fone", alternate = "FONE")
    @Expose
    private String fone;

    @SerializedName(value = "fax", alternate = "FAX")
    @Expose
    private String fax;

    @SerializedName(value = "site", alternate = "SITE")
    @Expose
    private String site;

    @SerializedName(value = "logomarca", alternate = "LOGOMARCA")
    @Expose
    private String logomarca;

    @SerializedName(value = "fundacao", alternate = "FUNDACAO")
    @Expose
    private String fundacao;

    @SerializedName(value = "usa_cad", alternate = "USU_CAD")
    @Expose
    private int usa_cad;

    @SerializedName(value = "usa_atu", alternate = "USU_ATU")
    @Expose
    private int usa_atu;

    @SerializedName(value = "nserie", alternate = "NSERIE")
    @Expose
    private String nserie;

    @SerializedName(value = "csenha", alternate = "CSENHA")
    @Expose
    private String csenha;

    @SerializedName(value = "nterm", alternate = "NTERM")
    @Expose
    private String nterm;

    @SerializedName(value = "id_plano_transferencia_c", alternate = "ID_PLANO_TRANSFERENCIA_C")
    @Expose
    private int id_plano_transferencia_c;

    @SerializedName(value = "id_plano_transferencia", alternate = "ID_PLANO_TRANSFERENCIA_D")
    @Expose
    private int id_plano_transferencia;

    @SerializedName(value = "id_caixa_geral", alternate = "ID_CAIXA_GERAL")
    @Expose
    private int id_caixa_geral;

    @SerializedName(value = "bloquear_estoque_negativo", alternate = "BLOQUEAR_ESTOQUE_NEGATIVO")
    @Expose
    private String bloquear_estoque_negativo;

    @SerializedName(value = "id_cidade", alternate = "ID_CIDADE")
    @Expose
    private int id_cidade;

    @SerializedName(value = "crt", alternate = "CRT")
    @Expose
    private int crt;

    @SerializedName(value = "id_uf", alternate = "ID_UF")
    @Expose
    private int id_uf;

    @SerializedName(value = "id_plano_venda", alternate = "ID_PLANO_VENDA")
    @Expose
    private int id_plano_venda;

    @SerializedName(value = "obsfisco", alternate = "OBSFISCO")
    @Expose
    private String obsfisco;

    @SerializedName(value = "cfop", alternate = "CFOP")
    @Expose
    private String cfop;

    @SerializedName(value = "csosn", alternate = "CSOSN")
    @Expose
    private String csosn;

    @SerializedName(value = "cst_icms", alternate = "CST_ICMS")
    @Expose
    private String cst_icms;

    @SerializedName(value = "aliq_icms", alternate = "ALIQ_ICMS")
    @Expose
    private Double aliq_icms;

    @SerializedName(value = "cst_entrada", alternate = "CST_ENTRADA")
    @Expose
    private String cst_entrada;

    @SerializedName(value = "cst_saida", alternate = "CST_SAIDA")
    @Expose
    private String cst_saida;

    @SerializedName(value = "aliq_pis", alternate = "ALIQ_PIS")
    @Expose
    private Double aliq_pis;

    @SerializedName(value = "aliq_cof", alternate = "ALIQ_COF")
    @Expose
    private Double aliq_cof;

    @SerializedName(value = "cst_ipi", alternate = "CST_IPI")
    @Expose
    private String cst_ipi;

    @SerializedName(value = "aliq_ipi", alternate = "ALIQ_IPI")
    @Expose
    private Double aliq_ipi;

    @SerializedName(value = "imp_f5", alternate = "IMP_F5")
    @Expose
    private String imp_f5;

    @SerializedName(value = "imp_f6", alternate = "IMP_F6")
    @Expose
    private String imp_f6;

    @SerializedName(value = "mostra_resumo_caixa", alternate = "MOSTRA_RESUMO_CAIXA")
    @Expose
    private String mostra_resumo_caixa;

    @SerializedName(value = "limite_diario", alternate = "LIMITE_DIARIO")
    @Expose
    private Double limite_diario;

    @SerializedName(value = "prazo_maximo", alternate = "PRAZO_MAXIMO")
    @Expose
    private int prazo_maximo;

    @SerializedName(value = "id_pla_conta_ficha_cli", alternate = "ID_PLA_CONTA_FICHA_CLI")
    @Expose
    private int id_pla_conta_ficha_cli;

    @SerializedName(value = "id_plano_conta_retirada", alternate = "ID_PLANO_CONTA_RETIRADA")
    @Expose
    private int id_plano_conta_retirada;

    @SerializedName(value = "usa_pdv", alternate = "USA_PDV")
    @Expose
    private String usa_pdv;

    @SerializedName(value = "recibo_vias", alternate = "RECIBO_VIAS")
    @Expose
    private String recibo_vias;

    @SerializedName(value = "id_plano_taxa_cartao", alternate = "ID_PLANO_TAXA_CARTAO")
    @Expose
    private int id_plano_taxa_cartao;

    @SerializedName(value = "obs_carne", alternate = "OBS_CARNE")
    @Expose
    private String obs_carne;

    @SerializedName(value = "caixa_unico", alternate = "CAIXA_UNICO")
    @Expose
    private String caixa_unico;

    @SerializedName(value = "caixa_rapido", alternate = "CAIXA_RAPIDO")
    @Expose
    private String caixa_rapido;

    @SerializedName(value = "id_plano_conta_devolucao", alternate = "ID_PLANO_CONTA_DEVOLUCAO")
    @Expose
    private int id_plano_conta_devolucao;

    @SerializedName(value = "n_inicial_nfce", alternate = "N_INICIAL_NFCE")
    @Expose
    private int n_inicial_nfce;

    @SerializedName(value = "n_inicial_nfe", alternate = "N_INICIAL_NFE")
    @Expose
    private int n_inicial_nfe;

    @SerializedName(value = "empresa_padrao", alternate = "EMPRESA_PADRAO")
    @Expose
    private int empresa_padrao;

    @SerializedName(value = "checa_estoque_fiscal", alternate = "CHECA_ESTOQUE_FISCAL")
    @Expose
    private String checa_estoque_fiscal;

    @SerializedName(value = "desconto_prod_promo", alternate = "DESCONTO_PROD_PROMO")
    @Expose
    private String desconto_prod_promo;

    @SerializedName(value = "data_cadastro", alternate = "DATA_CADASTRO")
    @Expose
    private String data_cadastro;

    @SerializedName(value = "data_validade", alternate = "DATA_VALIDADE")
    @Expose
    private String data_validade;

    @SerializedName(value = "flag", alternate = "FLAG")
    @Expose
    private String flag;

    @SerializedName(value = "lancar_cartao_credito", alternate = "LANCAR_CARTAO_CREDITO")
    @Expose
    private String lancar_cartao_credito;

    @SerializedName(value = "filtrar_empresa_login", alternate = "FILTRAR_EMPRESA_LOGIN")
    @Expose
    private String filtrar_empresa_login;

    @SerializedName(value = "enviar_email_nfe", alternate = "ENVIAR_EMAIL_NFE")
    @Expose
    private String enviar_email_nfe;

    @SerializedName(value = "transportadora", alternate = "TRANSPORTADORA")
    @Expose
    private String transportadora;

    @SerializedName(value = "tabela_preco", alternate = "TABELA_PRECO")
    @Expose
    private String tabela_preco;

    @SerializedName(value = "taxa_venda_prazo", alternate = "TAXA_VENDA_PRAZO")
    @Expose
    private Double taxa_venda_prazo;

    @SerializedName(value = "email_contador", alternate = "EMAIL_CONTADOR")
    @Expose
    private String email_contador;

    @SerializedName(value = "autopecas", alternate = "AUTOPECAS")
    @Expose
    private String autopecas;

    @SerializedName(value = "atualizar_pr_venda", alternate = "ATUALIZA_PR_VENDA")
    @Expose
    private String atualizar_pr_venda;

    @SerializedName(value = "informar_gtin", alternate = "INFORMAR_GTIN")
    @Expose
    private String informar_gtin;

    @SerializedName(value = "recolhe_fcp", alternate = "RECOLHE_FCP")
    @Expose
    private String recolhe_fcp;

    @SerializedName(value = "difal_origem", alternate = "DIFAL_ORIGEM")
    @Expose
    private Double difal_origem;

    @SerializedName(value = "difal_destino", alternate = "DIFAL_DESTINO")
    @Expose
    private Double difal_destino;

    @SerializedName(value = "exclui_pdv", alternate = "EXCLUI_PDV")
    @Expose
    private String exclui_pdv;

    @SerializedName(value = "venda_semente", alternate = "VENDA_SEMENTE")
    @Expose
    private String venda_semente;

    @SerializedName(value = "checa", alternate = "CHECA")
    @Expose
    private String checa;

    @SerializedName(value = "email", alternate = "EMAIL")
    @Expose
    private String email;

    @SerializedName(value = "ultimonsu", alternate = "ULTIMONSU")
    @Expose
    private String ultimonsu;

    @SerializedName(value = "ultimo_pedido", alternate = "ULTIMO_PEDIDO")
    @Expose
    private int ultimo_pedido;

    @SerializedName(value = "tipo_contrato", alternate = "TIPO_CONTRATO")
    @Expose
    private int tipo_contrato;

    @SerializedName(value = "tipo_empresa", alternate = "TIPO_EMPRESA")
    @Expose
    private int tipo_empresa;

    @SerializedName(value = "qtd_mesas", alternate = "QTD_MESAS")
    @Expose
    private int qtd_mesas;

    @SerializedName(value = "bloquear_preco", alternate = "BLOQUEAR_PRECO")
    @Expose
    private String bloquear_preco;

    @SerializedName(value = "exibe_resumo_caixa", alternate = "EXIBE_RESUMO_CAIXA")
    @Expose
    private String exibe_resumo_caixa;

    @SerializedName(value = "id_plano_compra", alternate = "ID_PLANO_COMPRA")
    @Expose
    private int id_plano_compra;

    @SerializedName(value = "responsavel_tecnico", alternate = "RESPONSAVEL_TECNICO")
    @Expose
    private String responsavel_tecnico;

    @SerializedName(value = "carencia_juros", alternate = "CARENCIA_JUROS")
    @Expose
    private int carencia_juros;

    @SerializedName(value = "pesquisa_referencia", alternate = "PESQUISA_REFERENCIA")
    @Expose
    private String pesquisa_referencia;

    @SerializedName(value = "restaurante", alternate = "RESTAURANTE")
    @Expose
    private String restaurante;

    @SerializedName(value = "exibe_f3", alternate = "EXIBE_F3")
    @Expose
    private String exibe_f3;

    @SerializedName(value = "exibe_f4", alternate = "EXIBE_F4")
    @Expose
    private String exibe_f4;

    @SerializedName(value = "ler_peso", alternate = "LER_PESO")
    @Expose
    private String ler_peso;

    @SerializedName(value = "desconto_maximo", alternate = "DESCONTO_MAXIMO")
    @Expose
    private Double desconto_maximo;

    @SerializedName(value = "chega_limite", alternate = "CHECA_LIMITE")
    @Expose
    private String chega_limite;

    @SerializedName(value = "emite_ecf", alternate = "EMITE_ECF")
    @Expose
    private String emite_ecf;

    @SerializedName(value = "loja_roupa", alternate = "LOJA_ROUPA")
    @Expose
    private String loja_roupa   ;

    @SerializedName(value = "tipo_juros", alternate = "TIPO_JUROS")
    @Expose
    private String tipo_juros;

    @SerializedName(value = "juros_dia", alternate = "JUROS_DIA")
    @Expose
    private Double juros_dia;

    @SerializedName(value = "juros_mes", alternate = "JUROS_MES")
    @Expose
    private Double juros_mes;

    @SerializedName(value = "farmacia", alternate = "FARMACIA")
    @Expose
    private String farmacia;

    @SerializedName(value = "pagamento_dinheiro", alternate = "PAGAMENTO_DINHEIRO")
    @Expose
    private String pagamento_dinheiro;

    @SerializedName(value = "responsavale_empresa", alternate = "RESPONSAVEL_EMPRESA")
    @Expose
    private String responsavale_empresa;

    @SerializedName(value = "habilita_desconto_pdv", alternate = "HABILITA_DESCONTO_PDV")
    @Expose
    private String habilita_desconto_pdv;

    @SerializedName(value = "puxa_cfop_produto", alternate = "PUXA_CFOP_PRODUTO")
    @Expose
    private String puxa_cfop_produto;

    @SerializedName(value = "lancar_cartao_cr", alternate = "LANCAR_CARTAO_CR")
    @Expose
    private String lancar_cartao_cr;

    @SerializedName(value = "usa_bluetooh_resta", alternate = "USA_BLUETOOTH_RESTA")
    @Expose
    private String usa_bluetooh_resta;

    @SerializedName(value = "cfop_externo", alternate = "CFOP_EXTERNO")
    @Expose
    private String cfop_externo;

    @SerializedName(value = "cnae", alternate = "CNAE")
    @Expose
    private String cnae;

    @SerializedName(value = "codigo_pais", alternate = "CODIGO_PAIS")
    @Expose
    private int codigo_pais;

    @SerializedName(value = "obsnfce", alternate = "OBSNFCE")
    @Expose
    private String obsnfce;

    @SerializedName(value = "csosn_externo", alternate = "CSOSN_EXTERNO")
    @Expose
    private String csosn_externo;

    @SerializedName(value = "aliq_icms_externo", alternate = "ALIQ_ICMS_EXTERNO")
    @Expose
    private Double aliq_icms_externo;

    @SerializedName(value = "cod_fpg_dinheiro", alternate = "COD_FPG_DINHEIRO")
    @Expose
    private int cod_fpg_dinheiro;

    @SerializedName(value = "habilitada_acrescimo", alternate = "HABILITA_ACRESCIMO")
    @Expose
    private String habilitada_acrescimo;

    @SerializedName(value = "multi_idioma", alternate = "MULTI_IDIOMA")
    @Expose
    private String multi_idioma;

    @SerializedName(value = "replicar_dados", alternate = "REPLICAR_DADOS")
    @Expose
    private String replicar_dados;

    @SerializedName(value = "id_plano_boleto", alternate = "ID_PLANO_BOLETO")
    @Expose
    private int id_plano_boleto;

    @SerializedName(value = "segunda_via_nfce", alternate = "SEGUNDA_VIA_NFCE")
    @Expose
    private String segunda_via_nfce;

    @SerializedName(value = "exibe_estoque_fiscal", alternate = "EXIBE_ESTOQUE_FISCAL")
    @Expose
    private String exibe_estoque_fiscal;

    @SerializedName(value = "nfce_produto_substituto", alternate = "NFCE_PRODUTO_SUBSTITUTO")
    @Expose
    private String nfce_produto_substituto;

    @SerializedName(value = "auto_cadastro_produto", alternate = "AUTO_CADASTRO_PRODUTO")
    @Expose
    private String auto_cadastro_produto;

    @SerializedName(value = "cfop_entrata_padrao", alternate = "CFOP_ENTRADA_PADRAO")
    @Expose
    private String cfop_entrata_padrao;

    @SerializedName(value = "cfop_entrada_padrao_e", alternate = "CFOP_ENTRADA_PADRO_E")
    @Expose
    private String cfop_entrada_padrao_e;

    @SerializedName(value = "puxar_cfop_entrada", alternate = "PUXAR_CFOP_ENTRADA")
    @Expose
    private String puxar_cfop_entrada;

    @SerializedName(value = "lucro_patrao", alternate = "LUCRO_PADRAO")
    @Expose
    private Double lucro_patrao;

    @SerializedName(value = "nfe_serie", alternate = "NFE_SERIE")
    @Expose
    private int nfe_serie;

    @SerializedName(value = "ocultar_saldo_anterior", alternate = "OCULTAR_SALDO_ANTERIOR")
    @Expose
    private String ocultar_saldo_anterior;

    @SerializedName(value = "baixar_estoque_nfe", alternate = "BAIXAR_ESTOQUE_NFE")
    @Expose
    private String baixar_estoque_nfe;

    @SerializedName(value = "transmitir_cartao_auto", alternate = "TRANSMITIR_CARTAO_AUTO")
    @Expose
    private String transmitir_cartao_auto;

    @SerializedName(value = "aliquota_simples", alternate = "ALIQUOTA_SIMPLES")
    @Expose
    private Double aliquota_simples;

    @SerializedName(value = "servidor_smtp_proprio", alternate = "SERVIDOR_SMTP_PROPRIO")
    @Expose
    private String servidor_smtp_proprio;

    @SerializedName(value = "mensagem_cobranca", alternate = "MENSAGEM_COBRANCA")
    @Expose
    private String mensagem_cobranca;

    @SerializedName(value = "pre_visualizar_impressao", alternate = "PRE_VISUALIZAR_IMPRESSAO")
    @Expose
    private String pre_visualizar_impressao;

    @SerializedName(value = "id_plano_cobertura", alternate = "ID_PLANO_ABERTURA")
    @Expose
    private int id_plano_cobertura;

    @SerializedName(value = "pesquisa_por_parte", alternate = "PESQUISA_POR_PARTE")
    @Expose
    private String pesquisa_por_parte;

    @SerializedName(value = "baixar_estoque_composicao", alternate = "BAIXAR_ESTOQUE_COMPOSICAO")
    @Expose
    private String baixar_estoque_composicao;

    @SerializedName(value = "auto_atualizada", alternate = "AUTO_ATUALIZA")
    @Expose
    private String auto_atualizada;

    @SerializedName(value = "usa_tef", alternate = "USA_TEF")
    @Expose
    private String usa_tef;

    @SerializedName(value = "ratear_frete", alternate = "RATEAR_FRETE")
    @Expose
    private String ratear_frete;

    @SerializedName(value = "usa_credito_simples", alternate = "USA_CREDITO_SIMPLES")
    @Expose
    private String usa_credito_simples;

    @SerializedName(value = "desconto_item_pvd", alternate = "DESCONTO_ITEM_PDV")
    @Expose
    private String desconto_item_pvd;

    @SerializedName(value = "bloquear_cpf", alternate = "BLOQUEAR_CPF")
    @Expose
    private String bloquear_cpf;

    @SerializedName(value = "bloquear_personalizacao", alternate = "BLOQUEAR_PERSONALIZACAO")
    @Expose
    private String bloquear_personalizacao;

    @SerializedName(value = "permitir_cpf_vazio", alternate = "PERMITIR_CPF_VAZIO")
    @Expose
    private String permitir_cpf_vazio;

    @SerializedName(value = "colorir_estoque", alternate = "COLORIR_ESTOQUE")
    @Expose
    private String colorir_estoque;

    @SerializedName(value = "fechamento_caixa_automatico", alternate = "FECHAMENTO_CAIXA_AUTOMATICO")
    @Expose
    private String fechamento_caixa_automatico;


    public Empresas(){

    }

    public Empresas(int codigo, String fantasia, String razao, String tipo, String cnpj, String ie, String im, String endereco, String numero, String complemento, String bairro, String cidade, String uf, String cep, String fone, String fax, String site, String logomarca, String fundacao, int usa_cad, int usa_atu, String nserie, String csenha, String nterm, int id_plano_transferencia_c, int id_plano_transferencia, int id_caixa_geral, String bloquear_estoque_negativo, int id_cidade, int crt, int id_uf, int id_plano_venda, String obsfisco, String cfop, String csosn, String cst_icms, Double aliq_icms, String cst_entrada, String cst_saida, Double aliq_pis, Double aliq_cof, String cst_ipi, Double aliq_ipi, String imp_f5, String imp_f6, String mostra_resumo_caixa, Double limite_diario, int prazo_maximo, int id_pla_conta_ficha_cli, int id_plano_conta_retirada, String usa_pdv, String recibo_vias, int id_plano_taxa_cartao, String obs_carne, String caixa_unico, String caixa_rapido, int id_plano_conta_devolucao, int n_inicial_nfce, int n_inicial_nfe, int empresa_padrao, String checa_estoque_fiscal, String desconto_prod_promo, String data_cadastro, String data_validade, String flag, String lancar_cartao_credito, String filtrar_empresa_login, String enviar_email_nfe, String transportadora, String tabela_preco, Double taxa_venda_prazo, String email_contador, String autopecas, String atualizar_pr_venda, String informar_gtin, String recolhe_fcp, Double difal_origem, Double difal_destino, String exclui_pdv, String venda_semente, String checa, String email, String ultimonsu, int ultimo_pedido, int tipo_contrato, int tipo_empresa, int qtd_mesas, String bloquear_preco, String exibe_resumo_caixa, int id_plano_compra, String responsavel_tecnico, int carencia_juros, String pesquisa_referencia, String restaurante, String exibe_f3, String exibe_f4, String ler_peso, Double desconto_maximo, String chega_limite, String emite_ecf, String loja_roupa, String tipo_juros, Double juros_dia, Double juros_mes, String farmacia, String pagamento_dinheiro, String responsavale_empresa, String habilita_desconto_pdv, String puxa_cfop_produto, String lancar_cartao_cr, String usa_bluetooh_resta, String cfop_externo, String cnae, int codigo_pais, String obsnfce, String csosn_externo, Double aliq_icms_externo, int cod_fpg_dinheiro, String habilitada_acrescimo, String multi_idioma, String replicar_dados, int id_plano_boleto, String segunda_via_nfce, String exibe_estoque_fiscal, String nfce_produto_substituto, String auto_cadastro_produto, String cfop_entrata_padrao, String cfop_entrada_padrao_e, String puxar_cfop_entrada, Double lucro_patrao, int nfe_serie, String ocultar_saldo_anterior, String baixar_estoque_nfe, String transmitir_cartao_auto, Double aliquota_simples, String servidor_smtp_proprio, String mensagem_cobranca, String pre_visualizar_impressao, int id_plano_cobertura, String pesquisa_por_parte, String baixar_estoque_composicao, String auto_atualizada, String usa_tef, String ratear_frete, String usa_credito_simples, String desconto_item_pvd, String bloquear_cpf, String bloquear_personalizacao, String permitir_cpf_vazio, String colorir_estoque, String fechamento_caixa_automatico) {
        this.codigo = codigo;
        this.fantasia = fantasia;
        this.razao = razao;
        this.tipo = tipo;
        this.cnpj = cnpj;
        this.ie = ie;
        this.im = im;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.fone = fone;
        this.fax = fax;
        this.site = site;
        this.logomarca = logomarca;
        this.fundacao = fundacao;
        this.usa_cad = usa_cad;
        this.usa_atu = usa_atu;
        this.nserie = nserie;
        this.csenha = csenha;
        this.nterm = nterm;
        this.id_plano_transferencia_c = id_plano_transferencia_c;
        this.id_plano_transferencia = id_plano_transferencia;
        this.id_caixa_geral = id_caixa_geral;
        this.bloquear_estoque_negativo = bloquear_estoque_negativo;
        this.id_cidade = id_cidade;
        this.crt = crt;
        this.id_uf = id_uf;
        this.id_plano_venda = id_plano_venda;
        this.obsfisco = obsfisco;
        this.cfop = cfop;
        this.csosn = csosn;
        this.cst_icms = cst_icms;
        this.aliq_icms = aliq_icms;
        this.cst_entrada = cst_entrada;
        this.cst_saida = cst_saida;
        this.aliq_pis = aliq_pis;
        this.aliq_cof = aliq_cof;
        this.cst_ipi = cst_ipi;
        this.aliq_ipi = aliq_ipi;
        this.imp_f5 = imp_f5;
        this.imp_f6 = imp_f6;
        this.mostra_resumo_caixa = mostra_resumo_caixa;
        this.limite_diario = limite_diario;
        this.prazo_maximo = prazo_maximo;
        this.id_pla_conta_ficha_cli = id_pla_conta_ficha_cli;
        this.id_plano_conta_retirada = id_plano_conta_retirada;
        this.usa_pdv = usa_pdv;
        this.recibo_vias = recibo_vias;
        this.id_plano_taxa_cartao = id_plano_taxa_cartao;
        this.obs_carne = obs_carne;
        this.caixa_unico = caixa_unico;
        this.caixa_rapido = caixa_rapido;
        this.id_plano_conta_devolucao = id_plano_conta_devolucao;
        this.n_inicial_nfce = n_inicial_nfce;
        this.n_inicial_nfe = n_inicial_nfe;
        this.empresa_padrao = empresa_padrao;
        this.checa_estoque_fiscal = checa_estoque_fiscal;
        this.desconto_prod_promo = desconto_prod_promo;
        this.data_cadastro = data_cadastro;
        this.data_validade = data_validade;
        this.flag = flag;
        this.lancar_cartao_credito = lancar_cartao_credito;
        this.filtrar_empresa_login = filtrar_empresa_login;
        this.enviar_email_nfe = enviar_email_nfe;
        this.transportadora = transportadora;
        this.tabela_preco = tabela_preco;
        this.taxa_venda_prazo = taxa_venda_prazo;
        this.email_contador = email_contador;
        this.autopecas = autopecas;
        this.atualizar_pr_venda = atualizar_pr_venda;
        this.informar_gtin = informar_gtin;
        this.recolhe_fcp = recolhe_fcp;
        this.difal_origem = difal_origem;
        this.difal_destino = difal_destino;
        this.exclui_pdv = exclui_pdv;
        this.venda_semente = venda_semente;
        this.checa = checa;
        this.email = email;
        this.ultimonsu = ultimonsu;
        this.ultimo_pedido = ultimo_pedido;
        this.tipo_contrato = tipo_contrato;
        this.tipo_empresa = tipo_empresa;
        this.qtd_mesas = qtd_mesas;
        this.bloquear_preco = bloquear_preco;
        this.exibe_resumo_caixa = exibe_resumo_caixa;
        this.id_plano_compra = id_plano_compra;
        this.responsavel_tecnico = responsavel_tecnico;
        this.carencia_juros = carencia_juros;
        this.pesquisa_referencia = pesquisa_referencia;
        this.restaurante = restaurante;
        this.exibe_f3 = exibe_f3;
        this.exibe_f4 = exibe_f4;
        this.ler_peso = ler_peso;
        this.desconto_maximo = desconto_maximo;
        this.chega_limite = chega_limite;
        this.emite_ecf = emite_ecf;
        this.loja_roupa = loja_roupa;
        this.tipo_juros = tipo_juros;
        this.juros_dia = juros_dia;
        this.juros_mes = juros_mes;
        this.farmacia = farmacia;
        this.pagamento_dinheiro = pagamento_dinheiro;
        this.responsavale_empresa = responsavale_empresa;
        this.habilita_desconto_pdv = habilita_desconto_pdv;
        this.puxa_cfop_produto = puxa_cfop_produto;
        this.lancar_cartao_cr = lancar_cartao_cr;
        this.usa_bluetooh_resta = usa_bluetooh_resta;
        this.cfop_externo = cfop_externo;
        this.cnae = cnae;
        this.codigo_pais = codigo_pais;
        this.obsnfce = obsnfce;
        this.csosn_externo = csosn_externo;
        this.aliq_icms_externo = aliq_icms_externo;
        this.cod_fpg_dinheiro = cod_fpg_dinheiro;
        this.habilitada_acrescimo = habilitada_acrescimo;
        this.multi_idioma = multi_idioma;
        this.replicar_dados = replicar_dados;
        this.id_plano_boleto = id_plano_boleto;
        this.segunda_via_nfce = segunda_via_nfce;
        this.exibe_estoque_fiscal = exibe_estoque_fiscal;
        this.nfce_produto_substituto = nfce_produto_substituto;
        this.auto_cadastro_produto = auto_cadastro_produto;
        this.cfop_entrata_padrao = cfop_entrata_padrao;
        this.cfop_entrada_padrao_e = cfop_entrada_padrao_e;
        this.puxar_cfop_entrada = puxar_cfop_entrada;
        this.lucro_patrao = lucro_patrao;
        this.nfe_serie = nfe_serie;
        this.ocultar_saldo_anterior = ocultar_saldo_anterior;
        this.baixar_estoque_nfe = baixar_estoque_nfe;
        this.transmitir_cartao_auto = transmitir_cartao_auto;
        this.aliquota_simples = aliquota_simples;
        this.servidor_smtp_proprio = servidor_smtp_proprio;
        this.mensagem_cobranca = mensagem_cobranca;
        this.pre_visualizar_impressao = pre_visualizar_impressao;
        this.id_plano_cobertura = id_plano_cobertura;
        this.pesquisa_por_parte = pesquisa_por_parte;
        this.baixar_estoque_composicao = baixar_estoque_composicao;
        this.auto_atualizada = auto_atualizada;
        this.usa_tef = usa_tef;
        this.ratear_frete = ratear_frete;
        this.usa_credito_simples = usa_credito_simples;
        this.desconto_item_pvd = desconto_item_pvd;
        this.bloquear_cpf = bloquear_cpf;
        this.bloquear_personalizacao = bloquear_personalizacao;
        this.permitir_cpf_vazio = permitir_cpf_vazio;
        this.colorir_estoque = colorir_estoque;
        this.fechamento_caixa_automatico = fechamento_caixa_automatico;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
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

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLogomarca() {
        return logomarca;
    }

    public void setLogomarca(String logomarca) {
        this.logomarca = logomarca;
    }

    public String getFundacao() {
        return fundacao;
    }

    public void setFundacao(String fundacao) {
        this.fundacao = fundacao;
    }

    public int getUsa_cad() {
        return usa_cad;
    }

    public void setUsa_cad(int usa_cad) {
        this.usa_cad = usa_cad;
    }

    public int getUsa_atu() {
        return usa_atu;
    }

    public void setUsa_atu(int usa_atu) {
        this.usa_atu = usa_atu;
    }

    public String getNserie() {
        return nserie;
    }

    public void setNserie(String nserie) {
        this.nserie = nserie;
    }

    public String getCsenha() {
        return csenha;
    }

    public void setCsenha(String csenha) {
        this.csenha = csenha;
    }

    public String getNterm() {
        return nterm;
    }

    public void setNterm(String nterm) {
        this.nterm = nterm;
    }

    public int getId_plano_transferencia_c() {
        return id_plano_transferencia_c;
    }

    public void setId_plano_transferencia_c(int id_plano_transferencia_c) {
        this.id_plano_transferencia_c = id_plano_transferencia_c;
    }

    public int getId_plano_transferencia() {
        return id_plano_transferencia;
    }

    public void setId_plano_transferencia(int id_plano_transferencia) {
        this.id_plano_transferencia = id_plano_transferencia;
    }

    public int getId_caixa_geral() {
        return id_caixa_geral;
    }

    public void setId_caixa_geral(int id_caixa_geral) {
        this.id_caixa_geral = id_caixa_geral;
    }

    public String getBloquear_estoque_negativo() {
        return bloquear_estoque_negativo;
    }

    public void setBloquear_estoque_negativo(String bloquear_estoque_negativo) {
        this.bloquear_estoque_negativo = bloquear_estoque_negativo;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public int getCrt() {
        return crt;
    }

    public void setCrt(int crt) {
        this.crt = crt;
    }

    public int getId_uf() {
        return id_uf;
    }

    public void setId_uf(int id_uf) {
        this.id_uf = id_uf;
    }

    public int getId_plano_venda() {
        return id_plano_venda;
    }

    public void setId_plano_venda(int id_plano_venda) {
        this.id_plano_venda = id_plano_venda;
    }

    public String getObsfisco() {
        return obsfisco;
    }

    public void setObsfisco(String obsfisco) {
        this.obsfisco = obsfisco;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public String getCst_icms() {
        return cst_icms;
    }

    public void setCst_icms(String cst_icms) {
        this.cst_icms = cst_icms;
    }

    public Double getAliq_icms() {
        return aliq_icms;
    }

    public void setAliq_icms(Double aliq_icms) {
        this.aliq_icms = aliq_icms;
    }

    public String getCst_entrada() {
        return cst_entrada;
    }

    public void setCst_entrada(String cst_entrada) {
        this.cst_entrada = cst_entrada;
    }

    public String getCst_saida() {
        return cst_saida;
    }

    public void setCst_saida(String cst_saida) {
        this.cst_saida = cst_saida;
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

    public String getCst_ipi() {
        return cst_ipi;
    }

    public void setCst_ipi(String cst_ipi) {
        this.cst_ipi = cst_ipi;
    }

    public Double getAliq_ipi() {
        return aliq_ipi;
    }

    public void setAliq_ipi(Double aliq_ipi) {
        this.aliq_ipi = aliq_ipi;
    }

    public String getImp_f5() {
        return imp_f5;
    }

    public void setImp_f5(String imp_f5) {
        this.imp_f5 = imp_f5;
    }

    public String getImp_f6() {
        return imp_f6;
    }

    public void setImp_f6(String imp_f6) {
        this.imp_f6 = imp_f6;
    }

    public String getMostra_resumo_caixa() {
        return mostra_resumo_caixa;
    }

    public void setMostra_resumo_caixa(String mostra_resumo_caixa) {
        this.mostra_resumo_caixa = mostra_resumo_caixa;
    }

    public Double getLimite_diario() {
        return limite_diario;
    }

    public void setLimite_diario(Double limite_diario) {
        this.limite_diario = limite_diario;
    }

    public int getPrazo_maximo() {
        return prazo_maximo;
    }

    public void setPrazo_maximo(int prazo_maximo) {
        this.prazo_maximo = prazo_maximo;
    }

    public int getId_pla_conta_ficha_cli() {
        return id_pla_conta_ficha_cli;
    }

    public void setId_pla_conta_ficha_cli(int id_pla_conta_ficha_cli) {
        this.id_pla_conta_ficha_cli = id_pla_conta_ficha_cli;
    }

    public int getId_plano_conta_retirada() {
        return id_plano_conta_retirada;
    }

    public void setId_plano_conta_retirada(int id_plano_conta_retirada) {
        this.id_plano_conta_retirada = id_plano_conta_retirada;
    }

    public String getUsa_pdv() {
        return usa_pdv;
    }

    public void setUsa_pdv(String usa_pdv) {
        this.usa_pdv = usa_pdv;
    }

    public String getRecibo_vias() {
        return recibo_vias;
    }

    public void setRecibo_vias(String recibo_vias) {
        this.recibo_vias = recibo_vias;
    }

    public int getId_plano_taxa_cartao() {
        return id_plano_taxa_cartao;
    }

    public void setId_plano_taxa_cartao(int id_plano_taxa_cartao) {
        this.id_plano_taxa_cartao = id_plano_taxa_cartao;
    }

    public String getObs_carne() {
        return obs_carne;
    }

    public void setObs_carne(String obs_carne) {
        this.obs_carne = obs_carne;
    }

    public String getCaixa_unico() {
        return caixa_unico;
    }

    public void setCaixa_unico(String caixa_unico) {
        this.caixa_unico = caixa_unico;
    }

    public String getCaixa_rapido() {
        return caixa_rapido;
    }

    public void setCaixa_rapido(String caixa_rapido) {
        this.caixa_rapido = caixa_rapido;
    }

    public int getId_plano_conta_devolucao() {
        return id_plano_conta_devolucao;
    }

    public void setId_plano_conta_devolucao(int id_plano_conta_devolucao) {
        this.id_plano_conta_devolucao = id_plano_conta_devolucao;
    }

    public int getN_inicial_nfce() {
        return n_inicial_nfce;
    }

    public void setN_inicial_nfce(int n_inicial_nfce) {
        this.n_inicial_nfce = n_inicial_nfce;
    }

    public int getN_inicial_nfe() {
        return n_inicial_nfe;
    }

    public void setN_inicial_nfe(int n_inicial_nfe) {
        this.n_inicial_nfe = n_inicial_nfe;
    }

    public int getEmpresa_padrao() {
        return empresa_padrao;
    }

    public void setEmpresa_padrao(int empresa_padrao) {
        this.empresa_padrao = empresa_padrao;
    }

    public String getCheca_estoque_fiscal() {
        return checa_estoque_fiscal;
    }

    public void setCheca_estoque_fiscal(String checa_estoque_fiscal) {
        this.checa_estoque_fiscal = checa_estoque_fiscal;
    }

    public String getDesconto_prod_promo() {
        return desconto_prod_promo;
    }

    public void setDesconto_prod_promo(String desconto_prod_promo) {
        this.desconto_prod_promo = desconto_prod_promo;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getData_validade() {
        return data_validade;
    }

    public void setData_validade(String data_validade) {
        this.data_validade = data_validade;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLancar_cartao_credito() {
        return lancar_cartao_credito;
    }

    public void setLancar_cartao_credito(String lancar_cartao_credito) {
        this.lancar_cartao_credito = lancar_cartao_credito;
    }

    public String getFiltrar_empresa_login() {
        return filtrar_empresa_login;
    }

    public void setFiltrar_empresa_login(String filtrar_empresa_login) {
        this.filtrar_empresa_login = filtrar_empresa_login;
    }

    public String getEnviar_email_nfe() {
        return enviar_email_nfe;
    }

    public void setEnviar_email_nfe(String enviar_email_nfe) {
        this.enviar_email_nfe = enviar_email_nfe;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public String getTabela_preco() {
        return tabela_preco;
    }

    public void setTabela_preco(String tabela_preco) {
        this.tabela_preco = tabela_preco;
    }

    public Double getTaxa_venda_prazo() {
        return taxa_venda_prazo;
    }

    public void setTaxa_venda_prazo(Double taxa_venda_prazo) {
        this.taxa_venda_prazo = taxa_venda_prazo;
    }

    public String getEmail_contador() {
        return email_contador;
    }

    public void setEmail_contador(String email_contador) {
        this.email_contador = email_contador;
    }

    public String getAutopecas() {
        return autopecas;
    }

    public void setAutopecas(String autopecas) {
        this.autopecas = autopecas;
    }

    public String getAtualizar_pr_venda() {
        return atualizar_pr_venda;
    }

    public void setAtualizar_pr_venda(String atualizar_pr_venda) {
        this.atualizar_pr_venda = atualizar_pr_venda;
    }

    public String getInformar_gtin() {
        return informar_gtin;
    }

    public void setInformar_gtin(String informar_gtin) {
        this.informar_gtin = informar_gtin;
    }

    public String getRecolhe_fcp() {
        return recolhe_fcp;
    }

    public void setRecolhe_fcp(String recolhe_fcp) {
        this.recolhe_fcp = recolhe_fcp;
    }

    public Double getDifal_origem() {
        return difal_origem;
    }

    public void setDifal_origem(Double difal_origem) {
        this.difal_origem = difal_origem;
    }

    public Double getDifal_destino() {
        return difal_destino;
    }

    public void setDifal_destino(Double difal_destino) {
        this.difal_destino = difal_destino;
    }

    public String getExclui_pdv() {
        return exclui_pdv;
    }

    public void setExclui_pdv(String exclui_pdv) {
        this.exclui_pdv = exclui_pdv;
    }

    public String getVenda_semente() {
        return venda_semente;
    }

    public void setVenda_semente(String venda_semente) {
        this.venda_semente = venda_semente;
    }

    public String getCheca() {
        return checa;
    }

    public void setCheca(String checa) {
        this.checa = checa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUltimonsu() {
        return ultimonsu;
    }

    public void setUltimonsu(String ultimonsu) {
        this.ultimonsu = ultimonsu;
    }

    public int getUltimo_pedido() {
        return ultimo_pedido;
    }

    public void setUltimo_pedido(int ultimo_pedido) {
        this.ultimo_pedido = ultimo_pedido;
    }

    public int getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(int tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    public int getTipo_empresa() {
        return tipo_empresa;
    }

    public void setTipo_empresa(int tipo_empresa) {
        this.tipo_empresa = tipo_empresa;
    }

    public int getQtd_mesas() {
        return qtd_mesas;
    }

    public void setQtd_mesas(int qtd_mesas) {
        this.qtd_mesas = qtd_mesas;
    }

    public String getBloquear_preco() {
        return bloquear_preco;
    }

    public void setBloquear_preco(String bloquear_preco) {
        this.bloquear_preco = bloquear_preco;
    }

    public String getExibe_resumo_caixa() {
        return exibe_resumo_caixa;
    }

    public void setExibe_resumo_caixa(String exibe_resumo_caixa) {
        this.exibe_resumo_caixa = exibe_resumo_caixa;
    }

    public int getId_plano_compra() {
        return id_plano_compra;
    }

    public void setId_plano_compra(int id_plano_compra) {
        this.id_plano_compra = id_plano_compra;
    }

    public String getResponsavel_tecnico() {
        return responsavel_tecnico;
    }

    public void setResponsavel_tecnico(String responsavel_tecnico) {
        this.responsavel_tecnico = responsavel_tecnico;
    }

    public int getCarencia_juros() {
        return carencia_juros;
    }

    public void setCarencia_juros(int carencia_juros) {
        this.carencia_juros = carencia_juros;
    }

    public String getPesquisa_referencia() {
        return pesquisa_referencia;
    }

    public void setPesquisa_referencia(String pesquisa_referencia) {
        this.pesquisa_referencia = pesquisa_referencia;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public String getExibe_f3() {
        return exibe_f3;
    }

    public void setExibe_f3(String exibe_f3) {
        this.exibe_f3 = exibe_f3;
    }

    public String getExibe_f4() {
        return exibe_f4;
    }

    public void setExibe_f4(String exibe_f4) {
        this.exibe_f4 = exibe_f4;
    }

    public String getLer_peso() {
        return ler_peso;
    }

    public void setLer_peso(String ler_peso) {
        this.ler_peso = ler_peso;
    }

    public Double getDesconto_maximo() {
        return desconto_maximo;
    }

    public void setDesconto_maximo(Double desconto_maximo) {
        this.desconto_maximo = desconto_maximo;
    }

    public String getChega_limite() {
        return chega_limite;
    }

    public void setChega_limite(String chega_limite) {
        this.chega_limite = chega_limite;
    }

    public String getEmite_ecf() {
        return emite_ecf;
    }

    public void setEmite_ecf(String emite_ecf) {
        this.emite_ecf = emite_ecf;
    }

    public String getLoja_roupa() {
        return loja_roupa;
    }

    public void setLoja_roupa(String loja_roupa) {
        this.loja_roupa = loja_roupa;
    }

    public String getTipo_juros() {
        return tipo_juros;
    }

    public void setTipo_juros(String tipo_juros) {
        this.tipo_juros = tipo_juros;
    }

    public Double getJuros_dia() {
        return juros_dia;
    }

    public void setJuros_dia(Double juros_dia) {
        this.juros_dia = juros_dia;
    }

    public Double getJuros_mes() {
        return juros_mes;
    }

    public void setJuros_mes(Double juros_mes) {
        this.juros_mes = juros_mes;
    }

    public String getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    public String getPagamento_dinheiro() {
        return pagamento_dinheiro;
    }

    public void setPagamento_dinheiro(String pagamento_dinheiro) {
        this.pagamento_dinheiro = pagamento_dinheiro;
    }

    public String getResponsavale_empresa() {
        return responsavale_empresa;
    }

    public void setResponsavale_empresa(String responsavale_empresa) {
        this.responsavale_empresa = responsavale_empresa;
    }

    public String getHabilita_desconto_pdv() {
        return habilita_desconto_pdv;
    }

    public void setHabilita_desconto_pdv(String habilita_desconto_pdv) {
        this.habilita_desconto_pdv = habilita_desconto_pdv;
    }

    public String getPuxa_cfop_produto() {
        return puxa_cfop_produto;
    }

    public void setPuxa_cfop_produto(String puxa_cfop_produto) {
        this.puxa_cfop_produto = puxa_cfop_produto;
    }

    public String getLancar_cartao_cr() {
        return lancar_cartao_cr;
    }

    public void setLancar_cartao_cr(String lancar_cartao_cr) {
        this.lancar_cartao_cr = lancar_cartao_cr;
    }

    public String getUsa_bluetooh_resta() {
        return usa_bluetooh_resta;
    }

    public void setUsa_bluetooh_resta(String usa_bluetooh_resta) {
        this.usa_bluetooh_resta = usa_bluetooh_resta;
    }

    public String getCfop_externo() {
        return cfop_externo;
    }

    public void setCfop_externo(String cfop_externo) {
        this.cfop_externo = cfop_externo;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public int getCodigo_pais() {
        return codigo_pais;
    }

    public void setCodigo_pais(int codigo_pais) {
        this.codigo_pais = codigo_pais;
    }

    public String getObsnfce() {
        return obsnfce;
    }

    public void setObsnfce(String obsnfce) {
        this.obsnfce = obsnfce;
    }

    public String getCsosn_externo() {
        return csosn_externo;
    }

    public void setCsosn_externo(String csosn_externo) {
        this.csosn_externo = csosn_externo;
    }

    public Double getAliq_icms_externo() {
        return aliq_icms_externo;
    }

    public void setAliq_icms_externo(Double aliq_icms_externo) {
        this.aliq_icms_externo = aliq_icms_externo;
    }

    public int getCod_fpg_dinheiro() {
        return cod_fpg_dinheiro;
    }

    public void setCod_fpg_dinheiro(int cod_fpg_dinheiro) {
        this.cod_fpg_dinheiro = cod_fpg_dinheiro;
    }

    public String getHabilitada_acrescimo() {
        return habilitada_acrescimo;
    }

    public void setHabilitada_acrescimo(String habilitada_acrescimo) {
        this.habilitada_acrescimo = habilitada_acrescimo;
    }

    public String getMulti_idioma() {
        return multi_idioma;
    }

    public void setMulti_idioma(String multi_idioma) {
        this.multi_idioma = multi_idioma;
    }

    public String getReplicar_dados() {
        return replicar_dados;
    }

    public void setReplicar_dados(String replicar_dados) {
        this.replicar_dados = replicar_dados;
    }

    public int getId_plano_boleto() {
        return id_plano_boleto;
    }

    public void setId_plano_boleto(int id_plano_boleto) {
        this.id_plano_boleto = id_plano_boleto;
    }

    public String getSegunda_via_nfce() {
        return segunda_via_nfce;
    }

    public void setSegunda_via_nfce(String segunda_via_nfce) {
        this.segunda_via_nfce = segunda_via_nfce;
    }

    public String getExibe_estoque_fiscal() {
        return exibe_estoque_fiscal;
    }

    public void setExibe_estoque_fiscal(String exibe_estoque_fiscal) {
        this.exibe_estoque_fiscal = exibe_estoque_fiscal;
    }

    public String getNfce_produto_substituto() {
        return nfce_produto_substituto;
    }

    public void setNfce_produto_substituto(String nfce_produto_substituto) {
        this.nfce_produto_substituto = nfce_produto_substituto;
    }

    public String getAuto_cadastro_produto() {
        return auto_cadastro_produto;
    }

    public void setAuto_cadastro_produto(String auto_cadastro_produto) {
        this.auto_cadastro_produto = auto_cadastro_produto;
    }

    public String getCfop_entrata_padrao() {
        return cfop_entrata_padrao;
    }

    public void setCfop_entrata_padrao(String cfop_entrata_padrao) {
        this.cfop_entrata_padrao = cfop_entrata_padrao;
    }

    public String getCfop_entrada_padrao_e() {
        return cfop_entrada_padrao_e;
    }

    public void setCfop_entrada_padrao_e(String cfop_entrada_padrao_e) {
        this.cfop_entrada_padrao_e = cfop_entrada_padrao_e;
    }

    public String getPuxar_cfop_entrada() {
        return puxar_cfop_entrada;
    }

    public void setPuxar_cfop_entrada(String puxar_cfop_entrada) {
        this.puxar_cfop_entrada = puxar_cfop_entrada;
    }

    public Double getLucro_patrao() {
        return lucro_patrao;
    }

    public void setLucro_patrao(Double lucro_patrao) {
        this.lucro_patrao = lucro_patrao;
    }

    public int getNfe_serie() {
        return nfe_serie;
    }

    public void setNfe_serie(int nfe_serie) {
        this.nfe_serie = nfe_serie;
    }

    public String getOcultar_saldo_anterior() {
        return ocultar_saldo_anterior;
    }

    public void setOcultar_saldo_anterior(String ocultar_saldo_anterior) {
        this.ocultar_saldo_anterior = ocultar_saldo_anterior;
    }

    public String getBaixar_estoque_nfe() {
        return baixar_estoque_nfe;
    }

    public void setBaixar_estoque_nfe(String baixar_estoque_nfe) {
        this.baixar_estoque_nfe = baixar_estoque_nfe;
    }

    public String getTransmitir_cartao_auto() {
        return transmitir_cartao_auto;
    }

    public void setTransmitir_cartao_auto(String transmitir_cartao_auto) {
        this.transmitir_cartao_auto = transmitir_cartao_auto;
    }

    public Double getAliquota_simples() {
        return aliquota_simples;
    }

    public void setAliquota_simples(Double aliquota_simples) {
        this.aliquota_simples = aliquota_simples;
    }

    public String getServidor_smtp_proprio() {
        return servidor_smtp_proprio;
    }

    public void setServidor_smtp_proprio(String servidor_smtp_proprio) {
        this.servidor_smtp_proprio = servidor_smtp_proprio;
    }

    public String getMensagem_cobranca() {
        return mensagem_cobranca;
    }

    public void setMensagem_cobranca(String mensagem_cobranca) {
        this.mensagem_cobranca = mensagem_cobranca;
    }

    public String getPre_visualizar_impressao() {
        return pre_visualizar_impressao;
    }

    public void setPre_visualizar_impressao(String pre_visualizar_impressao) {
        this.pre_visualizar_impressao = pre_visualizar_impressao;
    }

    public int getId_plano_cobertura() {
        return id_plano_cobertura;
    }

    public void setId_plano_cobertura(int id_plano_cobertura) {
        this.id_plano_cobertura = id_plano_cobertura;
    }

    public String getPesquisa_por_parte() {
        return pesquisa_por_parte;
    }

    public void setPesquisa_por_parte(String pesquisa_por_parte) {
        this.pesquisa_por_parte = pesquisa_por_parte;
    }

    public String getBaixar_estoque_composicao() {
        return baixar_estoque_composicao;
    }

    public void setBaixar_estoque_composicao(String baixar_estoque_composicao) {
        this.baixar_estoque_composicao = baixar_estoque_composicao;
    }

    public String getAuto_atualizada() {
        return auto_atualizada;
    }

    public void setAuto_atualizada(String auto_atualizada) {
        this.auto_atualizada = auto_atualizada;
    }

    public String getUsa_tef() {
        return usa_tef;
    }

    public void setUsa_tef(String usa_tef) {
        this.usa_tef = usa_tef;
    }

    public String getRatear_frete() {
        return ratear_frete;
    }

    public void setRatear_frete(String ratear_frete) {
        this.ratear_frete = ratear_frete;
    }

    public String getUsa_credito_simples() {
        return usa_credito_simples;
    }

    public void setUsa_credito_simples(String usa_credito_simples) {
        this.usa_credito_simples = usa_credito_simples;
    }

    public String getDesconto_item_pvd() {
        return desconto_item_pvd;
    }

    public void setDesconto_item_pvd(String desconto_item_pvd) {
        this.desconto_item_pvd = desconto_item_pvd;
    }

    public String getBloquear_cpf() {
        return bloquear_cpf;
    }

    public void setBloquear_cpf(String bloquear_cpf) {
        this.bloquear_cpf = bloquear_cpf;
    }

    public String getBloquear_personalizacao() {
        return bloquear_personalizacao;
    }

    public void setBloquear_personalizacao(String bloquear_personalizacao) {
        this.bloquear_personalizacao = bloquear_personalizacao;
    }

    public String getPermitir_cpf_vazio() {
        return permitir_cpf_vazio;
    }

    public void setPermitir_cpf_vazio(String permitir_cpf_vazio) {
        this.permitir_cpf_vazio = permitir_cpf_vazio;
    }

    public String getColorir_estoque() {
        return colorir_estoque;
    }

    public void setColorir_estoque(String colorir_estoque) {
        this.colorir_estoque = colorir_estoque;
    }

    public String getFechamento_caixa_automatico() {
        return fechamento_caixa_automatico;
    }

    public void setFechamento_caixa_automatico(String fechamento_caixa_automatico) {
        this.fechamento_caixa_automatico = fechamento_caixa_automatico;
    }
}
