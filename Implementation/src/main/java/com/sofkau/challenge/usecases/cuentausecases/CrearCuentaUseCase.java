package com.sofkau.challenge.usecases.cuentausecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.cuenta.Cuenta;
import com.sofkau.challenge.domain.cuenta.commands.CrearCuenta;

public class CrearCuentaUseCase extends UseCase<RequestCommand<CrearCuenta>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCuenta> crearCuentaRequestCommand) {
        var command = crearCuentaRequestCommand.getCommand();
        var cuenta = new Cuenta(
                command.getCuentaId(),
                command.getEstado()
        );
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
