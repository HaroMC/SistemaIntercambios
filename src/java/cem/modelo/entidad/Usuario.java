package cem.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

    private long codigo;
    private String nombre;
    private String contrasena;
    private Date fechaRegistro;
    private String rut;
    private String perfil;

    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    public Usuario() {
    }

    public Usuario(long codigo, String nombre, String contrasena) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.contrasena = "";
    }
    
    public Usuario(long codigo, String nombre, Date fechaRegistro, String rut,
            String perfil) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.contrasena = "";
        this.fechaRegistro = fechaRegistro;
        this.rut = rut;
        this.perfil = perfil;
    }

    public Usuario(long codigo, String nombre, String contrasena,
            Date fechaRegistro, String rut, String perfil) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
        this.rut = rut;
        this.perfil = perfil;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
    public long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public String getRut() {
        return rut;
    }
    
    public String getPerfil() {
        return perfil;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    //</editor-fold>
    
}
