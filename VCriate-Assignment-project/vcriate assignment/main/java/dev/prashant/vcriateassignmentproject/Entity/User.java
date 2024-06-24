package dev.prashant.vcriateassignmentproject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//User Authentication and Authorization
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String  Password;
    private String Role;

}
