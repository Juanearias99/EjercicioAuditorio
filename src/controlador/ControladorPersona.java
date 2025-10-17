/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DAOPersona;
import modelo.Auditorio;
import modelo.Persona;
import util.LSE;

/**
 *
 * @author Juan Esteban
 */
public class ControladorPersona {
    
    private DAOPersona dao;
    
    public ControladorPersona(Auditorio auditorio) {
        this.dao = new DAOPersona(auditorio);
    }
    
    public LSE<Persona>getPersonas(){
        return dao.getPersonas();
    }
    
    public void agregarP(Persona persona) throws RuntimeException {
        dao.agregarP(persona);
    }
    
    public Persona buscarP(String cedula) {
        return dao.buscarP(cedula);
        
    }
    
    public void editarP(Persona persona) throws RuntimeException {
        dao.editarP(persona);
    }
    
    public void eliminarP(String cedula) throws RuntimeException {
        dao.eliminarP(cedula);
    }
}
