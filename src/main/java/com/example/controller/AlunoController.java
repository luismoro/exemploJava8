package com.example.controller;

import com.example.model.Aluno;
import com.example.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return alunosService.getAlunoJava8(rg);
    }

}
