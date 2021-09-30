package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

public class Configuracion implements ValueObject<Configuracion.Props> {

    private final String idioma;
    private final boolean bloqueo;

    public Configuracion(String idioma, boolean bloqueo){
        this.idioma = idioma;
        this.bloqueo = bloqueo;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String idioma() {
                return idioma;
            }

            @Override
            public boolean bloqueo() {
                return bloqueo;
            }
        };
    }

    public interface Props{
        String idioma();
        boolean bloqueo();
    }
}
