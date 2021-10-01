package com.sofkau.challenge.domain.catalogo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.catalogo.values.DocumentalId;
import com.sofkau.challenge.domain.catalogo.values.Origen;

public class DocumentalAgregado extends DomainEvent {
    private final DocumentalId documentalId;
    private final Origen origen;

    public DocumentalAgregado(DocumentalId documentalId, Origen origen) {
        super("sofkau.challenge.domain.catalogo.peliculaagregada");
        this.documentalId = documentalId;
        this.origen = origen;
    }

    public DocumentalId getDocumentalId() {
        return documentalId;
    }

    public Origen getOrigen() {
        return origen;
    }
}
