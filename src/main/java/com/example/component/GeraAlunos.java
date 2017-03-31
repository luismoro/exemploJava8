package com.example.component;

import com.google.gson.Gson;

import com.example.model.Aluno;

import java.util.List;

/**
 * Created by luismoro on 31/03/17.
 */
public class GeraAlunos {

    public GeraAlunos(){}

    public Aluno getAluno (){
        return new Gson().fromJson("{\n" +
                "        \"nome\": \"Nome1\",\n" +
                "        \"sobrenome\": \"Sobrenome1\",\n" +
                "        \"idade\": \"1\",\n" +
                "        \"rg\" : \"rg1\"\n" +
                "    }", Aluno.class);
    }

    public List<Aluno> getAlunos (){
        return new Gson().fromJson("[\n" +
                "    {\n" +
                "        \"nome\": \"Nome1\",\n" +
                "        \"sobrenome\": \"Sobrenome1\",\n" +
                "        \"idade\": \"1\",\n" +
                "        \"rg\" : \"rg1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"nome\": \"Nome2\",\n" +
                "        \"sobrenome\": \"Sobrenome2\",\n" +
                "        \"idade\": \"2\",\n" +
                "        \"rg\" : \"rg2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"nome\": \"Nome3\",\n" +
                "        \"sobrenome\": \"Sobrenome3\",\n" +
                "        \"idade\": \"3\",\n" +
                "        \"rg\" : \"rg3\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"nome\": \"Nome4\",\n" +
                "        \"sobrenome\": \"Sobrenome4\",\n" +
                "        \"idade\": \"4\",\n" +
                "        \"rg\" : \"rg4\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"nome\": \"Nome5\",\n" +
                "        \"sobrenome\": \"Sobrenome5\",\n" +
                "        \"idade\": \"5\",\n" +
                "        \"rg\" : \"rg5\"\n" +
                "    }\n" +
                "]", List.class);
    }

}
