package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alinesantos on 15/03/17.
 */
public class Disciplina {

    private String nome;
    private String codigo;
    private Professor professor;
    private List<Aluno> alunos;


    public Disciplina(String nome, String codigo, Professor professor, List<Aluno> alunos) {
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
