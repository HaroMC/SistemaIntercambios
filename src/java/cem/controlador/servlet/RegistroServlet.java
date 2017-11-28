package cem.controlador.servlet;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.FamiliaAnfitriona;
import cem.modelo.entidad.Usuario;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/registrar"})
public class RegistroServlet extends HttpServlet {

    private DaoEntidades dao;
    
    @Override
    public void init() throws ServletException {
        dao = new DaoEntidades();
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        response.sendRedirect("login.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("tipo");
        String perfil;
        String estado;
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        if (accion != null) {
            
            //<editor-fold defaultstate="collapsed" desc="Registro de familias">
            
            if (accion.compareToIgnoreCase("familia") == 0) {
                
                perfil = "Familia" ;
                estado = "Aprobación pendiente";
                
                try {
                    /**
                     * Se instancia una <code>FamiliaAnfitriona</code>
                     * capturando los ingresos desde el formulario de registro.
                     */
                    FamiliaAnfitriona objFamilia = new FamiliaAnfitriona(
                            Short.parseShort(
                                    request.getParameter("cantidadIntegrantes")
                            ),
                            estado,
                            request.getParameter("run"),
                            request.getParameter("nombreJefeFamilia") + " " +
                                    request.getParameter("apellidoJefeFamilia"),
                            formato.parse(
                                    request.getParameter("fechaNacimiento")
                            ),
                            request.getParameter("domicilio"),
                            request.getParameter("ciudad"),
                            request.getParameter("pais"),
                            request.getParameter("correo"),
                            request.getParameter("telefono"),
                            perfil
                    );
                    
                    /**
                     * Se consulta el resultado del registro en la base de
                     * datos.
                     */
                    if (dao.insertarFamilia(objFamilia) != 1) {
                        request.setAttribute("mensaje", "Error de registro.");
                        request.getRequestDispatcher("registro/familia.jsp")
                                .forward(request, response);
                    }
                    
                    /**
                     * Si el registro funcionó correctamente, se procede a
                     * crear el <code>Usuario</code> correspondiente.
                     */

                    // Método para obtener la fecha en el momento del registro.
                    Calendar cal = Calendar.getInstance();
                    Date fechaRegistro = formato.parse(
                            Integer.toString(cal.get(Calendar.YEAR))+ "-" +
                            Integer.toString(cal.get(Calendar.MONTH)) + "-" +
                            Integer.toString(cal.get(Calendar.DAY_OF_MONTH))
                    );
                    
                    Usuario objUsuario = new Usuario(
                            dao.ultimoCodigoIncremental("USUARIO") + 1,
                            request.getParameter("nombreUsuario"),
                            request.getParameter("clave1"),
                            fechaRegistro,
                            request.getParameter("run"),
                            perfil
                    );
                    
                    if (dao.registrarUsuario(objUsuario,
                            request.getParameter("run"),
                            request.getParameter("clave1"))) {
                        
                        request.setAttribute("mensaje", "Se ha registrado "
                                + "correctamente.\n Ahora puede iniciar "
                                + "sesión.");
                        request.getRequestDispatcher("login.jsp")
                                .forward(request, response);
                    }
                    else {
                        request.setAttribute("mensaje", "Error de registro.");
                        request.getRequestDispatcher("registro/familia.jsp")
                                .forward(request, response);
                    }
                }
                catch (ParseException ex) {
                    Logger.getLogger(RegistroServlet.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Registro de alumnos">
            
            /**
             * Para el caso del registro de alumnos es diferente: se parte desde
             * la base que los datos personales de los alumnos ya se encuentran 
             * registrados en nuestra base de datos (estos datos deben haber
             * sido previamente extraídos con un web service desde el sistema
             * de gestión de alumnos del CEM).
             */
            if (accion.compareToIgnoreCase("alumno") == 0) {
                
                perfil = "Alumno";
                
                try {
                    /**
                     * Primero, se comprueba si el RUN ingresado pertenece al
                     * de un alumno del CEM: si pertenece, se procede a
                     * registrar la cuenta de usuario, caso contrario, se le
                     * informa que el RUN ingresado no pertenece al de un alumno
                     * matriculado en la institución.
                     */
                    if (dao.comprobarRutExistente(
                            request.getParameter("run"))) {
                        /**
                         * Se instancia un <code>Calendar</code> para obtener
                         * la fecha en el momento del registro.
                         */
                        Calendar cal = Calendar.getInstance();
                        Date fechaRegistro = formato.parse(
                                Integer.toString(cal.get(
                                        Calendar.YEAR))+ "-" +
                                        Integer.toString(
                                                cal.get(Calendar.MONTH)) + "-" +
                                        Integer.toString(
                                                cal.get(Calendar.DAY_OF_MONTH))
                        );
                        /**
                         * Si el RUN pertenece al de un alumno matriculado,
                         * entonces se instancia un <code>Usuario</code> para
                         * crear la cuenta de usuario del alumno en nuestro
                         * sistema.
                         */
                        Usuario objUsuario = new Usuario(
                                dao.ultimoCodigoIncremental("USUARIO") + 1,
                                request.getParameter("nombreUsuario"),
                                request.getParameter("clave1"),
                                fechaRegistro,
                                request.getParameter("run"),
                                perfil
                        );
                        /**
                         * Se intenta la inserción en la base de datos: si
                         * resulta, se redirige al usuario a la página de
                         * ingreso para que entre con su nueva cuenta y, si no
                         * se logró el registro, se mantiene en el formulario
                         * de registro y se le envía un mensaje de error.
                         */
                        if (dao.registrarUsuario(objUsuario,
                                request.getParameter("run"),
                                request.getParameter("clave1"))) {
                            
                            request.setAttribute("mensaje", "Se ha registrado "
                                    + "correctamente.\n Ahora puede iniciar "
                                    + "sesión.");
                            request.getRequestDispatcher("login.jsp")
                                    .forward(request, response);
                        }
                        else {
                            request.setAttribute("mensaje",
                                    "Error de registro.");
                            request.getRequestDispatcher("registro/alumno.jsp")
                                    .forward(request, response);
                        }
                    }
                    else {
                        request.setAttribute("mensaje", "Su RUN no pertenece a "
                                + "ningún alumno de la institución CEM.");
                        request.getRequestDispatcher("registro/alumno.jsp")
                                .forward(request, response);
                    }
                }
                catch (ParseException ex) {
                    Logger.getLogger(RegistroServlet.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
            //</editor-fold>
            
        }
    }
    
}
