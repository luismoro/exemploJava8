package com.example.model.bd;

import com.example.model.Curso;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alinesantos on 12/04/17.
 */
public class CursoData {

    public static List<Curso> getCursos(Integer qtd) {

        List<Curso> cursos = new ArrayList<>();
        for (int i = qtd; i >= 0; i--) {
            cursos.add(new Curso("Curso " + i, null));
        }

        return cursos;
    }
}
