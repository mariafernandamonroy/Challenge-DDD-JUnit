package com.sofkau.challenge.domain.catalogo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.events.*;
import com.sofkau.challenge.domain.catalogo.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Catalogo extends AggregateEvent<CatalogoId> {
    protected Interfaz interfaz;
    protected Tendencia tendencia;
    protected Pelicula pelicula;
    protected Serie serie;
    protected Documental documental;

    public Catalogo(CatalogoId catalogoId, Interfaz interfaz,Tendencia tendencia) {
        super(catalogoId);
        appendChange(new CatalogoCreado(interfaz,tendencia)).apply();
    }

    private Catalogo(CatalogoId catalogoId){
        super(catalogoId);
        subscribe(new CatalogoChange(this));
    }

    public static Catalogo from(CatalogoId catalogoId, List<DomainEvent> events){
        var catalogo = new Catalogo(catalogoId);
        events.forEach(catalogo::applyEvent);
        return catalogo;
    }

    public void ajustarInterfaz(Interfaz interfaz){
        appendChange(new InterfazAjustada(interfaz)).apply();
    }

    public void agregarPelicula( PeliculaId peliculaId, Informacion informacion){
        Objects.requireNonNull(peliculaId);
        Objects.requireNonNull(informacion);
        appendChange(new PeliculaAgregada(peliculaId, informacion)).apply();
    }

    public void agregarSerie(SerieId serieId, Informacion informacion, Temporada temporada){
        appendChange(new SerieAgregada(serieId,informacion,temporada)).apply();
    }

    public void actualizarInformacionPelicula(PeliculaId peliculaId, Informacion informacion){
        appendChange(new InformacionPeliculaActualizada(peliculaId,informacion)).apply();
    }

//    public void actualizarInformacionSerie(Serie serie){
//        appendChange(new InformacionSerieActualizada(serie)).apply();
//    }
//
//    public void actualizarOrigenDocumenta(Documental documental){
//        appendChange(new OrigenDocumentalActualizado(documental)).apply();
//    }

    public Interfaz interfaz() {
        return interfaz;
    }

    public Tendencia tendencia() {
        return tendencia;
    }

    public Pelicula pelicula() {
        return pelicula;
    }

    public Serie serie() {
        return serie;
    }

    public Documental documental() {
        return documental;
    }
}
