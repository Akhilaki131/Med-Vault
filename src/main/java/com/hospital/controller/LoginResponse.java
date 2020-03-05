package com.hospital.controller;


import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
