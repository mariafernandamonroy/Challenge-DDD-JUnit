package com.sofkau.challenge.domain.cuenta;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.challenge.domain.cuenta.events.CuentaCreada;

public class CuentaChange extends EventChange {
   public CuentaChange(Cuenta cuenta){
       apply((CuentaCreada event) -> {
           cuenta.estado = event.getEstado();
       });

//       apply((InterfazAjustada event) -> {
//           catalogo.interfaz = event.getInterfaz();
//       });
//


   }

}
