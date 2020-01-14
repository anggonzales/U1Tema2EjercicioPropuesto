package com.example.u1tema2ejerciciopropuesto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class menu1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu1, menu);
        return true; /** true -> el menú ya está visible */
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Salir) {
            //finish();
            startActivity(new Intent(this, Permisos.class));
            return true;
        }

        if (id == R.id.activity_registrar) {
            startActivity(new Intent(this, menu2.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
