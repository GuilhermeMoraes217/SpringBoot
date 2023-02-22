package com.example.apirest.utils;

import com.example.apirest.model.vendas.VendasMaster;

public class Apis {

    // 10.0.0.132 LABEX
    // 192.168.1.109 SIGATEC 192.168.1.104
    // 10.0.0.126 Casa - notebook
    // 10.0.0.100 Casa - desktop
    public static final String URL_001="http://192.168.1.109:8080/personas/"; // Notebook
    public static final String URL_002="http://192.168.1.109:8080/vendasmaster/"; // Notebook
    public static final String URL_003="http://192.168.1.109:8080/vendasformapagamento/"; // Notebook
    public static final String URL_004="http://192.168.1.109:8080/formapagamento/"; // Notebook
    public static final String URL_005="http://192.168.1.109:8080/empresas/"; // Notebook
    public static final String URL_006="http://192.168.1.109:8080/vendasdetalhes/"; // Notebook
    public static final String URL_007="http://192.168.1.109:8080/produtos/"; // Notebook

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


}
