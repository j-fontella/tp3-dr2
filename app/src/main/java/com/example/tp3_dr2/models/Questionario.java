package com.example.tp3_dr2.models;

import java.util.ArrayList;

public class Questionario {

    private ArrayList<Questao> questoes = new ArrayList<>();
    private int pontuacao;
    private String perfil;
    private int navegador;

    public Questionario(String perfil){
        this.perfil = perfil;
        navegador = 1;
    }

    public int getPontuacao(){
        return pontuacao;
    }
    public void addPontuacao(int pontos){
        pontuacao += pontos;
    }
    public String getPerfil() {
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }


    public int getNavegador() {
        return navegador;
    }

    public void setNavegador(int navegador) {
        this.navegador = navegador;
    }


}
