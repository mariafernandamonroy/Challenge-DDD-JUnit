package com.sofkau.challenge.usecases.cuentausecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.cuenta.Estado;
import com.sofkau.challenge.domain.cuenta.TipoPlan;
import com.sofkau.challenge.domain.cuenta.commands.ActualizarPlanUsuario;
import com.sofkau.challenge.domain.cuenta.events.CuentaCreada;
import com.sofkau.challenge.domain.cuenta.events.PlanUsuarioActualizado;
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
class ActualizarPlanUsuarioUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    private static String CUENTAID = "Cuenta-001";

    @Test
    void actualizarPlanUsuario(){
        var command = new ActualizarPlanUsuario(
                CuentaId.of(CUENTAID),
                UsuarioId.of("U1"),
                new Plan("Premium", TipoPlan.DOS_PANTALLAS)
        );
        var useCase = new ActualizarPlanUsuarioUseCase();

        Mockito.when(repository.getEventsBy(CUENTAID)).thenReturn(EventStore());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(CUENTAID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PlanUsuarioActualizado) events.get(0);
        Assertions.assertEquals("U1",event.getUsuarioId().value());
        Assertions.assertEquals(TipoPlan.DOS_PANTALLAS,event.getPlan());
        Mockito.verify(repository).getEventsBy(CUENTAID);
    }

    private List<DomainEvent> EventStore() {
        return List.of(
                new CuentaCreada(
                        Estado.ABIERTO
                ),
                new UsuarioAgregado(
                        new NombreCompleto("Ligia","Gongora"),
                        new CorreoElectronico("ligy@gmail.com"),
                        new FechaNacimiento(new Date(1964,07,18)),
                        new Membresia(new Date(2021,9,01),new Date(2021,10,01)),
                        new Plan("Premium",TipoPlan.DOS_PANTALLAS),
                        3
                )
        );
    }
}
