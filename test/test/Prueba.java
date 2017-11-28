package test;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.conexion.Conexion;
import cem.modelo.entidad.*;
import cem.modelo.entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prueba {
    
    public static void main(String[] args) throws SQLException {
        
        DaoEntidades dao = new DaoEntidades();
        Usuario objUsuario;
        
        if (eliminarPersona_2("18349276-1")) {
            System.out.println("Eliminada");
        }
        else {
            System.out.println("No eliminada");
        }
        
    }
    
    public static boolean eliminarPersona(String rut) {
        boolean resultado = false;
        String sql = "DELETE FROM CEM.PERSONA WHERE RUT = ?";
        try {
            Conexion conexion = new Conexion();
            Connection c = conexion.abrir();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, rut);
            
            ps.executeUpdate();
            c.commit();
            
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
    
    public static boolean eliminarPersona_2(String codigo) throws SQLException {
        PreparedStatement stmt = null;
        boolean resultado = false;
        String consulta = "DELETE FROM CEM.PERSONA WHERE RUT = ?";
        try {
            Conexion c = new Conexion();
            Connection con = c.abrir();
            stmt = con.prepareStatement(consulta);
            stmt.setString(1, codigo);

            stmt.executeUpdate();
            resultado = true;
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return resultado;
    }
    
}
