package com.sofkau.challenge.domain.catalogo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.challenge.domain.catalogo.values.CatalogoId;
import com.sofkau.challenge.domain.catalogo.values.Informacion;
import com.sofkau.challenge.domain.catalogo.values.SerieId;
import com.sofkau.challenge.domain.catalogo.values.Temporada;

public class AgregarSerie extends Command {

    private final CatalogoId catalogoId;
    private final SerieId serieId;
    private final Informacion informacion;
    private final Temporada temporada;

    public AgregarSerie(CatalogoId catalogoId, SerieId serieId, Informacion informacion, Temporada temporada) {
        this.catalogoId = catalogoId;
        this.serieId = serieId;
        this.informacion = informacion;
        this.temporada = temporada;
    }

    public CatalogoId getCatalogoId() {
        return catalogoId;
    }

    public SerieId getSerieId() {
        return serieId;
    }

    public Informacion getInformacion() {
        return informacion;
    }

    public Temporada getTemporada() {
        return temporada;
    }
}
