package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Auditorio;

public class Persistencia {

    private static final Persistencia INSTANCIA = new Persistencia();
    private Auditorio[][] auditorio;

    public Persistencia() {
        this.auditorio = leerAuditorios();
    }

    public static Persistencia getInstancia() {
        return INSTANCIA;
    }

    public Auditorio[][] getAuditorios() {
        return auditorio;
    }

    private Auditorio[][] leerAuditorios() {
        try {
            FileInputStream archivo = new FileInputStream("src/persistencia/personas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Auditorio[][]) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            this.auditorio = new Auditorio[3][4];
            for (int i = 0; i < auditorio.length; i++) {
                for (int j = 0; j < auditorio[i].length; j++) {
                    auditorio[i][j] = new Auditorio();
                }
            }
            return auditorio;
        }
    }

    public void escribirAuditorios() {
        try {
            FileOutputStream archivo = new FileOutputStream("src/persistencia/personas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(auditorio);
        } catch (IOException ex) {
        }
    }
}
