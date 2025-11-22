package br.ifce.academics.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "alunos", uniqueConstraints = @UniqueConstraint(columnNames = "matricula"))
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @Column(nullable = false, unique = true)
    private String matricula;
    
    private String email;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    
    @Enumerated(EnumType.STRING)
    private Status status;

    public static enum Status { ATIVO, INATIVO }
}
