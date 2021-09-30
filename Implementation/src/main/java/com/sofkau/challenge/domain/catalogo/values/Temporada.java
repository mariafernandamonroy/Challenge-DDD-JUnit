package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.ValueObject;

public class Temporada implements ValueObject<Temporada.Props> {
    private final Capitulo capitulo;
    private final int cantidadTemporadas;
    private final int cantidadCapitulos;

    public Temporada(Capitulo capitulo, int cantidadTemporadas, int cantidadCapitulos){
        this.capitulo = capitulo;
        this.cantidadTemporadas = cantidadTemporadas;
        this.cantidadCapitulos = cantidadCapitulos;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Capitulo capitulo() {
                return capitulo;
            }

            @Override
            public int cantidadTemporadas() {
                return cantidadTemporadas;
            }

            @Override
            public int cantidadCapitulos() {
                return cantidadCapitulos;
            }
        };
    }

    public interface Props{
        Capitulo capitulo();
        int cantidadTemporadas();
        int cantidadCapitulos();
    }
}
