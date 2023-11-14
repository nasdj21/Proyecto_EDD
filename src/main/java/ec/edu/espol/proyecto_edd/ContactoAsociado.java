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
<<<<<<< HEAD
public class ContactoAsociado implements Serializable {
=======
public class ContactoAsociado implements Serializable{
>>>>>>> 0004191fb95caa2efb0186dc180998aa0e1bbea4
    private String nombre;
    private String relacion;

    public ContactoAsociado(String nombre, String relacion) {
        this.nombre = nombre;
        this.relacion = relacion;
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
