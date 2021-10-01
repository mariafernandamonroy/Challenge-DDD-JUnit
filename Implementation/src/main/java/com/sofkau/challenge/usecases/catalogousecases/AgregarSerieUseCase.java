package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.catalogo.Catalogo;
import com.sofkau.challenge.domain.catalogo.commands.AgregarSerie;

public class AgregarSerieUseCase extends UseCase<RequestCommand<AgregarSerie>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarSerie> agregarSerieRequestCommand) {
        var command = agregarSerieRequestCommand.getCommand();
        var catalogo = Catalogo.from(command.getCatalogoId(),retrieveEvents(command.getCatalogoId().value()));
        catalogo.agregarSerie(command.getSerieId(), command.getInformacion(), command.getTemporada());
        emit().onResponse(new ResponseEvents(catalogo.getUncommittedChanges()));
    }
}
