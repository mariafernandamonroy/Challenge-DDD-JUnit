package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofkau.challenge.domain.cuenta.GeneroContenido;
import com.sofkau.challenge.domain.cuenta.TipoContenido;
import com.sofkau.challenge.domain.cuenta.TipoPlan;

public class Categoria implements ValueObject<Categoria.Props> {

    private final TipoContenido tipo;
    private final GeneroContenido genero;

    public Categoria(TipoContenido tipo, GeneroContenido genero){
        this.tipo = tipo;
        this.genero = genero;
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
