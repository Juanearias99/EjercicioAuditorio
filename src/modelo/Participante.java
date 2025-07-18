package modelo;

public class Participante {

    private String cedula;
    private String nombre;
    private String apellidos;
    private int edad;
    private String correo;
    private String contrasenia;

    public Participante(String cedula, String nombre, String apellidos, int edad, String correo, String contrasenia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return " Participante{ " + " cedula = " + cedula + " , nombre = " + nombre + ", apellidos = " + apellidos + ", edad = " + edad + " , correo = " + correo + ", contrasenia = " + contrasenia + '}';
    }
    
    
}
