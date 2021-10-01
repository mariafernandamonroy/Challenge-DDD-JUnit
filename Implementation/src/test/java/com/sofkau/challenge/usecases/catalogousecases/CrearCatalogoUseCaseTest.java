package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.challenge.domain.catalogo.events.CatalogoCreado;
import com.sofkau.challenge.domain.catalogo.commands.CrearCatalogo;
import com.sofkau.challenge.domain.catalogo.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearCatalogoUseCaseTest {

    @Test
    void crearCatalogoEscenarioExplicito(){
        var command = new CrearCatalogo(
                CatalogoId.of("ABC123"),
                new Interfaz(15.6),
                new Tendencia(1, "Dexter")
        );
        var useCase = new CrearCatalogoUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CatalogoCreado)events.get(0);
        Assertions.assertEquals(15.6,event.getInterfaz().value());
        Assertions.assertEquals(1,event.getTendencia().value().posicion());
        Assertions.assertEquals("Dexter",event.getTendencia().value().titulo());
    }
}