package com.example.proyecto_magana_dos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String platillo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        if (intent != null){
            Bundle datos = intent.getExtras();

            if (datos != null){
                if (datos.containsKey("platillo")){
                    platillo = datos.getString("platillo");
                    Log.d("platillo",platillo);
                }
            }
        }
    }

    public void btn_gordas(View view){
        Intent v1 = new Intent(this, gordas.class);
        startActivity(v1);
    }

    public void btn_quesa(View view){
        Intent v2 = new Intent(this, quesadillas.class);
        startActivity(v2);
    }

    public void btn_tacos(View view)
    {
        Intent v3 = new Intent(this, tacos.class);
        startActivity(v3);
    }

    public void btn_sope(View view)
    {
        Intent v4 = new Intent(this, sopes.class);
        startActivity(v4);
    }

    public void btn_huara(View view)
    {
        Intent v5 = new Intent(this, huaraches.class);
        startActivity(v5);
    }
}