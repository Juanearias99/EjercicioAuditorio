/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import idao.IDAO;
import modelo.Auditorio;
import modelo.Participante;
import util.LSE;

/**
 *
 * @author Juan Esteban
 */
public class DAOParticipante implements IDAO {

    private Auditorio auditorios;

    public DAOParticipante(Auditorio auditorio) {
        this.auditorios = auditorios;
    }

    public LSE<Participante> getParticipantes() {
        return auditorios.getParticipantes();
    }

    @Override
    public void registrarParticipante(Participante participante) {
        Participante aux = buscarParticipante(participante.getCedula());
        if(aux == null){
            
        }
    }

    @Override
    public Participante buscarParticipante(String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificarParticipante(Participante participante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarParticipante(String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
