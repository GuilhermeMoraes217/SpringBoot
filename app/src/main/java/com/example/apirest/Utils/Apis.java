package com.example.apirest.Utils;

public class Apis {

    //public static final String URL_001="http://192.168.0.106:8080/personas/";
    //public static final String URL_001="http://192.168.0.101:8080/personas/"; // PC DA SIGTEC INFORMATICA
    //public static final String URL_001="http://DESKTOP-3QJAEDO:8080/personas/"; // PC DA SIGTEC INFORMATICA
    //public static final String URL_001="http://10.0.0.100:8080/personas/"; // PC DO MEGAZORD
    //public static final String URL_001="http://10.0.0.106:8080/personas/"; // PC DA SIGTEC INFORMATICA
    public static final String URL_001="http://192.168.42.103:8080/personas/"; // celular


    public static PersonaService getPersonaService(){
        return  Cliente.getClient(URL_001).create(PersonaService.class);
    }

}
