package br.ifce.academics.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ifce.academics.repository.MatriculaRepository;
import br.ifce.academics.model.Matricula;
import br.ifce.academics.model.Aluno;
import br.ifce.academics.model.Disciplina;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {
    private final MatriculaRepository repo;
    public MatriculaService(MatriculaRepository repo){ this.repo = repo; }

    public List<Matricula> findAll(){ return repo.findAll(); }

    @Transactional
    public Matricula save(Matricula m){
        if(m.getAluno()==null || m.getDisciplina()==null) throw new RuntimeException("Aluno e Disciplina obrigatórios");
        var existing = repo.findByAlunoAndDisciplina(m.getAluno(), m.getDisciplina());
        if(existing.isPresent()){
            if(m.getId()==null) throw new RuntimeException("Aluno já matriculado nessa disciplina");
            if(!existing.get().getId().equals(m.getId())) throw new RuntimeException("Aluno já matriculado nessa disciplina");
        }
        if(m.getDataMatricula()==null) m.setDataMatricula(java.time.LocalDate.now());
        return repo.save(m);
    }

    public void delete(Long id){ repo.deleteById(id); }
}
