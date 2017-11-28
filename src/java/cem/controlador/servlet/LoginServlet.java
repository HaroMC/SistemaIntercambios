package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/ingresar"})
public class LoginServlet extends HttpServlet {

    private DaoEntidades dao;
    private HttpSession sesion;

    @Override
    public void init() {
        dao = new DaoEntidades();
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usuarioActual = dao.buscarUsuario(
                request.getParameter("nombreUsuario"),
                request.getParameter("contrasena")
        );

        if (usuarioActual != null) {
            sesion = request.getSession(true);
            sesion.setAttribute("usuarioActual", usuarioActual);
            redireccionarPerfil(response, usuarioActual.getPerfil());
        }
        else {
            String mensaje = "Sus credenciales no son válidas.";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("ingresar")
                    .forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        /*sesion = request.getSession();
        if ((Usuario) sesion.getAttribute("usuarioAcual") != null) {
            String perfil = ((Usuario) sesion
                    .getAttribute("usuarioActual"))
                    .getPerfil();
            redireccionarPerfil(response, perfil);
        }
        else {
            response.sendRedirect("login.jsp");
        }*/
        response.sendRedirect("login.jsp");
    }

    private void redireccionarPerfil(HttpServletResponse response,
            String perfil)
            throws ServletException, IOException {
        
        switch (perfil) {
            case "Administrador":
                response.sendRedirect("cem-programas");
                break;
                
            case "CEL":
                response.sendRedirect("CEL_home.jsp");
                break;
                
            case "Alumno":
                response.sendRedirect("Alumno_perfil.jsp");
                break;
                
            case "Familia":
                response.sendRedirect("Familia_perfil.jsp");
                break;
                
            default:
                response.sendRedirect("no-autorizado.html");
        }
    }
    
}
