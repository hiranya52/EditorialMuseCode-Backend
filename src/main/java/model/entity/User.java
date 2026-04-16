package model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

}
