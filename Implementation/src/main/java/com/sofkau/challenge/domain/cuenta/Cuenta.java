package com.sofkau.challenge.domain.cuenta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.challenge.domain.cuenta.events.*;
import com.sofkau.challenge.domain.cuenta.values.*;

import java.util.List;

public class Cuenta extends AggregateEvent {
    protected CuentaId cuentaId;
    protected Estado estado = Estado.CERRADO;
    protected Preferencia preferencia;
    protected Usuario usuario;
    protected Perfil perfil;

    public Cuenta(CuentaId cuentaId,Estado estado) {
        super(cuentaId);
        appendChange(new CuentaCreada(estado)).apply();
    }

    private Cuenta(CuentaId cuentaId){
        super(cuentaId);
        subscribe(new CuentaChange(this));
    }

    public static Cuenta from(CuentaId cuentaId, List<DomainEvent> events){
        var cuenta = new Cuenta(cuentaId);
        events.forEach(cuenta::applyEvent);
        return cuenta;
    }

    public void cambiarEstado(Estado estado){
        appendChange(new EstadoCambiado(estado)).apply();
    }

    public void agregarUsuario(UsuarioId usuarioId, NombreCompleto nombreCompleto, CorreoElectronico correoElectronico,FechaNacimiento fechaNacimiento,Membresia membresia,Plan plan,int cantidadUsuarios){
        appendChange(new UsuarioAgregado(usuarioId, nombreCompleto,correoElectronico,fechaNacimiento,membresia,plan,cantidadUsuarios)).apply();
    }

    public void aumentarCantidadUsuarios(int cantidaUsuarios){
        appendChange(new CatidadUsuariosAumentada(cantidaUsuarios)).apply();
    }

    public void actualizarPlanUsuario(UsuarioId usuarioId, Plan plan){
        appendChange(new PlanUsuarioActualizado(usuarioId,plan)).apply();
    }

    public CuentaId cuentaId() {
        return cuentaId;
    }

    public Estado estado() {
        return estado;
    }

    public Preferencia preferencia() {
        return preferencia;
    }

    public Usuario usuario() {
        return usuario;
    }

    public Perfil perfil() {
        return perfil;
    }
}
