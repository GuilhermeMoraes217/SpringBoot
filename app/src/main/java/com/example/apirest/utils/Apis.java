package com.example.apirest.utils;

public class Apis {

    public static final String URL_001="http://192.168.1.109:8080/personas/"; // PC DA SIGTEC INFORMATICA

    public static PersonaService getPersonaService(){
        return  Cliente.getClient(URL_001).create(PersonaService.class);
    }

}
