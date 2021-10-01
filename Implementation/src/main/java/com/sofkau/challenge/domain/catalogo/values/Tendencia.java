package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tendencia implements ValueObject<Tendencia.Props> {

    private final int posicion;
    private final String titulo;

    public Tendencia(int posicion, String titulo){
        this.posicion = Objects.requireNonNull(posicion);
        if(this.posicion <= 0){
            throw new IllegalArgumentException("La posicion no puede ser menor a 1");
        }
        if(this.posicion > 10){
            throw new IllegalArgumentException("La posición no puede ser mayor a 10");
        }
        this.titulo = Objects.requireNonNull(titulo);
        if(this.titulo.isBlank()){
            throw new IllegalArgumentException("El titulo no puede estar vacío");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tendencia tendencia = (Tendencia) o;
        return posicion == tendencia.posicion && Objects.equals(titulo, tendencia.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posicion, titulo);
    }
}
