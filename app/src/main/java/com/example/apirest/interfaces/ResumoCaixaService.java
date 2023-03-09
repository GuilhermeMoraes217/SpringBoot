package com.example.apirest.interfaces;

import com.example.apirest.model.checkout.Caixa;
import com.example.apirest.model.checkout.ResumoCaixa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ResumoCaixaService {

    @GET("listarresumocaixa")
    Call<List<ResumoCaixa>> getResumoCaixa();

    @POST("agregar")
    Call<ResumoCaixa>addPersona(@Body ResumoCaixa resumoCaixa);

    @POST("actualizar/{ID}")
    Call<ResumoCaixa>updatePersona(@Body ResumoCaixa resumoCaixa,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<ResumoCaixa>deletePersona(@Path("ID")int id);

}
