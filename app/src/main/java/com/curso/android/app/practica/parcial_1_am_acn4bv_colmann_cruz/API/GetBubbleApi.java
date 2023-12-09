package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz.API;

import android.os.AsyncTask;
import android.util.Log;

public class GetBubbleApi extends AsyncTask <String, Integer, String>{

    //mi AsyncTask
    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        return url;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("probando url" , s);
    }
}
