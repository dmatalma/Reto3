package com.g09.reto3.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
//import java.util.List;
import java.util.List;

@Entity
@Table(name="skates")
@Getter
@Setter
@NoArgsConstructor

public class Skates implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq5")
    @Column(name="id")
    private Long id;

    @Column(name="name", length=45)
    @NotNull
    private String name;

    @Column(name="brand", length=45)
    @NotNull
    private String brand;

    @Column(name="year", length=4)
    @NotNull
    private int year;

    @Column(name="description", length=250)
    @NotNull
    private String description;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties(value={"skates"})
    private Category category;
        
    @OneToMany( cascade = {CascadeType.PERSIST}, mappedBy = "skate")
    @JsonIgnoreProperties(value={"client","skate"})
    private List<Message> messages; 

    @OneToMany( cascade = CascadeType.ALL)
    private List<Reservation> reservations; 

    
}
