package com.app.springbootkeycloakresourceserver.controller;

import com.app.springbootkeycloakresourceserver.config.KeycloakProvider;
import com.app.springbootkeycloakresourceserver.entity.CreateUserRequest;
import com.app.springbootkeycloakresourceserver.entity.LoginRequest;
import com.app.springbootkeycloakresourceserver.service.KeycloakAdminClientService;
import com.app.springbootkeycloakresourceserver.service.UserService;
import com.app.springbootkeycloakresourceserver.web.BaseResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping(value = "/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {
    private final KeycloakAdminClientService kcAdminClient;
    private final KeycloakProvider kcProvider;

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<BaseResponse<?>> createUser(@RequestBody CreateUserRequest user) {
        Response createdResponse = kcAdminClient.createKeycloakUser(user);
        return ResponseEntity.status(createdResponse.getStatus()).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AccessTokenResponse> login(@NotNull @RequestBody LoginRequest loginRequest) {
        Keycloak keycloak = kcProvider.newKeycloakBuilderWithPasswordCredentials(loginRequest.getUsername(), loginRequest.getPassword()).build();
        AccessTokenResponse accessTokenResponse = null;
        try {
            accessTokenResponse = keycloak.tokenManager().getAccessToken();
            return ResponseEntity.status(HttpStatus.OK).body(accessTokenResponse);
        } catch (BadRequestException ex) {
            log.warn("invalid account. User probably hasn't verified email.", ex);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(accessTokenResponse);
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@NotNull @RequestBody String refreshToken) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(kcProvider.refreshToken(refreshToken));
        } catch (BadRequestException ex) {
            log.warn("invalid account. User probably hasn't verified email.", ex);
            throw new BadRequestException(ex);
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
