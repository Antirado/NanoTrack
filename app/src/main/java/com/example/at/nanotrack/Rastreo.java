package com.example.at.nanotrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Rastreo extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rastreo);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.rastreo:

                break;
            case R.id.cambioDir:

                break;
            case R.id.desactRastreo:

                break;
            default:
                break;
        }
    }
}
