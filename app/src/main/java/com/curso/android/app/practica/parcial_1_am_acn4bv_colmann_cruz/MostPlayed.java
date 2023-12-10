package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz.API.GetBubbleApi;
import com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MostPlayed extends AppCompatActivity implements GetBubbleApi.ApiListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_played);

        api();
    }

    public void api() {
        GetBubbleApi getBubbleApi = new GetBubbleApi();
        getBubbleApi.setApiListener(this);  // Establece la actividad como el listener
        getBubbleApi.execute("https://bubbleapi.karinacolmann18.repl.co/");
    }

        private void mostrarInformacionEnUI(JSONObject juego) {
            try {
                // Extrae información específica del objeto JSON
                String nombreJuego = juego.getString("nombre");
                String plataforma = juego.getString("plataforma");
                int añoLanzamiento = juego.getInt("añoLanzamiento");
                String genero = juego.getString("genero");
                String desarrollador = juego.getString("desarrollador");

                // Actualiza tu interfaz de usuario con la información
                TextView textViewNombre = findViewById(R.id.textViewNombre);
                TextView textViewPlataforma = findViewById(R.id.textViewPlataforma);
                TextView textViewLanzamiento = findViewById(R.id.textViewAñoLanzamiento);
                TextView textViewGenero = findViewById(R.id.textViewGenero);
                TextView textViewDesarrollador = findViewById(R.id.textViewDesarrollador);

                textViewNombre.setText("Nombre: " + nombreJuego);
                textViewPlataforma.setText("Plataforma: " + plataforma);
                textViewLanzamiento.setText("Año de Lanzamiento: " + añoLanzamiento);
                textViewGenero.setText("Género: " + genero);
                textViewDesarrollador.setText("Desarrollador: " + desarrollador);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onApiResponse(JSONObject juego) {
            // Procesa la respuesta JSON como un objeto
            mostrarInformacionEnUI(juego);
        }
    }
