package com.pronto.library.service;

import com.pronto.library.dto.input.LoginInputData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * The type Auth service.
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    /**
     * Auth request map.
     *
     * @param authRequestDto the auth request dto
     * @return the map
     */
    public Map<String, String> authRequest(LoginInputData authRequestDto) {
        final var authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.userName(), authRequestDto.password()));
        final var userDetails = (UserDetails) authenticate.getPrincipal();
        return getToken(userDetails);
    }

    /**
     * Gets token.
     *
     * @param userDetails the user details
     * @return the token
     */
    public Map<String, String> getToken(UserDetails userDetails) {
        final var roles = userDetails.getAuthorities();
        final var username = userDetails.getUsername();
        final var token = jwtService.generateToken(Map.of("role", roles), username);
        return Map.of("token", token);
    }
}
