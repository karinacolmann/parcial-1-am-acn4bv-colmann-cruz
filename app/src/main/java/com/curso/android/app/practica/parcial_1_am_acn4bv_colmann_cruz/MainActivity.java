package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NonNls;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchView searchBar = findViewById(R.id.searchBar);
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView contentText = findViewById(R.id.textViewBox);
                contentText.setVisibility(View.VISIBLE);
                contentText.setText(R.string.textViewContentSecondTOnClick);
            }
        });
    }




}



