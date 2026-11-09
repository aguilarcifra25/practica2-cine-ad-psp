package com.salesianostriana.dam.spring.data.jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Genero {

    @Id @GeneratedValue
    private Long id;

    private String nombre;
}
