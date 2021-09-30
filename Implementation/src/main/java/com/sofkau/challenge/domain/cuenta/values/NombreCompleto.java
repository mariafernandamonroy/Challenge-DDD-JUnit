package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

public class NombreCompleto implements ValueObject<NombreCompleto.Props> {

    private final String nombre;
    private final String apellido;

    public NombreCompleto(String nombre, String apellidoo){
        this.nombre = nombre;
        this.apellido = apellidoo;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String apellido() {
                return apellido;
            }
        };
    }


    public interface Props{
        String nombre();
        String apellido();
    }
}
