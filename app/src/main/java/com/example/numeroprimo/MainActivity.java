package com.example.numeroprimo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnNumeroprimo;
    EditText etNumero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        events();
    }


    private void findViews() {
        btnNumeroprimo = findViewById(R.id.btnNumeroPrimo);
        etNumero = findViewById(R.id.editTextNumber);
    }

    private void events() {
        btnNumeroprimo.setOnClickListener(this);
        etNumero.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String numtext = etNumero.getText().toString();
        int numero = Integer.parseInt(numtext);
        boolean primo = esPrimo(numero);
        if (primo){
            Toast.makeText(this, "Si es un numero primo", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No es un numero primo", Toast.LENGTH_SHORT).show();
        }

    }

//Funcion que devuelve si es un numero primo
    public static boolean esPrimo(int numero) {
        // El 0, 1 y 4 no son primos
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            // Si es divisible por cualquiera de estos números, no
            // es primo
            if (numero % x == 0)
                return false;
        }
        // Si no se pudo dividir por ninguno de los de arriba, sí es primo
        return true;
    }
}