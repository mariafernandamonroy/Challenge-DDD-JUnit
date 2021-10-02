package com.sofkau.challenge.domain.cuenta;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.challenge.domain.cuenta.events.*;

public class CuentaChange extends EventChange {
   public CuentaChange(Cuenta cuenta){
       apply((CuentaCreada event) -> {
           cuenta.estado = event.getEstado();
       });

       apply((EstadoCambiado event) -> {
           cuenta.estado = event.getEstado();
       });

       apply((UsuarioAgregado event) -> {
           cuenta.usuario= new Usuario(event.getUsuarioId(), event.getNombreCompleto(),event.getCorreoElectronico(),event.getFechaNacimiento(),event.getMembresia(),event.getPlan(),event.getCantidadUsuarios());
       });

       apply((PlanUsuarioActualizado event) -> {
           cuenta.usuario.actualizarPlan(event.getPlan());
       });

       apply((CatidadUsuariosAumentada event) -> {
           cuenta.usuario.actualizarCantidadUsuarios(event.getCantidaUsuarios());
       });







   }

}
