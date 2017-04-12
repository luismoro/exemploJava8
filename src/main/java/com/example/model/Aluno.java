package com.example.model;

/**
 * Created by luismoro on 15/03/17.
 */
public class Aluno {

    private final String nome;
    private final String sobrenome;
    private final Integer idade;
    private final String rg;


    public Aluno(String nome, String sobrenome, Integer idade, String rg) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.rg = rg;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getRg() {
        return rg;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade=" + idade +
                ", rg='" + rg + '\'' +
                '}';
    }
}
