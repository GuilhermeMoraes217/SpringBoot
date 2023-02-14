package com.example.apirest.utils;

import com.example.apirest.model.Persona;
import com.example.apirest.model.vendas.VendasMaster;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VendasMasterService {

    @GET("listarVendas")
    Call<List<VendasMaster>>  getVendasMaster();

    @POST("agregar")
    Call<VendasMaster>addPersona(@Body VendasMaster vendasMaster);

    @POST("actualizar/{ID}")
    Call<VendasMaster>updatePersona(@Body VendasMaster vendasMaster,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<VendasMaster>deletePersona(@Path("ID")int id);

}
