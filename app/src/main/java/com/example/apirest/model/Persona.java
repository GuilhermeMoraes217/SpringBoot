package com.example.apirest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Persona {

    @SerializedName(value = "id", alternate = "ID")
    @Expose
    private int id;

    @SerializedName(value = "nombres", alternate = "NOMBRES")
    @Expose
    private String nombres;

    @SerializedName(value = "apellidos", alternate = "APELLIDOS")
    @Expose
    private String apellidos;

    public  Persona(){

    }

    public Persona(int id, String nombres, String apellidos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
