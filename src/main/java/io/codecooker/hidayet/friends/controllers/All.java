package io.codecooker.hidayet.friends.controllers;

import io.codecooker.hidayet.friends.payload.request.LoginRequest;
import io.codecooker.hidayet.friends.payload.request.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface All {
    ResponseEntity registerUser(SignUpRequest signUpRequest);
    ResponseEntity authenticateUser(@Valid @RequestBody LoginRequest loginRequest);
}
