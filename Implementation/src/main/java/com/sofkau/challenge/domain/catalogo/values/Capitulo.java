package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.sql.Time;

public class Capitulo implements ValueObject<Capitulo.Props> {
    private final Informacion informacion;
    private final Time duracion;

    public Capitulo(Informacion informacion, Time duracion){
        this.informacion = informacion;
        this.duracion = duracion;
    }

    @Override
    public Capitulo.Props value() {
        return new Capitulo.Props() {
            @Override
            public Informacion informacion() {
                return informacion;
            }

            @Override
            public Time duracion() {
                return duracion;
            }
        };
    }

    public interface Props{
        Informacion informacion();
        Time duracion();
    }
}
