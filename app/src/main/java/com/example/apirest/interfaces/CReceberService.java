package com.example.apirest.interfaces;

import com.example.apirest.model.contas.CPagar;
import com.example.apirest.model.contas.CReceber;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CReceberService {

    @GET("listarCreceber")
    Call<List<CReceber>> getrebecer();

    @POST("agregar")
    Call<CReceber>addPersona(@Body CReceber cReceber);

    @POST("actualizar/{ID}")
    Call<CReceber>updatePersona(@Body CReceber cReceber,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<CReceber>deletePersona(@Path("ID")int id);

}
