package com.example.apirest.interfaces;

import com.example.apirest.model.Grupos;
import com.example.apirest.model.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GruposService {

    @GET("listargrupos")
    Call<List<Grupos>> getGrupos();

    @POST("agregar")
    Call<Grupos>addPersona(@Body Grupos grupos);

    @POST("actualizar/{ID}")
    Call<Grupos>updatePersona(@Body Grupos grupos,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<Grupos>deletePersona(@Path("ID")int id);

}
