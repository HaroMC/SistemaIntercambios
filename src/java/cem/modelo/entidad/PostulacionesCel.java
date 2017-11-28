package cem.modelo.entidad;

import java.util.ArrayList;
import java.util.Date;

public class PostulacionesCel {
    
    private long codigo;
    private Date fechaInscripcion;
    private String estado;
    private Programa programa;
    private ArrayList<CentroEstudiosLocal> cels;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    
    public PostulacionesCel() {
    }
    
    public PostulacionesCel(long codigo, Date fechaInscripcion, String estado) {
        this.codigo = codigo;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.programa = null;
        this.cels = new ArrayList<>();
    }
    
    public PostulacionesCel(long codigo, Date fechaInscripcion, String estado,
            Programa programa) {
        this.codigo = codigo;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.programa = programa;
        this.cels = new ArrayList<>();
    }

    public PostulacionesCel(long codigo, Date fechaInscripcion, String estado,
            Programa programa, ArrayList<CentroEstudiosLocal> cels) {
        
        this.codigo = codigo;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.programa = programa;
        this.cels = cels;
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
    
    public ArrayList<CentroEstudiosLocal> getCels() {
        return cels;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setCels(ArrayList<CentroEstudiosLocal> cels) {
        this.cels = cels;
    }
    
    //</editor-fold>
    
}
