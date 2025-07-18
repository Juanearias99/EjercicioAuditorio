package idao;

import modelo.Participante;

public interface IDAO {

    public void registrarParticipante(Participante participante);

    public Participante buscarParticipante(String cedula);

    public void modificarParticipante(Participante participante);

    public void eliminarParticipante(String cedula);
}
