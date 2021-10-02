package com.sofkau.challenge.domain.cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.cuenta.values.*;

public class UsuarioAgregado extends DomainEvent {
    private final NombreCompleto nombreCompleto;
    private final CorreoElectronico correoElectronico;
    private final FechaNacimiento fechaNacimiento;
    private final Membresia membresia;
    private final Plan plan;
    private final int cantidadUsuarios;

    public UsuarioAgregado(NombreCompleto nombreCompleto, CorreoElectronico correoElectronico, FechaNacimiento fechaNacimiento, Membresia membresia, Plan plan, int cantidadUsuarios) {
        super("sofkau.challenge.domain.cuenta.usuarioagregado");
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.membresia = membresia;
        this.plan = plan;
        this.cantidadUsuarios = cantidadUsuarios;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public CorreoElectronico getCorreoElectronico() {
        return correoElectronico;
    }

    public FechaNacimiento getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public Plan getPlan() {
        return plan;
    }

    public int getCantidadUsuarios() {
        return cantidadUsuarios;
    }
}
