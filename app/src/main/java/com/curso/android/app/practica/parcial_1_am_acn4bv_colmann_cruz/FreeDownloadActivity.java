package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

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

        LinearLayout layoutTextBox = findViewById(R.id.layoutTextBox);
        layoutTextBox.addView (contentButton);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.width = (int) 500;
        contentButton.setLayoutParams(params);
        params.gravity = Gravity.CENTER;
        params.topMargin = 30;

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
        descarga.execute("https://lh3.googleusercontent.com/u/0/drive-viewer/AK7aPaAXVmXVRJNUvqVFvIZtUoTwWgY_7u7fhAxC_FCIO9cFFeh9LTwWQBkjo2P87BGgelRJkhu8fLaDexHd95ZQ14WLRKIiXg=w2126-h1830");
    }


    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}