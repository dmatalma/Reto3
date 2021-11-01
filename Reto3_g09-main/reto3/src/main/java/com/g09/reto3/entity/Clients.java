package com.g09.reto3.entity;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.sun.istack.NotNull;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
//import java.util.List;
import java.util.List;

@Entity
@Table(name="clients")
@Getter
@Setter
@NoArgsConstructor


public class Clients implements Serializable{

@Id
@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq2")
@Column(name="client_id")
private Long idClient;

@Column(name="email", length=45)
@NotNull
private String email;

@Column(name="password", length=45)
@NotNull
private String password;

@Column(name="name", length=45)
@NotNull
private String name;

@Column(name="age")
@NotNull
private int age;

@OneToMany( cascade = CascadeType.ALL)
private List<Message> messages;

@OneToMany( cascade = CascadeType.ALL)
private List<Reservation> reservations;


    
}
