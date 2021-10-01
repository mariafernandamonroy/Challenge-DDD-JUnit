package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.catalogo.Catalogo;
import com.sofkau.challenge.domain.catalogo.commands.CrearCatalogo;

public class CrearCatalogoUseCase extends UseCase<RequestCommand<CrearCatalogo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCatalogo> crearCatalogoRequestCommand) {
        var command = crearCatalogoRequestCommand.getCommand();
        var catalogo = new Catalogo(
                command.getCatalogoId(),
                command.getInterfaz(),
                command.getTendencia()
        );
        emit().onResponse(new ResponseEvents(catalogo.getUncommittedChanges()));
    }
}
