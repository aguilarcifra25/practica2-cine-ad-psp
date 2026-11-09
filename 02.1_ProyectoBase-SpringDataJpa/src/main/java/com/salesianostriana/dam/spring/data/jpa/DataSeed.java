package com.salesianostriana.dam.spring.data.jpa;

import com.salesianostriana.dam.spring.data.jpa.models.Critica;
import com.salesianostriana.dam.spring.data.jpa.models.Genero;
import com.salesianostriana.dam.spring.data.jpa.models.Pelicula;
import com.salesianostriana.dam.spring.data.jpa.repository.CriticaRepository;
import com.salesianostriana.dam.spring.data.jpa.repository.GeneroRepository;
import com.salesianostriana.dam.spring.data.jpa.repository.PeliculaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeed {

    private final PeliculaRepository peliculaRepository;
    private final CriticaRepository criticaRepository;
    private final GeneroRepository generoRepository;

    public DataSeed(PeliculaRepository peliculaRepository, CriticaRepository criticaRepository, GeneroRepository generoRepository) {
        this.peliculaRepository = peliculaRepository;
        this.criticaRepository = criticaRepository;
        this.generoRepository = generoRepository;
    }

    @PostConstruct
    public void cargarDatos () {

        Genero g1 = new Genero(1L,"Superheroes");
        Genero g2 = new Genero(2L,"Ciencia ficción");

        generoRepository.save(g1);

        Pelicula p1 = null;
        Pelicula p2 = null;

        Critica c1 = new Critica(1L,"Paco","Muy chula",10F,p1);
        Critica c2 = new Critica(2L,"Francis","Malisima",3.5F,p1);
        Critica c3 = new Critica(3L,"Curro","Entretenida",6F,p2);

        criticaRepository.save(c1);
        criticaRepository.save(c2);
        criticaRepository.save(c3);

        List<Critica> criticas1 = new ArrayList<>();
        criticas1.add(c1);
        criticas1.add(c2);

        List<Critica> criticas2 = new ArrayList<>();
        criticas2.add(c1);

        List<Genero> generos1 = new ArrayList<>();
        generos1.add(g1);
        generos1.add(g2);

        List<Genero> generos2 = new ArrayList<>();
        generos2.add(g2);

        p1 = new Pelicula(1L, "Vengadores", 2012L,criticas1,generos1);
        p2 = new Pelicula(2L, "Ready player one", 2012L,criticas1,generos2);

        peliculaRepository.save(p1);
        peliculaRepository.save(p2);

    }

}
