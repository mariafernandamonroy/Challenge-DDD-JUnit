package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.commands.ActualizarInformacionPelicula;
import com.sofkau.challenge.domain.catalogo.events.CatalogoCreado;
import com.sofkau.challenge.domain.catalogo.events.InformacionPeliculaActualizada;
import com.sofkau.challenge.domain.catalogo.events.PeliculaAgregada;
import com.sofkau.challenge.domain.catalogo.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ActualizarInformacionPeliculaUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    private static String CATALOGOID = "ABC123";

    @Test
    void actualizarInformacionPelicula(){
        var command = new ActualizarInformacionPelicula(
                CatalogoId.of(CATALOGOID),
                PeliculaId.of("P1"),
                new Informacion("Doctor Strange","Sci-fi")
        );
        var useCase = new ActualizarInformacionPeliculaUseCase();

        Mockito.when(repository.getEventsBy(CATALOGOID)).thenReturn(EventStore());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(CATALOGOID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (InformacionPeliculaActualizada) events.get(0);
        Assertions.assertEquals("P1",event.getPeliculaId().value());
        Assertions.assertEquals("Doctor Strange",event.getInformacion().value().titulo());
        Assertions.assertEquals("Sci-fi",event.getInformacion().value().categoria());
        Mockito.verify(repository).getEventsBy(CATALOGOID);
    }

    private List<DomainEvent> EventStore() {
        return List.of(
                new CatalogoCreado(
                        new Interfaz(15.6),
                        new Tendencia(1, "Dexter")
                ),
                new PeliculaAgregada(
                        PeliculaId.of("P1"),
                        new Informacion("Advengers","Sci-fi")
                )
        );
    }
}