package com.example.apirest.utils;

import com.example.apirest.interfaces.CCompraService;
import com.example.apirest.interfaces.CPagamentoService;
import com.example.apirest.interfaces.CPagarService;
import com.example.apirest.interfaces.CReceberService;
import com.example.apirest.interfaces.CRecebimentoLoteService;
import com.example.apirest.interfaces.CRecebimentoService;
import com.example.apirest.interfaces.CaixaService;
import com.example.apirest.interfaces.ContasMovimentoService;
import com.example.apirest.interfaces.ContasService;
import com.example.apirest.interfaces.EmpresasService;
import com.example.apirest.interfaces.FormaPagamentoService;
import com.example.apirest.interfaces.GruposService;
import com.example.apirest.interfaces.PersonaService;
import com.example.apirest.interfaces.PessoasService;
import com.example.apirest.interfaces.ProdutosService;
import com.example.apirest.interfaces.ResumoCaixaService;
import com.example.apirest.interfaces.VendasDetalhesService;
import com.example.apirest.interfaces.VendasMasterService;
import com.example.apirest.interfaces.VendasfpgService;

public class Apis {

    // 192.168.1.107 LABEX
    // 192.168.1.107  SIGATEC
    // 192.168.1.107 Casa - notebook
    // 192.168.1.107 Casa - desktop
    public static final String URL_001="http://192.168.1.107:8080/personas/";
    public static final String URL_002="http://192.168.1.107:8080/vendasmaster/";
    public static final String URL_003="http://192.168.1.107:8080/vendasformapagamento/";
    public static final String URL_004="http://192.168.1.107:8080/formapagamento/";
    public static final String URL_005="http://192.168.1.107:8080/empresas/";
    public static final String URL_006="http://192.168.1.107:8080/vendasdetalhes/";
    public static final String URL_007="http://192.168.1.107:8080/produtos/";
    public static final String URL_008="http://192.168.1.107:8080/grupos/";
    public static final String URL_009="http://192.168.1.107:8080/cpagar/";
    public static final String URL_010="http://192.168.1.107:8080/cpagamento/";
    public static final String URL_011="http://192.168.1.107:8080/creceber/";
    public static final String URL_012="http://192.168.1.107:8080/crecebimento/";
    public static final String URL_013="http://192.168.1.107:8080/crecebimentolote/";
    public static final String URL_014="http://192.168.1.107:8080/pessoas/";
    public static final String URL_015="http://192.168.1.107:8080/ccompra/";
    public static final String URL_016="http://192.168.1.107:8080/caixa/";
    public static final String URL_017="http://192.168.1.107:8080/contas/";
    public static final String URL_018="http://192.168.1.107:8080/contasmovimento/";
    public static final String URL_019="http://192.168.1.107:8080/resumocaixa/";

    public static PersonaService getPersonaService(){
        return  Gestao.getClient(URL_001).create(PersonaService.class);
    }

    public static VendasMasterService getVendasMasterService(){
        return  Gestao.getClient(URL_002).create(VendasMasterService.class);
    }

    public static VendasfpgService getVendasfpgService(){
        return  Gestao.getClient(URL_003).create(VendasfpgService.class);
    }

    public static FormaPagamentoService getFormaPagamentoService(){
        return  Gestao.getClient(URL_004).create(FormaPagamentoService.class);
    }

    public static EmpresasService getEmpresasService(){
        return  Gestao.getClient(URL_005).create(EmpresasService.class);
    }

    public static VendasDetalhesService getVendasDetalhesService(){
        return  Gestao.getClient(URL_006).create(VendasDetalhesService.class);
    }

    public static ProdutosService getProdutos(){
        return  Gestao.getClient(URL_007).create(ProdutosService.class);
    }

    public static GruposService getGruposService(){
        return  Gestao.getClient(URL_008).create(GruposService.class);
    }

    public static CPagarService getCPagarService(){
        return  Gestao.getClient(URL_009).create(CPagarService.class);
    }

    public static CPagamentoService getCPagamentoService(){
        return  Gestao.getClient(URL_010).create(CPagamentoService.class);
    }

    public static CReceberService getCReceberService(){
        return  Gestao.getClient(URL_011).create(CReceberService.class);
    }

    public static CRecebimentoService getCRecebimentoService(){
        return  Gestao.getClient(URL_012).create(CRecebimentoService.class);
    }

    public static CRecebimentoLoteService getCRecebimentoLoteService(){
        return  Gestao.getClient(URL_013).create(CRecebimentoLoteService.class);
    }

    public static PessoasService getPessoasService(){
        return  Gestao.getClient(URL_014).create(PessoasService.class);
    }
    public static CCompraService getCCompraService(){
        return  Gestao.getClient(URL_015).create(CCompraService.class);
    }
    public static CaixaService getCaixaService(){
        return  Gestao.getClient(URL_016).create(CaixaService.class);
    }
    public static ContasService getContasService(){
        return  Gestao.getClient(URL_017).create(ContasService.class);
    }
    public static ContasMovimentoService getContasMovimentoService(){
        return  Gestao.getClient(URL_018).create(ContasMovimentoService.class);
    }
    public static ResumoCaixaService getResumoCaixaService(){
        return  Gestao.getClient(URL_019).create(ResumoCaixaService.class);
    }
}
