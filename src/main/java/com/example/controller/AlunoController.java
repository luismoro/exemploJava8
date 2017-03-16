package com.example.controller;

import com.example.model.Aluno;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luismoro on 15/03/17.
 */
@RestController
public class AlunoController {

    @RequestMapping(value = {"/alunos"}, method = RequestMethod.GET)
    public List<Aluno> getAllAlunos() {
        return new ArrayList<>();
    }
//
//    @RequestMapping(value = {"/alunos/{id}"}, method = RequestMethod.GET)
//    public Aluno getAlunos(@PathVariable("id") String id) {
//        return new Aluno("nome","sobrenome", 1);
//    }
//
//    @RequestMapping(value = {"/alunos"}, method = RequestMethod.POST)
//    public Aluno createAlunos(@RequestBody Alunos aluno) {
//        return new Aluno("nome","sobrenome", 1);
//    }
//
//    @RequestMapping(value = {"/alunos/{id}"}, method = RequestMethod.PATCH)
//    public List<Aluno> updateAlunosPacth(@PathVariable("id") String id, @RequestBody List<Aluno> aluno) {
//        return new ArrayList<>();
//    }
//
//    @RequestMapping(value = {"/alunos/{id}"}, method = RequestMethod.PUT)
//    public Aluno updateAlunosPut(@PathVariable("id") String id, @RequestBody List<Aluno> aluno) {
//        return new Aluno("nome","sobrenome", 1);
//    }

}
