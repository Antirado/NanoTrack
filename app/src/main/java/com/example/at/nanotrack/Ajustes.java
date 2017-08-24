package com.example.at.nanotrack;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

public class Ajustes extends AppCompatActivity {


    SmsManager smsManager = SmsManager.getDefault();
    private static Ajustes inst;

    public static Ajustes instance() {
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
        Preferences.setCurrentActivity(Ajustes.this, "4");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

    }

    public void updateInbox(final String address, final String smsBody) {

        //deleteSMS(MainActivity.this, smsBody, address);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                Ajustes.this);

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
