package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Informacion implements ValueObject<Informacion.Props> {
    private final String titulo;
    private final String categoria;

    public Informacion(String titulo, String categoria){
        this.titulo = Objects.requireNonNull(titulo);
        if(this.titulo.length()<=5){
            throw new IllegalArgumentException("El título debe tener mínimo 5 carácteres");
        }
        this.categoria = Objects.requireNonNull(categoria);
        if(this.categoria.length()<=5){
            throw new IllegalArgumentException("La categoría debe tener mínimo 5 carácteres");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String titulo() {
                return titulo;
            }

            @Override
            public String categoria() {
                return categoria;
            }
        };
    }

    public interface Props{
        String titulo();
        String categoria();
    }
}
