package com.dispositivosmoveis.aquainfo.model;

public class Aquario {
    // atributos do objeto aquário
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

//     método para calcular a litragem do aquário
    public float calcularLitragemFloat(Aquario aquario, char desconto){
        float resultado = 0.0f ;

        if (desconto == 's'){
            resultado = (aquario.getComprimento() * aquario.getLargura() * aquario.getAltura()) / 1000f;
            resultado *= 0.85f ;
        }
        if (desconto == 'n'){
            resultado = (aquario.getComprimento() * aquario.getLargura() * aquario.getAltura()) / 1000f;
        }
        return resultado;
    }

//    método para calcular o filtro adequado
    public String calcularFiltro(float litragem){
        int vazao = (int) (litragem * 5);
        return String.valueOf(vazao) + " l/h";
    }

//    método para calcular o aquecimento adequado
    public String calcularAquecimento(float litragem){
        int aquecimento = (int) (litragem * 1);
        return String.valueOf(aquecimento) + " w/l";
    }

//    método para calcular a iluminação adequado
    public String calcularIluminacao(float litragem, boolean plantas){
        int iluminacao = 0;
        if(plantas){
            iluminacao = (int) (litragem * 1);
        }else{
            iluminacao = (int) (litragem / 2);
        }
        return String.valueOf(iluminacao) + " w/l";
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
