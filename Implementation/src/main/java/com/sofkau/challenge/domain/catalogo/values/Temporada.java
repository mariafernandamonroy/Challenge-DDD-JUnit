package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.sql.Time;
import java.util.Objects;

public class Temporada implements ValueObject<Temporada.Props> {
    private final String nombreCapitulo;
    private final int cantidadTemporadas;
    private final int cantidadCapitulos;

    public Temporada(String nombreCapitulo, int cantidadTemporadas, int cantidadCapitulos){
        this.nombreCapitulo =Objects.requireNonNull(nombreCapitulo);
        if(this.nombreCapitulo.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.cantidadTemporadas = Objects.requireNonNull(cantidadTemporadas);
        if(this.cantidadTemporadas < 0){
            throw new IllegalArgumentException("La cantidad de temporadas no puede ser menor a cero");
        }
        this.cantidadCapitulos = Objects.requireNonNull(cantidadCapitulos);
        if(this.cantidadCapitulos< 0 ){
            throw new IllegalArgumentException("La cantidad de capitulos no puede ser menor a cero");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temporada temporada = (Temporada) o;
        return cantidadTemporadas == temporada.cantidadTemporadas && cantidadCapitulos == temporada.cantidadCapitulos && Objects.equals(nombreCapitulo, temporada.nombreCapitulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreCapitulo, cantidadTemporadas, cantidadCapitulos);
    }
}
