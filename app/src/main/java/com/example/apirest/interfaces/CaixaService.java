package com.example.apirest.interfaces;

import com.example.apirest.model.Persona;
import com.example.apirest.model.checkout.Caixa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CaixaService {

    @GET("listarcaixa")
    Call<List<Caixa>> getCaixa();

    @POST("agregar")
    Call<Caixa>addPersona(@Body Caixa caixa);

    @POST("actualizar/{ID}")
    Call<Caixa>updatePersona(@Body Caixa caixa,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<Caixa>deletePersona(@Path("ID")int id);

}
