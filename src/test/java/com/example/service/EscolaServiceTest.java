package com.example.service;

import com.example.model.Escola;
import com.example.model.bd.AlunosData;
import com.example.model.bd.EscolaData;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alinesantos on 12/04/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class EscolaServiceTest {

    List<Escola> escolaList;

    @InjectMocks
    private EscolaService escolaService;

    @Before
    public void setUp() throws Exception {
        escolaList = EscolaData.getEscolas();
    }

    @Test
    public void getEscolasTest() throws Exception {
        assertEquals(new Gson().toJson(escolaList), new Gson().toJson(escolaService.ordenaEscolaPorQuantidadeCursos()));
    }

}