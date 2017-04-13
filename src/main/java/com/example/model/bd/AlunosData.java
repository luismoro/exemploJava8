package com.example.model.bd;

import com.google.common.collect.ImmutableList;

import com.example.model.Aluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luismoro on 15/03/17.
 */
public class AlunosData {

    public static List<Aluno> getAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        Aluno aluno;
        aluno = new Aluno("Nome2", "Sobrenome2", 2, "rg2");
        alunos.add(aluno);
        aluno = new Aluno("Nome4", "Sobrenome4", 4, "rg4");
        alunos.add(aluno);
        aluno = new Aluno("Nome6", "Sobrenome6", 6, "rg6");
        alunos.add(aluno);
        aluno = new Aluno("Nome8", "Sobrenome8", 8, "rg8");
        alunos.add(aluno);
        aluno = new Aluno("Nome10", "Sobrenome10", 10, "rg10");
        alunos.add(aluno);
        aluno = new Aluno("Nome1", "Sobrenome1", 1, "rg1");
        alunos.add(aluno);
        aluno = new Aluno("Nome3", "Sobrenome3", 3, "rg3");
        alunos.add(aluno);
        aluno = new Aluno("Nome5", "Sobrenome5", 5, "rg5");
        alunos.add(aluno);
        aluno = new Aluno("Nome7", "Sobrenome7", 7, "rg7");
        alunos.add(aluno);
        aluno = new Aluno("Nome9", "Sobrenome9", 9, "rg9");
        alunos.add(aluno);
        return alunos;
    }

    public static List<Aluno> getAlunosAndre() {
        return ImmutableList.<Aluno>builder()
                .add(new Aluno("Nome2", "Sobrenome2", 2, "rg2"))
                .add(new Aluno("Nome4", "Sobrenome4", 4, "rg4"))
                .add(new Aluno("Nome6", "Sobrenome6", 6, "rg6"))
                .add(new Aluno("Nome8", "Sobrenome8", 8, "rg8"))
                .add(new Aluno("Nome10", "Sobrenome10", 10, "rg10"))
                .add(new Aluno("Nome1", "Sobrenome1", 1, "rg1"))
                .add(new Aluno("Nome3", "Sobrenome3", 3, "rg3"))
                .add(new Aluno("Nome5", "Sobrenome5", 5, "rg5"))
                .add(new Aluno("Nome7", "Sobrenome7", 7, "rg7"))
                .add(new Aluno("Nome9", "Sobrenome9", 9, "rg9"))
                .build();
    }

}
