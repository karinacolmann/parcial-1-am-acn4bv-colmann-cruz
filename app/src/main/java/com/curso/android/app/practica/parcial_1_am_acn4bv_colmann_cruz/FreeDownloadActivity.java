package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FreeDownloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_download);

        Button contentButton = new Button(this);
        contentButton.setText("Mystery Box");
        contentButton.setTextColor(Color.parseColor("#8ED8B0"));

        GradientDrawable background = new GradientDrawable();
        background.setColor(getResources().getColor(R.color.green_box));
        background.setCornerRadius(50f);
        contentButton.setBackgroundDrawable(background);


        LinearLayout layoutTextBox = findViewById(R.id.layoutTextBox);
        layoutTextBox.addView (contentButton);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.width = (int) 500;
        params.height = (int) 100;
        contentButton.setLayoutParams(params);
        params.gravity = Gravity.CENTER;
        params.topMargin = 20;

        contentButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View view) {

                TextView contentTitle =findViewById (R.id.contentTitle);
                contentTitle.setText("TRY AGAIN!");
            }

        });

    }

    public void download(View v){
        ImageView imageView = findViewById(R.id.imageViewDownload);
        ImageDownload descarga = new ImageDownload (imageView);
        descarga.execute("https://lh3.googleusercontent.com/u/0/drive-viewer/AK7aPaCwmBqrCADH5QBKc1kbPADosAVHjLH-WtSd4N6mqSkc3Lefszx-umZ-8RMbj_uenuy8fomO1sZ9hi9hKr_PTGogG19H5g=w2126-h1830");
    }


    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}