package com.example.at.nanotrack;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLocalizar, btnBloqueo, btnModoEst, btnEstado, btnAlarmas, btnRastreo, btnAjustes, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instance all buttons
        btnLocalizar = (Button) findViewById(R.id.localizar);
        btnBloqueo = (Button) findViewById(R.id.bloqueo);
        btnModoEst = (Button) findViewById(R.id.modoEst);
        btnEstado = (Button) findViewById(R.id.estado);
        btnAlarmas = (Button) findViewById(R.id.alarmas);
        btnRastreo = (Button) findViewById(R.id.rastreo);
        btnAjustes = (Button) findViewById(R.id.ajustes);
        btnReset = (Button) findViewById(R.id.reset);

        //Set Listeners
        btnLocalizar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.localizar:

                break;
            case R.id.bloqueo:

                break;
            case R.id.modoEst:

                break;
            case R.id.estado:

                break;
            case R.id.alarmas:
                Intent intentAlarma = new Intent(this, Alarma.class);
                startActivity(intentAlarma);
                break;
            case R.id.rastreo:
                Intent intentRastreo = new Intent(this, Rastreo.class);
                startActivity(intentRastreo);
                break;
            case R.id.ajustes:

                break;
            case R.id.reset:

                break;
            default:
                break;
        }
    }

}
