package com.xworkz.userapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user_table")

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="email")
    private String  email;
    @Column(name="phoneNumber")
    private Long phoneNumber;
}
