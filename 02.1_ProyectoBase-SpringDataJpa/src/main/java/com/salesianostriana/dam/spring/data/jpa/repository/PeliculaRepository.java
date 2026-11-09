package com.salesianostriana.dam.spring.data.jpa.repository;

import com.salesianostriana.dam.spring.data.jpa.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
