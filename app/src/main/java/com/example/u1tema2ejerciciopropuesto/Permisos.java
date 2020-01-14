package com.example.u1tema2ejerciciopropuesto;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Permisos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permiso);
        if ((ContextCompat.checkSelfPermission(Permisos.this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                &&
                (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)) {
            arranque();
            registrado();
        } else {
            Handler handler = new Handler();
            handler.postDelayed(
                    new Runnable() {
                        public void run() {
                            if ((ContextCompat.checkSelfPermission(Permisos.this,
                                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) &&
                                    (ContextCompat.checkSelfPermission(Permisos.this,
                                            Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)) {
                                //permisocamara();
                            } else {
                                solicitarPermiso(Manifest.permission.ACCESS_FINE_LOCATION,
                                        "Sin el permiso" + " de ubicación no se puede logear.", 0);
                                solicitarPermiso(Manifest.permission.CAMERA,
                                        "Sin el permiso" + " de camara no se puede logear.", 1);
                            }
                        }
                    }, 2000L);
        }
    }

    public void solicitarPermiso(final String permiso, String justificacion, final int codigo) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permiso)) {
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Solicitud de permiso");
            dialogo1.setMessage(justificacion);
            dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    ActivityCompat.requestPermissions(Permisos.this, new String[]{permiso}, codigo);
                }
            });
            dialogo1.show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{permiso}, codigo);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permisolocalizacion();
            } else {
                solicitarPermiso(Manifest.permission.ACCESS_FINE_LOCATION,
                        "Sin el permiso" + " de ubicación no podemos localizarte.", 0);
            }
        }
        if (requestCode == 1) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permisocamara();
            } else {
                solicitarPermiso(Manifest.permission.CAMERA,
                        "Sin el permiso" + " de camara no podremos guardar tu información", 1);
            }
        }
    }

    void arranque() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("FELICITACIONES");
        dialogo1.setMessage("Usted ya tiene los permisos necesarios para usar nuestra app");
        dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                finish();
            }
        });
        dialogo1.show();
    }

    void registrado() {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

        builder1.setNeutralButton("Ver", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Uri gmmIntentUri;
                gmmIntentUri = Uri.parse("google.navigation:q=" + -18.005124 + "," + -70.235074);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(mapIntent);
                else
                    Toast.makeText(Permisos.this, "Maps no esta instalado", Toast.LENGTH_LONG).show();
            }
        });

        builder1.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });

        builder1.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                return;
            }
        });

        builder1.show();
    }


    void permisolocalizacion() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

        } else {
            solicitarPermiso(Manifest.permission.ACCESS_FINE_LOCATION,
                    "Sin el permiso" + " de ubicacion no podremos localizarte", 1);
        }
    }

    void permisocamara() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {

        } else {
            solicitarPermiso(Manifest.permission.CAMERA,
                    "Sin el permiso" + " de la camara no podremos guardar su informacion", 1);
        }
    }
}
