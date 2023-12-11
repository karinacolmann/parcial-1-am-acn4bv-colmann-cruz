package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    TextView textView;
    ProgressBar progressBar;


    public void login(String email, String password) {

        Log.i("firebase", "email:" + email);
        Log.i("firebase", "password: " + password);

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class );
                            startActivity (intent);

                        } else {
                            Toast.makeText(LoginActivity.this, " Falló el login ",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }



    public void onLoginButtonClick (View view) {

        EditText emailInput = findViewById(R.id.emailBox);
        EditText passInput = findViewById(R.id.passwordBox);

        String email = emailInput.getText(). toString();
        String password = passInput.getText().toString();

        this.login( email, password);

        progressBar.setVisibility(View.VISIBLE);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.loginToRegisterBottomMessage);
        progressBar = findViewById(R.id.loginProgressBar);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity (intent);
                finish ();

            }
        });
    }





}