package com.salesianostriana.dam.spring.data.jpa.models;

import jakarta.persistence.*;
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
public class Pelicula {

    @Id @GeneratedValue
    private Long id;

    private String titulo;
    private Long anioEstreno;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Critica> criticas = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Genero> generos = new ArrayList<>();

    // helpers
    public void addCritica(Critica c) {
        criticas.add( c );
        c.setPelicula( this );
    }

    public void removeCritica(Critica c) {
        criticas.remove( c );
        c.setPelicula( null );
    }

}
