package modelo;

import util.LSE;

public class Auditorio {

    private String tema;
    private LSE<Participante> participantes;

    public Auditorio() {
        this.tema = "";
        this.participantes = new LSE();
    }

    public String getTema() {
        return tema;
    }

    public LSE<Participante> getParticipantes() {
        return participantes;
    }

    public boolean validarParticipante() {
        return !participantes.isEmpty();
    }

    public boolean hayTema() {
        return !this.tema.equals("");
    }

}
