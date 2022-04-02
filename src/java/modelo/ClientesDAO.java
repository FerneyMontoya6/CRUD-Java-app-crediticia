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
    
    public List<Clientes> listarClientes() {
        
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
                
                Clientes cliente = new Clientes(id, edad, cedula, nombre, estadoCivil, trabaja);
                lista.add(cliente);
            }
            
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en ClientesDAO" + e.toString());
            
            return null;
        }
    }
    
    public Clientes mostrarClientes(int _id) {
        
        PreparedStatement ps;
        ResultSet rs;
        
        Clientes cliente = null;
        
        try {
            
            ps = conexion.prepareStatement("SELECT IDcliente, Nombre, Edad, EstadoCivil, Trabaja, cedula FROM clientes WHERE IDcliente=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("IDcliente");
                String nombre = rs.getString("Nombre");
                int edad = rs.getInt("Edad");
                String estadoCivil = rs.getString("EstadoCivil");
                String trabaja = rs.getString("Trabaja");
                int cedula = rs.getInt("cedula");
                
                cliente = new Clientes(id, edad, cedula, nombre, estadoCivil, trabaja);
            }
            
            return cliente;
        } catch (SQLException e) {
            System.out.println("Error en ClientesDao" + e.toString());
            
            return null;
        }
    }

    public boolean insertarClientes(Clientes cliente) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("INSERT INTO clientes (Nombre, Edad, EstadoCivil, Trabaja, cedula) VALUES (?,?,?,?,?)");
            ps.setString(1, cliente.getNombre());
            ps.setInt(2, cliente.getEdad());
            ps.setString(3, cliente.getEstadoCivil());
            ps.setString(4, cliente.getTrabaja());
            ps.setInt(5, cliente.getCedula());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en ClientesDao" + e.toString());
            
            return false;
        }
    }

    
    public boolean actualizar(Clientes cliente) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("UPDATE clientes SET Nombre=?, Edad=?, EstadoCivil=?, Trabaja=?, cedula=? WHERE IDcliente=?");
            ps.setString(1, cliente.getNombre());
            ps.setInt(2, cliente.getEdad());
            ps.setString(3, cliente.getEstadoCivil());
            ps.setString(4, cliente.getTrabaja());
            ps.setInt(5, cliente.getCedula());
            ps.setInt(6, cliente.getId());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error en ClientesDao actualizar " + e.toString());
            
            return false;
        }
    }


    public boolean eliminar(int _id) {
        
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("DELETE FROM clientes WHERE IDcliente=?");
            ps.setInt(1, _id);
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error en ClientesDao " + e.toString());
            
            return false;
        }
    }
}
