package com.example.u1tema2ejerciciopropuesto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class Adaptador extends
        RecyclerView.Adapter<Adaptador.ViewHolder> {
    private LayoutInflater inflador;
    private Vector<String> lista;
    Context micontext;

    public Adaptador(Context context, Vector<String> lista) {
        this.lista = lista;
        micontext=context;
        inflador = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflador.inflate(R.layout.activity_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(micontext, multimedia.class);
                    intent.putExtra("nombre", holder.titulo.getText());
                    micontext.startActivity(intent);

                //((Controlmultimedia) micontext).mensaje("El elemento de la posición: " + i + " Su valor es: " + lista.get(i));
            }
        });
        holder.titulo.setText(lista.get(i));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titulo, subtitutlo;
        public ImageView icon;
        ViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView)itemView.findViewById(R.id.txttitulo);
            subtitutlo = (TextView)itemView.findViewById(R.id.subtitulo);
            icon = (ImageView)itemView.findViewById(R.id.icono);
        }
    }
}
