package cem.modelo.entidad;

public class CentroEstudiosLocal extends Persona {
    
    private byte estaAcreditada;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    
    public CentroEstudiosLocal() {
    }
    
    public CentroEstudiosLocal(int rutPersona, byte estaAcreditada) {
        this.estaAcreditada = estaAcreditada;
    }
    
    public CentroEstudiosLocal(byte estaAcreditada, String rutPersona,
            String nombreCompleto, String domicilio, String ciudad, String pais,
            String correo, String telefono, String tipo) {
        
        super (rutPersona, nombreCompleto, domicilio, ciudad, pais, correo,
                telefono, tipo);
        
        this.estaAcreditada = estaAcreditada;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
        
    public byte getEstaAcreditada() {
        return estaAcreditada;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    
    public void setEstaAcreditada(byte estaAcreditada) {
        this.estaAcreditada = estaAcreditada;
    }
    
    //</editor-fold>
    
}
