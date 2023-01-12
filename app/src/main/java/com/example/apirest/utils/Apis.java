package com.example.apirest.utils;

public class Apis {

    //public static final String URL_001="http://10.0.0.100:8080/personas/"; // PC DO MEGAZORD
    //public static final String URL_001="http://10.0.0.106:8080/personas/"; // PC DA SIGTEC INFORMATICA
    public static final String URL_001="http://192.168.1.104:8080/personas/"; //192.168.1.104 192.168.1.104

    public static PersonaService getPersonaService(){
        return  Cliente.getClient(URL_001).create(PersonaService.class);
    }

}
