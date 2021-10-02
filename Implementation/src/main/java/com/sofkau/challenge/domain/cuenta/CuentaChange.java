package com.sofkau.challenge.domain.cuenta;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.challenge.domain.cuenta.events.CuentaCreada;
import com.sofkau.challenge.domain.cuenta.events.EstadoCambiado;
import com.sofkau.challenge.domain.cuenta.events.PlanUsuarioActualizado;

public class CuentaChange extends EventChange {
   public CuentaChange(Cuenta cuenta){
       apply((CuentaCreada event) -> {
           cuenta.estado = event.getEstado();
       });

       apply((EstadoCambiado event) -> {
           cuenta.estado = event.getEstado();
       });
//
//       apply((PlanUsuarioActualizado event) -> {
//           cuenta.usuario.actualizarPlan(event.getUsuarioId(),event.getPlan());
//       });






   }

}
