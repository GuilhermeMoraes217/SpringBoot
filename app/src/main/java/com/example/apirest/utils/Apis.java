package com.example.apirest.utils;

public class Apis {

    //public static final String URL_001="http://10.0.0.100:8080/personas/"; // PC DO MEGAZORD
    //public static final String URL_001="http://10.0.0.106:8080/personas/"; // PC DA SIGTEC INFORMATICA
    public static final String URL_001="http://192.168.42.103:8080/personas/"; //http://localhost:8080/personas/listar

    public static PersonaService getPersonaService(){
        return  Cliente.getClient(URL_001).create(PersonaService.class);
    }

}
