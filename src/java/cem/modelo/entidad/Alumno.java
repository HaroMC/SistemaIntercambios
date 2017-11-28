package cem.modelo.entidad;

import java.util.ArrayList;
import java.util.Date;

public class Alumno extends Persona {
    
    private long numeroMatricula;
    private Date fechaMatricula;
    private byte esMoroso;
    
    private ArrayList<Certificado> certificados;
    private ArrayList<Calificacion> calificaciones;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    
    public Alumno() {
    }
    
    public Alumno(long numeroMatricula, Date fechaMatricula, byte esMoroso,
            String rutPersona, String nombreCompleto, Date fechaNacimiento,
            String domicilio, String ciudad, String pais, String correo,
            String telefono, String tipo) {
        
        super (rutPersona, nombreCompleto, fechaNacimiento, domicilio, ciudad,
                pais, correo, telefono, tipo);
        
        this.numeroMatricula = numeroMatricula;
        this.fechaMatricula = fechaMatricula;
        this.esMoroso = esMoroso;
        this.certificados = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }
    
    public Alumno(long numeroMatricula, Date fechaMatricula, byte esMoroso,
            String rutPersona, String nombreCompleto, Date fechaNacimiento,
            String domicilio, String ciudad, String pais, String correo,
            String telefono, String tipo, Usuario usuario) {
        
        super (rutPersona, nombreCompleto, fechaNacimiento, domicilio, ciudad,
                pais, correo, telefono, tipo, usuario);
        
        this.numeroMatricula = numeroMatricula;
        this.fechaMatricula = fechaMatricula;
        this.esMoroso = esMoroso;
        this.certificados = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
    
    public long getNumeroMatricula() {
        return numeroMatricula;
    }
    
    public Date getFechaMatricula() {
        return fechaMatricula;
    }
    
    public byte getEsMoroso() {
        return esMoroso;
    }
    
    public ArrayList<Certificado> getCertificados() {
        return certificados;
    }

    public ArrayList<Calificacion> getCalificaciones() {
        return calificaciones;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    
    public void setCertificados(ArrayList<Certificado> certificados) {
        this.certificados = certificados;
    }

    public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }
    
    
    //</editor-fold>
    
    @Override
    public String toString() {
        return
                super.toString() +
                "Número matrícula : " + numeroMatricula + "\n" +
                "Fecha Matrícula  : " + fechaMatricula + "\n";
    }
    
}
