package br.ifce.academics.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import br.ifce.academics.repository.UsuarioRepository;
import br.ifce.academics.model.Usuario;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UsuarioRepository repo;
    public CustomUserDetailsService(UsuarioRepository repo){ this.repo = repo; }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = repo.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        return User.builder()
                .username(u.getLogin())
                .password(u.getSenha())
                .roles(u.getRole().replace("ROLE_",""))
                .build();
    }
}
