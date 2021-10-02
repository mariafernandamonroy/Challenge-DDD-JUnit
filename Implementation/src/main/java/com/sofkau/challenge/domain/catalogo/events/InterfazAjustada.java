package com.sofkau.challenge.domain.catalogo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.values.Interfaz;

public class InterfazAjustada extends DomainEvent {
    private final Interfaz interfaz;

    public InterfazAjustada(Interfaz interfaz) {
        super("sofkau.challenge.domain.catalogo.interfazajustada");
        this.interfaz = interfaz;
    }

    public Interfaz getInterfaz() {
        return interfaz;
    }
}
