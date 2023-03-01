package com.example.apirest.interfaces;

import com.example.apirest.model.contas.CPagar;
import com.example.apirest.model.contas.Pessoas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PessoasService {

    @GET("listarPessoas")
    Call<List<Pessoas>> getPersonas();

    @POST("agregar")
    Call<Pessoas>addPersona(@Body Pessoas pessoas);

    @POST("actualizar/{ID}")
    Call<Pessoas>updatePersona(@Body Pessoas pessoas,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<Pessoas>deletePersona(@Path("ID")int id);

}
