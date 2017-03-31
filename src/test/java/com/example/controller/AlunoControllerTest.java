package com.example.controller;

import com.google.gson.Gson;

import com.example.model.Aluno;
import com.example.model.bd.AlunosData;
import com.example.service.AlunoService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by luismoro on 31/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AlunoControllerTest {

    @InjectMocks
    private AlunoController alunoController;

    @Mock
    AlunoService alunoService;

    List<Aluno> alunoList;
    Aluno aluno;

    @Before
    public void setUp() throws Exception {
        aluno = AlunosData.getAlunos().get(0);
        alunoList = AlunosData.getAlunos();
    }

    @Test
    public void getAlunosTest() throws Exception {
        when(alunoService.getAlunos()).thenReturn(alunoList);

        assertEquals(new Gson().toJson(alunoList), new Gson().toJson(alunoController.getAluno()));
    }

    @Test
    public void getAlunoPorNomeTest() throws Exception {
        when(alunoService.getAluno(anyString(), anyString())).thenReturn(aluno);

        assertEquals(new Gson().toJson(aluno), new Gson().toJson(alunoController.getAlunoPorNome("Nome1", "Sobrenome1")));
    }

    @Test
    public void getAlunoRgTest() throws Exception {
        when(alunoService.getAluno(anyString())).thenReturn(aluno);

        assertEquals(new Gson().toJson(aluno), new Gson().toJson(alunoController.getAluno("rg1")));
    }

}
