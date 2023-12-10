package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz.API;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetBubbleApi extends AsyncTask<String, Integer, String> {

    private ApiListener apiListener;
    private JSONObject juegos;

    public void setApiListener(ApiListener listener) {
        this.apiListener = listener;
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
        // Procesa la respuesta JSON
        try {
            JSONArray juegosArray = new JSONArray(s);

            if (apiListener != null) {
                apiListener.onApiResponse(juegos);
            }
        } catch (JSONException e) {
            Log.e("GetBubbleApi", "Error al analizar JSON: " + e.getMessage());
        }
    }

    public interface ApiListener {
        void onApiResponse(JSONObject juegos);

        abstract void onApiResponse(JSONArray juegosArray);
    }
}
