package br.ifce.academics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifce.academics.model.Disciplina;
import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    Optional<Disciplina> findByCodigo(String codigo);
    boolean existsByCodigo(String codigo);
}
