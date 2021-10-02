package com.sofkau.challenge.domain.cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.cuenta.TipoPlan;
import com.sofkau.challenge.domain.cuenta.values.PerfilId;
import com.sofkau.challenge.domain.cuenta.values.Plan;
import com.sofkau.challenge.domain.cuenta.values.UsuarioId;

public class PlanUsuarioActualizado extends DomainEvent {
    private final UsuarioId usuarioId;
    private final Plan plan;

    public PlanUsuarioActualizado(UsuarioId usuarioId, Plan plan) {
        super("sofkau.challenge.domain.cuenta.planusuarioactualizado");
        this.usuarioId = usuarioId;
        this.plan = plan;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public Plan getPlan() {
        return plan;
    }
}
