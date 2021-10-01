package com.sofkau.challenge.domain.catalogo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.values.DocumentalId;
import com.sofkau.challenge.domain.catalogo.values.Origen;

public class OrigenDocumentalActualizado extends DomainEvent {
    public OrigenDocumentalActualizado(DocumentalId documentalId, Origen origen) {
        super();
    }
}
