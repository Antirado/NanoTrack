package com.example.at.nanotrack;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLocalizar, btnBloqueo, btnModoEst, btnEstado, btnAlarmas, btnRastreo, btnAjustes, btnReset;
    private static final int READ_SMS_PERMISSIONS_REQUEST = 1;
    SmsManager smsManager = SmsManager.getDefault();
    private static MainActivity inst;
    Spinner spinnerBloqueo, spinnerModoEst;

    public static MainActivity instance() {
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
        Preferences.setCurrentActivity(MainActivity.this, "1");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting preferences
        Preferences.setUsername(MainActivity.this, "Andres Tirado");
        Preferences.setTracker(MainActivity.this, "+584144199040");
        Preferences.setTrackerPassword(MainActivity.this, "-PASSWORD-");
        Preferences.setAngulo(MainActivity.this, "-Angulo-");
        Preferences.setDistanciaAutorizada(MainActivity.this, "-DistAut-");
        Preferences.setRepeticionAlarma(MainActivity.this, "-RepAlarma-");
        Preferences.setRepeticionRastreo(MainActivity.this, "-RepRastreo-");
        Preferences.setSensibilidad(MainActivity.this, "-Sensibilidad-");
        Preferences.setTiempoRastreoApagado(MainActivity.this, "-TiempoRastreoApagado");
        Preferences.setTiempoRastreoPrendido(MainActivity.this, "-TiempoRastreoPrendido-");
        Preferences.setVelocidadMaxima(MainActivity.this, "-VelMax-");



        //Ask for permissions
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            getPermissionToReadSMS();
        }

        // Instance all buttons
        btnLocalizar = (Button) findViewById(R.id.localizar);
        btnBloqueo = (Button) findViewById(R.id.bloqueo);
        btnModoEst = (Button) findViewById(R.id.modoEst);
        btnEstado = (Button) findViewById(R.id.estado);
        btnAlarmas = (Button) findViewById(R.id.alarmas);
        btnRastreo = (Button) findViewById(R.id.rastreo);
        btnAjustes = (Button) findViewById(R.id.ajustes);
        btnReset = (Button) findViewById(R.id.reset);

        //Instance Spinner
        spinnerBloqueo = (Spinner) findViewById(R.id.spinnerBloqueo);
        spinnerModoEst = (Spinner) findViewById(R.id.spinnerModoEst);

        //Set Listeners
        btnLocalizar.setOnClickListener(this);
        btnBloqueo.setOnClickListener(this);
        btnModoEst.setOnClickListener(this);
        btnEstado.setOnClickListener(this);
        btnAlarmas.setOnClickListener(this);
        btnRastreo.setOnClickListener(this);
        btnAjustes.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.localizar:
                //Llamada al tracker!!!!

                break;

            case R.id.bloqueo:
                if(spinnerBloqueo.getSelectedItem().toString().equals("Activar")){
                    smsManager.sendTextMessage(Preferences.getTracker(MainActivity.this),
                            null,
                            "STOP" + Preferences.getTrackerPassword(MainActivity.this),
                            null,
                            null);
                }else {
                    smsManager.sendTextMessage(Preferences.getTracker(MainActivity.this),
                            null,
                            "RESUME" + Preferences.getTrackerPassword(MainActivity.this),
                            null,
                            null);
                }
                Toast.makeText(this, "Mensaje enviado!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.modoEst:
                if(spinnerModoEst.getSelectedItem().toString().equals("Activar")){
                    smsManager.sendTextMessage(Preferences.getTracker(MainActivity.this),
                            null,
                            "ARM" + Preferences.getTrackerPassword(MainActivity.this),
                            null,
                            null);
                }else {
                    smsManager.sendTextMessage(Preferences.getTracker(MainActivity.this),
                            null,
                            "DISARM" + Preferences.getTrackerPassword(MainActivity.this),
                            null,
                            null);
                }


                Toast.makeText(this, "Mensaje enviado!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.estado:
                smsManager.sendTextMessage(Preferences.getTracker(MainActivity.this),
                        null,
                        "CHECK" + Preferences.getTrackerPassword(MainActivity.this),
                        null,
                        null);
                Toast.makeText(this, "Mensaje enviado!", Toast.LENGTH_SHORT).show();

                break;

            case R.id.alarmas:
                Log.i("Boton", "Alarmas");
                Intent intentAlarma = new Intent(this, Alarma.class);
                startActivity(intentAlarma);
                break;

            case R.id.rastreo:
                Log.i("Boton", "Rastreo");
                Intent intentRastreo = new Intent(this, Rastreo.class);
                startActivity(intentRastreo);
                break;

            case R.id.ajustes:
                Log.i("Boton", "Ajustes");
                Intent intentAjustes = new Intent(this, Ajustes.class);
                startActivity(intentAjustes);
                break;

            case R.id.reset:
                smsManager.sendTextMessage(Preferences.getTracker(MainActivity.this),
                        null,
                        "RESET" + Preferences.getTrackerPassword(MainActivity.this),
                        null,
                        null);
                Toast.makeText(this, "Mensaje enviado!", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    public void updateInbox(final String address, final String smsBody) {

        deleteSMS(MainActivity.this, smsBody, address);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

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

    public void deleteSMS(Context context, String message, String number) {
        Log.i("SMS", "enter delete");
        try {
            Log.i("SMS","Deleting SMS from inbox");
            Uri uriSms = Uri.parse("content://sms/inbox");
            Cursor c = context.getContentResolver().query(uriSms,
                    new String[] { "_id", "thread_id", "address",
                            "person", "date", "body" }, null, null, null);

            if (c != null && c.moveToFirst()) {
                do {
                    long id = c.getLong(0);
                    long threadId = c.getLong(1);
                    String address = c.getString(2);
                    String body = c.getString(5);

                    if (message.equals(body) && address.equals(number)) {
                        Log.i("SMS","Deleting SMS with id: " + threadId);
                        context.getContentResolver().delete(
                                Uri.parse("content://sms/" + id), null, null);
                    }
                } while (c.moveToNext());
                c.close();
            }
        } catch (Exception e) {
            Log.i("SMS","Could not delete SMS from inbox: " + e.getMessage());
        }
    }

    public void getPermissionToReadSMS() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.READ_SMS)) {
                Toast.makeText(this, "Please allow permission!", Toast.LENGTH_SHORT).show();
            }
            requestPermissions(new String[]{Manifest.permission.READ_SMS},
                    READ_SMS_PERMISSIONS_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        // Make sure it's our original READ_CONTACTS request
        if (requestCode == READ_SMS_PERMISSIONS_REQUEST) {
            if (grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Read SMS permission granted", Toast.LENGTH_SHORT).show();
                //refreshSmsInbox();
            } else {
                Toast.makeText(this, "Read SMS permission denied", Toast.LENGTH_SHORT).show();
            }

        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }



    }

}
