package com.example.u1tema2ejerciciopropuesto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class item extends AppCompatActivity {

    EditText edttitulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

    }

    public void Verificar(View view){
        Intent intent = new Intent(this, multimedia.class);
        intent.putExtra("nombre", edttitulo.getText().toString());
        startActivity(intent);
    }

    public void Ver(){
        /*Intent intent = new Intent(this, multimedia.class);
        intent.putExtra("nombre", titulo);
        startActivity(intent);*/
        startActivity(new Intent(this, multimedia.class));
    }

}
