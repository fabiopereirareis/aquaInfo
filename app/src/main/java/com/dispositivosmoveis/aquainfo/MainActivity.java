package com.dispositivosmoveis.aquainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.dispositivosmoveis.aquainfo.metodos.Metodos;
import com.dispositivosmoveis.aquainfo.model.Aquario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularLitragem(View view){
        //        objetos da inteface de usuário
        TextView saidaLitragem = findViewById(R.id.txtSaidaLitragem);
        TextView saidaFiltro = findViewById(R.id.saidaFiltro);
        TextView saidaIluminacao = findViewById(R.id.saidaIluminacao);
        TextView saidaAquecedor = findViewById(R.id.saidaAquecedor);
        RadioButton radioSim = findViewById(R.id.radioSim);
        RadioButton radioNao = findViewById(R.id.radioNao);
        CheckBox checkBoxPlantas = findViewById(R.id.checkBoxPlantas);

        //        dados de entrada
        EditText entradaAltura = findViewById(R.id.entradaAltura);
        EditText entradaLargura = findViewById(R.id.entradaLargura);
        EditText entradacomprimento = findViewById(R.id.entradaComprimento);

//        classe que contém métodos globais para o projeto
        Metodos metodos = new Metodos();

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

//        checagem se o aquário vai conter plantas
        if(checkBoxPlantas.isChecked()){
            plantas = true;
        }

        if(radioSim.isChecked()){
            litragem = aquario.calcularLitragemFloat(aquario,'s');

        }else if(radioNao.isChecked()){
            litragem = aquario.calcularLitragemFloat(aquario,'n');

        }

//        Strings contendo os resultados dos cálculos

//        Litragem do aquário
        strLitragem = metodos.converteFloatString(litragem);
        strLitragem += " /Litros";
//        Filtragem
        strFiltro = aquario.calcularFiltro(litragem);
//        Aquecimento
        strAquecimento = aquario.calcularAquecimento(litragem);
//        Iluminação
        strIluminacao = aquario.calcularIluminacao(litragem,plantas);

//        saída de dados para o usuário
        saidaLitragem.setText(strLitragem);
        saidaFiltro.setText(strFiltro);
        saidaIluminacao.setText(strIluminacao);
        saidaAquecedor.setText(strAquecimento);

    }

}