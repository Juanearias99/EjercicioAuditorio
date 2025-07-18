/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import idao.IDAO;
import modelo.Auditorio;
import modelo.Participante;
import singleton.Singleton;
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
    public void registrarParticipante(Participante participante) throws RuntimeException {
        Participante aux = buscarParticipante(participante.getCedula());
        if (aux == null) {
            auditorios.getParticipantes().add(participante);
            Singleton.getINSTANCIA().escribirAuditorios();
            return;
        }
        throw new RuntimeException("Cedula ocupado en este auditorio");
    }

    @Override
    public Participante buscarParticipante(String cedula) {
        for (int i = 0; i < auditorios.getParticipantes().size(); i++) {
            if (auditorios.getParticipantes().get(i).getCedula().equals(cedula)) {
                return auditorios.getParticipantes().get(i);
            }
        }
        return null;
    }

    @Override
    public void modificarParticipante(Participante participante) throws RuntimeException {
        Participante aux = buscarParticipante(participante.getCedula());
        if (aux != null) {
            aux.setNombre(participante.getNombre());
            aux.setApellidos(participante.getApellidos());
            aux.setEdad(participante.getEdad());
            aux.setCorreo(participante.getCorreo());
            aux.setContrasenia(participante.getContrasenia());
            Singleton.getINSTANCIA().escribirAuditorios();
            return;
        }
        throw new RuntimeException("No se puede modificar la cedula en este auditorio");
    }

    @Override
    public void eliminarParticipante(String cedula) throws RuntimeException {
        for (int i = 0; i < auditorios.getParticipantes().size(); i++) {
            if (auditorios.getParticipantes().get(i).getCedula().equals(cedula)) {
                auditorios.getParticipantes().remove(i);
                Singleton.getINSTANCIA().escribirAuditorios();
                return;
            }
            throw new RuntimeException("No se puede eliminar la cedula en este auditorio");
        }
    }

}
