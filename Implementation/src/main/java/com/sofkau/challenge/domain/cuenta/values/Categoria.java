package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofkau.challenge.domain.cuenta.GeneroContenido;
import com.sofkau.challenge.domain.cuenta.TipoContenido;

import java.util.Objects;

public class Categoria implements ValueObject<Categoria.Props> {

    private TipoContenido tipo;
    private final GeneroContenido genero;

    public Categoria(TipoContenido tipo, GeneroContenido genero){
        this.tipo = Objects.requireNonNull(tipo);
        if(isTipoContenido(tipo)){
            throw new IllegalArgumentException("El tipo de contenido no puede ser diferente a SERIE,PELICULA,DOCUMENTAL");
        }
        this.genero = Objects.requireNonNull(genero);
        if(isGenero(genero)){
            throw new IllegalArgumentException("El genero no puede ser diferente a SUSPENSO,ACCION,ROMANCE,COMEDIA,TERROR,THRILLER_PSICOLOGICO");
        }
    }

    private boolean isGenero(GeneroContenido genero) {
        return this.genero != genero.SUSPENSO || this.genero != genero.ACCION || this.genero != genero.ROMANCE
                || this.genero != genero.COMEDIA || this.genero != genero.TERROR || this.genero != genero.THRILLER_PSICOLOGICO ;
    }

    private boolean isTipoContenido(TipoContenido tipo) {
        return this.tipo != tipo.SERIE || this.tipo != tipo.PELICULA || this.tipo != tipo.DOCUMENTAL;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return tipo == categoria.tipo && genero == categoria.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, genero);
    }
}
