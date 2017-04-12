package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alinesantos on 12/04/17.
 */
public class Curso {

    private String nome;

    private List<Disciplina> disciplinas = new ArrayList<>();

    public Curso(String nome, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
