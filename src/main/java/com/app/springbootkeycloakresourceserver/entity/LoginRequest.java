package com.app.springbootkeycloakresourceserver.entity;
import lombok.Getter;

@Getter
public class LoginRequest {

    String username;
    String password;
}