package com.sofkau.challenge.domain.cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.cuenta.Estado;

public class EstadoCambiado extends DomainEvent {
    public EstadoCambiado(Estado estado) {
        super("sofkau.challenge.domain.cuenta.catalogocreado");
    }
}
