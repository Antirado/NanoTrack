package com.example.at.nanotrack;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Alarma extends AppCompatActivity implements View.OnClickListener {

    EditText EtVelocidad, EtDistancia;
    Button btnVelocidad, btnDistancia;
    Spinner spinnerDist, spinnerVel;

    SmsManager smsManager = SmsManager.getDefault();
    private static Alarma inst;

    public static Alarma instance() {
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
        Preferences.setCurrentActivity(Alarma.this, "3");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarma);

        //Instanciate
        EtDistancia = (EditText) findViewById(R.id.ETdistancia);
        EtVelocidad = (EditText) findViewById(R.id.ETvelocidad);
        btnDistancia = (Button) findViewById(R.id.distancia);
        btnVelocidad = (Button) findViewById(R.id.velocidad);
        spinnerDist = (Spinner) findViewById(R.id.spinnerDistancia);
        spinnerVel = (Spinner) findViewById(R.id.spinnerVelocidad);

        //Temporal
        EtDistancia.setVisibility(View.INVISIBLE);
        EtVelocidad.setVisibility(View.INVISIBLE);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.distancia:
                if(spinnerDist.getSelectedItem().toString().equals("Activar")){
                    smsManager.sendTextMessage(Preferences.getTracker(Alarma.this),
                            null,
                            "MOVE" + Preferences.getTrackerPassword(Alarma.this)
                                    + " "
                                    + Preferences.getDistanciaAutorizada(Alarma.this),
                            null,
                            null);
                } else {
                    smsManager.sendTextMessage(Preferences.getTracker(Alarma.this),
                            null,
                            "NOMOVE" + Preferences.getTrackerPassword(Alarma.this),
                            null,
                            null);
                }
                break;

            case R.id.velocidad:
                if(spinnerVel.getSelectedItem().toString().equals("Activar")){
                    smsManager.sendTextMessage(Preferences.getTracker(Alarma.this),
                            null,
                            "SPEED" + Preferences.getTrackerPassword(Alarma.this)
                                    + " "
                                    + Preferences.getVelocidadMaxima(Alarma.this),
                            null,
                            null);
                } else {
                    smsManager.sendTextMessage(Preferences.getTracker(Alarma.this),
                            null,
                            "NOSPEED" + Preferences.getTrackerPassword(Alarma.this),
                            null,
                            null);
                }
                break;
            default:
                break;
        }
    }

    public void updateInbox(final String address, final String smsBody) {

        //deleteSMS(MainActivity.this, smsBody, address);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                Alarma.this);

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
