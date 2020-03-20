package com.hospital.controller;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonAutoDetect
@JsonSerialize
public class LoginResponse implements Serializable {

    @JsonProperty
    public String code;


    public LoginResponse() {
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }
}
