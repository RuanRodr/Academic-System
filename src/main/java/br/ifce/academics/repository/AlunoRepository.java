package br.ifce.academics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifce.academics.model.Aluno;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByMatricula(String matricula);
    boolean existsByMatricula(String matricula);
}
