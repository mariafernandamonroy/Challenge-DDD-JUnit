package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.catalogo.Catalogo;
import com.sofkau.challenge.domain.catalogo.commands.ActualizarInformacionPelicula;
import com.sofkau.challenge.domain.catalogo.events.InformacionPeliculaActualizada;

public class ActualizarInformacionPeliculaUseCase extends UseCase<RequestCommand<ActualizarInformacionPelicula>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarInformacionPelicula> actualizarInformacionPeliculaRequestCommand) {
        var command = actualizarInformacionPeliculaRequestCommand.getCommand();
        var catalogo = Catalogo.from(command.getCatalogoId(), retrieveEvents(command.getCatalogoId().value()));
        catalogo.actualizarInformacionPelicula(command.getPeliculaId(), command.getInformacion());
        emit().onResponse(new ResponseEvents(catalogo.getUncommittedChanges()));
    }
}
