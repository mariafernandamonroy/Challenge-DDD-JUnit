package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Interfaz implements ValueObject<Double> {
    private final double tamañoPantalla;

    public Interfaz(double tamañoPantalla){
        this.tamañoPantalla = Objects.requireNonNull(tamañoPantalla);
        if(this.tamañoPantalla < 0 ){
            throw new IllegalArgumentException("El tamaño de la pantalla no puede ser menor a cero");
        }
    }

    @Override
    public Double value() {
        return tamañoPantalla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interfaz interfaz = (Interfaz) o;
        return Double.compare(interfaz.tamañoPantalla, tamañoPantalla) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tamañoPantalla);
    }
}
