package br.ifce.academics.model;

import javax.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "matriculas", uniqueConstraints = @UniqueConstraint(columnNames = {"aluno_id","disciplina_id"}))
public class Matricula {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Aluno aluno;

    @ManyToOne(optional = false)
    private Disciplina disciplina;

    private LocalDate dataMatricula;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    private Double notaFinal;

    public static enum Situacao { CURSANDO, APROVADO, REPROVADO, TRANCADO }
}
