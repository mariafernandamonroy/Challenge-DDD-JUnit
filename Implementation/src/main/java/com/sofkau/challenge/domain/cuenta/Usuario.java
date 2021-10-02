package com.sofkau.challenge.domain.cuenta;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.challenge.domain.cuenta.values.*;

import java.util.Objects;

public class Usuario extends Entity<UsuarioId> {
    private NombreCompleto nombreCompleto;
    private CorreoElectronico correoElectronico;
    private FechaNacimiento fechaNacimiento;
    private Membresia membresia;
    private Plan plan;
    private int cantidadUsuario;

    public Usuario(UsuarioId usuarioId, NombreCompleto nombreCompleto, CorreoElectronico correoElectronico, FechaNacimiento fechaNacimiento, Membresia membresia, Plan plan, int cantidadUsuario) {
        super(usuarioId);
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.membresia = membresia;
        this.plan = plan;
        this.cantidadUsuario = cantidadUsuario;
    }

    public void actualizarNombrecompleto(NombreCompleto nombreCompleto){
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public void actualizarCorreoElectronico(CorreoElectronico correoElectronico){
        this.correoElectronico =  Objects.requireNonNull(correoElectronico);
    }

    public void actualizarFechaNacimiento(FechaNacimiento fechaNacimiento){
        this.fechaNacimiento =  Objects.requireNonNull(fechaNacimiento);
    }

    public void actualizarMembresia(Membresia membresia){
        this.membresia =  Objects.requireNonNull(membresia);
    }

    public void actualizarPlan(Plan plan){
        this.plan =  Objects.requireNonNull(plan);
    }

    public void actualizarCantidadUsuarios(int cantidadUsuario){
        this.cantidadUsuario = Objects.requireNonNull(cantidadUsuario);
    }

}
