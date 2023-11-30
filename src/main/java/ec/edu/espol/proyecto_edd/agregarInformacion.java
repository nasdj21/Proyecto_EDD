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
public abstract class agregarInformacion implements Serializable{
    private Contacto contacto;

    
    public static void addCorreoToLinkedListCircular(Contacto contacto, Correo correo) {
        contacto.getCorreos().add(correo);
    }

    public static void addDireccionToLinkedListCircular(Contacto contacto, Direccion direccion) {
        contacto.getDirecciones().add(direccion);
    }
    

   
   
    
}
