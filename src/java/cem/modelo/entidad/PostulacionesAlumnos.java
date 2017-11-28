/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cem.modelo.entidad;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class PostulacionesAlumnos {
    
    private long codigo;
    private Date fechaInscripcion;
    private String estado;
    private Programa programa;
    private ArrayList<Alumno> alumnos;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    
    public PostulacionesAlumnos() {
    }
    
    public PostulacionesAlumnos(long codigo, Date fechaInscripcion,
            String estado) {
        
        this.codigo = codigo;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.programa = null;
        this.alumnos = new ArrayList<>();
    }
    
    public PostulacionesAlumnos(long codigo, Date fechaInscripcion,
            String estado, Programa programa) {
        
        this.codigo = codigo;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.programa = programa;
        this.alumnos = new ArrayList<>();
    }

    public PostulacionesAlumnos(long codigo, Date fechaInscripcion,
            String estado, Programa programa, ArrayList<Alumno> alumnos) {
        
        this.codigo = codigo;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.programa = programa;
        this.alumnos = alumnos;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
    
    public long getCodigo() {
        return codigo;
    }
    
    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public Programa getPrograma() {
        return programa;
    }
    
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    //</editor-fold>
    
}
