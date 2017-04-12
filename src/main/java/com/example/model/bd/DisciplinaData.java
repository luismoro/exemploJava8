package com.example.model.bd;

import com.example.model.Disciplina;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by alinesantos on 12/04/17.
 */
public class DisciplinaData {

    public static List<Disciplina> getDisciplinas(){

        return ImmutableList.<Disciplina>builder()
                .add(new Disciplina("Disciplina1", "cod12", null, AlunosData.getAlunos()))
                .add(new Disciplina("Disciplina2", "cod02", null, AlunosData.getAlunos()))
                .add(new Disciplina("Disciplina3", "cod35", null, AlunosData.getAlunos()))
                .add(new Disciplina("Disciplina4", "cod21", null, AlunosData.getAlunos()))
                .build();
    }
}
