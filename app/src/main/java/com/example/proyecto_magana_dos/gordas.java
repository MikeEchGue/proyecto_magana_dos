package com.example.proyecto_magana_dos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class gordas extends AppCompatActivity {
    RadioButton rdPastor, rdLonganiza, rdCampechanos, rdSuadero, rdBistec, rdSencilla;
    CheckBox cbLechuga, cbCilantro, cbCebolla, cbSalsaVerde, cbSalsaRoja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gordas);

        //Declaracion de varibales con widgets de los radioButton(Ingredientes)
        rdPastor = (RadioButton) findViewById(R.id.radioButtonPastor);
        rdLonganiza = (RadioButton) findViewById(R.id.radioButtonLonganiza);
        rdCampechanos = (RadioButton) findViewById(R.id.radioButtonCampechanos);
        rdSuadero = (RadioButton) findViewById(R.id.radioButtonSuadero);
        rdBistec = (RadioButton) findViewById(R.id.radioButtonBistec);
        rdSencilla = (RadioButton) findViewById(R.id.radioButtonSencilla);

        //Declaracion de variables de widgets de checkBox(Extras)
        cbLechuga = (CheckBox) findViewById(R.id.checkBoxLechuga);
        cbCilantro = (CheckBox) findViewById(R.id.checkBoxCilantro);
        cbCebolla = (CheckBox) findViewById(R.id.checkBoxCebolla);
        cbSalsaVerde = (CheckBox) findViewById(R.id.checkBoxSalsaVerde);
        cbSalsaRoja = (CheckBox) findViewById(R.id.checkBoxSalsaRoja);
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
        String platillo = "gorda de";
        int precio = 40;
        if(rdBistec.isChecked()){
            platillo +="bistec";
        } else if (rdCampechanos.isChecked()) {
            platillo += "campechano";
        } else if (rdLonganiza.isChecked()){
            platillo += "longaniza";
        } else if (rdPastor.isChecked()) {
            platillo += "pastor";
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