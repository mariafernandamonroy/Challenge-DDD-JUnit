package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.catalogo.Catalogo;
import com.sofkau.challenge.domain.catalogo.commands.AjustarInterfaz;
import com.sofkau.challenge.domain.catalogo.values.Interfaz;

public class InterfazAjustadaUseCase extends UseCase<RequestCommand<AjustarInterfaz>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AjustarInterfaz> ajustarInterfazRequestCommand) {
        var command = ajustarInterfazRequestCommand.getCommand();
        var interfaz = new Interfaz(command.getInterfaz().value());
        var catalogo = Catalogo.from(command.getCatalogoId(),retrieveEvents());
        catalogo.ajustarInterfaz(command.getCatalogoId(), interfaz);
        emit().onResponse(new ResponseEvents(catalogo.getUncommittedChanges()));
    }
}
