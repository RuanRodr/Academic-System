package br.ifce.academics.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "disciplinas", uniqueConstraints = @UniqueConstraint(columnNames = "codigo"))
public class Disciplina {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String codigo;
    private String nome;
    private Integer cargaHoraria;
    private String semestre;
}
