package edu.icet.model.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequest {

    private String fullName;
    private String email;
    private String password;

}
