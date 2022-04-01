package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Familia Montoya
 */
public class ClientesDAO {
    
    Connection conexion;
    
    public ClientesDAO() {
        Conexion con = new Conexion();
        conexion = con.getContexion();
    }
    
    public List<Clientes> listarProductos() {
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<Clientes> lista = new ArrayList<>();
        
        try {
            
            ps = conexion.prepareStatement("SELECT IDcliente, Nombre, Edad, EstadoCivil, Trabaja, cedula FROM clientes");
            rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("IDcliente");
                String nombre = rs.getString("Nombre");
                int edad = rs.getInt("Edad");
                String estadoCivil = rs.getString("EstadoCivil");
                String trabaja = rs.getString("Trabaja");
                int cedula = rs.getInt("cedula");
                
                Clientes producto = new Clientes(id, edad, cedula, nombre, estadoCivil, trabaja);
                lista.add(producto);
            }
            
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en ClientesDAO" + e.toString());
            
            return null;
        }
    }
    
    public Clientes mostrarProductos(int _id) {
        
        PreparedStatement ps;
        ResultSet rs;
        
        Clientes producto = null;
        
        try {
            
            ps = conexion.prepareStatement("SELECT IDcliente, Nombre, Edad, EstadoCivil, Trabaja, cedula FROM clientes WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("IDcliente");
                String nombre = rs.getString("Nombre");
                int edad = rs.getInt("Edad");
                String estadoCivil = rs.getString("EstadoCivil");
                String trabaja = rs.getString("Trabaja");
                int cedula = rs.getInt("cedula");
                
                producto = new Clientes(id, edad, cedula, nombre, estadoCivil, trabaja);
            }
            
            return producto;
        } catch (SQLException e) {
            System.out.println("Error en ClientesDao" + e.toString());
            
            return null;
        }
    }

    public boolean insertarProductos(Clientes producto) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("INSERT INTO clientes (Nombre, Edad, EstadoCivil, Trabaja, cedula) VALUES (?,?,?,?,?)");
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getEdad());
            ps.setString(3, producto.getEstadoCivil());
            ps.setString(4, producto.getTrabaja());
            ps.setInt(5, producto.getCedula());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en ClientesDao" + e.toString());
            
            return false;
        }
    }

    
    public boolean actualizar(Clientes producto) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("UPDATE clientes SET Nombre=?, Edad=?, EstadoCivil=?, Trabaja=?, cedula=? WHERE id=?");
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getEdad());
            ps.setString(3, producto.getEstadoCivil());
            ps.setString(4, producto.getTrabaja());
            ps.setInt(5, producto.getCedula());
            ps.setInt(6, producto.getId());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en ClientesDao" + e.toString());
            
            return false;
        }
    }


    public boolean eliminar(int _id) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("DELETE FROM productos WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en ClientesDao" + e.toString());
            
            return false;
        }
    }
}
