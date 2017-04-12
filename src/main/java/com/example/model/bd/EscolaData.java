package com.example.model.bd;

import com.example.model.Escola;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by alinesantos on 12/04/17.
 */
public class EscolaData {

    public static Escola getEscola(){
        return new Escola("Fiap",CursoData.getCursos(10));
    }

    public static List<Escola> getEscolas(){
        return ImmutableList.<Escola>builder()
                .add(new Escola("Impacta", CursoData.getCursos(3)))
                .add(new Escola("Fiap", CursoData.getCursos(10)))
                .add(new Escola("Uninove", CursoData.getCursos(120)))
                .add(new Escola("Senac", CursoData.getCursos(45)))
                .add(getEscola())
                .build();
    }
}
