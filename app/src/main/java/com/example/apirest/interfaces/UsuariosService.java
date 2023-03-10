package com.example.apirest.interfaces;

import com.example.apirest.model.checkout.Usuarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UsuariosService {

    @GET("listarusuarios")
    Call<List<Usuarios>> getUsuarios();

    @POST("agregar")
    Call<Usuarios>addPersona(@Body Usuarios usuarios);

    @POST("actualizar/{ID}")
    Call<Usuarios>updatePersona(@Body Usuarios usuarios,@Path("ID") int id);

    @POST("eliminar/{ID}")
    Call<Usuarios>deletePersona(@Path("ID")int id);

}
