package com.example.ejercicio_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ejercicio_app.adapter.AutorAdapter;
import com.example.ejercicio_app.api.ServiceAutorApi;
import com.example.ejercicio_app.entity.Autor;
import com.example.ejercicio_app.util.ConnectionRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AutorCrudListaActivity extends AppCompatActivity {

    List<Autor> lstData = new ArrayList<Autor>();
    AutorAdapter adaptador = null;
    ListView lstView = null;
    ServiceAutorApi api=null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor_crud_lista);

        lstView= findViewById(R.id.idCrudAutorList);

        adaptador = new AutorAdapter(this, R.layout.activity_autor_crud_item,lstData);
        lstView.setAdapter(adaptador);
        api = ConnectionRest.getConnection().create(ServiceAutorApi.class);


        lista();


    }

    public void lista(){
        mensaje("LOG -> En metodo lista 1");

       Call<List<Autor>>  call = api.listaAutor();
       call.enqueue(new Callback<List<Autor>>() {
           @Override
           public void onResponse(Call<List<Autor>> call, Response<List<Autor>> response) {
               mensaje("LOG -> En metodo lista 2");
               if (response.isSuccessful()) {
                   mensaje("LOG -> En metodo lista 3");
                   List<Autor> lista = response.body();

                   lstData.clear();
                   lstData.addAll(lista);

                   adaptador.notifyDataSetChanged();


               } else {
                   mensaje("ERROR -> " + "Error en la respuesta");
               }
           }



           @Override
           public void onFailure(Call<List<Autor>> call, Throwable t) {


               mensaje("ERROR -> " +   t.getMessage());

           }
       });
    }



    void mensaje(String msg){

       Toast toast1 = Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG);
       toast1.show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.activity_menu,menu);
        return   true;
    }

    @Override

    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        int id= item.getItemId();

        if(id== R.id.idMenuCrudAutor){
            return  true;
        }

        if ( id == R.id.idMenuCrudAutor){

            Intent intent = new Intent(this,AutorCrudListaActivity.class);
            startActivity(intent);

            return  true;

        }
        return super.onOptionsItemSelected(item);
    }


}