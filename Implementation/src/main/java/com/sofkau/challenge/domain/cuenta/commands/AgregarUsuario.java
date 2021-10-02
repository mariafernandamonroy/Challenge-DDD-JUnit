package com.sofkau.challenge.domain.cuenta.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.challenge.domain.cuenta.values.*;

public class AgregarUsuario extends Command {
    private final CuentaId cuentaId;
    private final UsuarioId usuarioId;
    private final NombreCompleto nombreCompleto;
    private final CorreoElectronico correoElectronico;
    private final FechaNacimiento fechaNacimiento;
    private final Membresia membresia;
    private final Plan plan;
    private final int cantidadUsuarios;

    public AgregarUsuario(CuentaId cuentaId, UsuarioId usuarioId, NombreCompleto nombreCompleto, CorreoElectronico correoElectronico, FechaNacimiento fechaNacimiento, Membresia membresia, Plan plan, int cantidadUsuarios){
        this.cuentaId = cuentaId;
        this.usuarioId = usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.membresia = membresia;
        this.plan = plan;
        this.cantidadUsuarios = cantidadUsuarios;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public FechaNacimiento getFechaNacimiento() {
        return fechaNacimiento;
    }

    public CorreoElectronico getCorreoElectronico() {
        return correoElectronico;
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
