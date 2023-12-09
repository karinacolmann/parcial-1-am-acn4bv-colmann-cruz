package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz.API;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz.R;

public class APIJuegos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apijuegos);
    }

    public void api(){
        GetBubbleApi getBubbleApi = new GetBubbleApi();
        getBubbleApi.execute ("https://bubbleapi.karinacolmann18.repl.co/");
    }
}