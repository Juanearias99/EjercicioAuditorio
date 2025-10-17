/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import modelo.Persona;

/**
 *
 * @author Juan Esteban
 */
public interface IDAOPersona {

    public void agregarP(Persona persona) throws RuntimeException;
    
    public Persona buscarP(String cedula);
    
    public void editarP(Persona persona) throws RuntimeException;
    
    public void eliminarP(String cedula) throws RuntimeException;
}
