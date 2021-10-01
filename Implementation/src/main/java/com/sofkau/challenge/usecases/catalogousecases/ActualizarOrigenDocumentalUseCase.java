package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.catalogo.Catalogo;
import com.sofkau.challenge.domain.catalogo.commands.ActualizarOrigenDocumental;

public class ActualizarOrigenDocumentalUseCase extends UseCase<RequestCommand<ActualizarOrigenDocumental>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarOrigenDocumental> actualizarOrigenDocumentalRequestCommand) {
        var command = actualizarOrigenDocumentalRequestCommand.getCommand();
        var catalogo = Catalogo.from(command.getCatalogoId(), retrieveEvents(command.getCatalogoId().value()));
        catalogo.actualizarOrigenDocumental(command.getDocumentalId(),command.getOrigen());
        emit().onResponse(new ResponseEvents(catalogo.getUncommittedChanges()));
    }
}
