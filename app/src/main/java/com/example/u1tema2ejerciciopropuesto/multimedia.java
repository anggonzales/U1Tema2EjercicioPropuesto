package com.example.u1tema2ejerciciopropuesto;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class multimedia extends AppCompatActivity {
    MediaPlayer mp;
    TextView txtmensaje;
    String titulo;
    int posicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);
        Bundle extras = getIntent().getExtras();
        titulo = extras.getString("nombre");
        txtmensaje=findViewById(R.id.txtcancion);
        txtmensaje.setText("Nombre : " + titulo);

    }

    public void destruir() {
        if(mp!=null)
            mp.release();
    }

    public void iniciar(View v){
        destruir();
        mp = MediaPlayer.create(this, R.raw.cancion);
        mp.start();
    }

    public void pausar(View v){
        if(mp!=null && mp.isPlaying()){
            posicion = mp.getCurrentPosition();
            mp.pause();
        }
    }

    public void continuar(View v){
        if(mp !=null && mp.isPlaying() == false){
            mp.seekTo(posicion);
            mp.start();
        }
    }

    public void detener(View v){
        if(mp !=null){
            posicion = 0;
            mp.start();
        }
    }
}
