/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Auditorio;
import persistencia.Persistencia;

/**
 *
 * @author Juan Esteban
 */
public class DAOAuditorio {

    private Auditorio[][] auditorio;

    public DAOAuditorio() {
        this.auditorio = Persistencia.getInstancia().getAuditorios();
    }

    public Auditorio obtenerAuditorios(int fila, int columna) {
        return this.auditorio[fila][columna];
    }

    public boolean auditoriosOcupados(int fila, int columna) {
        return obtenerAuditorios(fila, columna).validarPersona();
    }
}
