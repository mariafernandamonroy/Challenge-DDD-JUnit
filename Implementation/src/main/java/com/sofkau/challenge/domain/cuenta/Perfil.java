package com.sofkau.challenge.domain.cuenta;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.challenge.domain.cuenta.values.Configuracion;
import com.sofkau.challenge.domain.cuenta.values.PerfilId;

import java.util.Objects;

public class Perfil extends Entity<PerfilId> {
    private int pin;
    private Configuracion configuracion;

    public Perfil(PerfilId entityId) {
        super(entityId);
    }

    public void actualizarPin(int pin){
        this.pin = pin;
    }

    public void actualizarConfiguracion(Configuracion configuracion){
        this.configuracion = Objects.requireNonNull(configuracion);
    }
}
