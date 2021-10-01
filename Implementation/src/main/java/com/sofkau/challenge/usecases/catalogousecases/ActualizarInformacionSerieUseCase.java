package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.catalogo.Catalogo;
import com.sofkau.challenge.domain.catalogo.commands.ActualizarInformacionSerie;

public class ActualizarInformacionSerieUseCase extends UseCase<RequestCommand<ActualizarInformacionSerie>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarInformacionSerie> actualizarInformacionSerieRequestCommand) {
        var command = actualizarInformacionSerieRequestCommand.getCommand();
        var catalogo = Catalogo.from(command.getCatalogoId(), retrieveEvents(command.getCatalogoId().value()));
        catalogo.actualizarInformacionSerie(command.getSerieId(),command.getInformacion(),command.getTemporada());
        emit().onResponse(new ResponseEvents(catalogo.getUncommittedChanges()));
    }
}
