package com.dispositivosmoveis.aquainfo.model;

public class Aquario {
    // atributos do obejto aquário
    private float largura;
    private float altura;
    private float comprimento;


    // método para calcular a litragem do aquário
    public String calcularLitragem(Aquario aquario, char desconto){
        float resultado = 0.0f ;

        if (desconto == 's'){
            resultado = (aquario.getComprimento() * aquario.getLargura() * aquario.getAltura()) / 1000f;
            resultado *= 0.85f ;
        }
        if (desconto == 'n'){
            resultado = (aquario.getComprimento() * aquario.getLargura() * aquario.getAltura()) / 1000f;
        }
        return String.valueOf(resultado) + "/Litros";

    }

//    métodos construtores
    public Aquario() {
    }

    public Aquario(float largura, float altura, float comprimento) {
        this.largura = largura;
        this.altura = altura;
        this.comprimento = comprimento;
    }

    //    métodos get's e set's
    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }
}
