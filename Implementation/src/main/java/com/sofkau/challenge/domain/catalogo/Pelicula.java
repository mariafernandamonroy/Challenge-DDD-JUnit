package com.sofkau.challenge.domain.catalogo;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.challenge.domain.catalogo.values.Informacion;
import com.sofkau.challenge.domain.catalogo.values.PeliculaId;

import java.util.Objects;

public class Pelicula extends Entity<PeliculaId> {
    private PeliculaId peliculaId;
    private Informacion informacion;

    public Pelicula(PeliculaId peliculaId, Informacion informacion) {
        super(peliculaId);
        this.informacion = informacion;
    }

    public void actualizarInformacion(Informacion informacion){
        this.informacion = Objects.requireNonNull(informacion);
    }

    public Informacion getInformacion() {
        return informacion;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }
}
