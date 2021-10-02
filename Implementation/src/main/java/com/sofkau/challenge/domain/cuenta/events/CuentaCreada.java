package com.sofkau.challenge.domain.cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.values.Interfaz;
import com.sofkau.challenge.domain.catalogo.values.Tendencia;
import com.sofkau.challenge.domain.cuenta.Estado;
import com.sofkau.challenge.domain.cuenta.Perfil;
import com.sofkau.challenge.domain.cuenta.Preferencia;
import com.sofkau.challenge.domain.cuenta.Usuario;

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
