package com.sofkau.challenge.domain.catalogo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.values.Informacion;
import com.sofkau.challenge.domain.catalogo.values.PeliculaId;


public class PeliculaAgregada extends DomainEvent {
    private final PeliculaId peliculaId;
    private final Informacion informacion;

    public PeliculaAgregada(PeliculaId peliculaId, Informacion informacion) {
        super("sofkau.challenge.domain.catalogo.peliculaagregada");
        this.peliculaId = peliculaId;
        this.informacion = informacion;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public Informacion getInformacion() {
        return informacion;
    }
}
