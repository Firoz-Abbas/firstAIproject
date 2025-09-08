package com.spring.ai.firstproject.model.employee;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String mobile;
    private String address;
    private String username;
    private String password;
    private String created_on;
}
