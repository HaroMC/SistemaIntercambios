package cem.modelo.entidad;

import java.util.Date;

public class Calificacion {
    
    private long codigo;
    private Date fechaCalificacion;
    private double nota;
    private Asignatura asignatura;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    
    public Calificacion() {
    }
    
    public Calificacion(long codigo, Date fechaCalificacion, double nota) {
        this.codigo = codigo;
        this.fechaCalificacion = fechaCalificacion;
        this.nota = nota;
        this.asignatura = null;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
    
    public long getCodigo() {
        return codigo;
    }
    
    public Date getFechaCalificacion() {
        return fechaCalificacion;
    }
    
    public double getNota() {
        return nota;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }
        
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    
    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    
    //</editor-fold>
    
}
