/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import idao.IDAOPersona;
import modelo.Auditorio;
import modelo.Persona;
import persistencia.Persistencia;
import util.LSE;

/**
 *
 * @author Juan Esteban
 */
public class DAOPersona implements IDAOPersona {

    private Auditorio auditorio;

    public DAOPersona(Auditorio auditorio) {
        this.auditorio = auditorio;
    }

    public LSE<Persona> getPersonas() {
        return auditorio.getPersonas();
    }

    @Override
    public void agregarP(Persona persona) throws RuntimeException {
        Persona aux = buscarP(persona.getCedula());
        if (aux == null) {
            auditorio.getPersonas().addFirst(persona);
            Persistencia.getInstancia().escribirAuditorios();
            return;
        }
        throw new RuntimeException("Ya se encuentra esa cedula");
    }

    @Override
    public Persona buscarP(String cedula) {
        for (int i = 0; i < auditorio.getPersonas().size(); i++) {
            if (auditorio.getPersonas().get(i).getCedula().equals(cedula)) {
                return auditorio.getPersonas().get(i);
            }
        }
        return null;
    }

    @Override
    public void editarP(Persona persona) throws RuntimeException {
        Persona aux = buscarP(persona.getCedula());
        if (aux != null) {
            aux.setNombre(persona.getNombre());
            Persistencia.getInstancia().escribirAuditorios();
            return;
        }
        throw new RuntimeException("No se puede editar la persona");
    }

    @Override
    public void eliminarP(String cedula) throws RuntimeException {
        for (int i = 0; i < auditorio.getPersonas().size(); i++) {
            if (auditorio.getPersonas().get(i).getCedula().equals(cedula)) {
                auditorio.getPersonas().remove(i);
                Persistencia.getInstancia().escribirAuditorios();
                return;
            }
            throw new RuntimeException("No se puede eliminar la persona");
        }
    }
}
