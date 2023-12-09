package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

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
                LinearLayout gameRowContainer1 = findViewById(R.id.gameRowContainer1);
                LinearLayout gameRowContainer2 = findViewById(R.id.gameRowContainer2);
                LinearLayout gameRowContainer3 = findViewById(R.id.gameRowContainer3);
                LinearLayout gameRowContainer4 = findViewById(R.id.gameRowContainer4);
                LinearLayout gameRowContainer5 = findViewById(R.id.gameRowContainer5);
                LinearLayout gameRowContainer6 = findViewById(R.id.gameRowContainer6);

                List<LinearLayout> gameRowContainers = new ArrayList<>();
                gameRowContainers.add(gameRowContainer1);
                gameRowContainers.add(gameRowContainer2);
                gameRowContainers.add(gameRowContainer3);
                gameRowContainers.add(gameRowContainer4);
                gameRowContainers.add(gameRowContainer5);
                gameRowContainers.add(gameRowContainer6);

                // para agarrar los números aleatoriamente, necesito un num aleatorio
                int numeroAleatorio = (int) (Math.random() * gameRowContainers.size());
                LinearLayout selectedGameRowContainer = gameRowContainers.get(numeroAleatorio);

                LinearLayout layoutCenterRowsContainer = findViewById(R.id.layoutCenterRowsContainer);


                // Crea una copia del contenedor seleccionado
                LinearLayout newContainer = new LinearLayout(button.getContext());
                newContainer.setLayoutParams(selectedGameRowContainer.getLayoutParams());
                newContainer.setOrientation(selectedGameRowContainer.getOrientation());
                newContainer.setBackground(selectedGameRowContainer.getBackground());

                // Crea una copia de la imagen y agrégala al nuevo contenedor
                ImageView newImage = new ImageView(button.getContext());
                newImage.setImageDrawable(((ImageView) selectedGameRowContainer.getChildAt(0)).getDrawable());
                newImage.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
                newContainer.addView(newImage);

                // Crea una copia del texto y agrégala al nuevo contenedor
                TextView newText = new TextView(button.getContext());
                newText.setText(((TextView) selectedGameRowContainer.getChildAt(1)).getText());
                newText.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
                newContainer.addView(newText);

                // Agrega el nuevo contenedor al diseño
                layoutCenterRowsContainer.addView(newContainer);

                CharSequence msg = "Estado actualizado";
                Toast toast = Toast.makeText(contentButton.getContext(), msg, Toast.LENGTH_SHORT);
                toast.show();



            }
        });

    }
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }















}
