package com.example.apirest.utils;

import com.example.apirest.model.vendas.VendasMaster;

public class Apis {

    public static final String URL_001="http://192.168.1.110:8080/personas/"; // Notebook
    public static final String URL_002="http://192.168.1.110:8080/vendasMaster/"; // Notebook

    public static PersonaService getPersonaService(){
        return  Cliente.getClient(URL_001).create(PersonaService.class);
    }

    public static VendasMasterService getVendasMasterService(){
        return  Cliente.getClient(URL_002).create(VendasMasterService.class);
    }

}
