package com.example.ejercicio_app.api;

import com.example.ejercicio_app.entity.Autor;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServiceAutorApi {

    //GET ==> LISTA

    @GET ("autor")
    public abstract  Call<List<Autor>> listaAutor();

    @GET ("autor/{id}")
    public abstract  Call<Optional<Autor>> buscarAutor(String id);


    //POST --> INSERTAR

    @POST("autor")
    public abstract Call<Autor> insertaAutor(@Body Autor obj);


    //PUT ..> ACTUALIZAR
    @PUT("autor")
    public abstract Call<Autor> actualizaAutor(@Body Autor obj);

    //DELTE --> ELIMINAR

    @DELETE("autor/{id}")
    public  abstract Call<Autor> eliminaAutor(@Path("id")String id);


}