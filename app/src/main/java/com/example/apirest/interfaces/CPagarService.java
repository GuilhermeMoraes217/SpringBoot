package com.example.apirest.interfaces;

import com.example.apirest.model.Persona;
import com.example.apirest.model.contas.CPagar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CPagarService {

    @GET("listarCpagar")
    Call<List<CPagar>> getPersonas();

    @POST("agregar")
    Call<CPagar>addPersona(@Body CPagar cPagar);

    @POST("actualizar/{ID}")
    Call<CPagar>updatePersona(@Body CPagar cPagar,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<CPagar>deletePersona(@Path("ID")int id);

}
