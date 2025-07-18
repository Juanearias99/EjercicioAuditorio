package singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import javax.tools.FileObject;
import modelo.Auditorio;

public class Singleton {

    private static final Singleton INSTANCIA = new Singleton();
    private Auditorio[][] auditorios;

    public Singleton() {
        auditorios = leerAuditorios();
    }

    public static Singleton getINSTANCIA() {
        return INSTANCIA;
    }

    public Auditorio[][] getAuditorios() {
        return auditorios;
    }

    private Auditorio[][] leerAuditorios() {
        try {
            FileInputStream archivo = new FileInputStream("src/singleton/participantes.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Auditorio[][]) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            auditorios = new Auditorio[3][4];
            for (int i = 0; i < auditorios.length; i++) {
                for (int j = 0; j < auditorios[i].length; j++) {
                    auditorios[i][j] = new Auditorio();
                }
            }
            return auditorios;
        }
    }

    public void escribirAuditorios() {
        try {
            FileOutputStream archivo = new FileOutputStream("src/singleton/participantes.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(auditorios);
        } catch (IOException ex) {
        }
    }
}
