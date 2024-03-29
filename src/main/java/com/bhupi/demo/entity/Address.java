package com.bhupi.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;


    @OneToOne(mappedBy = "address")
    private Student student;
}
