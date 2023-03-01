package com.example.apirest.interfaces;

import com.example.apirest.model.vendas.FormaPagamento;
import com.example.apirest.model.vendas.Vendasfpg;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FormaPagamentoService {

    @GET("listarFormapagamento")
    Call<List<FormaPagamento>>  getFormaPagamento();

    @POST("agregar")
    Call<FormaPagamento>addPersona(@Body FormaPagamento formaPagamento);

    @POST("actualizar/{ID}")
    Call<FormaPagamento>updatePersona(@Body FormaPagamento formaPagamento,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<FormaPagamento>deletePersona(@Path("ID")int id);

}
