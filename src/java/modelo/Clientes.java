package modelo;

/**
 *
 * @author Familia Montoya
 */
public class Clientes implements Comparable<Clientes> {
    private int id, edad, cedula;
    private String nombre, estadoCivil, trabaja;
    
    private int puntuacion = 0;


    public Clientes(int id, int edad, int cedula, String nombre, String estadoCivil, String trabaja) {
        this.id = id;
        this.edad = edad;
        this.cedula = cedula;
        this.nombre = nombre;
        this.estadoCivil = estadoCivil;
        this.trabaja = trabaja;
    }
    
    
    public void puntuacion(Clientes cliente) {
        int edad = cliente.getEdad();
        String estadoCivil = cliente.getEstadoCivil();
        String trabaja = cliente.getTrabaja();
        int puntuacion = cliente.getPuntuacion();
        
        int EDAD_IDEAL = 35;
        
        if(edad <= EDAD_IDEAL) {
            puntuacion += 5;
        } else {
            puntuacion += 2;
        } 
        
        if(null == trabaja) {
            System.out.println("Error estado civil puntuación");
        } else switch (trabaja) {
            case "si":
                puntuacion += 5;
                break;
            case "no":
                puntuacion += 1;
                break;
            default:
                System.out.println("Error estado civil puntuación");
                break;
        }
        
        if("soltero".equals(estadoCivil) || "soltera".equals(estadoCivil)) {
            puntuacion += 5;
        } else if("casado".equals(estadoCivil) || "casada".equals(estadoCivil)) {
            puntuacion += 2;
        }
        
        cliente.setPuntuacion(puntuacion);
    }
    
    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
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

    @Override
    public int compareTo(Clientes o) {
        if(this.puntuacion < o.getPuntuacion()) {
            return 1;
        } else {
            if(this.puntuacion > o.getPuntuacion()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    
    
}
