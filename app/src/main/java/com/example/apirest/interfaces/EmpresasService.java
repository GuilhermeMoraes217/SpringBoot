package com.example.apirest.interfaces;

import com.example.apirest.model.Empresas;
import com.example.apirest.model.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EmpresasService {

    @GET("listarEmpresas")
    Call<List<Empresas>> getEmpresas();

    @POST("agregar")
    Call<Empresas>addPersona(@Body Empresas empresas);

    @POST("actualizar/{ID}")
    Call<Empresas>updatePersona(@Body Empresas empresas,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<Empresas>deletePersona(@Path("ID")int id);

}
