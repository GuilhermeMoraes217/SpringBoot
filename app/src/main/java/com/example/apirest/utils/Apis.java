package com.example.apirest.utils;

public class Apis {

    public static final String URL_001="http://192.168.1.110:8080/personas/"; // Notebook

    public static PersonaService getPersonaService(){
        return  Cliente.getClient(URL_001).create(PersonaService.class);
    }

}
