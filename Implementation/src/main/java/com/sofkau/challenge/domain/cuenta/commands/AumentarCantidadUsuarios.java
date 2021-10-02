package com.sofkau.challenge.domain.cuenta.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.challenge.domain.cuenta.values.CuentaId;
import com.sofkau.challenge.domain.cuenta.values.UsuarioId;

public class AumentarCantidadUsuarios extends Command {
    private final CuentaId cuentaId;
    private final UsuarioId usuarioId;
    private final int cantidadUsuarios;

    public AumentarCantidadUsuarios(CuentaId cuentaId, UsuarioId usuarioId, int cantidadUsuarios){

        this.cuentaId = cuentaId;
        this.usuarioId = usuarioId;
        this.cantidadUsuarios = cantidadUsuarios;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public int getCantidadUsuarios() {
        return cantidadUsuarios;
    }


}
