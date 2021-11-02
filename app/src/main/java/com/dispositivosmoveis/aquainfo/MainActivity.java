package com.dispositivosmoveis.aquainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dispositivosmoveis.aquainfo.metodos.Metodos;
import com.dispositivosmoveis.aquainfo.model.Aquario;
import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void calcularLitragem(View view){
//        classe que contém métodos globais para o projeto
        Metodos metodos = new Metodos();

//        dados de entrada
        EditText entradaAltura = findViewById(R.id.txtEntradaAltura);
        EditText entradaLargura = findViewById(R.id.txtEntradaLargura);
        EditText entradacomprimento = findViewById(R.id.txtEntradaComprimento);

//        conversão dos tipos
        Float altura = metodos.converteFloat(metodos.converteString(entradaAltura));
        Float largura = metodos.converteFloat(metodos.converteString(entradaLargura));
        Float comprimento = metodos.converteFloat(metodos.converteString(entradacomprimento));

//        instanciação do objeto aquário
        Aquario aquario = new Aquario(largura,altura,comprimento);

//        saída de dados para o usuário
        TextView teste = findViewById(R.id.textView);

//        calculo da litragem do aquário
        teste.setText(aquario.calcularLitragem(aquario));

    }

}