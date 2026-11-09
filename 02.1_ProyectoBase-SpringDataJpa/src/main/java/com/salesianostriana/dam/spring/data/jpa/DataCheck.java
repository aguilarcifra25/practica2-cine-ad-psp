package com.salesianostriana.dam.spring.data.jpa;

import com.salesianostriana.dam.spring.data.jpa.repository.CriticaRepository;
import com.salesianostriana.dam.spring.data.jpa.repository.GeneroRepository;
import com.salesianostriana.dam.spring.data.jpa.repository.PeliculaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class DataCheck {

    private final PeliculaRepository peliculaRepository;
    private final CriticaRepository criticaRepository;
    private final GeneroRepository generoRepository;

    public DataCheck(PeliculaRepository peliculaRepository, CriticaRepository criticaRepository, GeneroRepository generoRepository) {
        this.peliculaRepository = peliculaRepository;
        this.criticaRepository = criticaRepository;
        this.generoRepository = generoRepository;
    }

    @PostConstruct
    @DependsOn("DataSeed")
    public void comprobarDatos() {

        peliculaRepository.findAll();

        peliculaRepository.findById(1L);

    }


}
