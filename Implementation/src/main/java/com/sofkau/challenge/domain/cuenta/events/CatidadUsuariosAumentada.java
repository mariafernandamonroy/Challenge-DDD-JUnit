package com.sofkau.challenge.domain.cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;

public class CatidadUsuariosAumentada extends DomainEvent {
    private final int cantidaUsuarios;

    public CatidadUsuariosAumentada(int cantidaUsuarios) {
        super("sofkau.challenge.domain.cuenta.cantidadusuariosaumentada");
        this.cantidaUsuarios = cantidaUsuarios;
    }

    public int getCantidaUsuarios() {
        return cantidaUsuarios;
    }
}
