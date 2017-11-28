package cem.controlador.dao;

import cem.modelo.conexion.Conexion;
import cem.modelo.entidad.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEntidades {
    
    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public DaoEntidades() {
        this.c = null;
        this.ps = null;
        this.rs = null;
    }
    
    public long ultimoCodigoIncremental(String nombreTabla) {
        long codigo = -1;
        String sql = "SELECT MAX(CODIGO) FROM CEM." + nombreTabla;
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                codigo = rs.getLong(1);
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return codigo;
    }
    
    // Como persona es una clase abstracta, los métodos crud de persona no
    // serán accesibles fuera de esta clase.
    // Eliminar persona es la única excepción, debido a que es posible eliminar
    // una persona por su rut y, gracias al CASCADE CONSTRAINT en la base de
    // datos, se eliminará tambíen el Alumno, CEL, Docente o FamiliaAnfitriona
    // enlazada.
    
    //<editor-fold defaultstate="collapsed" desc=" Persona : Completo ">
    
    private boolean insertarPersona(String rut, String nombreCompleto,
            Date fechaNacimiento, String domicilio, String ciudad, String pais,
            String correo, String telefono, String tipo) {
        
        boolean resultado = false;
        String sql = "INSERT INTO CEM.PERSONA (RUT, NOMBRE_COMPLETO, "
                + "FECHA_NACIMIENTO, DOMICILIO, CIUDAD, PAIS, CORREO, "
                + "TELEFONO, TIPO) VALUES (?, ?, ?, ?, ? ,? ,? ,? , ?)";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setString(1, rut);
            ps.setString(2, nombreCompleto);
            ps.setDate  (3, fechaNacimiento);
            ps.setString(4, domicilio);
            ps.setString(5, ciudad);
            ps.setString(6, pais);
            ps.setString(7, correo);
            ps.setString(8, telefono);
            ps.setString(9, tipo);
            ps.executeUpdate();
            ps.close();
            c.close();
            conexion.cerrar();
            resultado = true;
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return resultado;
    }
    
    public boolean comprobarRutExistente(String rut) {
        boolean resultado = false;
        String sql = "SELECT * FROM CEM.PERSONA WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            Connection c = conexion.abrir();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, rut);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                if (rs.getRow() > 0)
                    resultado = true;
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return resultado;
    }
    
    public boolean eliminarPersona(String rut) {
        boolean resultado = false;
        String sql = "DELETE FROM CEM.PERSONA WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setString(1, rut);
            ps.executeUpdate();
            ps.close();
            c.close();
            conexion.cerrar();
            resultado = true;
        }
        catch (SQLException ex) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    private boolean modificarPersona(String rut, String nombreCompleto,
            Date fechaNacimiento, String domicilio, String ciudad, String pais,
            String correo, String telefono, String tipo) {
        
        boolean resultado = false;
        String sql = "UPDATE CEM.PERSONA SET NOMBRE_COMPLETO = ?, "
                + "FECHA_NACIMIENTO = ?, DOMICILIO = ?, CIUDAD = ?, PAIS = ?, "
                + "CORREO = ?, TELEFONO = ?, TIPO = ? WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setString(1, nombreCompleto);
            ps.setDate  (2, fechaNacimiento);
            ps.setString(3, domicilio);
            ps.setString(4, ciudad);
            ps.setString(5, pais);
            ps.setString(6, correo);
            ps.setString(7, telefono);
            ps.setString(8, tipo);
            ps.setString(9, rut);
            ps.executeUpdate();
            ps.close();
            c.close();
            conexion.cerrar();
            resultado = true;
        }
        catch (SQLException ex) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    /*private ArrayList<Persona> listadoPersonas() {
        
        ArrayList<Persona> listado = null;
        String sql = "SELECT * FROM CEM.PERSONA";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                listado.add()
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return listado;
    }*/
    
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Alumno : Completo ">
    
    public ArrayList<Alumno> listarAlumnos() {
        ArrayList<Alumno> listado = new ArrayList<>();
        String sql = "SELECT * FROM CEM.ALUMNO INNER JOIN CEM.PERSONA "
                + "ON ALUMNO.RUT_PERSONA = PERSONA.RUT "
                + "INNER JOIN CEM.USUARIO ON PERSONA.RUT = USUARIO.RUT_PERSONA";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(new Alumno(
                        // Datos de alumno:
                        rs.getLong(2),
                        rs.getDate(3),
                        rs.getByte(4),
                        // Datos de persona:
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        new Usuario(
                                rs.getInt(14),
                                rs.getString(15),
                                rs.getString(16),
                                rs.getDate(17),
                                rs.getString(18),
                                rs.getString(19)
                        )
                ));
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return listado;
    }
    
    
    /**
     * 
     * @param objAlumno Objeto tipo Alumno con que contiene, además, los datos
     *                  de su clase padre Persona.
     * @return (-2) Si el rut ya existe en la base de datos.<br>
     *         (-1) Si no se logró insertar la persona.<br>
     *         ( 0) Si no se logró insertar el alumno.<br>
     *         ( 1) Si toda la inserción fue correcta.
     */
    public int insertarAlumno(Alumno objAlumno) {
        int resultado = 0;
        // Si el rut no está registrado en la base de datos, entonces se
        // procede con la inserción.
        if (!comprobarRutExistente(objAlumno.getRut())) {
            Date fechaNacimiento = new java.sql.Date(
                    objAlumno.getFechaNacimiento().getTime());
            // Antes de insertar a un alumno, deben insertarse los datos de la
            // persona y, si esta se inserta correctamente, se procede con la
            // inserción del alumno.
            if (insertarPersona(
                    objAlumno.getRut(),
                    objAlumno.getNombreCompleto(),
                    fechaNacimiento,
                    objAlumno.getDomicilio(),
                    objAlumno.getCiudad(),
                    objAlumno.getPais(),
                    objAlumno.getCorreo(),
                    objAlumno.getTelefono(),
                    objAlumno.getTipo())) {
                
                String sql = "INSERT INTO CEM.ALUMNO (RUT_PERSONA, "
                        + "NUMERO_MATRICULA, FECHA_MATRICULA)"
                        + "VALUES (?, ?, ?)";
                try {
                    Conexion conexion = new Conexion();
                    c = conexion.abrir();
                    ps = c.prepareStatement(sql);
                    Date fechaMatricula = new java.sql.Date(
                            objAlumno.getFechaNacimiento().getTime());
                    ps.setString(1, objAlumno.getRut());
                    ps.setLong(2, objAlumno.getNumeroMatricula());
                    ps.setDate(3, fechaMatricula);
                    ps.executeUpdate();
                    ps.close();
                    c.close();
                    conexion.cerrar();
                    resultado = 1;
                }
                catch (SQLException se) {
                    Logger.getLogger(DaoEntidades.class.getName())
                            .log(Level.SEVERE, null, se);
                }
            }
            else {
                resultado = -1;
            }
        }
        else {
            resultado = -2;
        }
        return resultado;
    }
    
    public int modificarAlumno(Alumno objAlumno) {
        int resultado = 0;
        if (comprobarRutExistente(objAlumno.getRut())) {
            Date fechaNacimiento = new java.sql.Date(
                    objAlumno.getFechaNacimiento().getTime());
            if (modificarPersona(
                    objAlumno.getRut(),
                    objAlumno.getNombreCompleto(),
                    fechaNacimiento,
                    objAlumno.getDomicilio(),
                    objAlumno.getCiudad(),
                    objAlumno.getPais(),
                    objAlumno.getCorreo(),
                    objAlumno.getTelefono(),
                    objAlumno.getTipo())) {
                resultado = 1;
            }
            else {
                resultado = -1;
            }
        }
        else {
            resultado = -2;
        }
        return resultado;
    }
    
    public Alumno buscarAlumno(String rutPersona) {
        Alumno alumno = null;
        String sql = "SELECT NUMERO_MATRICULA, FECHA_MATRICULA, ES_MOROSO, "
                + "RUT_PERSONA, NOMBRE_COMPLETO, FECHA_NACIMIENTO, DOMICILIO, "
                + "CIUDAD, PAIS, CORREO, TELEFONO, TIPO FROM CEM.ALUMNO "
                + "INNER JOIN CEM.PERSONA ON ALUMNO.RUT_PERSONA = PERSONA.RUT "
                + "WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setString(1, rutPersona);
            rs = ps.executeQuery();
            while (rs.next()) {
                alumno = new Alumno(
                        rs.getLong(1),
                        rs.getDate(2),
                        rs.getByte(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12)
                );
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return alumno;
    }
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Programa : Completo ">
        
    public boolean insertarPrograma(Programa objPrograma) {
        
        boolean resultado = false;
        String sql = "INSERT INTO CEM.PROGRAMA (CODIGO, NOMBRE, FECHA_INICIO, "
                + "FECHA_TERMINO, VALOR, ESTADO) VALUES (? ,?, ?, ?, ?, ?)";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            
            Date fechaInicio = new java.sql.Date(
                    objPrograma.getFechaInicio().getTime());
            Date fechaTermino = new java.sql.Date(
                    objPrograma.getFechaTermino().getTime());
            
            ps.setLong  (1, objPrograma.getCodigo());
            ps.setString(2, objPrograma.getNombre());
            ps.setDate  (3, fechaInicio);
            ps.setDate  (4, fechaTermino);
            ps.setInt   (5, objPrograma.getValor());
            ps.setString(6, objPrograma.getEstado());
            
            ps.executeUpdate();
            ps.close();
            c.close();
            conexion.cerrar();
            resultado = true;
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return resultado;
    }
        
    public ArrayList<Programa> listarProgramas() {
        ArrayList<Programa> listado = null;
        String sql = "SELECT * FROM CEM.PROGRAMA";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            listado = new ArrayList<>();
            while (rs.next()) {
                listado.add(new Programa(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getString(6)
                ));
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return listado;
    }
    
    public ArrayList<Programa> listarProgramasParaPostularCel() {
        ArrayList<Programa> listado = null;
        String sql = "SELECT * FROM CEM.PROGRAMA";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            listado = new ArrayList<>();
            while (rs.next()) {
                if (rs.getString(6).equalsIgnoreCase("Sin CEL asignado"))  {
                    listado.add(new Programa(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getDate(4),
                            rs.getInt(5),
                            rs.getString(6)
                    ));
                }
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return listado;
    }
    
    public boolean eliminarPrograma(long codigo) {
        boolean resultado = false;
        String sql = "DELETE FROM CEM.PROGRAMA WHERE CODIGO = ?";
        try {
            Conexion conexion = new Conexion();
            Connection c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setLong(1, codigo);
            ps.executeUpdate();
            ps.close();
            c.close();
            conexion.cerrar();
            resultado = true;
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return resultado;
    }
    
    public boolean modificarPrograma(Programa objPrograma) {
        boolean resultado = false;
        String sql = "UPDATE CEM.PROGRAMA SET NOMBRE = ?, FECHA_INICIO = ?, "
                + "FECHA_TERMINO = ?, VALOR = ?, ESTADO = ? WHERE CODIGO = ?";
        
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            
            Date fechaInicio = new java.sql.Date(
                    objPrograma.getFechaInicio().getTime());
            
            Date fechaTermino = new java.sql.Date(
                    objPrograma.getFechaTermino().getTime());
            
            ps.setString(1, objPrograma.getNombre());
            ps.setDate  (2, fechaInicio);
            ps.setDate  (3, fechaTermino);
            ps.setInt   (4, objPrograma.getValor());
            ps.setString(5, objPrograma.getEstado());
            ps.setLong  (6, objPrograma.getCodigo());
            
            ps.executeUpdate();
            
            ps.close();
            c.close();
            conexion.cerrar();
            
            resultado = true;
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        
        return resultado;
    }
    
    public Programa buscarPrograma(long codigo) {
        Programa programa = null;
        String sql = "SELECT * FROM CEM.PROGRAMA WHERE CODIGO = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setString(1, String.valueOf(codigo));
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                programa = new Programa(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getString(6)
                );
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return programa;
    }
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Familia Anfitriona : Completo ">
    
    public int insertarFamilia(FamiliaAnfitriona objFamilia) {
        int resultado = 0;
        if (!comprobarRutExistente(objFamilia.getRut())) {
            Date fechaNacimiento = new java.sql.Date(
                    objFamilia.getFechaNacimiento().getTime());
            if (insertarPersona(
                    objFamilia.getRut(),
                    objFamilia.getNombreCompleto(),
                    fechaNacimiento,
                    objFamilia.getDomicilio(),
                    objFamilia.getCiudad(),
                    objFamilia.getPais(),
                    objFamilia.getCorreo(),
                    objFamilia.getTelefono(),
                    objFamilia.getTipo())) {
                
                String sql = "INSERT INTO CEM.FAMILIA_ANFITRIONA (RUT_PERSONA, "
                        + "CANTIDAD_INTEGRANTES, ESTADO) VALUES (?, ?, ?)";
                try {
                    Conexion conexion = new Conexion();
                    c = conexion.abrir();
                    ps = c.prepareStatement(sql);
                    ps.setString(1, objFamilia.getRut());
                    ps.setShort (2, objFamilia.getCantidadIntegrantes());
                    ps.setString(3, objFamilia.getEstado());
                    ps.executeUpdate();
                    ps.close();
                    c.close();
                    conexion.cerrar();
                    resultado = 1;
                }
                catch (SQLException se) {
                    Logger.getLogger(DaoEntidades.class.getName())
                            .log(Level.SEVERE, null, se);
                }
            }
            else {
                resultado = -1;
            }
        }
        else {
            resultado = -2;
        }
        return resultado;
    }
    
    public int modificarFamilia(FamiliaAnfitriona objFamilia) {
        int resultado = 0;
        if (comprobarRutExistente(objFamilia.getRut())) {
            Date fechaNacimiento = new java.sql.Date(
                    objFamilia.getFechaNacimiento().getTime());
            if (modificarPersona(
                    objFamilia.getRut(),
                    objFamilia.getNombreCompleto(),
                    fechaNacimiento,
                    objFamilia.getDomicilio(),
                    objFamilia.getCiudad(),
                    objFamilia.getPais(),
                    objFamilia.getCorreo(),
                    objFamilia.getTelefono(),
                    objFamilia.getTipo())) {
                
                String sql = "UPDATE CEM.FAMILIA_ANFITRIONA "
                        + "SET CANTIDAD_INTEGRANTES = ?, ESTADO = ? "
                        + "WHERE RUT_PERSONA = ?";
                try {
                    Conexion conexion = new Conexion();
                    c = conexion.abrir();
                    ps = c.prepareStatement(sql);
                    ps.setShort (1, objFamilia.getCantidadIntegrantes());
                    ps.setString(2, objFamilia.getEstado());
                    ps.setString(3, objFamilia.getRut());
                    ps.executeUpdate();
                    ps.close();
                    c.close();
                    conexion.cerrar();
                    resultado = 1;
                }
                catch (SQLException se) {
                    Logger.getLogger(DaoEntidades.class.getName())
                            .log(Level.SEVERE, null, se);
                }
            }
            else {
                resultado = -1;
            }
        }
        else {
            resultado = -2;
        }
        return resultado;
    }
    
    public ArrayList<FamiliaAnfitriona> listarFamilias() {
        
        ArrayList<FamiliaAnfitriona> listado = new ArrayList<>();
        String sql = "SELECT CANTIDAD_INTEGRANTES, ESTADO, RUT_PERSONA, "
                + "NOMBRE_COMPLETO, FECHA_NACIMIENTO, DOMICILIO, "
                + "CIUDAD, PAIS,  CORREO, TELEFONO, TIPO "
                + "FROM CEM.FAMILIA_ANFITRIONA INNER JOIN CEM.PERSONA "
                + "ON FAMILIA_ANFITRIONA.RUT_PERSONA = PERSONA.RUT";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            
            while (rs.next()) {
                listado.add(new FamiliaAnfitriona(
                        // Datos de familia:
                        rs.getShort(1),
                        rs.getString(2),
                        // Datos de persona:
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                ));
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return listado;
    }
    
    public FamiliaAnfitriona buscarFamilia(String rutPersona) {
        FamiliaAnfitriona familia = null;
        String sql = "SELECT CANTIDAD_INTEGRANTES, ESTADO, RUT_PERSONA, "
                + "NOMBRE_COMPLETO, FECHA_NACIMIENTO, DOMICILIO, "
                + "CIUDAD, PAIS, CORREO, TELEFONO, TIPO "
                + "FROM CEM.FAMILIA_ANFITRIONA INNER JOIN CEM.PERSONA "
                + "ON FAMILIA_ANFITRIONA.RUT_PERSONA = PERSONA.RUT"
                + "WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setString(1, rutPersona);
            rs = ps.executeQuery();
            while (rs.next()) {
                familia = new FamiliaAnfitriona(
                        // Datos de familia:
                        rs.getShort(1),
                        rs.getString(2),
                        // Datos de persona:
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                );
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return familia;
    }
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Asignatura : ">
    
    public boolean insertarAsignatura(Asignatura objAsignatura) {
        boolean resultado = false;
        String sql = "INSERT INTO CEM.ASIGNATURA (CODIGO, RUT_DOCENTE, "
                + "NOMBRE_ASIGNATURA, DESCRIPCION, CUPOS) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setLong  (1, objAsignatura.getCodigo());
            ps.setString(2, objAsignatura.getDocente().getRut());
            ps.setString(3, objAsignatura.getNombreAsignatura());
            ps.setString(4, objAsignatura.getDescripcion());
            ps.setLong  (5, objAsignatura.getCupos());
            ps.executeLargeUpdate();
            ps.close();
            c.close();
            conexion.cerrar();
            resultado = true;
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return resultado;
    }
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Docente : Completo ">
    
    public int ingresarDocente(Docente objDocente) {
        
        int resultado = 0;
        if (!comprobarRutExistente(objDocente.getRut())) {
            
            Date fechaNacimiento = new java.sql.Date(
                    objDocente.getFechaNacimiento().getTime());
            if (insertarPersona(
                    objDocente.getRut(),
                    objDocente.getNombreCompleto(),
                    fechaNacimiento,
                    objDocente.getDomicilio(),
                    objDocente.getCiudad(),
                    objDocente.getPais(),
                    objDocente.getCorreo(),
                    objDocente.getTelefono(),
                    objDocente.getTipo())) {
                
                String sql = "INSERT INTO CEM.DOCENTE (RUT_PERSONA, ESTADO, "
                        + "OBSERVACIONES) VALUES (?, ?, ?, ?, ?)";
                
                try {
                    Conexion conexion = new Conexion();
                    c = conexion.abrir();
                    ps = c.prepareStatement(sql);
                    ps.setString(1, objDocente.getRut());
                    ps.setString(2, objDocente.getEstado());
                    ps.setString(3, objDocente.getObservaciones());
                    ps.executeUpdate();
                    ps.close();
                    c.close();
                    conexion.cerrar();
                    resultado = 1;
                }
                catch (SQLException se) {
                    Logger.getLogger(DaoEntidades.class.getName())
                            .log(Level.SEVERE, null, se);
                }
            }
            else {
                resultado = -1;
            }
        }
        else {
            resultado = -2;
        }
        return resultado;
    }
    
    public Docente buscarDocente(int rutPersona) {
        Docente objDocente = null;
        String sql = "SELECT ESTADO, OBSERVACIONES, RUT_PERSONA, "
                + "NOMBRE_COMPLETO, FECHA_NACIMIENTO, DOMICILIO, CIUDAD, PAIS,"
                + "CORREO, TELEFONO, TIPO FROM CEM.DOCENTE "
                + "INNER JOIN CEM.PERSONA ON DOCENTE.RUT_PERSONA = PERSONA.RUT"
                + "WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            ps.setInt(1, rutPersona);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                objDocente = new Docente(
                        // Datos de docente:
                        rs.getString(1),
                        rs.getString(2),
                        // Datos de persona:
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                );
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return objDocente;
    }
    
    /*
    public Docente(String estado, String observaciones, String rutPersona,
            String nombreCompleto, Date fechaNacimiento, String domicilio,
            String ciudad, String pais, String correo, String telefono,
            String tipo) {*/
    
    public ArrayList<Docente> listarDocentes() {
        ArrayList<Docente> listado = new ArrayList<>();
        String sql = "SELECT ESTADO, OBSERVACIONES, RUT_PERSONA, "
                + "NOMBRE_COMPLETO, FECHA_NACIMIENTO, DOMICILIO, CIUDAD, PAIS, "
                + "CORREO, TELEFONO, TIPO FROM CEM.DOCENTE "
                + "INNER JOIN CEM.PERSONA ON DOCENTE.RUT_PERSONA = PERSONA.RUT";
        try {
            Conexion conexion = new Conexion();
            c = conexion.abrir();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                listado.add(new Docente(
                        // Datos de docente:
                        rs.getString(1),
                        rs.getString(2),
                        // Datos de persona:
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                ));
            }
            rs.close();
            ps.close();
            c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return listado;
    }
    
    public int modificarDocente(Docente objDocente) {
        
        int resultado = 0;
        if (comprobarRutExistente(objDocente.getRut())) {
            
            Date fechaNacimiento = new java.sql.Date(
                    objDocente.getFechaNacimiento().getTime());
            
            if (modificarPersona(
                    objDocente.getRut(),
                    objDocente.getNombreCompleto(),
                    fechaNacimiento,
                    objDocente.getDomicilio(),
                    objDocente.getCiudad(),
                    objDocente.getPais(),
                    objDocente.getCorreo(),
                    objDocente.getTelefono(),
                    objDocente.getTipo())) {
                
                String sql = "UPDATE CEM.DOCENTE SET ESTADO = ?, "
                        + "OBSERVACIONES = ? WHERE RUT_PERSONA = ?";
                
                try {
                    Conexion conexion = new Conexion();
                    c = conexion.abrir();
                    ps = c.prepareStatement(sql);
                    ps.setString(1, objDocente.getEstado());
                    ps.setString(2, objDocente.getObservaciones());
                    ps.setString(3, objDocente.getRut());
                    ps.executeUpdate();
                    ps.close();
                    c.close();
                    conexion.cerrar();
                    resultado = 1;
                }
                catch (SQLException se) {
                    Logger.getLogger(DaoEntidades.class.getName())
                            .log(Level.SEVERE, null, se);
                }
            }
            else {
                resultado = -1;
            }
        }
        else {
            resultado = -2;
        }
        return resultado;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Antecedente : ">
    
    public boolean ingresarAntecedente(Antecedente objAntecedente,
            String rutPersona) {
        
        boolean resultado = false;
        if (comprobarRutExistente(rutPersona)) {
            
            String sql = "INSERT INTO CEM.ANTECEDENTE (CODIGO, DESCRIPCION, "
                    + "FECHA_CADUCIDAD, DOCUMENTO, RUT_FAMILIA) "
                    + "VALUES (?, ?, ?, ?, ?)";
            try {
                Conexion conexion = new Conexion();
                c = conexion.abrir();
                ps = c.prepareStatement(sql);
                
                Date fechaCaducidad = new java.sql.Date(
                        objAntecedente.getFechaCaducidad().getTime());
                
                ps.setLong  (1, objAntecedente.getCodigo());
                ps.setString(2, objAntecedente.getDescripcion());
                ps.setDate  (3, fechaCaducidad);
                ps.setString(4, objAntecedente.getDocumento());
                ps.setString(5, rutPersona);
                
                ps.executeUpdate();
                
                ps.close();
                c.close();
                conexion.cerrar();
                resultado = true;
            }
            catch (SQLException se) {
                Logger.getLogger(DaoEntidades.class.getName())
                        .log(Level.SEVERE, null, se);
            }
        }
        return resultado;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Usuario : Completo ">
    
    public boolean validarUsuario(String nombreUsuario,
            String c) {
        
        boolean resultado = false;
        String sql = "SELECT NOMBRE FROM CEM.USUARIO "
                + "WHERE NOMBRE = ? AND CONTRASENA = ?";
        try {
            Conexion conexion = new Conexion();
            this.c = conexion.abrir();
            ps = this.c.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, c);
            rs = ps.executeQuery(sql);
            if (rs.getRow() > 0) {
                resultado = true;
            }
            rs.close();
            ps.close();
            this.c.close();
            conexion.cerrar();
            resultado = true;
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return resultado;
    }
    
    public boolean registrarUsuario(Usuario objUsuario, String rutPersona,
            String c) {
        boolean resultado = false;
        if (comprobarRutExistente(rutPersona)) {
            
            String sql = "INSERT INTO CEM.USUARIO (CODIGO, NOMBRE, CONTRASENA, "
                    + "FECHA_REGISTRO, RUT_PERSONA, PERFIL) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            try {
                Conexion conexion = new Conexion();
                this.c = conexion.abrir();
                ps = this.c.prepareStatement(sql);
                
                Date fechaRegistro = new java.sql.Date(
                        objUsuario.getFechaRegistro().getTime());
            
                ps.setLong  (1, objUsuario.getCodigo());
                ps.setString(2, objUsuario.getNombre());
                ps.setString(3, c);
                ps.setDate  (4, fechaRegistro);
                ps.setString(5, rutPersona);
                ps.setString(6, objUsuario.getPerfil());
                
                ps.executeUpdate();
                ps.close();
                this.c.close();
                conexion.cerrar();
                resultado = true;
            }
            catch (SQLException se) {
                Logger.getLogger(DaoEntidades.class.getName())
                        .log(Level.SEVERE, null, se);
            }
        }
        return resultado;
    }
    
    public boolean modificarUsuario(Usuario objUsuario, String rutPersona,
            String c) {
        boolean resultado = false;
        if (comprobarRutExistente(rutPersona)) {
            String sql = "UPDATE CEM.USUARIO SET NOMBRE = ?, CONTRSENA = ?, "
                    + "PERFIL = ? WHERE RUT_PERSONA = ?";
            try {
                Conexion conexion = new Conexion();
                this.c = conexion.abrir();
                ps = this.c.prepareStatement(sql);
                ps.setString(1, objUsuario.getNombre());
                ps.setString(2, c);
                ps.setString(3, objUsuario.getPerfil());
                ps.executeUpdate();
                ps.close();
                this.c.close();
                conexion.cerrar();
                resultado = true;
            }
            catch (SQLException se) {
                Logger.getLogger(DaoEntidades.class.getName())
                        .log(Level.SEVERE, null, se);
            }
        }
        return resultado;
    }
    
    public boolean eliminarUsuario(String rutPersona) {
        boolean resultado = false;
        if (comprobarRutExistente(rutPersona)) {
            
            String sql = "DELETE FROM CEM.USUARIO WHERE RUT_PERSONA = ?";
            try {
                Conexion conexion = new Conexion();
                c = conexion.abrir();
                ps = c.prepareStatement(sql);
                ps.executeUpdate();
                ps.close();
                c.close();
                conexion.cerrar();
                resultado = true;
            }
            catch (SQLException se) {
                Logger.getLogger(DaoEntidades.class.getName())
                        .log(Level.SEVERE, null, se);
            }
        }
        return resultado;
    }
    
    public Usuario buscarUsuario(String nU, String c) {
        
        Usuario objUsuario = null;
        String sql = "SELECT CODIGO, FECHA_REGISTRO, RUT_PERSONA, PERFIL "
                + "FROM CEM.USUARIO WHERE NOMBRE = ? AND CONTRASENA = ?";
        try {
            Conexion conexion = new Conexion();
            this.c = conexion.abrir();
            ps = this.c.prepareStatement(sql);
            
            ps.setString(1, nU);
            ps.setString(2, c);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                objUsuario = new Usuario(
                        rs.getLong(1),
                        nU,
                        rs.getDate(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }
            
            rs.close();
            ps.close();
            this.c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return objUsuario;
    }
    
    public ArrayList<Usuario> listarUsuarios() {
        
        ArrayList<Usuario> listado = new ArrayList<>();
        String sql = "SELECT * FROM CEM.USUARIO";
        try {
            Conexion conexion = new Conexion();
            this.c = conexion.abrir();
            ps = this.c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(new Usuario(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
            rs.close();
            ps.close();
            this.c.close();
            conexion.cerrar();
        }
        catch (SQLException se) {
            Logger.getLogger(DaoEntidades.class.getName())
                    .log(Level.SEVERE, null, se);
        }
        return listado;
    }
    
    
//</editor-fold>
    
}
