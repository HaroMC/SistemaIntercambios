package cem.modelo.entidad;

import java.util.Date;

public abstract class Persona {

    private String rut;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private String domicilio;
    private String ciudad;
    private String pais;
    private String correo;
    private String telefono;
    private String tipo;
    private Usuario usuario;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    
    public Persona() {
    }
        
    public Persona(String rut, String nombreCompleto, String domicilio,
            String ciudad, String pais, String correo, String telefono,
            String tipo) {
        
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.pais = pais;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
        this.usuario = null;
    }
    
    public Persona(String rut, String nombreCompleto, Date fechaNacimiento,
            String domicilio, String ciudad, String pais, String correo,
            String telefono, String tipo) {
        
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.pais = pais;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
        this.usuario = null;
    }
    
    public Persona(String rut, String nombreCompleto, Date fechaNacimiento,
            String domicilio, String ciudad, String pais, String correo,
            String telefono, String tipo, Usuario usuario) {
        
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.pais = pais;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
        this.usuario = usuario;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
    
    public String getRut() {
        return rut;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public String getDomicilio() {
        return domicilio;
    }
    
    public String getCiudad() {
        return ciudad;
    }
    
    public String getPais() {
        return pais;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getTipo() {
        return tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }
        
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    //</editor-fold>
    
    @Override
    public String toString() {
        return
                "Rut                 : " + rut + "\n" +
                "Nombre completo     : " + nombreCompleto + "\n" +
                "Fecha de nacimiento : " + fechaNacimiento + "\n" +
                "Domicilio           : " + domicilio + "\n"+
                "Ciudad              : " + ciudad + "\n"+
                "País                : " + pais + "\n"+
                "E-mail              : " + correo + "\n"+
                "Teléfono            : " + telefono + "\n" +
                "Tipo                : " + tipo + "\n" +
                "Nombre usuario      : " + usuario.getNombre() + "\n";
    }
    
}
