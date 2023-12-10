package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MostPlayed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_played);

        api();
    }

    public void api() {
        new GetBubbleApi(this).execute("https://bubbleapi.karinacolmann18.repl.co/");
    }

    /*private void mostrarInformacionEnUI(JSONObject juego) {
        try {*/
    private void mostrarInformacionEnUI(JSONArray juegosArray) {
        try {
            JSONObject primerJuego = juegosArray.getJSONObject(0);

            // Extrae información específica del objeto JSON
            String nombreJuego = primerJuego.getString("nombre");
            String plataforma = primerJuego.getString("plataforma");
            int añoLanzamiento = primerJuego.getInt("añoLanzamiento");
            String genero = primerJuego.getString("genero");
            String desarrollador = primerJuego.getString("desarrollador");

            // Actualiza tu interfaz de usuario con la información
            TextView textViewNombre = findViewById(R.id.textViewNombre);
            TextView textViewPlataforma = findViewById(R.id.textViewPlataforma);
            TextView textViewAñoLanzamiento = findViewById(R.id.textViewAñoLanzamiento);
            TextView textViewGenero = findViewById(R.id.textViewGenero);
            TextView textViewDesarrollador = findViewById(R.id.textViewDesarrollador);

            textViewNombre.setText("Nombre: " + nombreJuego);
            textViewPlataforma.setText("Plataforma: " + plataforma);
            textViewAñoLanzamiento.setText("Año de Lanzamiento: " + añoLanzamiento);
            textViewGenero.setText("Género: " + genero);
            textViewDesarrollador.setText("Desarrollador: " + desarrollador);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static class GetBubbleApi extends AsyncTask<String, Integer, String> {

        private MostPlayed mostPlayed;

        GetBubbleApi(MostPlayed mostPlayed) {
            this.mostPlayed = mostPlayed;
        }

        OkHttpClient client = new OkHttpClient();

        String run(String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
        }


        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];
            String response = "";
            try {
                response = run(url);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return response;
        }
       /* @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];
            String response = "";
            try {
                response = run(url);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return response;
        }*/


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // Procesa la respuesta JSON
            try {
                JSONArray juegosArray = new JSONArray(s);
                mostPlayed.mostrarInformacionEnUI(juegosArray);
            } catch (JSONException e) {
                Log.e("GetBubbleApi", "Error al analizar JSON: " + e.getMessage());
            }
        }

        /*@Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // Procesa la respuesta JSON
            try {
                JSONObject juego = new JSONObject(s);
                mostPlayed.mostrarInformacionEnUI(juego);
            } catch (JSONException e) {
                Log.e("GetBubbleApi", "Error al analizar JSON: " + e.getMessage());
                e.printStackTrace();
            }
        }*/
    }
}
