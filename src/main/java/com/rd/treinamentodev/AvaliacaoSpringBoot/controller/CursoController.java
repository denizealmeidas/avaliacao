package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CursoController {

    @Autowired
    private CursoService service;


//    @Autowired
//    private CursoRepository repository;
//
//    @GetMapping("/curso/{nome}")
//    public List<CursoEntity> getServico(@PathVariable("nome") String nome){
//        return repository.findByNomeCurso(nome);
//    }

    @PostMapping("/curso")
    public ResponseEntity cadastrarCurso(@RequestBody CursoDTO curso){
        //if (curso.getNome() == null || curso.getCargaHoraria() == null)
        //    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome e carga horária são atributos obrigatórios");
        String retorno = service.cadastrar(curso);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
}
