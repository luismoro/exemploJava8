package com.example.controller;

import com.google.gson.Gson;

import com.example.model.Aluno;
import com.example.model.bd.AlunosData;
import com.example.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * Created by luismoro on 15/03/17.
 */
@RestController
public class AlunoController {

    @Autowired
    AlunoService alunosService;

    @RequestMapping(value = {"/alunos"}, method = RequestMethod.GET)
    public List<Aluno> getAluno() {
        return alunosService.getAlunos();
    }

    @RequestMapping(value = {"/alunosPorNome"}, method = RequestMethod.GET)
    public Aluno getAlunoPorNome(@RequestParam(value = "nome") String nome, @RequestParam(value = "sobrenome") String sobrenome) {
        return alunosService.getAluno(nome, sobrenome);
    }
    @RequestMapping(value = {"/alunos/{rg}"}, method = RequestMethod.GET)
    public Aluno getAluno(@PathVariable("rg") String rg) {
        return alunosService.getAluno(rg);
    }

    @RequestMapping(value = {"/alunosPorNomeJava8"}, method = RequestMethod.GET)
    public Aluno getAlunoPorNomeJava8(@RequestParam(value = "nome") String nome, @RequestParam(value = "sobrenome") String sobrenome) {
        return alunosService.getAlunoJava8(nome, sobrenome);
    }
    @RequestMapping(value = {"/alunosJava8/{rg}"}, method = RequestMethod.GET)
    public Aluno getAlunoJava8(@PathVariable("rg") String rg) {
        return alunosService.getAlunoJava8(rg).orElse(new Aluno("Aluno", "Novo", 0, rg));
    }
    @RequestMapping(value = {"/alunosOrdenadosPorIdade"}, method = RequestMethod.GET)
    public List<Aluno> getAlunoOrdenadosPorIdade() {
        return alunosService.getAlunoOrdenadoPorIdade(AlunosData.getAlunos());
    }
    @RequestMapping(value = {"/alunosOrdenadosPorIdadeDefatultMetod"}, method = RequestMethod.GET)
    public List<Aluno> getAlunoOrdenadosPorIdadeDefaultMetod() {
        return alunosService.getAlunoOrdenadoPorIdadeDefaultMetod(AlunosData.getAlunos());
    }
    @RequestMapping(value = {"/alunosOrdenadosPorIdadeJava8"}, method = RequestMethod.GET)
    public List<Aluno> getAlunoOrdenadosPorIdadeJava8() {
        return alunosService.getAlunoOrdenadoPorIdadeJava8(AlunosData.getAlunosAndre());
    }
    @RequestMapping(value = {"/printaAlunos"}, method = RequestMethod.GET)
    public void printaAlunos() {
        alunosService.printaAlunos(AlunosData.getAlunos());
    }
    @RequestMapping(value = {"/printaAlunosComLambda"}, method = RequestMethod.GET)
    public void printaAlunosComLambda() {
        alunosService.printaAlunosComLambda(AlunosData.getAlunos());
    }
    @RequestMapping(value = {"/getAlunosIdadeMaior5"}, method = RequestMethod.GET)
    public List<Aluno> getAlunosIdadeMaior5() {
        return alunosService.getAlunosIdadeMaior5(AlunosData.getAlunos());
    }
    @RequestMapping(value = {"/getMediaIdadeAlunosOrZero"}, method = RequestMethod.GET)
    public Double getMediaIdadeAlunosOrZero() {
        return alunosService.getMediaIdadeAlunos(AlunosData.getAlunos())
                .orElse(0);
    }
    @RequestMapping(value = {"/getMediaIdadeDivididoPor2EPrintaAlunosOrZero"}, method = RequestMethod.GET)
    public Double getMediaIdadeDivididoPor2EPrintaAlunosOrZero() {
         final Double  aDouble;

        OptionalDouble mediaIdadeAlunos = alunosService.getMediaIdadeAlunos(AlunosData.getAlunos());
        mediaIdadeAlunos.ifPresent(media -> System.out.println(media/2));

        return mediaIdadeAlunos.isPresent() ? mediaIdadeAlunos.getAsDouble() / 2 : 0;
    }
    @RequestMapping(value = {"/getalunoPorRg123/{rg}"}, method = RequestMethod.GET)
    public Aluno getalunoPorRg123(@PathVariable("rg") String rg) {
        Optional<Aluno> rg1 = alunosService.getAlunoJava8(rg);
        return rg1.filter(a -> a.getRg().startsWith("123"))
                .orElse(new Aluno("Aluno", "Novo", 0, rg));
    }
    @RequestMapping(value = {"/printaNome"}, method = RequestMethod.GET)
    public void printaNome() {
        List<Aluno> alunos = AlunosData.getAlunos();

        System.out.println("Java 8 - Lambda");
        alunos.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
        alunos.forEach(a -> System.out.println(a.getNome()));

        System.out.println("Java 8 - Method Reference");
        alunos.stream()
                .map(a -> a.getNome())
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }
    @RequestMapping(value = {"/getDatas"}, method = RequestMethod.GET)
    public String getDatas() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");


        String hoje = alunosService.getHoje().format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        int diferencaAno = alunosService.getDiferencaAno(LocalDate.now().plusYears(4));
        Period diferencaAnoMesDia = alunosService.getDiferencaAnoMesDia(LocalDate.now().plusYears(4));
        String soma4Anos = alunosService.getSoma4Anos(LocalDate.now());


        Map map = new HashMap();
        map.put("hoje", hoje);
        map.put("diferencaAno", diferencaAno);
        map.put("diferencaAnoMesDia", diferencaAnoMesDia);
        map.put("soma4Anos", soma4Anos);

        return new Gson().toJson(map);

    }
}
