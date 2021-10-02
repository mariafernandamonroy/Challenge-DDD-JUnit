package com.sofkau.challenge.usecases.cuentausecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.challenge.domain.cuenta.Cuenta;
import com.sofkau.challenge.domain.cuenta.Estado;
import com.sofkau.challenge.domain.cuenta.events.CuentaCreada;
import com.sofkau.challenge.domain.cuenta.values.CuentaId;

public class EstadoCambiadoUseCase extends UseCase<TriggeredEvent<CuentaCreada>,ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CuentaCreada> cuentaCreadaTriggeredEvent) {
        var event = cuentaCreadaTriggeredEvent.getDomainEvent();
        var cuenta = Cuenta.from(CuentaId.of(event.aggregateRootId()), this.retrieveEvents());
        cuenta.cambiarEstado(Estado.ABIERTO);
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
