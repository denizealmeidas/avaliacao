package com.rd.treinamentodev.AvaliacaoSpringBoot.repository;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {

    List<CursoEntity> findByNomeCurso(String curso);
    //CursoRepository um método de busca por nome do curso que retorne uma lista de cursos.

}
