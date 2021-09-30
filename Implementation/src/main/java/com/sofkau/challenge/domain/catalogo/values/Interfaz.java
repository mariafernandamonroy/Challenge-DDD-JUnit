package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.ValueObject;

public class Interfaz implements ValueObject<Double> {
    private final double tamañoPantalla;

    public Interfaz(double tamañoPantalla){

        this.tamañoPantalla = tamañoPantalla;
    }

    @Override
    public Double value() {
        return tamañoPantalla;
    }
}
