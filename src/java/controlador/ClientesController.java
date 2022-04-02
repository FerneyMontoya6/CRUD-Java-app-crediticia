package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Clientes;
import modelo.ClientesDAO;

/**
 *
 * @author Familia Montoya
 */
@WebServlet(name = "ClientesController", urlPatterns = {"/ClientesController"})
public class ClientesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        ClientesDAO clientesDAO = new ClientesDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("Clientes/index.jsp");
            List<Clientes> listaClientes = clientesDAO.listarClientes();
            request.setAttribute("lista", listaClientes);
        } else if("nuevo".equals(accion)) {
            dispatcher = request.getRequestDispatcher("Clientes/nuevo.jsp");
        } else if("insertar".equals(accion)) {
            
            String nombre = request.getParameter("nombre");
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            int edad = Integer.parseInt(request.getParameter("edad"));
            String trabaja = request.getParameter("trabaja");
            String estadoCivil = request.getParameter("estadoCivil");
            
            Clientes cliente = new Clientes(0, edad, cedula, nombre, estadoCivil, trabaja);
            
           
            clientesDAO.insertarClientes(cliente);
            dispatcher = request.getRequestDispatcher("Clientes/index.jsp");
            List<Clientes> listaClientes = clientesDAO.listarClientes();
            request.setAttribute("lista", listaClientes);
       }  else if("modificar".equals(accion)) {
            dispatcher = request.getRequestDispatcher("Clientes/modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Clientes cliente = clientesDAO.mostrarClientes(id);
            request.setAttribute("cliente", cliente);
        } else if("actualizar".equals(accion)) {
            
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            int edad = Integer.parseInt(request.getParameter("edad"));
            String trabaja = request.getParameter("trabaja");
            String estadoCivil = request.getParameter("estadoCivil");
            
            Clientes cliente = new Clientes(id, edad, cedula, nombre, estadoCivil, trabaja);
            
            clientesDAO.actualizar(cliente);
            dispatcher = request.getRequestDispatcher("Clientes/index.jsp");
            List<Clientes> listaClientes = clientesDAO.listarClientes();
            request.setAttribute("lista", listaClientes);
                        
        } else if("eliminar".equals(accion)) {
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            clientesDAO.eliminar(id);
            
            dispatcher = request.getRequestDispatcher("Clientes/index.jsp");
            List<Clientes> listaClientes = clientesDAO.listarClientes();
            request.setAttribute("lista", listaClientes);
        } else {
            dispatcher = request.getRequestDispatcher("Clientes/index.jsp");
            List<Clientes> listaClientes = clientesDAO.listarClientes();
            request.setAttribute("lista", listaClientes);
        }
        
       dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
