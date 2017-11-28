/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cem.modelo.entidad;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class FamiliaAnfitriona extends Persona {
    
    private short cantidadIntegrantes;
    private String estado;
    private ArrayList<Antecedente> antecedentes;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    
    public FamiliaAnfitriona() {
    }
    
    public FamiliaAnfitriona(short cantidadIntegrantes, String estado) {
        
        this.cantidadIntegrantes = cantidadIntegrantes;
        this.estado = estado;
        this.antecedentes = new ArrayList<>();
    }
    
    public FamiliaAnfitriona(short cantidadIntegrantes, String estado,
            String rutPersona, String nombreCompleto, Date fechaNacimiento,
            String domicilio, String ciudad, String pais, String correo,
            String telefono, String tipo) {
        
        super (rutPersona, nombreCompleto, fechaNacimiento, domicilio, ciudad,
                pais, correo, telefono, tipo);
        
        this.cantidadIntegrantes = cantidadIntegrantes;
        this.estado = estado;
        this.antecedentes = new ArrayList<>();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
    
    public short getCantidadIntegrantes() {
        return cantidadIntegrantes;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public ArrayList<Antecedente> getAntecedentes() {
        return antecedentes;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    
    public void setCantidadIntegrantes(short cantidadIntegrantes) {
        this.cantidadIntegrantes = cantidadIntegrantes;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setAntecedentes(ArrayList<Antecedente> antecedentes) {
        this.antecedentes = antecedentes;
    }
    
    //</editor-fold>
    
    @Override
    public String toString() {
        return
                super.toString() +
                "Cantidad de integrantes : " + cantidadIntegrantes + "\n" +
                "Estado de inscripción   : " + estado + "\n";
    }
    
}
