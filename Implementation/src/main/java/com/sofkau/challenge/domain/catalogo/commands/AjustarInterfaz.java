package com.sofkau.challenge.domain.catalogo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.challenge.domain.catalogo.values.CatalogoId;
import com.sofkau.challenge.domain.catalogo.values.Interfaz;

public class AjustarInterfaz extends Command {

    private final CatalogoId catalogoId;
    private final Interfaz interfaz;

    public AjustarInterfaz(CatalogoId catalogoId, Interfaz interfaz){
        this.catalogoId = catalogoId;
        this.interfaz = interfaz;
    }

    public CatalogoId getCatalogoId() {
        return catalogoId;
    }

    public Interfaz getInterfaz() {
        return interfaz;
    }
}
