package com.dispositivosmoveis.aquainfo.metodos;

import android.widget.EditText;

public class Metodos {

    public String converteString(EditText dados){
        String converte = dados.getText().toString();
        return converte;
    }
    public float converteFloat(String dados){
        Float converte = Float.parseFloat(dados);
        return converte;
    }

}
