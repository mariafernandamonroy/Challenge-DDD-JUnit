package com.sofkau.challenge.domain.cuenta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.cuenta.events.CuentaCreada;
import com.sofkau.challenge.domain.cuenta.events.EstadoCambiado;
import com.sofkau.challenge.domain.cuenta.values.CuentaId;

import java.util.List;

public class Cuenta extends AggregateEvent {
    protected CuentaId cuentaId;
    protected Estado estado;
    protected Preferencia preferencia;
    protected Usuario usuario;
    protected Perfil perfil;

    public Cuenta(CuentaId cuentaId,Estado estado) {
        super(cuentaId);
        appendChange(new CuentaCreada(estado)).apply();
    }

    private Cuenta(CuentaId cuentaId){
        super(cuentaId);
        subscribe(new CuentaChange(this));
    }

    public static Cuenta from(CuentaId cuentaId, List<DomainEvent> events){
        var cuenta = new Cuenta(cuentaId);
        events.forEach(cuenta::applyEvent);
        return cuenta;
    }

    public cambiarEstado(Estado estado){
        appendChange(new EstadoCambiado(estado)).apply();
    }


    public CuentaId cuentaId() {
        return cuentaId;
    }

    public Estado estado() {
        return estado;
    }

    public Preferencia preferencia() {
        return preferencia;
    }

    public Usuario usuario() {
        return usuario;
    }

    public Perfil perfil() {
        return perfil;
    }
}
