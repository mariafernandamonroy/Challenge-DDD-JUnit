package com.sofkau.challenge.domain.catalogo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.values.Informacion;
import com.sofkau.challenge.domain.catalogo.values.SerieId;
import com.sofkau.challenge.domain.catalogo.values.Temporada;

public class InformacionSerieActualizada extends DomainEvent {
    private final SerieId serieId;
    private final Informacion informacion;
    private final Temporada temporada;

    public InformacionSerieActualizada(SerieId serieId, Informacion informacion, Temporada temporada) {
        super("sofkau.challenge.domain.catalogo.informacionpeliculaactualizada");
        this.serieId = serieId;
        this.informacion = informacion;
        this.temporada = temporada;
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
