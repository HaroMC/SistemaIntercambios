package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcesaBusquedaRut", urlPatterns = {"/ProcesaBusquedaRut"})
public class ProcesaBusquedaRut extends HttpServlet {

   private DaoEntidades dao = new DaoEntidades();
   
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        
        String rutSeleccionado = req.getParameter("rutSeleccionado");
        req.setAttribute("alumnoEncontrado", dao.buscarAlumno(rutSeleccionado));
        req.getRequestDispatcher("visualizarAlumno.jsp").forward(req, resp);
    }
  
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String rutAlumnoEliminado = request.getParameter("rutAlumnoEliminado");
        
        try {
            dao.eliminarPersona_2(rutAlumnoEliminado);
            response.sendRedirect("cem-alumnos");
        } catch (Exception e) {
        }
       
    }

}
