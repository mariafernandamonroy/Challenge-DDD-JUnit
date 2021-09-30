package com.sofkau.challenge.domain.catalogo;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.challenge.domain.catalogo.values.Informacion;
import com.sofkau.challenge.domain.catalogo.values.PeliculaId;

public class Pelicula extends Entity<PeliculaId> {
    private Informacion informacion;

    public Pelicula(PeliculaId peliculaId, Informacion informacion) {
        super(peliculaId);
        this.informacion = informacion;
    }

    public void actualizarInformacion(Informacion informacion){
        this.informacion = informacion;
    }
}
