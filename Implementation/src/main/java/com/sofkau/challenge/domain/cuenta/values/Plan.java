package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofkau.challenge.domain.cuenta.TipoPlan;

import java.util.Objects;

public class Plan implements ValueObject<Plan.Props> {

    private final String nombrePlan;
    private final TipoPlan tipoPlan;

    public Plan(String nombrePlan, TipoPlan tipoPlan ){
        this.nombrePlan = Objects.requireNonNull(nombrePlan);
        if(this.nombrePlan.length()<=5){
            throw new IllegalArgumentException("El correo debe tener mínimo 5 carácteres");
        }
        this.tipoPlan = Objects.requireNonNull(tipoPlan);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String nombrePlan() {
                return nombrePlan;
            }

            @Override
            public TipoPlan tipoPlan() {
                return tipoPlan;
            }
        };
    }

    public interface Props{
        String nombrePlan();
        TipoPlan tipoPlan();
    }
}
