package com.example.proyecto_magana_dos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class tacos extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RadioButton rdPastor, rdSuadero, rdBistec, rdLonganiza, rdCampechanos;
    CheckBox cbCilantro, cbCebolla, cbSalsaVerde, cbSalsaRoja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tacos);

        rdPastor = (RadioButton) findViewById(R.id.radioButtonPastor);
        rdSuadero = (RadioButton) findViewById(R.id.radioButtonSuadero);
        rdBistec = (RadioButton) findViewById(R.id.radioButtonBistec);
        rdLonganiza = (RadioButton) findViewById(R.id.radioButtonLonganiza);
        rdCampechanos = (RadioButton) findViewById(R.id.radioButtonCampechanos);

        cbCilantro = (CheckBox) findViewById(R.id.checkBoxCilantro);
        cbCebolla = (CheckBox) findViewById(R.id.checkBoxCebolla);
        cbSalsaVerde = (CheckBox) findViewById(R.id.checkBoxSalsaVerde);
        cbSalsaRoja = (CheckBox) findViewById(R.id.checkBoxSalsaRoja);

        Spinner spinner = findViewById(R.id.hola);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
        String platillo = "taco de";
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

        if (cbSalsaRoja.isChecked()) {
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