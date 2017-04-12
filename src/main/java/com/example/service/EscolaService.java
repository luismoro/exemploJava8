package com.example.service;

import com.example.model.Curso;
import com.example.model.Escola;
import com.example.model.bd.EscolaData;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by alinesantos on 12/04/17.
 */
@Service
public class EscolaService {


    public List<Escola> getEscolaPorQuantidadeAlunos(Integer qtdAluno) {

        List<Escola> listaEscolas = EscolaData.getEscolas();

        ComparadorPorTamanho comparadorPorTamanho = new ComparadorPorTamanho();
        Collections.sort(listaEscolas, comparadorPorTamanho);

        System.out.println(listaEscolas);
        return null;
    }

    public List<Escola> getEscolaPorQuantidadeAlunosJava8(Integer qtdAluno) {
        return null;
    }

    class ComparadorPorTamanho implements Comparator<Escola>{

        @Override
        public int compare(Escola e1, Escola e2) {


            if (e1.getCursos().size() < e2.getCursos().size()){
                return -1;
            }

            if(e1.getCursos().size() > e1.getCursos().size()){
                return  1;
            }
            return 0;
        }
    }
}
