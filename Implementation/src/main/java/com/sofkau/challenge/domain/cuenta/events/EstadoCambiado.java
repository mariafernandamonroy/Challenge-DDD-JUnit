package com.sofkau.challenge.domain.cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.cuenta.Estado;

public class EstadoCambiado extends DomainEvent {
    private final Estado estado;

    public EstadoCambiado(Estado estado) {
        super("sofkau.challenge.domain.cuenta.estadocambiado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
