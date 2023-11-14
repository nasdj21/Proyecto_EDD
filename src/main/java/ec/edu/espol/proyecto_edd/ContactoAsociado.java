/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import java.io.Serializable;

/**
 *
 * @author nicolassierra
 */
public class ContactoAsociado implements Serializable {
    private String nombre;
    private String relacion;

    public ContactoAsociado(String nombre, String relacion) {
        this.nombre = nombre;
        this.relacion = relacion;
    }
    
        public ContactoAsociado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }
    
    
}
