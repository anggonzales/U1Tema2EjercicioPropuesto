package com.example.u1tema2ejerciciopropuesto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.Vector;

public class Main2Activity extends AppCompatActivity implements Controlmultimedia {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Adaptador adaptador;
    private Vector<String> misdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recycler_view);
        misdatos = new Vector<String>();
        misdatos.add("Canción 1");
        misdatos.add("Canción 2");
        misdatos.add("Canción 3");
        misdatos.add("Canción 4");
        misdatos.add("Canción 5");
        misdatos.add("Canción 6");
        misdatos.add("Canción 7");
        misdatos.add("Canción 8");
        misdatos.add("Canción 9");
        misdatos.add("Canción 10");
        misdatos.add("Canción 11");
        misdatos.add("Canción 12");
        misdatos.add("Canción 13");
        misdatos.add("Canción 14");
        misdatos.add("Canción 15");
        misdatos.add("Canción 16");
        misdatos.add("Canción 17");
        misdatos.add("Canción 18");
        misdatos.add("Canción 19");
        misdatos.add("Canción 20");
        adaptador = new Adaptador(this,
                misdatos);
        recyclerView.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void mensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }
}
