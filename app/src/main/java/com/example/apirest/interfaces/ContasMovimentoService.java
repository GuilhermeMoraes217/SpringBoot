package com.example.apirest.interfaces;

import com.example.apirest.model.checkout.Caixa;
import com.example.apirest.model.checkout.ContasMovimento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ContasMovimentoService {

    @GET("listarcontasmovimento")
    Call<List<ContasMovimento>> getContasMovimento();

    @POST("agregar")
    Call<ContasMovimento>addPersona(@Body ContasMovimento contasMovimento);

    @POST("actualizar/{ID}")
    Call<ContasMovimento>updatePersona(@Body ContasMovimento contasMovimento,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<ContasMovimento>deletePersona(@Path("ID")int id);

}
