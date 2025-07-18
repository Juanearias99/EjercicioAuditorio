/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Auditorio;
import singleton.Singleton;

/**
 *
 * @author Juan Esteban
 */
public class DAOAuditorio {

    private Auditorio[][] auditorios;

    public DAOAuditorio() {
        this.auditorios = Singleton.getINSTANCIA().getAuditorios();

    }

    public Auditorio obtenerAuditorios(int fila, int columna) {
        return auditorios[fila][columna];
    }

    public boolean auditorioOcupado(int fila, int columna) {
        return obtenerAuditorios(fila, columna).hayTema();
    }
}
