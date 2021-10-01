package com.sofkau.challenge.domain.catalogo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.challenge.domain.catalogo.values.Informacion;
import com.sofkau.challenge.domain.catalogo.values.PeliculaId;

public class AgregarPelicula extends Command {

    private final PeliculaId peliculaId;
    private final Informacion informacion;

    public AgregarPelicula(PeliculaId peliculaId, Informacion informacion){
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
