package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.challenge.domain.catalogo.Pelicula;
import com.sofkau.challenge.domain.catalogo.commands.AgregarPelicula;

public class PeliculaAgregadaUseCase extends UseCase<RequestCommand<AgregarPelicula>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPelicula> agregarPeliculaRequestCommand) {
        var command = agregarPeliculaRequestCommand.getCommand();
        var pelicula = new Pelicula(
                command.getPeliculaId(),
                command.getInformacion()
        );
//        emit().onResponse(new ResponseEvents(pelicula.getUncommittedChanges()));
    }
}
