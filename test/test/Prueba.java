package test;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.*;
import cem.modelo.entidad.Usuario;
import java.util.ArrayList;

public class Prueba {
    
    public static void main(String[] args) {
        
        DaoEntidades dao = new DaoEntidades();
        Usuario objUsuario;
        
        /*ArrayList<Alumno> alumnos = dao.listarAlumnos();
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
        }*/
        
        ArrayList<Programa> listaProgramasParaCel = dao.listarProgramasParaPostularCel();
        
        for (Programa programa : listaProgramasParaCel) {
            System.out.println("Nombre: " + programa.getNombre() + "\nEstado: " + programa.getEstado());
        }
    }
}
