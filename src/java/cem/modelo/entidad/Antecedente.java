package cem.modelo.entidad;

import java.util.Date;

public class Antecedente {
    
    private long codigo;
    private String descripcion;
    private Date fechaCaducidad;
    private String documento;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    
    public Antecedente() {
    }
    
    public Antecedente(long codigo, Date fechaCaducidad, String documento) {
        this.codigo = codigo;
        this.descripcion = null;
        this.fechaCaducidad = fechaCaducidad;
        this.documento = documento;
    }
    
    public Antecedente(long codigo, String descripcion, Date fechaCaducidad,
            String documento) {
        
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaCaducidad = fechaCaducidad;
        this.documento = documento;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
    
    public long getCodigo() {
        return codigo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }
    
    public String getDocumento() {
        return documento;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    //</editor-fold>
    
}
