package com.example.apirest.interfaces;

import com.example.apirest.model.contas.CPagar;
import com.example.apirest.model.contas.CRecebimento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CRecebimentoService {

    @GET("listarCrecebimento")
    Call<List<CRecebimento>> getPersonas();

    @POST("agregar")
    Call<CRecebimento>addPersona(@Body CRecebimento cRecebimento);

    @POST("actualizar/{ID}")
    Call<CRecebimento>updatePersona(@Body CRecebimento cRecebimento,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<CRecebimento>deletePersona(@Path("ID")int id);

}
