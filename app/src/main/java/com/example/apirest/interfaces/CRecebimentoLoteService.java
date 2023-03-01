package com.example.apirest.interfaces;

import com.example.apirest.model.contas.CPagar;
import com.example.apirest.model.contas.CRecebimentoLote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CRecebimentoLoteService {

    @GET("listarCrecebimentolote")
    Call<List<CRecebimentoLote>> getPersonas();

    @POST("agregar")
    Call<CRecebimentoLote>addPersona(@Body CRecebimentoLote cRecebimentoLote);

    @POST("actualizar/{ID}")
    Call<CRecebimentoLote>updatePersona(@Body CRecebimentoLote cRecebimentoLote,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<CRecebimentoLote>deletePersona(@Path("ID")int id);

}
