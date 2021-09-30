package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.ValueObject;

public class Origen implements ValueObject<Origen.Props> {
    private final String ciudad;
    private final String pais;

    public Origen(String ciudad, String pais){
        this.ciudad = ciudad;
        this.pais = pais;
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
}
