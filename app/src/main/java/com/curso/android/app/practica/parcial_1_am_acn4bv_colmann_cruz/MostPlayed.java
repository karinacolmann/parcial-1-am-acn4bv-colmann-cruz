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

    private void mostrarInformacionEnUI(JSONArray juegosArray) {
        try {
            //los primeros 5 juegos en el array
            int numJuegosAMostrar = Math.min(5, juegosArray.length());
            for (int i = 0; i < numJuegosAMostrar; i++) {
                JSONObject juego = juegosArray.getJSONObject(i);


                String nombreJuego = juego.getString("nombre");
                String plataforma = juego.getString("plataforma");
                int añoLanzamiento = juego.getInt("añoLanzamiento");
                String genero = juego.getString("genero");
                String desarrollador = juego.getString("desarrollador");


                int textViewNombreId = getResources().getIdentifier("textViewNombre" + (i + 1), "id", getPackageName());
                int textViewPlataformaId = getResources().getIdentifier("textViewPlataforma" + (i + 1), "id", getPackageName());
                int textViewAñoLanzamientoId = getResources().getIdentifier("textViewAñoLanzamiento" + (i + 1), "id", getPackageName());
                int textViewGeneroId = getResources().getIdentifier("textViewGenero" + (i + 1), "id", getPackageName());
                int textViewDesarrolladorId = getResources().getIdentifier("textViewDesarrollador" + (i + 1), "id", getPackageName());

                TextView textViewNombre = findViewById(textViewNombreId);
                TextView textViewPlataforma = findViewById(textViewPlataformaId);
                TextView textViewAñoLanzamiento = findViewById(textViewAñoLanzamientoId);
                TextView textViewGenero = findViewById(textViewGeneroId);
                TextView textViewDesarrollador = findViewById(textViewDesarrolladorId);

                String informacionJuego = String.format(
                        "Nombre: %s\nPlataforma: %s\nAño de Lanzamiento: %d\nGénero: %s\nDesarrollador: %s\n\n",
                        nombreJuego, plataforma, añoLanzamiento, genero, desarrollador);

                textViewNombre.setText("Nombre: " + nombreJuego);
                textViewPlataforma.setText("Plataforma: " + plataforma);
                textViewAñoLanzamiento.setText("Año de Lanzamiento: " + añoLanzamiento);
                textViewGenero.setText("Género: " + genero);
                textViewDesarrollador.setText("Desarrollador: " + desarrollador);
            }
        } catch (JSONException e) {
            Log.e("MostPlayed", "Error al analizar JSON: " + e.getMessage());
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

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONArray juegosArray = new JSONArray(s);
                mostPlayed.mostrarInformacionEnUI(juegosArray);
            } catch (JSONException e) {
                Log.e("GetBubbleApi", "Error al analizar JSON: " + e.getMessage());
            }
        }

    }
}
