package com.sofkau.challenge.domain.catalogo;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.values.Interfaz;
import com.sofkau.challenge.domain.catalogo.values.Tendencia;

import java.util.Set;

public class CatalogoCreado extends DomainEvent {
    private final Interfaz interfaz;
    private final Tendencia tendencia;
    private final Set<Pelicula> peliculas;
    private final Set<Serie> series;
    private final Set<Documental> documentales;

    public CatalogoCreado(Interfaz interfaz, Tendencia tendencia, Set<Pelicula> peliculas, Set<Serie> series, Set<Documental> documentales) {
        super("sofkaU.onlineplatform.profesor.catalogocreado");
        this.interfaz = interfaz;
        this.tendencia = tendencia;
        this.peliculas = peliculas;
        this.series = series;
        this.documentales = documentales;
    }

    public Interfaz getInterfaz() {
        return interfaz;
    }

    public Tendencia getTendencia() {
        return tendencia;
    }

    public Set<Pelicula> getPeliculas() {
        return peliculas;
    }

    public Set<Serie> getSeries() {
        return series;
    }

    public Set<Documental> getDocumentales() {
        return documentales;
    }
}
