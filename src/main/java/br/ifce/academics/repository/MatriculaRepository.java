package br.ifce.academics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifce.academics.model.Matricula;
import br.ifce.academics.model.Aluno;
import br.ifce.academics.model.Disciplina;
import java.util.Optional;
import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    Optional<Matricula> findByAlunoAndDisciplina(Aluno aluno, Disciplina disciplina);
    List<Matricula> findByAluno(Aluno aluno);
    List<Matricula> findByDisciplina(Disciplina disciplina);
}
