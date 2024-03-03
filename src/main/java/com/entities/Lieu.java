package com.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Lieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;

    private String address;


}
