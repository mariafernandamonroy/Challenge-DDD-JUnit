package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.commands.AgregarDocumental;
import com.sofkau.challenge.domain.catalogo.events.CatalogoCreado;
import com.sofkau.challenge.domain.catalogo.events.DocumentalAgregado;
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
class AgregarDocumentalUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarDocumental(){
        var command = new AgregarDocumental(
                CatalogoId.of("ABC123"),
                DocumentalId.of("D1"),
                new Origen("Grecia","Italia")
        );

        var useCase = new AgregarDocumentalUseCase();
        Mockito.when(repository.getEventsBy("ABC123")).thenReturn(EventStore());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("ABC123")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DocumentalAgregado) events.get(0);
        Assertions.assertEquals("D1",event.getDocumentalId().value());
        Assertions.assertEquals("Grecia",event.getOrigen().value().ciudad());
        Assertions.assertEquals("Italia",event.getOrigen().value().pais());
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
                        new Origen("Grecia","Italia")
                )
        );
    }

}