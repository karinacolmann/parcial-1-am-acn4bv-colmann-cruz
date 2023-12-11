package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    private User user;


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

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        SearchView searchBar = findViewById(R.id.searchBar);
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView contentText = findViewById(R.id.textViewBox);
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


                //Intent que conduce al Activity 'New Release'
                Intent intent = new Intent(MainActivity.this, NewRelease.class);
                startActivity(intent);
            }
        });//fin


        //evento freeDownloadLayout
        freeDownloadLayout = findViewById(R.id.freeDownloadLayout);
        android.widget.TextView freeDownloadTitle = findViewById(R.id.freeDownloadTitle);
        freeDownloadLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                freeDownloadLayout.setBackgroundResource(R.color.freeDownload);
                freeDownloadTitle.setTextColor(getResources().getColor(R.color.white));
                //Toast
                Toast.makeText(getApplicationContext(), "¡Descargá Gratis!", Toast.LENGTH_SHORT).show();
                freeDownloadLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        freeDownloadLayout.setBackgroundResource(R.color.white);
                        freeDownloadTitle.setTextColor(getResources().getColor(R.color.black));
                    }
                }, 1000);

                //Intent que conduce al Activity 'Free Download'
                Intent intent = new Intent(MainActivity.this, FreeDownloadActivity.class);
                startActivity(intent);



            }
        });//fin

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

                //Intent que conduce al Activity 'MostPlayed'
                Intent intent = new Intent(MainActivity.this, MostPlayed.class);
                startActivity(intent);
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

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser !=null) {

            String uid = currentUser.getUid();
            db      .collection("users")
                    .get()

                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                         if (task.isSuccessful()){
                             for (QueryDocumentSnapshot documento: task.getResult()){
                                 String id = documento.getId();
                                 Map<String, Object> data = documento.getData();

                                 user = documento.toObject(User.class);

                                 Log.i ("firebase firestore", "Apellido: " + user.getLastname());
                                 Log.i ("firebase firestore", "Nombre: " + user.getName());
                                 Log.i ("firebase firestore", "Cuenta Verificada: " + user.isVerified());


                                 String currentLastName = (String) data.get ("lastname");
                                 String currentName = (String) data.get ("name");
                                 boolean currentVerified = (boolean) data.get("verified");
                                 String updatedLastName = "";
                                 String updatedName = "";
                                 boolean updatedVerified = currentVerified;

                                 if ("cRuZ". equalsIgnoreCase(currentLastName)){
                                     updatedLastName = "Cruz";
                                     updatedName = "Eliana";
                                     if (currentVerified) {
                                         updatedVerified = false;
                                     }else{
                                         updatedVerified = true;
                                     }

                                 } else if ("COLMANn". equalsIgnoreCase(currentLastName)){
                                     updatedLastName = "Colmann";
                                     updatedName = "Karina";

                                     if (currentVerified){
                                         updatedVerified = false;
                                     }else{
                                         updatedVerified = true;
                                     }
                                 }


                                 db.collection("users")
                                         .document(id)
                                         .update("lastname", updatedLastName, "name", updatedName, "verified", updatedVerified)

                                         .addOnSuccessListener(new OnSuccessListener<Void>() {
                                             @Override
                                             public void onSuccess(Void aVoid) {

                                                 Log.i("firebase firestore", "Los datos del usuario se actualizaron con éxito: " + id);

                                             }
                                         })
                                         .addOnFailureListener(new OnFailureListener() {
                                             @Override
                                             public void onFailure(@NonNull Exception e) {
                                                 Log.e ("firebase firestore", "Error al actualizar el usuario: " + id, e);
                                             }
                                         });

                             }
                         }

                        }
                    });

            //Verificacion de Email
        if (currentUser.isEmailVerified()) {
            Log.i("firebase", "El usuario existe. Accediste a la pantalla principal.");
        } else {
            currentUser.sendEmailVerification();
        }

    } else {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        Log.i("firebase", "Deberia loguearme porque no hay usuario");

    }}



    //Para Cerrar sesion

    public void logout (View v){
        mAuth.signOut();
        Intent intent = new Intent (getApplicationContext(), LoginActivity.class);
        startActivity (intent);
        Log.i ("firebase", "Volví a la pantalla del login.");
    }


}