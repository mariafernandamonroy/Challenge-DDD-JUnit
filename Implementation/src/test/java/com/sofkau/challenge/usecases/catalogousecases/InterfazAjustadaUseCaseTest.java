package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.commands.AjustarInterfaz;
import com.sofkau.challenge.domain.catalogo.events.CatalogoCreado;
import com.sofkau.challenge.domain.catalogo.events.InterfazAjustada;
import com.sofkau.challenge.domain.catalogo.values.CatalogoId;
import com.sofkau.challenge.domain.catalogo.values.Interfaz;
import com.sofkau.challenge.domain.catalogo.values.Tendencia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class InterfazAjustadaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void ajustarInterfaz(){
        var command = new AjustarInterfaz(
                CatalogoId.of("ABC123"),
                new Interfaz(18)
        );
        var useCase = new InterfazAjustadaUseCase();

        Mockito.when(repository.getEventsBy("ExecutorA")).thenReturn(EventStore());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("ExecutorA")
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (InterfazAjustada)events.get(0);
        Assertions.assertEquals(18,event.getInterfaz().value());
    }

    private List<DomainEvent> EventStore() {
        return List.of(
                new CatalogoCreado(
                        new Interfaz(15.6),
                        new Tendencia(1, "Dexter")
                ),
                new InterfazAjustada(
                        CatalogoId.of("ABC123"),
                        new Interfaz(18)
                )
        );
    }
}