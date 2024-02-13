package com.project.risoti.simulation.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class UserModel {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonCreator
    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
