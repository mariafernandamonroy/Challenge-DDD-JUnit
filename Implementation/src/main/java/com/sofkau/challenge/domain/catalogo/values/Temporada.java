package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.sql.Time;

public class Temporada implements ValueObject<Temporada.Props> {
    private final String nombreCapitulo;
    private final int cantidadTemporadas;
    private final int cantidadCapitulos;

    public Temporada(String nombreCapitulo, int cantidadTemporadas, int cantidadCapitulos){
        this.nombreCapitulo = nombreCapitulo;
        this.cantidadTemporadas = cantidadTemporadas;
        this.cantidadCapitulos = cantidadCapitulos;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String nombreCapitulo() {
                return Temporada.this.nombreCapitulo;
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
        String nombreCapitulo();
        int cantidadTemporadas();
        int cantidadCapitulos();
    }
}
