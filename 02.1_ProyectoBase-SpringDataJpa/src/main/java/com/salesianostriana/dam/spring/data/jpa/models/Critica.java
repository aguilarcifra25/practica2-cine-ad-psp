package com.salesianostriana.dam.spring.data.jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Critica {

    @Id @GeneratedValue
    private Long id;

    private String autor;
    private String texto;
    private Float puntuacion;

    @ManyToOne
    private Pelicula pelicula;



    // equals y hascode

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Critica critica = (Critica) o;
        return Objects.equals( autor, critica.autor) && Objects.equals( texto, critica.texto) && Objects.equals( puntuacion, critica.puntuacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash( autor, texto, puntuacion );
    }

}
