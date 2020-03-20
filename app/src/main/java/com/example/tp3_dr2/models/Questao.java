package com.example.tp3_dr2.models;

import java.io.Serializable;

public class Questao implements Serializable {
    private String enunciado;

    public Questao(String enunciado){
        this.enunciado = enunciado;
    }
}
