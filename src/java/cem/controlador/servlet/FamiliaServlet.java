package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.FamiliaAnfitriona;
import cem.modelo.entidad.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FamiliaServlet", urlPatterns = {"/familias"})
public class FamiliaServlet extends HttpServlet {
    
    private DaoEntidades dao;
    
    @Override
    public void init() {
        dao = new DaoEntidades();
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario objUsuario = 
                (Usuario) request.getSession().getAttribute("usuarioActual");
        
        FamiliaAnfitriona objFamilia =
                dao.buscarFamilia(objUsuario.getRut());
        
        request.getRequestDispatcher("CEM_administracion_familia.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
}
