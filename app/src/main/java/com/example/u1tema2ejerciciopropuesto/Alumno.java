package com.example.u1tema2ejerciciopropuesto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;



public class Alumno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);
    }

    public void maps(View view) {



    }

    public void mapas(View view) {
        /*Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:-18.013739816,-70.2510593169"));
        startActivity(intent);*/
        startActivity(new Intent(this, Permisos.class));


    }

    public void foto(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }
}
