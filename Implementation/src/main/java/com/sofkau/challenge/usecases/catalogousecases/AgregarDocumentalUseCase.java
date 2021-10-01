package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.catalogo.Catalogo;
import com.sofkau.challenge.domain.catalogo.commands.AgregarDocumental;

public class AgregarDocumentalUseCase extends UseCase<RequestCommand<AgregarDocumental>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDocumental> agregarDocumentalRequestCommand) {
        var command = agregarDocumentalRequestCommand.getCommand();
        var catalogo = Catalogo.from(command.getCatalogoId(),retrieveEvents(command.getCatalogoId().value()));
        catalogo.agregarDocumental(command.getDocumentalId(), command.getOrigen());
        emit().onResponse(new ResponseEvents(catalogo.getUncommittedChanges()));
    }
}
