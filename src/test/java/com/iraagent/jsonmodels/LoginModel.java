package com.iraagent.jsonmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class LoginModel {



    private String username;
    private String password;




    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
