package com.example.apirest.interfaces;

import com.example.apirest.model.Persona;
import com.example.apirest.model.vendas.VendasDetalhes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VendasDetalhesService {

    @GET("listarVendasDetalhes")
    Call<List<VendasDetalhes>> getVendasDetalhes();

    @POST("agregar")
    Call<VendasDetalhes>addPersona(@Body VendasDetalhes vendasDetalhes);

    @POST("actualizar/{ID}")
    Call<VendasDetalhes>updatePersona(@Body VendasDetalhes vendasDetalhes,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<VendasDetalhes>deletePersona(@Path("ID")int id);

}
