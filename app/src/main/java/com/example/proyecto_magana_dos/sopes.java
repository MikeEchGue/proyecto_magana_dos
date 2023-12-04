package com.example.proyecto_magana_dos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class sopes extends AppCompatActivity {
    RadioButton rdBistec, rdSuadero, rdLonganiza;
    CheckBox cbCebolla, cbCilantro, cbSalsaRoja, cbSalsaVerde, cbLechuga, cbQueso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sopes);

        rdBistec = (RadioButton) findViewById(R.id.radioButtonBistec);
        rdSuadero = (RadioButton) findViewById(R.id.radioButtonSuadero);
        rdLonganiza = (RadioButton) findViewById(R.id.radioButtonLonganiza);

        cbCebolla = (CheckBox) findViewById(R.id.checkBoxCebolla);
        cbCilantro = (CheckBox) findViewById(R.id.checkBoxCilantro);
        cbSalsaRoja = (CheckBox) findViewById(R.id.checkBoxSalsaRoja);
        cbSalsaVerde = (CheckBox) findViewById(R.id.checkBoxSalsaVerde);
        cbLechuga = (CheckBox) findViewById(R.id.checkBoxLechuga);
        cbQueso = (CheckBox) findViewById(R.id.checkBoxQueso);

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
        String platillo = "sope de";
        int precio = 40;
        if(rdBistec.isChecked()){
            platillo +="bistec";
        } else if (rdLonganiza.isChecked()){
            platillo += "longaniza";
        } else if (rdSuadero.isChecked()) {
            platillo += "suadero";
        }
        else {
            Toast.makeText(this, "Selecciones un ingrediente", Toast.LENGTH_SHORT).show();
        }

        if(cbLechuga.isChecked()){
            platillo += " con lechuga";
        } else if (cbSalsaRoja.isChecked()) {
            platillo += " con salsa roja";
        } else if (cbSalsaVerde.isChecked()) {
            platillo += " con salsa verde";
        } else if (cbCilantro.isChecked()) {
            platillo += " con nopales";
        } else if (cbCebolla.isChecked()) {
            platillo += " con queso";
            precio += 10;
        }
        return platillo;
    }
}