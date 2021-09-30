package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class Membresia implements ValueObject<Membresia.Props> {

    private final Date fechaInicio;
    private final Date fechaFinalizacion;

    public Membresia(Date fechaInicio, Date fechaFinalizacion){
        this.fechaInicio = Objects.requireNonNull(fechaInicio);
        this.fechaFinalizacion = Objects.requireNonNull(fechaFinalizacion);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Date fechaInicio() {
                return fechaInicio;
            }

            @Override
            public Date fechaFinalizacion() {
                return fechaFinalizacion;
            }
        };
    }

    public interface Props{
        Date fechaInicio();
        Date fechaFinalizacion();
    }
}
