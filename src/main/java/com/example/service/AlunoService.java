package com.example.service;

import com.example.model.Aluno;
import com.example.model.bd.AlunosData;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
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

    public Optional<Aluno> getAlunoJava8(String rg){
        List<Aluno> alunos = AlunosData.getAlunos();

       return alunos.stream().
               filter(aluno -> rg.equals(aluno.getRg()))
               .findFirst();
    }

    public Aluno getAlunoJava8(String nome, String sobrenome){
        List<Aluno> alunos = AlunosData.getAlunos();

        return alunos.stream()
                .filter(aluno -> nome.equals(aluno.getNome()))
                .filter(aluno -> sobrenome.equals(aluno.getSobrenome()))
                .findFirst()
                .orElse(null);
    }

    public List<Aluno> getAlunoOrdenadoPorIdade(List<Aluno> alunos){
        Collections.sort(alunos, new ComparadorPorIdade());

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        return alunos;
    }

    public List<Aluno> getAlunoOrdenadoPorIdadeDefaultMetod(List<Aluno> alunos){
        alunos.sort(new ComparadorPorIdade());
        alunos.forEach(new PrintaAluno());
        return alunos;
    }

    public void printaAlunosConsumer(List<Aluno> alunos){
        Consumer<Aluno> consumer = new Consumer<Aluno>() {
            @Override
            public void accept(Aluno aluno) {
                System.out.println(aluno);
            }
        };
        alunos.forEach(consumer);
    }

    public void printaAlunos(List<Aluno> alunos){
        alunos.forEach(new Consumer<Aluno>() {
            @Override
            public void accept(Aluno aluno) {
                System.out.println(aluno);
            }
        });
    }

    public void printaAlunosComLambda(List<Aluno> alunos){
        alunos.forEach(aluno -> System.out.println(aluno));
    }

    public void printaAlunosComMethodReference(List<Aluno> alunos){
        alunos.forEach(System.out::println);
    }

    public List<Aluno> getAlunoOrdenadoPorIdadeJava8(final List<Aluno> alunos){
        return alunos.stream()
            .sorted((a1,a2) -> a1.getIdade()-a2.getIdade())
            .peek(System.out::println)
            .collect(Collectors.toList());
    }

    public List<Aluno> ordenaAlunoPorIdadeListJava8(){
        List<Aluno> alunos = AlunosData.getAlunos();
        alunos.sort((aluno1, aluno2) -> Integer.compare(aluno1.getIdade(), aluno2.getIdade()));

        alunos.sort(Comparator.comparingInt(Aluno::getIdade));

        return alunos;
    }

    class ComparadorPorIdade implements Comparator<Aluno> {
        @Override
        public int compare(Aluno a1, Aluno a2) {
            return a1.getIdade()-a2.getIdade();
        }
    }
    class PrintaAluno implements Consumer<Aluno> {
        @Override
        public void accept(Aluno aluno) {
            System.out.println(aluno);
        }
    }

    public List<Aluno> getAlunosIdadeMaior5(final List<Aluno> alunos){
        return alunos.stream()
                .filter(aluno -> aluno.getIdade()>5)
                .collect(Collectors.toList());
    }

    public OptionalDouble getMediaIdadeAlunos(final List<Aluno> alunos){
        return alunos.stream()
                .mapToInt(aluno -> aluno.getIdade())
                .average();
    }

    public LocalDate getHoje(){
        return LocalDate.now();
    }

    public int getDiferencaAno(LocalDate localDate){
        return localDate.getYear() - LocalDate.now().getYear();
    }

    public Period getDiferencaAnoMesDia(LocalDate localDate){
        Period period = Period.between(LocalDate.now(), localDate);
        return period;
    }

    public String getSoma4Anos(LocalDate localDate){
        LocalDate localDatePlus4 = localDate.plusYears(4);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return dateTimeFormatter.format(localDatePlus4);
    }
}
