package com.example.apirest.interfaces;

import com.example.apirest.model.checkout.Caixa;
import com.example.apirest.model.checkout.Contas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ContasService {

    @GET("listarconta")
    Call<List<Contas>> getContas();

    @POST("agregar")
    Call<Contas>addPersona(@Body Contas contas);

    @POST("actualizar/{ID}")
    Call<Contas>updatePersona(@Body Contas contas,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<Contas>deletePersona(@Path("ID")int id);

}
