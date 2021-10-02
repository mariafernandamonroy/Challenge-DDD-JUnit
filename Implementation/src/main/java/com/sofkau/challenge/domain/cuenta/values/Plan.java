package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofkau.challenge.domain.cuenta.TipoPlan;

import java.util.Objects;

public class Plan implements ValueObject<Plan.Props> {

    private final String nombrePlan;
    private final TipoPlan tipoPlan;

    public Plan(String nombrePlan, TipoPlan tipoPlan ){
        this.nombrePlan = Objects.requireNonNull(nombrePlan);
        if(this.nombrePlan.isBlank()){
            throw new IllegalArgumentException("El nombre del plan no puede estar vacío");
        }
        if(this.nombrePlan.length()<=5){
            throw new IllegalArgumentException("El correo debe tener mínimo 5 carácteres");
        }
        this.tipoPlan = Objects.requireNonNull(tipoPlan);
//        if(isTipoPlan(tipoPlan)){
//            throw new IllegalArgumentException("El tipo de plan no puede ser diferente a DOS_PANTALLAS,TRES_PANTALLAS,CUATRO_PANTALLAS");
//        }
    }

    private boolean isTipoPlan(TipoPlan tipoPlan) {
        return this.tipoPlan != tipoPlan.DOS_PANTALLAS || this.tipoPlan != tipoPlan.TRES_PANTALLAS || this.tipoPlan != tipoPlan.CUATRO_PANTALLAS;
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
