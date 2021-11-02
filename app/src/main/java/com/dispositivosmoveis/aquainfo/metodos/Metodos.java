package com.dispositivosmoveis.aquainfo.metodos;

import android.widget.EditText;

public class Metodos {
    public String calcularLitragem(EditText altura, EditText largura, EditText comprimento){
        Float alturaNumero = Float.parseFloat(converte(altura));
        Float larguraNumero = Float.parseFloat(converte(largura));
        Float comprimentoNumero = Float.parseFloat(converte(comprimento));
        Float calculo = (comprimentoNumero * larguraNumero * alturaNumero) / 1000f;

        return calculo.toString();
    }
    public String converte(EditText dados){
        String converte = dados.getText().toString();
        return converte;
    }

}
