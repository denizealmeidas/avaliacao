package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.InstrutorDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public List<TurmaDTO> listar(){
        List<TurmaEntity> listEntity = turmaRepository.findAll();
        List<TurmaDTO> listDTO = new ArrayList<>();

        //TODO implementar a conversão da lista de objetos de TurmaEntity para TurmaDTO e retornar a listDTO preenchida


        for(TurmaEntity turmaEntity : listEntity){

            TurmaDTO turma = new TurmaDTO();
            turma.setDtInicio(turma.getDtInicio());
            turma.setDtFim(turma.getDtFim());

            CursoDTO curso = new CursoDTO();
            curso.setNome(turmaEntity.getCurso().getNomeCurso());
            curso.setCargaHoraria(turmaEntity.getCurso().getNrCargaHoraria());

            turma.setCurso(curso);


            //pegar todos os alunos desse curso
            List<AlunoEntity> alunosEntity = turmaEntity.getAlunos();
            List<AlunoDTO> alunosDTO = new ArrayList<>();

            for(AlunoEntity alunoEntity: alunosEntity){
                AlunoDTO aluno = new AlunoDTO();
                aluno.setNome(alunoEntity.getNomeAluno());
                aluno.setCpf(alunoEntity.getCpf());

                alunosDTO.add(aluno);
            }

            //pegar todos os instrutores dessa turma
            List<InstrutorEntity> instrutores = turmaEntity.getInstrutores();
            List<InstrutorDTO> instrutoresDTO = new ArrayList<>();

            for(InstrutorEntity instrutorEntity : instrutores){
                InstrutorDTO instrutor = new InstrutorDTO();
                instrutor.setNome(instrutorEntity.getNomeInstrutor());
                instrutor.setValorHora(instrutorEntity.getValorHora());

                instrutoresDTO.add(instrutor);
            }

            turma.setAlunos(alunosDTO);
            turma.setInstrutores(instrutoresDTO);
            listDTO.add(turma);
        }
        return listDTO;
    }
}
