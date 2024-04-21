package com.springserver.server.service.user;

import com.springserver.server.domain.Role;
import com.springserver.server.domain.SiteUser;
import com.springserver.server.dto.SiteUserDto;
import com.springserver.server.exception.InvalidCredentialsException;
import com.springserver.server.exception.UserAlreadyExistsException;
import com.springserver.server.repository.UserRepository;
import com.springserver.server.security.AuthenticationResponse;
import com.springserver.server.security.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse register(SiteUserDto request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("User with username " + request.getUsername() + " already exists");
        }
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        SiteUser user = new ModelMapper().map(request, SiteUser.class);
        if (request.getUsername().equals("admin")) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }
        userRepository.save(user);
        var jwtToken = jwtUtil.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse login(SiteUserDto siteUser) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            siteUser.getUsername(),
                            siteUser.getPassword()
                    )
            );
        } catch (BadCredentialsException e){
            throw new InvalidCredentialsException("Incorrect username or password");
        }
        var user = userRepository.findByUsername(siteUser.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        var jwtToken = jwtUtil.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}