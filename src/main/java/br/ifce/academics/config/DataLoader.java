package br.ifce.academics.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.ifce.academics.model.Usuario;
import br.ifce.academics.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(UsuarioRepository repo, BCryptPasswordEncoder encoder) {
        return args -> {
            if(repo.findByLogin("admin").isEmpty()) {
                Usuario u = new Usuario();
                u.setLogin("admin");
                u.setSenha(encoder.encode("admin123"));
                u.setRole("ROLE_ADMIN");
                repo.save(u);
            }
            if(repo.findByLogin("secretaria").isEmpty()) {
                Usuario s = new Usuario();
                s.setLogin("secretaria");
                s.setSenha(encoder.encode("sec123"));
                s.setRole("ROLE_SECRETARIA");
                repo.save(s);
            }
        };
    }
}
