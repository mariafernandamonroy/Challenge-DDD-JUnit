package com.sofkau.challenge.domain.cuenta;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.challenge.domain.cuenta.values.Categoria;
import com.sofkau.challenge.domain.cuenta.values.PreferenciaId;

import java.util.Objects;

public class Preferencia extends Entity<PreferenciaId> {
    private Categoria categoria;

    public Preferencia(PreferenciaId preferenciaId) {
        super(preferenciaId);
    }

    public void actualizarCategoria(Categoria categoria){
        this.categoria = Objects.requireNonNull(categoria);
    }
}
