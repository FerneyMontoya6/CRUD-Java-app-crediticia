package modelo;

/**
 *
 * @author Familia Montoya
 */
public class Clientes {
    private int id, edad, cedula;
    private String nombre, estadoCivil, trabaja;

    public Clientes(int id, int edad, int cedula, String nombre, String estadoCivil, String trabaja) {
        this.id = id;
        this.edad = edad;
        this.cedula = cedula;
        this.nombre = nombre;
        this.estadoCivil = estadoCivil;
        this.trabaja = trabaja;
    }

    public Clientes(int edad, int cedula, String nombre, String estadoCivil, String trabaja) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTrabaja() {
        return trabaja;
    }

    public void setTrabaja(String trabaja) {
        this.trabaja = trabaja;
    }
    
    
}
