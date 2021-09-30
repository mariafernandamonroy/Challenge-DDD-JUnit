package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCompleto implements ValueObject<NombreCompleto.Props> {

    private final String nombre;
    private final String apellido;

    public NombreCompleto(String nombre, String apellido){
        this.nombre = Objects.requireNonNull(nombre);
        if(this.nombre.length()<=3){
            throw new IllegalArgumentException("El nombre debe tener mínimo 3 carácteres");
        }
        this.apellido = Objects.requireNonNull(apellido);
        if(this.apellido.length()<=3){
            throw new IllegalArgumentException("El apellido debe tener mínimo 3 carácteres");
        }
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
