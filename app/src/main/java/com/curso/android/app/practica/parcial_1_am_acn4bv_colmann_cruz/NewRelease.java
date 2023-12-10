package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NewRelease extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_release);


        Button contentButton = new Button(this);
        contentButton.setText(R.string.contentButtonText);
        contentButton.setBackgroundColor(+R.color.crimson);

        LinearLayout layoutCenterArrayPic = findViewById(R.id.layoutCenterArrayPic);
        layoutCenterArrayPic.addView(contentButton);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.width = (int) 500;
        contentButton.setLayoutParams(params);
        params.gravity = Gravity.CENTER;
        params.topMargin = 30;


        contentButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View button) {
                ArrayList<Juegos> listaDeJuegos = new ArrayList<Juegos>();
                listaDeJuegos.add(new Juegos("Counter Strike", R.drawable.coustrike));
                listaDeJuegos.add(new Juegos("Call of Duty", R.drawable.callofduty));
                listaDeJuegos.add(new Juegos("Destiny 2", R.drawable.destinty_dos));
                listaDeJuegos.add(new Juegos("EA FC 24", R.drawable.eafc));
                listaDeJuegos.add(new Juegos("Grand Theft Auto V", R.drawable.grandtheftauto_cinco));
                listaDeJuegos.add(new Juegos("PUBG Battlegrounds", R.drawable.battle));



                int numeroAleatorio = (int) (Math.random() * listaDeJuegos.size());

                CharSequence msg = "Estado actualizado";
                Toast toast = Toast.makeText(contentButton.getContext(), msg, Toast.LENGTH_SHORT);
                toast.show();

                addGameRowIntoContainer(listaDeJuegos.get(numeroAleatorio),button.getContext());

            }
        });

    }

    public void addGameRowIntoContainer(Juegos game, Context context){



        LinearLayout gameRowContainer = new LinearLayout(context);
        gameRowContainer.setLayoutParams(new LinearLayout.LayoutParams(

                LinearLayout.LayoutParams.MATCH_PARENT,
                150 // Altura del gameRow

        ));

        gameRowContainer.setOrientation(LinearLayout.HORIZONTAL);
        gameRowContainer.setBackgroundColor(Color.WHITE);


        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));
        imageView.setImageResource(game.getImg());


        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));
        textView.setText(game.getTitulo());


        gameRowContainer.addView(imageView);
        gameRowContainer.addView(textView);


        LinearLayout appContent = findViewById(R.id.layoutCenterRowsContainer);
        appContent.addView(gameRowContainer);
    }
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}

