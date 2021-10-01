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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membresia membresia = (Membresia) o;
        return Objects.equals(fechaInicio, membresia.fechaInicio) && Objects.equals(fechaFinalizacion, membresia.fechaFinalizacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaInicio, fechaFinalizacion);
    }
}
