package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofkau.challenge.domain.cuenta.GeneroContenido;
import com.sofkau.challenge.domain.cuenta.TipoContenido;

import java.util.Objects;

public class Categoria implements ValueObject<Categoria.Props> {

    private final TipoContenido tipo;
    private final GeneroContenido genero;

    public Categoria(TipoContenido tipo, GeneroContenido genero){
        this.tipo = Objects.requireNonNull(tipo);
        this.genero = Objects.requireNonNull(genero);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public TipoContenido tipo() {
                return tipo;
            }

            @Override
            public GeneroContenido genero() {
                return genero;
            }
        };
    }

    public interface Props{
        TipoContenido tipo();
        GeneroContenido genero();
    }
}
