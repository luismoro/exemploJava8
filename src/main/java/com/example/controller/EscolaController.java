package com.example.controller;

import com.example.model.Escola;
import com.example.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alinesantos on 12/04/17.
 */

@RestController
@RequestMapping("escola")
public class EscolaController {

    @Autowired
    EscolaService escolaService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Escola> getAlunoPorNomeJava8(@RequestParam(value = "qtdAlunos") Integer qtdAlunos) {
        return escolaService.getEscolaPorQuantidadeAlunos(qtdAlunos);
    }


}
