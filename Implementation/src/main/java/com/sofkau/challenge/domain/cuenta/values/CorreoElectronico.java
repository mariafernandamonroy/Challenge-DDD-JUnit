package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CorreoElectronico implements ValueObject<String> {

    private final String correElectronico;

    public CorreoElectronico(String correElectronico){

        this.correElectronico = Objects.requireNonNull(correElectronico);
        if(this.correElectronico.isBlank()){
            throw new IllegalArgumentException("El correo no puede estar vacío");
        }
        if(this.correElectronico.length()<=2){
            throw new IllegalArgumentException("El correo debe tener mínimo 2 carácteres");
        }
        if (!this.correElectronico.matches("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("El email no es valido");
        }
    }

    @Override
    public String value() {
        return correElectronico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorreoElectronico that = (CorreoElectronico) o;
        return Objects.equals(correElectronico, that.correElectronico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correElectronico);
    }
}
