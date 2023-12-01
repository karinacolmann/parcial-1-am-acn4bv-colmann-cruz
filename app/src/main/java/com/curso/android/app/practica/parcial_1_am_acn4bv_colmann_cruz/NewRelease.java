package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class NewRelease extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_release);


    }
    public void onBackPressed() {
        super.onBackPressed();
        finish(); // Esto cierra la actividad actual y vuelve a la actividad anterior (MainActivity en este caso)
    }
}
