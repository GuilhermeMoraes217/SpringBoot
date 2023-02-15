package com.example.apirest.utils;

import com.example.apirest.model.vendas.VendasMaster;

public class Apis {

    // 10.0.0.132 LABEX
    // 192.168.1.104 SIGATEC
    public static final String URL_001="http://10.0.0.132:8080/personas/"; // Notebook
    public static final String URL_002="http://10.0.0.132:8080/vendasmaster/"; // Notebook
    public static final String URL_003="http://10.0.0.132:8080/vendasformapagamento/"; // Notebook
    public static final String URL_004="http://10.0.0.132:8080/formapagamento/"; // Notebook

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


}
