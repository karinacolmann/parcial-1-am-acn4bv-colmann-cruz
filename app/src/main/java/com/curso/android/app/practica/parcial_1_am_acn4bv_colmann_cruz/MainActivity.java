package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    RelativeLayout newReleaseLayout;
    RelativeLayout freeDownloadLayout;
    RelativeLayout topSellersLayout;
    RelativeLayout mostPlayedLayout;
    RelativeLayout saleEventsLayout;
    RelativeLayout communityLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SearchView searchBar=findViewById(R.id.searchBar);
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView contentText =findViewById(R.id.textViewBox);
                contentText.setVisibility(View.VISIBLE);
                contentText.setText(R.string.textViewContentSecondTOnClick);
            }
        });



        //evento ReleaseLayout
        newReleaseLayout = findViewById(R.id.newReleaseLayout);
        android.widget.TextView newReleaseTitle = findViewById(R.id.newReleaseTitle);
        newReleaseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newReleaseLayout.setBackgroundResource(R.color.release);
                newReleaseTitle.setTextColor(getResources().getColor(R.color.white));
                //Toast
                Toast.makeText(getApplicationContext(), "¡Descubrí los nuevos lanzamientos!", Toast.LENGTH_SHORT).show();
                newReleaseLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        newReleaseLayout.setBackgroundResource(R.color.white);
                        newReleaseTitle.setTextColor(getResources().getColor(R.color.black));
                    }
                }, 1000);
            }
        });//fin

        //evento freeDownloadLayout
        freeDownloadLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                freeDownloadLayout.setBackgroundResource(R.color.freeDownload);

                Toast.makeText(getApplicationContext(), "¡Descargá Gratis!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, FreeDownload.class);
                startActivity(intent);

                freeDownloadLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        freeDownloadLayout.setBackgroundResource(R.color.white);

                    }
                }, 1000);
            }
        });
//fin

        //evento topSellersLayout
        topSellersLayout = findViewById(R.id.topSellersLayout);
        android.widget.TextView topSellersTitle = findViewById(R.id.topSellersTitle);
        topSellersLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topSellersLayout.setBackgroundResource(R.color.topSellers);
                topSellersTitle.setTextColor(getResources().getColor(R.color.white));
                //Toast
                Toast.makeText(getApplicationContext(), "¡Estos son los favoritos!", Toast.LENGTH_SHORT).show();
                topSellersLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topSellersLayout.setBackgroundResource(R.color.white);
                        topSellersTitle.setTextColor(getResources().getColor(R.color.black));
                    }
                }, 1000);
            }
        });//fin

        //evento mostPlayedLayout
        mostPlayedLayout = findViewById(R.id.mostPlayedLayout);
        android.widget.TextView mostPlayedTitle = findViewById(R.id.mostPlayedTitle);
        mostPlayedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostPlayedLayout.setBackgroundResource(R.color.mostPlayed);
                mostPlayedTitle.setTextColor(getResources().getColor(R.color.white));
                //Toast
                Toast.makeText(getApplicationContext(), "¡Estos son los más jugados!", Toast.LENGTH_SHORT).show();
                mostPlayedLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mostPlayedLayout.setBackgroundResource(R.color.white);
                        mostPlayedTitle.setTextColor(getResources().getColor(R.color.black));
                    }
                }, 1000);
            }
        });//fin

        //evento saleEventsLayout
        saleEventsLayout = findViewById(R.id.saleEventsLayout);
        android.widget.TextView saleEventsTitle = findViewById(R.id.saleEventsTitle);
        saleEventsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saleEventsLayout.setBackgroundResource(R.color.saleEvents);
                saleEventsTitle.setTextColor(getResources().getColor(R.color.white));
                //Toast
                Toast.makeText(getApplicationContext(), "¡Selección de ofertas!", Toast.LENGTH_SHORT).show();
                saleEventsLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        saleEventsLayout.setBackgroundResource(R.color.white);
                        saleEventsTitle.setTextColor(getResources().getColor(R.color.black));
                    }
                }, 1000);
            }
        });//fin

        //evento communityLayout
        communityLayout = findViewById(R.id.communityLayout);
        android.widget.TextView communityTitle = findViewById(R.id.communityTitle);
        communityLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                communityLayout.setBackgroundResource(R.color.community);
                communityTitle.setTextColor(getResources().getColor(R.color.white));

                //Toast
                Toast.makeText(getApplicationContext(), "¡Unite a la Comunidad!", Toast.LENGTH_SHORT).show();
                communityLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        communityLayout.setBackgroundResource(R.color.white);
                        communityTitle.setTextColor(getResources().getColor(R.color.black));
                    }
                }, 1000);
            }
        });



    }
    //Intent free download
    public void FreeDownload (View view){
        Intent freeDownload = new Intent(this,FreeDownload.class);
        startActivity(freeDownload);
    }
}