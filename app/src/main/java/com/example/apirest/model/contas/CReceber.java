package com.example.apirest.model.contas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CReceber implements Serializable {

    @SerializedName(value = "codigo", alternate = "CODIGO")
    @Expose
    private int codigo;

    @SerializedName(value = "data", alternate = "DATA")
    @Expose
    private String data;

    @SerializedName(value = "fkcliente", alternate = "FKCLIENTE")
    @Expose
    private int fkcliente;

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

    @SerializedName(value = "data_recebimento", alternate = "DATA_RECEBIMENTO")
    @Expose
    private String data_recebimento;

    @SerializedName(value = "desconto", alternate = "DESCONTO")
    @Expose
    private Double desconto;

    @SerializedName(value = "juros", alternate = "JUROS")
    @Expose
    private Double juros;

    @SerializedName(value = "vrecebido", alternate = "VRECEBIDO")
    @Expose
    private Double vrecebido;

    @SerializedName(value = "vl_restante", alternate = "VL_RESTANTE")
    @Expose
    private Double vl_restante;

    @SerializedName(value = "situacao", alternate = "SITUACAO")
    @Expose
    private String situacao;

    @SerializedName(value = "fkempresa", alternate = "FKEMPRESA")
    @Expose
    private int fkempresa;

    @SerializedName(value = "fk_venda", alternate = "FK_VENDA")
    @Expose
    private int fk_venda;

    @SerializedName(value = "fkconta", alternate = "FKCONTA")
    @Expose
    private int fkconta;

    @SerializedName(value = "tipo", alternate = "TIPO")
    @Expose
    private String tipo;

    @SerializedName(value = "nboleto", alternate = "NBOLETO")
    @Expose
    private int nboleto;

    @SerializedName(value = "id_vendedor", alternate = "ID_VENDEDOR")
    @Expose
    private int id_vendedor;

    @SerializedName(value = "fk_os", alternate = "FK_OS")
    @Expose
    private int fk_os;

    @SerializedName(value = "flag", alternate = "FLAG")
    @Expose
    private String flag;

    @SerializedName(value = "bloqueado", alternate = "BLOQUEADO")
    @Expose
    private String bloqueado;

    @SerializedName(value = "fk_usuario", alternate = "FK_USUARIO")
    @Expose
    private int fk_usuario;

    @SerializedName(value = "cartao", alternate = "CARTAO")
    @Expose
    private String cartao;

    @SerializedName(value = "fpg_venda", alternate = "FPG_VENDA")
    @Expose
    private int fpg_venda;

    @SerializedName(value = "pagamento_loja", alternate = "PAGAMENTO_LOJA")
    @Expose
    private String pagamento_loja;

    @SerializedName(value = "cancelamento_loja", alternate = "CANCELAMENTO_LOJA")
    @Expose
    private String cancelamento_loja;

    @SerializedName(value = "alteraacao_loja", alternate = "ALTERACAO_LOJA")
    @Expose
    private String alteraacao_loja;

    @SerializedName(value = "cancelamento_data", alternate = "CANCELAMENTO_DATA")
    @Expose
    private String cancelamento_data;

    @SerializedName(value = "remessa", alternate = "REMESSA")
    @Expose
    private String remessa;

    @SerializedName(value = "remessa_reenviar", alternate = "REMESSA_REENVIAR")
    @Expose
    private String remessa_reenviar;

    @SerializedName(value = "remessa_data", alternate = "REMESSA_DATA")
    @Expose
    private String remessa_data;

    @SerializedName(value = "remessa_arquivo", alternate = "REMESSA_ARQUIVO")
    @Expose
    private String remessa_arquivo;

    @SerializedName(value = "registro_id_cbr_retorno", alternate = "REGISTRO_ID_CBR_RETORNO")
    @Expose
    private String registro_id_cbr_retorno;

    @SerializedName(value = "registro_status", alternate = "REGISTRO_STATUS")
    @Expose
    private String registro_status;

    @SerializedName(value = "registro_data", alternate = "REGISTRO_DATA")
    @Expose
    private String registro_data;
    @SerializedName(value = "registro_arquivo", alternate = "REGISTRO_ARQUIVO")
    @Expose
    private String registro_arquivo;

    @SerializedName(value = "retorno_id_cbe_retorno", alternate = "RETORNO_ID_CBR_RETORNO")
    @Expose
    private int retorno_id_cbe_retorno;

    @SerializedName(value = "registro_historico", alternate = "REGISTRO_HISTORICO")
    @Expose
    private String registro_historico;

    @SerializedName(value = "registro_sem_registro", alternate = "REGISTRO_SEM_REGISTRO")
    @Expose
    private String registro_sem_registro;

    @SerializedName(value = "registro_limite_prazo", alternate = "REGISTRO_LIMITE_PRAZO")
    @Expose
    private String registro_limite_prazo;

    @SerializedName(value = "retorno_historico", alternate = "RETORNO_HISTORICO")
    @Expose
    private String retorno_historico;

    @SerializedName(value = "obs", alternate = "OBS")
    @Expose
    private String obs;

    @SerializedName(value = "id_cbr_remess_uuid", alternate = "ID_CBR_REMESSA_UUID")
    @Expose
    private String id_cbr_remess_uuid;

    @SerializedName(value = "retorno_sem_registro", alternate = "RETORNO_SEM_REGISTRO")
    @Expose
    private String retorno_sem_registro;

    @SerializedName(value = "retorno_limite_prazo", alternate = "RETORNO_LIMITE_PRAZO")
    @Expose
    private String retorno_limite_prazo;

    @SerializedName(value = "fk_nfe", alternate = "FK_NFE")
    @Expose
    private int fk_nfe;

    @SerializedName(value = "restante", alternate = "RESTANTE")
    @Expose
    private Double restante;

    private String nomeEmpresa;

    private String nomePessaReceber;
    private String formaPagamento;


    public CReceber(){

    }

    public CReceber(int codigo, String data, int fkcliente, String doc, Double valor, String dtvencimento, String historico, String data_recebimento, Double desconto, Double juros, Double vrecebido, Double vl_restante, String situacao, int fkempresa, int fk_venda, int fkconta, String tipo, int nboleto, int id_vendedor, int fk_os, String flag, String bloqueado, int fk_usuario, String cartao, int fpg_venda, String pagamento_loja, String cancelamento_loja, String alteraacao_loja, String cancelamento_data, String remessa, String remessa_reenviar, String remessa_data, String remessa_arquivo, String registro_id_cbr_retorno, String registro_status, String registro_data, String registro_arquivo, int retorno_id_cbe_retorno, String registro_historico, String registro_sem_registro, String registro_limite_prazo, String retorno_historico, String obs, String id_cbr_remess_uuid, String retorno_sem_registro, String retorno_limite_prazo, int fk_nfe, Double restante) {
        this.codigo = codigo;
        this.data = data;
        this.fkcliente = fkcliente;
        this.doc = doc;
        this.valor = valor;
        this.dtvencimento = dtvencimento;
        this.historico = historico;
        this.data_recebimento = data_recebimento;
        this.desconto = desconto;
        this.juros = juros;
        this.vrecebido = vrecebido;
        this.vl_restante = vl_restante;
        this.situacao = situacao;
        this.fkempresa = fkempresa;
        this.fk_venda = fk_venda;
        this.fkconta = fkconta;
        this.tipo = tipo;
        this.nboleto = nboleto;
        this.id_vendedor = id_vendedor;
        this.fk_os = fk_os;
        this.flag = flag;
        this.bloqueado = bloqueado;
        this.fk_usuario = fk_usuario;
        this.cartao = cartao;
        this.fpg_venda = fpg_venda;
        this.pagamento_loja = pagamento_loja;
        this.cancelamento_loja = cancelamento_loja;
        this.alteraacao_loja = alteraacao_loja;
        this.cancelamento_data = cancelamento_data;
        this.remessa = remessa;
        this.remessa_reenviar = remessa_reenviar;
        this.remessa_data = remessa_data;
        this.remessa_arquivo = remessa_arquivo;
        this.registro_id_cbr_retorno = registro_id_cbr_retorno;
        this.registro_status = registro_status;
        this.registro_data = registro_data;
        this.registro_arquivo = registro_arquivo;
        this.retorno_id_cbe_retorno = retorno_id_cbe_retorno;
        this.registro_historico = registro_historico;
        this.registro_sem_registro = registro_sem_registro;
        this.registro_limite_prazo = registro_limite_prazo;
        this.retorno_historico = retorno_historico;
        this.obs = obs;
        this.id_cbr_remess_uuid = id_cbr_remess_uuid;
        this.retorno_sem_registro = retorno_sem_registro;
        this.retorno_limite_prazo = retorno_limite_prazo;
        this.fk_nfe = fk_nfe;
        this.restante = restante;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNomePessaReceber() {
        return nomePessaReceber;
    }

    public void setNomePessaReceber(String nomePessaReceber) {
        this.nomePessaReceber = nomePessaReceber;
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

    public int getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(int fkcliente) {
        this.fkcliente = fkcliente;
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

    public String getData_recebimento() {
        return data_recebimento;
    }

    public void setData_recebimento(String data_recebimento) {
        this.data_recebimento = data_recebimento;
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

    public Double getVrecebido() {
        return vrecebido;
    }

    public void setVrecebido(Double vrecebido) {
        this.vrecebido = vrecebido;
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

    public int getFk_venda() {
        return fk_venda;
    }

    public void setFk_venda(int fk_venda) {
        this.fk_venda = fk_venda;
    }

    public int getFkconta() {
        return fkconta;
    }

    public void setFkconta(int fkconta) {
        this.fkconta = fkconta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNboleto() {
        return nboleto;
    }

    public void setNboleto(int nboleto) {
        this.nboleto = nboleto;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getFk_os() {
        return fk_os;
    }

    public void setFk_os(int fk_os) {
        this.fk_os = fk_os;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(String bloqueado) {
        this.bloqueado = bloqueado;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public int getFpg_venda() {
        return fpg_venda;
    }

    public void setFpg_venda(int fpg_venda) {
        this.fpg_venda = fpg_venda;
    }

    public String getPagamento_loja() {
        return pagamento_loja;
    }

    public void setPagamento_loja(String pagamento_loja) {
        this.pagamento_loja = pagamento_loja;
    }

    public String getCancelamento_loja() {
        return cancelamento_loja;
    }

    public void setCancelamento_loja(String cancelamento_loja) {
        this.cancelamento_loja = cancelamento_loja;
    }

    public String getAlteraacao_loja() {
        return alteraacao_loja;
    }

    public void setAlteraacao_loja(String alteraacao_loja) {
        this.alteraacao_loja = alteraacao_loja;
    }

    public String getCancelamento_data() {
        return cancelamento_data;
    }

    public void setCancelamento_data(String cancelamento_data) {
        this.cancelamento_data = cancelamento_data;
    }

    public String getRemessa() {
        return remessa;
    }

    public void setRemessa(String remessa) {
        this.remessa = remessa;
    }

    public String getRemessa_reenviar() {
        return remessa_reenviar;
    }

    public void setRemessa_reenviar(String remessa_reenviar) {
        this.remessa_reenviar = remessa_reenviar;
    }

    public String getRemessa_data() {
        return remessa_data;
    }

    public void setRemessa_data(String remessa_data) {
        this.remessa_data = remessa_data;
    }

    public String getRemessa_arquivo() {
        return remessa_arquivo;
    }

    public void setRemessa_arquivo(String remessa_arquivo) {
        this.remessa_arquivo = remessa_arquivo;
    }

    public String getRegistro_id_cbr_retorno() {
        return registro_id_cbr_retorno;
    }

    public void setRegistro_id_cbr_retorno(String registro_id_cbr_retorno) {
        this.registro_id_cbr_retorno = registro_id_cbr_retorno;
    }

    public String getRegistro_status() {
        return registro_status;
    }

    public void setRegistro_status(String registro_status) {
        this.registro_status = registro_status;
    }

    public String getRegistro_data() {
        return registro_data;
    }

    public void setRegistro_data(String registro_data) {
        this.registro_data = registro_data;
    }

    public String getRegistro_arquivo() {
        return registro_arquivo;
    }

    public void setRegistro_arquivo(String registro_arquivo) {
        this.registro_arquivo = registro_arquivo;
    }

    public int getRetorno_id_cbe_retorno() {
        return retorno_id_cbe_retorno;
    }

    public void setRetorno_id_cbe_retorno(int retorno_id_cbe_retorno) {
        this.retorno_id_cbe_retorno = retorno_id_cbe_retorno;
    }

    public String getRegistro_historico() {
        return registro_historico;
    }

    public void setRegistro_historico(String registro_historico) {
        this.registro_historico = registro_historico;
    }

    public String getRegistro_sem_registro() {
        return registro_sem_registro;
    }

    public void setRegistro_sem_registro(String registro_sem_registro) {
        this.registro_sem_registro = registro_sem_registro;
    }

    public String getRegistro_limite_prazo() {
        return registro_limite_prazo;
    }

    public void setRegistro_limite_prazo(String registro_limite_prazo) {
        this.registro_limite_prazo = registro_limite_prazo;
    }

    public String getRetorno_historico() {
        return retorno_historico;
    }

    public void setRetorno_historico(String retorno_historico) {
        this.retorno_historico = retorno_historico;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getId_cbr_remess_uuid() {
        return id_cbr_remess_uuid;
    }

    public void setId_cbr_remess_uuid(String id_cbr_remess_uuid) {
        this.id_cbr_remess_uuid = id_cbr_remess_uuid;
    }

    public String getRetorno_sem_registro() {
        return retorno_sem_registro;
    }

    public void setRetorno_sem_registro(String retorno_sem_registro) {
        this.retorno_sem_registro = retorno_sem_registro;
    }

    public String getRetorno_limite_prazo() {
        return retorno_limite_prazo;
    }

    public void setRetorno_limite_prazo(String retorno_limite_prazo) {
        this.retorno_limite_prazo = retorno_limite_prazo;
    }

    public int getFk_nfe() {
        return fk_nfe;
    }

    public void setFk_nfe(int fk_nfe) {
        this.fk_nfe = fk_nfe;
    }

    public Double getRestante() {
        return restante;
    }

    public void setRestante(Double restante) {
        this.restante = restante;
    }
}
