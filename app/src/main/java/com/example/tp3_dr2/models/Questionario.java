package com.example.tp3_dr2.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Questionario implements Serializable {

    private ArrayList<Questao> questoes = new ArrayList<>();
    private ArrayList<Integer> pontuacao = new ArrayList<>();
    private int score;
    private String perfil;
    private int navegador;

    public Questionario(String perfil){
        this.perfil = perfil;
        navegador = 1;
    }

    public void removePontuacao(){
        pontuacao.remove(pontuacao.size() - 1);
    }
    public void addPontuacao(Integer pontos){
        pontuacao.add(pontos);
    }
    public String getPerfil() {
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public ArrayList<Integer> getPontuacao() {
        return pontuacao;
    }

    public int getNavegador() {
        return navegador;
    }

    public void setNavegador(int navegador) {
        this.navegador = navegador;
    }


}
