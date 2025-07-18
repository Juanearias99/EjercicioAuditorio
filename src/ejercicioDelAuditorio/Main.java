package ejercicioDelAuditorio;

import util.LSE;
import modelo.Participante;

public class Main {
    
    public static void main(String[] args) {
        
        LSE<Participante> lista = new LSE();
        Participante p = new Participante("1234", "Juan", "Arias", 26, "Juan99", "123");
        Participante p1 = new Participante("123", "Jose", "Arbelaez", 23, "Jose123", "12");
        
       lista.add(p);
        lista.add(p1);
        
      
        
    }
}
