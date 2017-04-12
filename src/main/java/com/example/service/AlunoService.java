package com.example.service;

import com.example.model.Aluno;
import com.example.model.bd.AlunosData;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by luismoro on 15/03/17.
 */
@Service
public class AlunoService {

    public List<Aluno> getAlunos(){
        return AlunosData.getAlunosAndre();
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

       return alunos.stream().
               filter(aluno -> rg.equals(aluno.getRg()))
               .findFirst()
               .orElse(null);
    }

    public Aluno getAlunoJava8(String nome, String sobrenome){
        List<Aluno> alunos = AlunosData.getAlunos();

        return alunos.stream()
                .filter(aluno -> nome.equals(aluno.getNome()))
                .filter(aluno -> sobrenome.equals(aluno.getSobrenome()))
                .findFirst()
                .orElse(null);
    }

    public List<Aluno> getAlunoOrdenadoPorIdade(final List<Aluno> alunos){
        List<Aluno> alunoList = new ArrayList<Aluno>(alunos);

        Collections.sort(alunoList, new ComparadorPorIdade());

        alunos.forEach(new PrintaALuno());

        return alunos;
    }

    public List<Aluno> getAlunoOrdenadoPorIdadeJava8(final List<Aluno> alunos){

        return alunos.stream()
            .sorted((a1,a2) -> a1.getIdade()-a2.getIdade())
            .peek(Aluno::toString)
            .collect(Collectors.toList());


    }

    class ComparadorPorIdade implements Comparator<Aluno> {
        @Override
        public int compare(Aluno a1, Aluno a2) {
            return a1.getIdade()-a2.getIdade();
        }
    }
    class PrintaALuno implements Consumer<Aluno> {
        @Override
        public void accept(Aluno aluno) {
            System.out.println(aluno.getIdade() + " - " + aluno.getNome() + " " + aluno.getSobrenome());
        }
    }


}
