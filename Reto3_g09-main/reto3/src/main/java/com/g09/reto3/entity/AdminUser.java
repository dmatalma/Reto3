package com.g09.reto3.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="adminUser")
@Getter
@Setter
@NoArgsConstructor

public class AdminUser implements Serializable{

    @Id
    @Column(name="email")
    @NotNull
    private String email;

    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="password")
    @NotNull
    private String password;
    
}
