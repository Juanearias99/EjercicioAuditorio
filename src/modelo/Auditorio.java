/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import persistencia.Persistencia;
import util.LSE;

/**
 *
 * @author Juan Esteban
 */
public class Auditorio {

    private LSE<Persona> personas;
    private String tema;

    public Auditorio() {
        this.personas = new LSE<>();
        this.tema = "";
    }

    public LSE<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(LSE<Persona> personas) {
        this.personas = personas;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public boolean validarPersona() {
        return !this.personas.isEmpty();
    }

    public boolean validarTema() {
        return !this.tema.equals("");
    }

    public void escribirAuditorios() {
        Persistencia.getInstancia().escribirAuditorios();
    }
}
