package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Origen implements ValueObject<Origen.Props> {
    private final String ciudad;
    private final String pais;

    public Origen(String ciudad, String pais){
        this.ciudad = Objects.requireNonNull(ciudad);
        if(this.ciudad.isBlank()){
            throw new IllegalArgumentException("La ciudad no puede estar vacía");
        }
        this.pais = Objects.requireNonNull(pais);
        if(this.pais.isBlank()){
            throw new IllegalArgumentException("El país no puede estar vacío");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String ciudad() {
                return ciudad;
            }

            @Override
            public String pais() {
                return pais;
            }
        };
    }

    public interface Props{
        String ciudad();
        String pais();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Origen origen = (Origen) o;
        return Objects.equals(ciudad, origen.ciudad) && Objects.equals(pais, origen.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciudad, pais);
    }
}
