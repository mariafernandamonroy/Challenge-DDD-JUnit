package com.sofkau.challenge.usecases.cuentausecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.challenge.domain.cuenta.Estado;
import com.sofkau.challenge.domain.cuenta.commands.CrearCuenta;
import com.sofkau.challenge.domain.cuenta.events.CuentaCreada;
import com.sofkau.challenge.domain.cuenta.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearCuentaUseCaseTest {

    @Test
    void crearCuenta(){
        var command = new CrearCuenta(
                CuentaId.of("Cuenta-001"),
                Estado.ABIERTO
        );
        var useCase = new CrearCuentaUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CuentaCreada)events.get(0);
        Assertions.assertEquals(Estado.ABIERTO,event.getEstado());
    }
}
