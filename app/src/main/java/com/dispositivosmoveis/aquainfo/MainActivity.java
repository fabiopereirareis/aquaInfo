package com.dispositivosmoveis.aquainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dispositivosmoveis.aquainfo.metodos.Metodos;
import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void calcularLitragem(View view){
        Metodos metodos = new Metodos();
//        dados de entrada
        EditText altura = findViewById(R.id.txtEntradaAltura);
        EditText largura = findViewById(R.id.txtEntradaLargura);
        EditText comprimento = findViewById(R.id.txtEntradaComprimento);

        TextView teste = findViewById(R.id.textView);

        teste.setText(metodos.calcularLitragem(altura,largura,comprimento));

    }

}