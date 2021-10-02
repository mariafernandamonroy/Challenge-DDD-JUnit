package com.sofkau.challenge.usecases.cuentausecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.challenge.domain.cuenta.Cuenta;
import com.sofkau.challenge.domain.cuenta.events.UsuarioAgregado;
import com.sofkau.challenge.domain.cuenta.values.CuentaId;


public class CantidadUsuariosAumentadaUseCase extends UseCase<TriggeredEvent<UsuarioAgregado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<UsuarioAgregado> agregarUsuarioTriggeredEvent) {
        var event = agregarUsuarioTriggeredEvent.getDomainEvent();
        var cuenta= Cuenta.from(CuentaId.of(event.aggregateRootId()),this.retrieveEvents());
        cuenta.aumentarCantidadUsuarios(event.getCantidadUsuarios()+1);
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
