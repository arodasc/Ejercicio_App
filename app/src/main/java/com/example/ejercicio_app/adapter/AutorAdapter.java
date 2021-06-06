package com.example.ejercicio_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ejercicio_app.R;
import com.example.ejercicio_app.entity.Autor;

import java.util.List;

public class AutorAdapter extends ArrayAdapter<Autor> {

private Context contex;
private List<Autor> lista;

    public AutorAdapter(@NonNull Context context, int resource,
                        @NonNull List<Autor> lista) {
        super(context, resource, lista);

        this.contex= context;
        this.lista= lista;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)contex.getSystemService(contex.LAYOUT_INFLATER_SERVICE);
        View row= inflater.inflate(R.layout.activity_autor_crud_item,parent, false);

        Autor obj = lista.get(position);

        TextView txtNombre = row.findViewById(R.id.idItemCrudAutorNombre);
        txtNombre.setText(obj.getNombres());



        return row;



    }
}
