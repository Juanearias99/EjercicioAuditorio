/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DAOAuditorio;
import modelo.Auditorio;

/**
 *
 * @author Juan Esteban
 */
public class ControladorPrincipal {

    private DAOAuditorio dao;

    public ControladorPrincipal() {
        this.dao = new DAOAuditorio();
    }

    public Auditorio obtenerAuditorios(int fila, int columna) {
        return dao.obtenerAuditorios(fila, columna);
    }

    public boolean auditoriosOcupados(int fila, int columna) {
        return dao.auditoriosOcupados(fila, columna);
    }
}
