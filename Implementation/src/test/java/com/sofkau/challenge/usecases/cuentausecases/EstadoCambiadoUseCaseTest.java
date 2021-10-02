package com.sofkau.challenge.usecases.cuentausecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.cuenta.Estado;
import com.sofkau.challenge.domain.cuenta.commands.CambiarEstado;
import com.sofkau.challenge.domain.cuenta.events.CuentaCreada;
import com.sofkau.challenge.domain.cuenta.events.EstadoCambiado;
import com.sofkau.challenge.domain.cuenta.values.CuentaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class EstadoCambiadoUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    private static String CUENTAID = "Cuenta-001";

    @Test
    void cambiarEstado(){
        var event = new CuentaCreada(
                Estado.CERRADO
        );
        event.setAggregateRootId(CUENTAID);
        var useCase = new EstadoCambiadoUseCase();

        Mockito.when(repository.getEventsBy(CUENTAID)).thenReturn(EventStore());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(CUENTAID)
                .syncExecutor(useCase,new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var eventEstadoCambiado = (EstadoCambiado) events.get(0);
        Assertions.assertEquals(Estado.ABIERTO,eventEstadoCambiado.getEstado());
        Mockito.verify(repository).getEventsBy(CUENTAID);
    }

    private List<DomainEvent> EventStore() {
        return List.of(
                new CuentaCreada(
                        Estado.CERRADO
                ),
                new EstadoCambiado(
                        Estado.ABIERTO
                )
        );
    }
}