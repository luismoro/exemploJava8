package com.example.service;

import com.google.gson.Gson;

import com.example.model.Aluno;
import com.example.model.bd.AlunosData;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by luismoro on 31/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AlunoServiceTest {
    List<Aluno> alunoList;

    @InjectMocks
    private AlunoService alunoService;

    @Before
    public void setUp() throws Exception {
        alunoList = AlunosData.getAlunos();
    }

    @Test
    public void getAlunosTest() throws Exception {
        assertEquals(new Gson().toJson(alunoList), new Gson().toJson(alunoService.getAlunos()));
    }

    @Test
    public void getAlunoTest() throws Exception {
        assertEquals(new Gson().toJson(alunoList.get(0)), new Gson().toJson(alunoService.getAluno(alunoList.get(0).getRg())));
    }

    @Test
    public void getAlunoPorNomeTest() throws Exception {
        assertEquals(new Gson().toJson(alunoList.get(0)), new Gson().toJson(alunoService.getAluno(alunoList.get(0).getNome(), alunoList.get(0).getSobrenome())));
    }

}
