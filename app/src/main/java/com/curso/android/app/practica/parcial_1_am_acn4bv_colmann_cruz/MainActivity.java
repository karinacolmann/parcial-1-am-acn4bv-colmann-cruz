package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

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

        Button contentButton = new Button(this);
        contentButton.setText("Mystery Box");

        LinearLayout content = findViewById(R.id.content);
        content.addView (contentButton);

        contentButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View view) {

                TextView contentTitle =findViewById (R.id.contentTitle);
                contentTitle.setText("El Texto fue Actualizado");
            }

        });

    }
}