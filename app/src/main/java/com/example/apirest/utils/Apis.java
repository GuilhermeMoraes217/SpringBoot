package com.example.apirest.utils;

import com.example.apirest.model.vendas.VendasMaster;

public class Apis {

    // 10.0.0.132 LABEX
    // 192.168.1.107 SIGATEC
    // 10.0.0.126 Casa - notebook
    // 10.0.0.100 Casa - desktop
    public static final String URL_001="http://192.168.1.107:8080/personas/";
    public static final String URL_002="http://192.168.1.107:8080/vendasmaster/";
    public static final String URL_003="http://192.168.1.107:8080/vendasformapagamento/";
    public static final String URL_004="http://192.168.1.107:8080/formapagamento/";
    public static final String URL_005="http://192.168.1.107:8080/empresas/";
    public static final String URL_006="http://192.168.1.107:8080/vendasdetalhes/";
    public static final String URL_007="http://192.168.1.107:8080/produtos/";
    public static final String URL_008="http://192.168.1.107:8080/grupos/";

    public static PersonaService getPersonaService(){
        return  Cliente.getClient(URL_001).create(PersonaService.class);
    }

    public static VendasMasterService getVendasMasterService(){
        return  Cliente.getClient(URL_002).create(VendasMasterService.class);
    }

    public static VendasfpgService getVendasfpgService(){
        return  Cliente.getClient(URL_003).create(VendasfpgService.class);
    }

    public static FormaPagamentoService getFormaPagamentoService(){
        return  Cliente.getClient(URL_004).create(FormaPagamentoService.class);
    }

    public static EmpresasService getEmpresasService(){
        return  Cliente.getClient(URL_005).create(EmpresasService.class);
    }

    public static VendasDetalhesService getVendasDetalhesService(){
        return  Cliente.getClient(URL_006).create(VendasDetalhesService.class);
    }

    public static ProdutosService getProdutos(){
        return  Cliente.getClient(URL_007).create(ProdutosService.class);
    }

    public static GruposService getGruposService(){
        return  Cliente.getClient(URL_008).create(GruposService.class);
    }


}
