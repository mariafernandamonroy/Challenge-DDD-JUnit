package com.sofkau.challenge.usecases.cuentausecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.cuenta.Cuenta;
import com.sofkau.challenge.domain.cuenta.commands.AgregarUsuario;

public class AgregarUsuarioUseCase extends UseCase<RequestCommand<AgregarUsuario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarUsuario> agregarUsuarioRequestCommand) {
        var command = agregarUsuarioRequestCommand.getCommand();
        var cuenta = Cuenta.from(command.getCuentaId(),retrieveEvents());
        cuenta.agregarUsuario(command.getNombreCompleto(), command.getCorreoElectronico(), command.getFechaNacimiento(), command.getMembresia(), command.getPlan(), command.getCantidadUsuarios());
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
