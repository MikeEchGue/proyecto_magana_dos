package com.example.proyecto_magana_dos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class quesadillas extends AppCompatActivity {
    CheckBox cbSalsaVerde, cbSalsaRoja,cbLechuga;
    RadioButton rbChicharron, rbPollo, rbQueso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quesadillas);

        rbChicharron = findViewById(R.id.radioButtonChicharon);
        rbPollo = findViewById(R.id.radioButtonPollo);
        rbQueso = findViewById(R.id.radioButtonQueso);

        cbSalsaVerde = (CheckBox) findViewById(R.id.checkBoxSalsaVerde);
        cbSalsaRoja = (CheckBox) findViewById(R.id.checkBoxSalsaRoja);
        cbLechuga = (CheckBox) findViewById(R.id.checkBoxLechuga);
    }

    public void detalles(View view) {
        String pedido = orden_pedido();
        Intent i1 = new Intent(this, ventana_detalles.class);
        i1.putExtra("platillo", pedido);
        startActivity(i1);
    }

    public void otro_platillo(View view) {
        String pedido = orden_pedido();

        Intent i2 = new Intent(this, MainActivity.class);
        i2.putExtra("platillo", pedido);
        startActivity(i2);
    }

    public String orden_pedido(){
        String platillo = "quesadilla de ";
        int precio = 40;
        if(rbChicharron.isChecked()){
            platillo +="chicharron ";
        } else if (rbQueso.isChecked()) {
            platillo += "queso ";
        } else if (rbPollo.isChecked()){
            platillo += "pollo ";
        }

        if(cbLechuga.isChecked()){
            platillo += " con lechuga";
        } else if (cbSalsaRoja.isChecked()) {
            platillo += " con salsa roja";
        } else if (cbSalsaVerde.isChecked()) {
            platillo += " con salsa verde";
        }
        return platillo;
    }
}