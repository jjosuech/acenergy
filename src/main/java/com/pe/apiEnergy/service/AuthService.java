package com.pe.apiEnergy.service;

import com.pe.apiEnergy.model.Usuario;
import com.pe.apiEnergy.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String login(String username, String password){

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(()->new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password,usuario.getPassword())){
            throw new RuntimeException("Password incorrecto");
        }

        return jwtService.generateToken(usuario.getUsername());
    }
}