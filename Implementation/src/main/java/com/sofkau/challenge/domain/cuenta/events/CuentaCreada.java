package com.sofkau.challenge.domain.cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.cuenta.Estado;
public class CuentaCreada extends DomainEvent {

    private final Estado estado;

    public CuentaCreada(Estado estado) {
        super("sofkau.challenge.domain.cuenta.cuentacreada");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
