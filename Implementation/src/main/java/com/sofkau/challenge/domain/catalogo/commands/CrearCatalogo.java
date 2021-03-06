package com.sofkau.challenge.domain.catalogo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.challenge.domain.catalogo.values.CatalogoId;
import com.sofkau.challenge.domain.catalogo.values.Interfaz;
import com.sofkau.challenge.domain.catalogo.values.Tendencia;

public class CrearCatalogo extends Command {
    private final CatalogoId catalogoId;
    private final Interfaz interfaz;
    private final Tendencia tendencia;

    public CrearCatalogo(CatalogoId catalogoId, Interfaz interfaz, Tendencia tendencia){
        this.catalogoId = catalogoId;
        this.interfaz = interfaz;
        this.tendencia = tendencia;
    }

    public CatalogoId getCatalogoId() {
        return catalogoId;
    }

    public Interfaz getInterfaz() {
        return interfaz;
    }

    public Tendencia getTendencia() {
        return tendencia;
    }

}
