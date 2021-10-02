package com.sofkau.challenge.domain.cuenta.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.challenge.domain.cuenta.Estado;
import com.sofkau.challenge.domain.cuenta.values.CuentaId;

public class CrearCuenta extends Command {
    private final CuentaId cuentaId;
    private final Estado estado;

    public CrearCuenta(CuentaId cuentaId, Estado estado){
        this.cuentaId = cuentaId;
        this.estado = estado;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Estado getEstado() {
        return estado;
    }
}
