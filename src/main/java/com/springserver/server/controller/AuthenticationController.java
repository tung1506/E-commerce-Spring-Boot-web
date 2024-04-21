package com.springserver.server.controller;

import com.springserver.server.dto.SiteUserDto;
import com.springserver.server.security.AuthenticationResponse;
import com.springserver.server.service.user.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(SiteUserDto userDTO) {
        return ResponseEntity.ok(authenticationService.register(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login( SiteUserDto userDTO) {
        return ResponseEntity.ok(authenticationService.login(userDTO));
    }
}