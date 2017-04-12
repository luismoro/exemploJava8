package com.example.model.bd;

import com.example.model.Professor;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by alinesantos on 12/04/17.
 */
public class ProfessorData {

    public static Professor getProfessor(){
        return new Professor("João Bosco");
    }

    public static List<Professor> getProfessores(){
        return ImmutableList.<Professor>builder()
                .add(new Professor("Carmem Lima"))
                .add(new Professor("Luciano Marcos"))
                .add(new Professor("Zezito"))
                .build();
    }
}
