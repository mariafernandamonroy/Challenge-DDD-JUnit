package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.ValueObject;

public class Informacion implements ValueObject<Informacion.Props> {
    private final String titulo;
    private final String categoria;

    public Informacion(String titulo, String categoria){
        this.titulo = titulo;
        this.categoria = categoria;
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
