package com.sofkau.challenge.domain.Catalogo;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkau.challenge.domain.catalogo.CatalogoCreado;
import com.sofkau.challenge.domain.catalogo.Documental;
import com.sofkau.challenge.domain.catalogo.Pelicula;
import com.sofkau.challenge.domain.catalogo.Serie;
import com.sofkau.challenge.domain.catalogo.values.CatalogoId;
import com.sofkau.challenge.domain.catalogo.values.Interfaz;
import com.sofkau.challenge.domain.catalogo.values.Tendencia;

import java.util.Set;

public class Catalogo extends AggregateEvent {
    protected Interfaz interfaz;
    protected Tendencia tendencia;
    protected Set<Pelicula> peliculas;
    protected Set<Serie> series;
    protected Set<Documental> documentales;

    public Catalogo(CatalogoId catalogoId, Interfaz interfaz,Tendencia tendencia,Set<Pelicula> peliculas,Set<Serie> series,Set<Documental> documentales) {
        super(catalogoId);
        appendChange(new CatalogoCreado(interfaz,tendencia,peliculas,series,documentales)).apply();
    }

//    private Catalogo(CatalogoId catalogoId){
//        super(CatalogoId);
//        subscribe(new CatalogoChange(this));
//    }
//
//    public static Catalogo from(CatalogoId CatalogoId, List<DomainEvent> events){
//        var Catalogo = new Catalogo(CatalogoId);
//        events.forEach(Catalogo::applyEvent);
//        return Catalogo;
//    }
//
//    public void ajustarInterfaz(Interfaz interfaz){
//        appendChange(new InterfazAjustada(interfaz)).apply();
//    }
//
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
