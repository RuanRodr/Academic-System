package br.ifce.academics.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String login;
    @Column(nullable = false)
    private String senha; // BCrypt
    @Column(nullable = false)
    private String role; // e.g., ROLE_ADMIN, ROLE_SECRETARIA
}
