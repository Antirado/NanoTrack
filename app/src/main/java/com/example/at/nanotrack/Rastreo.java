package com.example.at.nanotrack;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Rastreo extends AppCompatActivity implements View.OnClickListener {

    Button btnRastreo, btnCambioDir, btnDesactivar;
    Spinner spinnerRastreo;

    SmsManager smsManager = SmsManager.getDefault();
    private static Rastreo inst;

    public static Rastreo instance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    public void onResume() {
        super.onResume();
        Preferences.setCurrentActivity(Rastreo.this, "2");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rastreo);

        //Instance
        btnRastreo = (Button) findViewById(R.id.rastreo);
        btnCambioDir = (Button) findViewById(R.id.cambioDir);
        btnDesactivar = (Button) findViewById(R.id.desactRastreo);
        spinnerRastreo = (Spinner) findViewById(R.id.spinnerRastreo);

        //Set Listeners
        btnRastreo.setOnClickListener(this);
        btnCambioDir.setOnClickListener(this);
        btnDesactivar.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.rastreo:
                if(spinnerRastreo.getSelectedItem().toString().equals("Limitado")){
                    smsManager.sendTextMessage(Preferences.getTracker(Rastreo.this),
                            null,
                            "FIX" + Preferences.getTiempoRastreoPrendido(Rastreo.this)
                                    + "S"
                                    + Preferences.getRepeticionRastreo(Rastreo.this)
                                    + "N"
                                    + Preferences.getTrackerPassword(Rastreo.this),
                            null,
                            null);
                } else {
                    smsManager.sendTextMessage(Preferences.getTracker(Rastreo.this),
                            null,
                            "DISTANCE" + Preferences.getTrackerPassword(Rastreo.this)
                                    + " "
                                    + Preferences.getDistanciaAutorizada(Rastreo.this),
                            null,
                            null);
                }
                Toast.makeText(this, "Mensaje enviado!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cambioDir:
                smsManager.sendTextMessage(Preferences.getTracker(Rastreo.this),
                        null,
                        "ANGLE" + Preferences.getTrackerPassword(Rastreo.this)
                                + " "
                                + Preferences.getAngulo(Rastreo.this),
                        null,
                        null);
                Toast.makeText(this, "Mensaje enviado!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.desactRastreo:
                smsManager.sendTextMessage(Preferences.getTracker(Rastreo.this),
                        null,
                        "NOFIX" + Preferences.getTrackerPassword(Rastreo.this),
                        null,
                        null);
                Toast.makeText(this, "Mensaje enviado!", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    public void updateInbox(final String address, final String smsBody) {

        //deleteSMS(MainActivity.this, smsBody, address);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                Rastreo.this);

        // set title
        alertDialogBuilder.setTitle("Notificación NanoTrack");

        // set dialog message
        alertDialogBuilder
                .setMessage(smsBody)
                .setCancelable(true)
                .setPositiveButton("Aceptar",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }
}
