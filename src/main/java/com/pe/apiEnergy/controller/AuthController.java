package com.pe.apiEnergy.controller;

import com.pe.apiEnergy.dto.AuthResponse;
import com.pe.apiEnergy.dto.LoginRequest;
import com.pe.apiEnergy.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest){
        String token=authService.login(loginRequest.getUsername(),loginRequest.getPassword());
        return new AuthResponse(token);
    }
}
