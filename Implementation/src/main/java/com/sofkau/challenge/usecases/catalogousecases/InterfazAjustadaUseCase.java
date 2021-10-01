package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.catalogo.Catalogo;
import com.sofkau.challenge.domain.catalogo.commands.AjustarInterfaz;

public class InterfazAjustadaUseCase extends UseCase<RequestCommand<AjustarInterfaz>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AjustarInterfaz> ajustarInterfazRequestCommand) {
        var command = ajustarInterfazRequestCommand.getCommand();
        var catalogo = Catalogo.from(command.getCatalogoId(),retrieveEvents());
        catalogo.ajustarInterfaz(command.getInterfaz());
        emit().onResponse(new ResponseEvents(catalogo.getUncommittedChanges()));
    }
}
