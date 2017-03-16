package com.example.model.bd;

import com.example.model.Aluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luismoro on 15/03/17.
 */
public class AlunosData {

    public static List<Aluno> setAlunos() {
        List<Aluno> alunos = new ArrayList<>();

        Aluno aluno = new Aluno("Nome1", "Sobrenome1", 1);
        alunos.add(aluno);
        aluno = new Aluno("Nome2", "Sobrenome2", 2);
        alunos.add(aluno);
        aluno = new Aluno("Nome3", "Sobrenome3", 3);
        alunos.add(aluno);
        aluno = new Aluno("Nome4", "Sobrenome4", 4);
        alunos.add(aluno);
        aluno = new Aluno("Nome5", "Sobrenome5", 5);
        alunos.add(aluno);
        aluno = new Aluno("Nome6", "Sobrenome6", 6);
        alunos.add(aluno);
        aluno = new Aluno("Nome7", "Sobrenome7", 7);
        alunos.add(aluno);


        return alunos;
    }

}
