package com.sofkau.challenge.domain.catalogo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.values.Interfaz;
import com.sofkau.challenge.domain.catalogo.values.Tendencia;

public class CatalogoCreado extends DomainEvent {
    private final Interfaz interfaz;
    private final Tendencia tendencia;

    public CatalogoCreado(Interfaz interfaz, Tendencia tendencia) {
        super("sofkau.challenge.domain.catalogo.catalogocreado");
        this.interfaz = interfaz;
        this.tendencia = tendencia;
    }

    public Interfaz getInterfaz() {
        return interfaz;
    }

    public Tendencia getTendencia() {
        return tendencia;
    }
}
