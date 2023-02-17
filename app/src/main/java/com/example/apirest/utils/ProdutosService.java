package com.example.apirest.utils;

import com.example.apirest.model.Persona;
import com.example.apirest.model.Produtos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProdutosService {

    @GET("listarProdutosService")
    Call<List<Produtos>> getProdutosService();

    @POST("agregar")
    Call<Produtos>addPersona(@Body Produtos produtos);

    @POST("actualizar/{ID}")
    Call<Produtos>updatePersona(@Body Produtos produtos,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<Produtos>deletePersona(@Path("ID")int id);

}
