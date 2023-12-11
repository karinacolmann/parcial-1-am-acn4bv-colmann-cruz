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

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    TextView textView;
    ProgressBar progressBar;


    public void register (String email, String password) {

        Log.i("firebase", "email:" + email);
        Log.i("firebase", "password: " + password);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(RegisterActivity.this, " Te cuenta ha sido creada ",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(RegisterActivity.this, " Falló el Registro ",
                                    Toast.LENGTH_SHORT).show();
                            Log.e("Firebase", "Error al crear cuenta: " + task.getException().getMessage());

                        }
                    }
                });
    }



    public void onRegisterButtonClick (View view) {

        EditText emailInput = findViewById(R.id.emailBox);
        EditText passInput = findViewById(R.id.passwordBox);

        String email = emailInput.getText(). toString();
        String password = passInput.getText().toString();

        this.register( email, password);

        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        textView =findViewById(R.id.registerTologinBottomMessage);
        progressBar = findViewById(R.id.progressBar);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity (intent);
                finish ();

            }
        });
    }




}
