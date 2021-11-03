package com.dispositivosmoveis.aquainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
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

//        objetos da inteface de usuário
        TextView teste = findViewById(R.id.textView);
        TextView saidaFiltro = findViewById(R.id.saidaFiltro);
        TextView saidaIluminacao = findViewById(R.id.saidaIluminacao);
        TextView saidaAquecedor = findViewById(R.id.saidaAquecedor);
        RadioButton radioSim = findViewById(R.id.radioSim);
        RadioButton radioNao = findViewById(R.id.radioNao);
        CheckBox checkBoxPlantas = findViewById(R.id.checkBoxPlantas);

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


//        calculo da litragem do aquário
        String strLitragem = "";
        String strFiltro = "";
        String strIluminacao = "";
        String strAquecimento = "";
        boolean plantas = false;
        float litragem = 0.0f;
        if(checkBoxPlantas.isChecked()){
            plantas = true;
        }
        if(radioSim.isChecked()){
            litragem = aquario.calcularLitragemFloat(aquario,'s');
            strLitragem = metodos.converteFloatString(litragem);
            strFiltro = aquario.calcularFiltro(litragem);
            strAquecimento = aquario.calcularAquecimento(litragem);
            strIluminacao = aquario.calcularIluminacao(litragem,plantas);

        }else if(radioNao.isChecked()){
            teste.setText(aquario.calcularLitragem(aquario,'n'));
        }

//        saída de dados para o usuário
        teste.setText(strLitragem);
        saidaFiltro.setText(strFiltro);
        saidaIluminacao.setText(strIluminacao);
        saidaAquecedor.setText(strAquecimento);

    }

}