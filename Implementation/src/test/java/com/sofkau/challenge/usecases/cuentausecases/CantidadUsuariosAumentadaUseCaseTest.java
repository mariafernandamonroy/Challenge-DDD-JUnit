package com.sofkau.challenge.usecases.cuentausecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.cuenta.Estado;
import com.sofkau.challenge.domain.cuenta.TipoPlan;
import com.sofkau.challenge.domain.cuenta.commands.AumentarCantidadUsuarios;
import com.sofkau.challenge.domain.cuenta.events.CatidadUsuariosAumentada;
import com.sofkau.challenge.domain.cuenta.events.CuentaCreada;
import com.sofkau.challenge.domain.cuenta.events.EstadoCambiado;
import com.sofkau.challenge.domain.cuenta.events.UsuarioAgregado;
import com.sofkau.challenge.domain.cuenta.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CantidadUsuariosAumentadaUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    private static String CUENTAID = "Cuenta-001";

    @Test
    void aumentarUsuarios() {
        var event = new UsuarioAgregado(
                UsuarioId.of("U1"),
                new NombreCompleto("Ligia", "Gongora"),
                new CorreoElectronico("ligy@gmail.com"),
                new FechaNacimiento(new Date(1964, 07, 18)),
                new Membresia(new Date(2021, 9, 01), new Date(2021, 10, 01)),
                new Plan("Premium", TipoPlan.TRES_PANTALLAS),
                1
        );
        event.setAggregateRootId(CUENTAID);
        var useCase = new CantidadUsuariosAumentadaUseCase();

        Mockito.when(repository.getEventsBy(CUENTAID)).thenReturn(EventStore());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(CUENTAID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var eventAumentarCantidadUsuarios = (CatidadUsuariosAumentada) events.get(0);
        System.out.println(eventAumentarCantidadUsuarios.getCantidaUsuarios());
        Assertions.assertEquals(2,eventAumentarCantidadUsuarios.getCantidaUsuarios());
        Mockito.verify(repository).getEventsBy(CUENTAID);
    }

    private List<DomainEvent> EventStore() {
        var event = new UsuarioAgregado(
                UsuarioId.of("U1"),
                new NombreCompleto("Ligia", "Gongora"),
                new CorreoElectronico("ligy@gmail.com"),
                new FechaNacimiento(new Date(1964, 07, 18)),
                new Membresia(new Date(2021, 9, 01), new Date(2021, 10, 01)),
                new Plan("Premium", TipoPlan.TRES_PANTALLAS),
                1
        );
        return List.of(
                event
        );
    }
}