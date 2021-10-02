package com.sofkau.challenge.usecases.cuentausecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.cuenta.Cuenta;
import com.sofkau.challenge.domain.cuenta.commands.ActualizarPlanUsuario;

public class ActualizarPlanUsuarioUseCase extends UseCase<RequestCommand<ActualizarPlanUsuario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarPlanUsuario> actualizarPlanUsuarioRequestCommand) {
        var command = actualizarPlanUsuarioRequestCommand.getCommand();
        var cuenta = Cuenta.from(command.getCuentaId(),retrieveEvents());
        cuenta.actualizarPlanUsuario(command.getUsuarioId(), command.getPlan());
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges())); 
    }
}
