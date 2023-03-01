package com.example.apirest.interfaces;

import com.example.apirest.model.contas.CPagamento;
import com.example.apirest.model.contas.CPagar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CPagamentoService {

    @GET("listarCpagamento")
    Call<List<CPagamento>> getpagamento();

    @POST("agregar")
    Call<CPagamento>addPersona(@Body CPagamento cPagamento);

    @POST("actualizar/{ID}")
    Call<CPagamento>updatePersona(@Body CPagamento cPagamento,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<CPagamento>deletePersona(@Path("ID")int id);

}
