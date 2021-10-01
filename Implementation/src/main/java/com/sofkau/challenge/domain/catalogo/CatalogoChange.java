package com.sofkau.challenge.domain.catalogo;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.challenge.domain.catalogo.events.*;

import java.util.HashSet;

public class CatalogoChange extends EventChange {

    public CatalogoChange(Catalogo catalogo) {
        apply((CatalogoCreado event) -> {
            catalogo.interfaz = event.getInterfaz();
            catalogo.tendencia = event.getTendencia();
        });

        apply((InterfazAjustada event) -> {
            catalogo.interfaz = event.getInterfaz();
        });

        apply((PeliculaAgregada event) -> {
            catalogo.pelicula = new Pelicula(event.getPeliculaId(), event.getInformacion());
        });

        apply((SerieAgregada event) -> {
            catalogo.serie = new Serie(event.getSerieId(), event.getInformacion(),event.getTemporada());
        });

    }
}
