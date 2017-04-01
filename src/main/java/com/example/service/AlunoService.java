package com.example.service;

import com.example.model.Aluno;
import com.example.model.bd.AlunosData;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by luismoro on 15/03/17.
 */
@Service
public class AlunoService {

    public List<Aluno> getAlunos(){
        return AlunosData.getAlunos();
    }

    public Aluno getAluno(String rg){
        List<Aluno> alunos = AlunosData.getAlunos();

        for (Aluno aluno : alunos) {
            if (rg.equals(aluno.getRg())) {
                return aluno;
            }
        }

        return null;
    }

    public Aluno getAluno(String nome, String sobrenome){
        List<Aluno> alunos = AlunosData.getAlunos();

        for (Aluno aluno : alunos) {
            if (nome.equals(aluno.getNome()) && sobrenome.equals(aluno.getSobrenome())) {
                return aluno;
            }
        }

        return null;
    }

    public Aluno getAlunoJava8(String rg){
        List<Aluno> alunos = AlunosData.getAlunos();

       return alunos.stream().filter(aluno -> rg.equals(aluno.getRg())).findFirst().orElse(null);
    }

    public Aluno getAlunoJava8(String nome, String sobrenome){
        List<Aluno> alunos = AlunosData.getAlunos();

        return alunos.stream().filter(
                aluno -> nome.equals(aluno.getNome())).filter(
                aluno -> sobrenome.equals(aluno.getSobrenome())
        ).findFirst().orElse(null);
    }

}
