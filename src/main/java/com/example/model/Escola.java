package com.example.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alinesantos on 15/03/17.
 */
public class Escola {

    private String nome;
    private List<Curso> cursos;


    public Escola(String nome, List<Curso> cursos) {
        this.nome = nome;
        this.cursos = cursos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
