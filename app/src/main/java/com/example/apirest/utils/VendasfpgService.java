package com.example.apirest.utils;

import com.example.apirest.model.vendas.VendasMaster;
import com.example.apirest.model.vendas.Vendasfpg;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VendasfpgService {

    @GET("listarVendasfpgService")
    Call<List<Vendasfpg>>  getVendasfpg();

    @POST("agregar")
    Call<Vendasfpg>addPersona(@Body Vendasfpg vendasfpg);

    @POST("actualizar/{ID}")
    Call<Vendasfpg>updatePersona(@Body Vendasfpg vendasfpg,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<Vendasfpg>deletePersona(@Path("ID")int id);

}
