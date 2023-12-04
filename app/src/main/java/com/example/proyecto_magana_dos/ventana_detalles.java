package com.example.proyecto_magana_dos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ventana_detalles extends AppCompatActivity {
    String platillo, precio;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_detalles);
        platillo = getIntent().getStringExtra("platillo");
        precio = getIntent().getStringExtra("precio");

    }

    public void enviar(View view) {
        Map<String, Object> pedido = new HashMap<>();
        pedido.put("descripcion", platillo);
        pedido.put("precio", precio);

        db.collection("Pedido").document("2")
                .set(pedido)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("mensaje", "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Mensaje 2", "Error writing document", e);
                    }
                });
        Intent iI = new Intent(this, MainActivity.class);
        startActivity(iI);
    }
}