package com.example.apirest.interfaces;

import com.example.apirest.model.Persona;
import com.example.apirest.model.contas.CCompra;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CCompraService {

    @GET("listarCcompra")
    Call<List<CCompra>> getCcompra();

    @POST("agregar")
    Call<CCompra>addPersona(@Body Persona persona);

    @POST("actualizar/{ID}")
    Call<CCompra>updatePersona(@Body Persona persona,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<CCompra>deletePersona(@Path("ID")int id);

}
