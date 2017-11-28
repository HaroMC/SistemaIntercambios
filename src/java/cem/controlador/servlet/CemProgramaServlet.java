package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Programa;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CemProgramaServlet", urlPatterns = {"/cem-programas"})
public class CemProgramaServlet extends HttpServlet {
    
    private DaoEntidades dao;
    
    @Override
    public void init() {
        dao = new DaoEntidades();
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            if (accion.compareToIgnoreCase("eliminar") == 0) {
                long codigo = Long.parseLong(request.getParameter("codigo"));
                if (dao.eliminarPrograma(codigo)) {
                    
                }
            }
        }
        else {
            cargarLista(request);
            request.getRequestDispatcher("CEM_ver_programas.jsp")
                    .forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
                
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String accion = request.getParameter("accion");
        String mensaje;
        
        switch (accion) {
            case "agregar":
                try {
                    Programa objPrograma = new Programa(
                            dao.ultimoCodigoIncremental("PROGRAMA") + 1,
                            request.getParameter("nombrePrograma"),
                            format.parse(request.getParameter("fechaInicio")),
                            format.parse(request.getParameter("fechaTermino")),
                            Integer.parseInt(request.getParameter("valor")),
                            "Sin CEL asignado"
                    );
                    if (dao.insertarPrograma(objPrograma)) {
                        mensaje = "Programa agregado.";
                        request.getSession().setAttribute("mensaje", mensaje);
                        cargarLista(request);
                        response.sendRedirect("CEM_ver_programas.jsp");
                    }
                    else {
                        mensaje = "Error de registro.";
                        request.getSession().setAttribute("mensaje", mensaje);
                        response.sendRedirect("CEM_agregarPrograma.jsp");
                    }
                }
                catch (ParseException ex) {
                    Logger.getLogger(CemProgramaServlet.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
                break;
                
            case "modificar":
                break;
        }
    }
        
    private void cargarLista(HttpServletRequest request)
            throws ServletException, IOException {
        
        ArrayList<Programa> listadoProgramas = dao.listarProgramas();
        request.getSession().setAttribute(
                "listadoProgramas", listadoProgramas);
        
        /*
        // Definir que tipo de usuario es para redfireccionarlo a la página
        // que corresponda.
        String perfil = 
                ((Usuario) request.getSession()
                        .getAttribute("usuarioActual")).getPerfil();
        */
    }
    
}