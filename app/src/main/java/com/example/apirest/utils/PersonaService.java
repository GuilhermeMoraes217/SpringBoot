package com.example.apirest.utils;

import com.example.apirest.model.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PersonaService {

    @GET("listar")
    Call<List<Persona>> getPersonas();

    @POST("agregar")
    Call<Persona>addPersona(@Body Persona persona);

    @POST("actualizar/{ID}")
    Call<Persona>updatePersona(@Body Persona persona,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<Persona>deletePersona(@Path("ID")int id);

}
