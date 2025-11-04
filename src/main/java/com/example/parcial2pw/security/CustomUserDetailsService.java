package com.example.parcial2pw.security;

import com.example.parcial2pw.model.Usuario;
import com.example.parcial2pw.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
    	Usuario u = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if (u == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return new User(
                u.getCorreo(),
                u.getPassword(), // debe estar codificada con PasswordEncoder
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + u.getRol().name()))
        );
    }
}
