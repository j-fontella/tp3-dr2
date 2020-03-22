package com.example.tp3_dr2.models;

import java.util.ArrayList;

public class Questao {
    private String qNumero;
    private String enunciado;
    private ArrayList<String> respostas;

    public Questao(String qNumero, String enunciado, ArrayList<String> respostas) {
        this.qNumero = qNumero;
        this.enunciado = enunciado;
        this.respostas = respostas;
    }

    public String getqNumero() {
        return qNumero;
    }

    public void setqNumero(String questao_numero) {
        this.qNumero = questao_numero;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }


    public ArrayList<String> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<String> respostas) {
        this.respostas = respostas;
    }
}
