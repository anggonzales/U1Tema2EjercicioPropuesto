package com.example.u1tema2ejerciciopropuesto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void escucharCancion(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    public void Login(View view) {
        startActivity(new Intent(this, menu1.class));
    }
}
