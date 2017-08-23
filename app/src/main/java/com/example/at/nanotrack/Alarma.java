package com.example.at.nanotrack;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Alarma extends AppCompatActivity implements View.OnClickListener {

    EditText EtVelocidad, EtDistancia;
    Button btnVelocidad, btnDistancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarma);

        //Instanciate
        EtDistancia = (EditText) findViewById(R.id.ETdistancia);
        EtVelocidad = (EditText) findViewById(R.id.ETvelocidad);
        btnDistancia = (Button) findViewById(R.id.distancia);
        btnVelocidad = (Button) findViewById(R.id.velocidad);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.distancia:

                break;
            case R.id.velocidad:

                break;
            default:
                break;
        }
    }

}
