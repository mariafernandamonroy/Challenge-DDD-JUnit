package com.sofkau.challenge.usecases.cuentausecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.commands.ActualizarOrigenDocumental;
import com.sofkau.challenge.domain.catalogo.events.CatalogoCreado;
import com.sofkau.challenge.domain.catalogo.events.DocumentalAgregado;
import com.sofkau.challenge.domain.catalogo.events.OrigenDocumentalActualizado;
import com.sofkau.challenge.domain.catalogo.values.*;
import com.sofkau.challenge.domain.cuenta.Estado;
import com.sofkau.challenge.domain.cuenta.commands.CambiarEstado;
import com.sofkau.challenge.domain.cuenta.events.CuentaCreada;
import com.sofkau.challenge.domain.cuenta.events.EstadoCambiado;
import com.sofkau.challenge.domain.cuenta.values.CuentaId;
import com.sofkau.challenge.usecases.catalogousecases.ActualizarOrigenDocumentalUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CambiarEstadoUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    private static String CUENTAID = "Cuenta-001";

    @Test
    void cambiarEstado(){
        var command = new CambiarEstado(
                CuentaId.of(CUENTAID),
                Estado.CERRADO
        );
        var useCase = new CambiarEstadoUseCase();

        Mockito.when(repository.getEventsBy(CUENTAID)).thenReturn(EventStore());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(CUENTAID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EstadoCambiado) events.get(0);
        Assertions.assertEquals(Estado.CERRADO,event.getEstado());
        Mockito.verify(repository).getEventsBy(CUENTAID);
    }

    private List<DomainEvent> EventStore() {
        return List.of(
                new CuentaCreada(
                        Estado.CERRADO
                ),
                new EstadoCambiado(
                        Estado.CERRADO
                )
        );
    }
}