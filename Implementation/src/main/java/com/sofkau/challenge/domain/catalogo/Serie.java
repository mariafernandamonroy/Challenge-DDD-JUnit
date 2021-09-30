package com.sofkau.challenge.domain.catalogo;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.challenge.domain.catalogo.values.Informacion;
import com.sofkau.challenge.domain.catalogo.values.SerieId;
import com.sofkau.challenge.domain.catalogo.values.Temporada;

public class Serie extends Entity<SerieId> {
    private Informacion informacion;
    private Temporada temporada;

    public Serie(SerieId serieId, Informacion informacion, Temporada temporada) {
        super(serieId);
        this.informacion = informacion;
        this.temporada = temporada;
    }

    public void actualizarInformacion(Informacion informacion){
        this.informacion = informacion;
    }

    public void agregarTemporada(Temporada temporada){
        this.temporada = temporada;
    }
}
