package cem.modelo.entidad;

public class Asignatura {
    
    private long codigo;
    private String nombreAsignatura;
    private String descripcion;
    private long cupos;
    private Docente docente;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    
    public Asignatura() {
    }
    
    public Asignatura(long codigo, String nombreAsignatura, String descripcion,
            long cupos) {
        
        this.codigo = codigo;
        this.nombreAsignatura = nombreAsignatura;
        this.descripcion = descripcion;
        this.cupos = cupos;
        this.docente = null;
    }
    
    public Asignatura(long codigo, String nombreAsignatura, String descripcion,
            long cupos, Docente docente) {
        
        this.codigo = codigo;
        this.nombreAsignatura = nombreAsignatura;
        this.descripcion = descripcion;
        this.cupos = cupos;
        this.docente = docente;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
    
    public long getCodigo() {
        return codigo;
    }
    
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public long getCupos() {
        return cupos;
    }
    
    public Docente getDocente() {
        return docente;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setCupos(long cupos) {
        this.cupos = cupos;
    }
    
    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
    //</editor-fold>
    
    @Override
    public String toString() {
        return
                "Código                  : " + getCodigo()+ "\n" +
                "Nombre de la asignatura : " + getNombreAsignatura()+ "\n" +
                "Descripción             : " + getDescripcion()+ "\n" +
                "Cupos disponibles       : " + getCupos()+ "\n";
    }
    
}
