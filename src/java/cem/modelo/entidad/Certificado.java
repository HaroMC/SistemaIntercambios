package cem.modelo.entidad;

import java.util.Date;

public class Certificado {
    
    private long codigo;
    private Date fechaSolicitud;
    
    //<editor-fold defaultstate="collapsed" desc=" Constrcutores ">
    
    public Certificado() {
    }
    
    public Certificado(long codigo, Date fechaSolicitud) {
        this.codigo = codigo;
        this.fechaSolicitud = fechaSolicitud;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
    
    public long getCodigo() {
        return codigo;
    }
    
    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }
    
    //</editor-fold>
    
}
