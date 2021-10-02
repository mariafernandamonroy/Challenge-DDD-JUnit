package com.sofkau.challenge.domain.cuenta.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.challenge.domain.cuenta.TipoPlan;
import com.sofkau.challenge.domain.cuenta.values.CuentaId;
import com.sofkau.challenge.domain.cuenta.values.Plan;
import com.sofkau.challenge.domain.cuenta.values.UsuarioId;

public class ActualizarPlanUsuario extends Command {
    private final CuentaId cuentaId;
    private final UsuarioId usuarioId;
    private final Plan plan;

    public ActualizarPlanUsuario(CuentaId cuentaId, UsuarioId usuarioId, Plan plan){
        this.cuentaId = cuentaId;
        this.usuarioId = usuarioId;
        this.plan = plan;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Plan getPlan() {
        return plan;
    }
}
