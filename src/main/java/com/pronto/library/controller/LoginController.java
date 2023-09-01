package com.pronto.library.controller;


import com.pronto.library.dto.input.LoginInputData;
import com.pronto.library.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * The type Login controller.
 */
@RestController
@RequestMapping("api/auth")
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final AuthService authService;

    /**
     * Auth request response entity.
     *
     * @param authRequestDto the auth request dto
     * @return the response entity
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> authRequest(@RequestBody LoginInputData authRequestDto) {
        var userRegistrationResponse = authService.authRequest(authRequestDto);
        return new ResponseEntity<>(userRegistrationResponse, HttpStatus.OK);
    }


}
