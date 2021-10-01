package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.Documental;
import com.sofkau.challenge.domain.catalogo.commands.ActualizarInformacionPelicula;
import com.sofkau.challenge.domain.catalogo.commands.ActualizarOrigenDocumental;
import com.sofkau.challenge.domain.catalogo.events.*;
import com.sofkau.challenge.domain.catalogo.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActualizarOrigenDocumentalUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarOrigenDocumental(){
        var command = new ActualizarOrigenDocumental(
                CatalogoId.of("ABC123"),
                DocumentalId.of("D1"),
                new Origen("Buenos Aires","Argentina")
        );
        var useCase = new ActualizarOrigenDocumentalUseCase();

        Mockito.when(repository.getEventsBy("ABC123")).thenReturn(EventStore());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("ABC123")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (OrigenDocumentalActualizado) events.get(0);
        Assertions.assertEquals("D1",event.getDocumentalId().value());
        Assertions.assertEquals("Buenos Aires",event.getOrigen().value().ciudad());
        Assertions.assertEquals("Argentina",event.getOrigen().value().pais());
        Mockito.verify(repository).getEventsBy("ABC123");
    }

    private List<DomainEvent> EventStore() {
        return List.of(
                new CatalogoCreado(
                        new Interfaz(15.6),
                        new Tendencia(1, "Dexter")
                ),
                new DocumentalAgregado(
                        DocumentalId.of("D1"),
                        new Origen("Buenos Aires","Argentina")
                )
        );
    }
}