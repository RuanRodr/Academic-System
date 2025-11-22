package br.ifce.academics.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ifce.academics.repository.AlunoRepository;
import br.ifce.academics.model.Aluno;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository repo;
    public AlunoService(AlunoRepository repo){ this.repo = repo; }

    public List<Aluno> findAll(){ return repo.findAll(); }
    public Optional<Aluno> findById(Long id){ return repo.findById(id); }

    @Transactional
    public Aluno save(Aluno a){
        if(a.getMatricula() != null && repo.existsByMatricula(a.getMatricula())){
            // if updating same aluno, allow — naive check: if id null treat as create
            if(a.getId()==null) throw new RuntimeException("Matrícula duplicada");
            var existing = repo.findByMatricula(a.getMatricula()).orElse(null);
            if(existing != null && !existing.getId().equals(a.getId())) throw new RuntimeException("Matrícula duplicada");
        }
        return repo.save(a);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
