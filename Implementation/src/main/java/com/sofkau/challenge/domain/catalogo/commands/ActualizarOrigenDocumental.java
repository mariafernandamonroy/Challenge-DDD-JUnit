package com.sofkau.challenge.domain.catalogo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.challenge.domain.catalogo.values.CatalogoId;
import com.sofkau.challenge.domain.catalogo.values.DocumentalId;
import com.sofkau.challenge.domain.catalogo.values.Origen;

public class ActualizarOrigenDocumental extends Command {
    private final CatalogoId catalogoId;
    private final DocumentalId documentalId;
    private final Origen origen;

    public ActualizarOrigenDocumental(CatalogoId catalogoId, DocumentalId documentalId, Origen origen){
        this.catalogoId = catalogoId;
        this.documentalId = documentalId;
        this.origen = origen;
    }

    public CatalogoId getCatalogoId() {
        return catalogoId;
    }

    public DocumentalId getDocumentalId() {
        return documentalId;
    }

    public Origen getOrigen() {
        return origen;
    }
}
