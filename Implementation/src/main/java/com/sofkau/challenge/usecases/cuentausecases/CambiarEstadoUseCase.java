package com.sofkau.challenge.usecases.cuentausecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.cuenta.Cuenta;
import com.sofkau.challenge.domain.cuenta.commands.CambiarEstado;

public class CambiarEstadoUseCase extends UseCase<RequestCommand<CambiarEstado>,ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarEstado> cambiarEstadoRequestCommand) {
        var command = cambiarEstadoRequestCommand.getCommand();
        var cuenta = Cuenta.from(command.getCuentaId(),retrieveEvents());
        cuenta.cambiarEstado(command.getEstado());
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
