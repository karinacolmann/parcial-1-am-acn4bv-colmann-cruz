package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz.API;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetBubbleApi extends AsyncTask <String, Integer, String>{

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    //mi AsyncTask
    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        String response = "";
        try {
            response = run(url);
            JSONObject juegos = new JSONObject(response);
            /**/
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("probando url" , s);
    }
}
