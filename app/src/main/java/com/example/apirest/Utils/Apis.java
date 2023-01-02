package com.example.apirest.Utils;

public class Apis {

    //public static final String URL_001="http://192.168.0.106:8080/personas/";
    //public static final String URL_001="http://192.168.0.101:8080/personas/"; // PC DA SIGTEC INFORMATICA
    //public static final String URL_001="http://DESKTOP-3QJAEDO:8080/personas/"; // PC DA SIGTEC INFORMATICA
    public static final String URL_001="http://10.0.0.102:8080/personas/"; // PC DA SIGTEC INFORMATICA

    /*
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/bd_web_aplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=
     */
    //public static final String URL_001="http://192.168.0.101:8080/personas/"; // PC DA SIGTEC INFORMATICA
    public static final String URL_001="http://10.0.0.100:8080/personas/"; // PC DO MEGAZORD


    public static PersonaService getPersonaService(){
        return  Cliente.getClient(URL_001).create(PersonaService.class);
    }

}
