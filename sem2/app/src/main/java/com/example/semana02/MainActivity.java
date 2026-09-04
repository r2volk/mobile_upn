package com.example.semana02;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMulti, btnSuma, btnResta, btnDiv;
    EditText txtN1, txtN2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMulti = (Button) findViewById(R.id.btnMultiplicar);
        btnSuma = (Button)findViewById(R.id.btnSuma);
        btnResta = (Button)findViewById(R.id.btnRestar);
        btnDiv = (Button)findViewById(R.id.btnDivision);

        txtN1 = (EditText)findViewById(R.id.editTxtN1);
        txtN2 = (EditText)findViewById(R.id.editTxtN2);

        btnMulti.setOnClickListener( v -> calcular("multi"));
        btnSuma.setOnClickListener( v -> calcular("suma"));
        btnResta.setOnClickListener( v -> calcular("resta"));
        btnDiv.setOnClickListener( v -> calcular("div"));

    }

    public void calcular(String operacion){
        String n1str = txtN1.getText().toString();
        String n2str = txtN2.getText().toString();

        int n1 = Integer.parseInt(n1str);
        int n2 = Integer.parseInt(n2str);

        int resultado;

        if (operacion.equals("multi")) {
            resultado = n1 * n2;
        } else if (operacion.equals("suma")) {
            resultado = n1 + n2;
        } else if (operacion.equals("resta")) {
            resultado = n1 - n2;
        } else {
            resultado = n1 / n2;
        }

        Toast.makeText(getApplicationContext(),"El resultado es: " + resultado, Toast.LENGTH_LONG).show();

    }

}