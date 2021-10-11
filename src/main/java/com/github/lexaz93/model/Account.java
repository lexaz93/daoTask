package com.github.lexaz93.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private final String login;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
}
