package com.g09.reto3.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.sun.istack.NotNull;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="catergory")
@Getter
@Setter
@NoArgsConstructor

public class Category implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq1")
    @Column(name="id")
    private Long id;


    @Column(name="name", length=45)
    @NotNull
    private String name;

    @Column(name="description", length=250)
    @NotNull
    private String description;

    @OneToMany( cascade = CascadeType.ALL)
    private List<Skates> skates;

    
}
