package com.sofkau.challenge.domain.catalogo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.events.CatalogoCreado;
import com.sofkau.challenge.domain.catalogo.events.InterfazAjustada;
import com.sofkau.challenge.domain.catalogo.values.CatalogoId;
import com.sofkau.challenge.domain.catalogo.values.Interfaz;
import com.sofkau.challenge.domain.catalogo.values.Tendencia;

import java.util.List;
import java.util.Set;

public class Catalogo extends AggregateEvent<CatalogoId> {
    protected Interfaz interfaz;
    protected Tendencia tendencia;
    protected Set<Pelicula> peliculas;
    protected Set<Serie> series;
    protected Set<Documental> documentales;

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

    public void ajustarInterfaz(CatalogoId catalogoId, Interfaz interfaz){
        appendChange(new InterfazAjustada(catalogoId, interfaz)).apply();
    }

//    public void agregarPelicula(Pelicula pelicula){
//        appendChange(new PeliculaAgregada(pelicula)).apply();
//    }
//
//    public void agregarSerie(Serie serie){
//        appendChange(new SerieAgregada(serie)).apply();
//    }
//
//    public void actualizarInformacionPelicula(Pelicula pelicula){
//        appendChange(new InformacionPeliculaActualizada(pelicula)).apply();
//    }
//
//    public void actualizarInformacionSerie(Serie serie){
//        appendChange(new InformacionSerieActualizada(serie)).apply();
//    }
//
//    public void actualizarOrigenDocumenta(Documental documental){
//        appendChange(new OrigenDocumentalActualizado(documental)).apply();
//    }
}
