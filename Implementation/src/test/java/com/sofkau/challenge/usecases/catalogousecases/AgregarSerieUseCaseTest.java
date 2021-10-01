package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.commands.AgregarSerie;
import com.sofkau.challenge.domain.catalogo.events.CatalogoCreado;
import com.sofkau.challenge.domain.catalogo.events.SerieAgregada;
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
class AgregarSerieUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarSerie(){
        var command = new AgregarSerie(
                CatalogoId.of("ABC123"),
                SerieId.of("S1"),
                new Informacion("Casa de papel","Accion"),
                new Temporada("El robo perfecto",3,8)
        );
        
        var useCase = new AgregarSerieUseCase();
        Mockito.when(repository.getEventsBy("ABC123")).thenReturn(EventStore());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("ABC123")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (SerieAgregada) events.get(0);
        Assertions.assertEquals("S1",event.getSerieId().value());
        Assertions.assertEquals("Casa de papel",event.getInformacion().value().titulo());
        Assertions.assertEquals("Accion",event.getInformacion().value().categoria());
        Mockito.verify(repository).getEventsBy("ABC123");
    }

    private List<DomainEvent> EventStore() {
        return List.of(
                new CatalogoCreado(
                        new Interfaz(15.6),
                        new Tendencia(1, "Dexter")
                ),
                new SerieAgregada(
                        SerieId.of("S1"),
                        new Informacion("Casa de papel","Accion"),
                        new Temporada("El robo perfecto",3,8)
                )
        );
    }

}