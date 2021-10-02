package com.sofkau.challenge.usecases.catalogousecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.commands.ActualizarInformacionSerie;
import com.sofkau.challenge.domain.catalogo.events.*;
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
class ActualizarInformacionSerieUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    private static String CATALOGOID = "ABC123";

    @Test
    void actualizarInformacionSerie(){
        var command = new ActualizarInformacionSerie(
                CatalogoId.of(CATALOGOID),
                SerieId.of("S1"),
                new Informacion("Emily in Paris","Romance"),
                new Temporada("Llegando a Paris",2,8)
        );
        var useCase = new ActualizarInformacionSerieUseCase();
        Mockito.when(repository.getEventsBy(CATALOGOID)).thenReturn(EventStore());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(CATALOGOID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (InformacionSerieActualizada) events.get(0);
        Assertions.assertEquals("S1",event.getSerieId().value());
        Assertions.assertEquals("Emily in Paris",event.getInformacion().value().titulo());
        Assertions.assertEquals("Romance",event.getInformacion().value().categoria());
        Assertions.assertEquals("Llegando a Paris",event.getTemporada().value().nombreCapitulo());
        Assertions.assertEquals(2,event.getTemporada().value().cantidadTemporadas());
        Assertions.assertEquals(8,event.getTemporada().value().cantidadCapitulos());
    }

    private List<DomainEvent> EventStore() {
        return List.of(
                new CatalogoCreado(
                        new Interfaz(15.6),
                        new Tendencia(1, "Dexter")
                ),
                new SerieAgregada(
                        SerieId.of("S1"),
                        new Informacion("Witcher","Fantasia"),
                        new Temporada("Principio del fin",2,8)
                )
        );
    }
}