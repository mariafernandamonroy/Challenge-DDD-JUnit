package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.ValueObject;

public class Tendencia implements ValueObject<Tendencia.Props> {

    private final int posicion;
    private final String titulo;

    public Tendencia(int posicion, String titulo){
        this.posicion = posicion;
        this.titulo = titulo;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public int posicion() {
                return posicion;
            }

            @Override
            public String titulo() {
                return titulo;
            }
        };
    }

    public interface Props{
        int posicion();
        String titulo();
    }
}
