package cem.modelo.entidad;

import java.util.Date;

public class Docente extends Persona {
    
    private String estado;
    private String observaciones;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    
    public Docente() {
    }
    
    public Docente(String estado, String observaciones) {
        this.estado = estado;
        this.observaciones = observaciones;
    }
    
    public Docente(String estado, String observaciones, String rutPersona,
            String nombreCompleto, Date fechaNacimiento, String domicilio,
            String ciudad, String pais, String correo, String telefono,
            String tipo) {
        
        super (rutPersona, nombreCompleto, fechaNacimiento, domicilio, ciudad,
                pais, correo, telefono, tipo);
        
        this.estado = estado;
        this.observaciones = observaciones;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
    
    public String getEstado() {
        return estado;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    //</editor-fold>
    
    @Override
    public String toString() {
        return
                super.toString() +
                "Estado              : " + estado + "\n" +
                "Observaciones       : " + observaciones + "\n";
    }
    
}
