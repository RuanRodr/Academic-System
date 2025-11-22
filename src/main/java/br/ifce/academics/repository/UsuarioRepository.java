package br.ifce.academics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifce.academics.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
}
