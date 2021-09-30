package com.sofkau.challenge.domain.catalogo;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.challenge.domain.catalogo.values.DocumentalId;
import com.sofkau.challenge.domain.catalogo.values.Origen;

public class Documental extends Entity<DocumentalId> {
    private Origen origen;

    public Documental(DocumentalId entityId, Origen origen) {
        super(entityId);
        this.origen = origen;
    }

    public void actualizarOrigen(Origen origen){
        this.origen = origen;
    }
}
