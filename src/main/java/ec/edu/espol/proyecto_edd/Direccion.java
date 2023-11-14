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
public class Direccion implements Serializable {
=======
public class Direccion implements Serializable{
>>>>>>> 0004191fb95caa2efb0186dc180998aa0e1bbea4
    private String label;
    private String direccion;

    public Direccion(String label, String direccion) {
        this.label = label;
        this.direccion = direccion;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
