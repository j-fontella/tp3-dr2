package com.example.tp3_dr2.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Questionario implements Serializable {

    private ArrayList<Integer> pontuacao = new ArrayList<>();
    private String perfil;
    private int navegador;
    private ArrayList<Questao> questoes = new ArrayList<>();

    public Questionario(String perfil){
        this.perfil = perfil;
        navegador = 1;
    }

    public void addQuestao(String qNumero, String enunciado, String r1, String r2, String r3){
        ArrayList<String> respostas = new ArrayList<>();
        respostas.add(r1);
        respostas.add(r2);
        respostas.add(r3);
        questoes.add(new Questao(qNumero, enunciado,respostas));
    }
    public void addQuestao(String qNumero, String enunciado, String r1, String r2, String r3, String r4){
        ArrayList<String> respostas = new ArrayList<>();
        respostas.add(r1);
        respostas.add(r2);
        respostas.add(r3);
        respostas.add(r4);
        questoes.add(new Questao(qNumero, enunciado,respostas));
    }
    public void addQuestao(String qNumero, String enunciado, String r1, String r2, String r3, String r4, String r5){
        ArrayList<String> respostas = new ArrayList<>();
        respostas.add(r1);
        respostas.add(r2);
        respostas.add(r3);
        respostas.add(r4);
        respostas.add(r5);
        questoes.add(new Questao(qNumero, enunciado,respostas));
    }

    public ArrayList<Questao> getQuestoes() {
        return questoes;
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
