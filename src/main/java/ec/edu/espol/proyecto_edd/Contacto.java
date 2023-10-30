/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author nicolassierra
 */
public class Contacto {
    private String nombres;
    private String apellidos;
    private int numero;
    private LinkedList<Correo> correos;
    private String foto;
    private LinkedList<Direccion> direcciones;

    public Contacto(String nombres, String apellidos, int numero, LinkedList<Correo> correos, String foto, LinkedList<Direccion> direcciones) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numero = numero;
        this.correos = correos;
        this.foto = foto;
        this.direcciones = direcciones;
    }

    public LinkedList<Correo> getCorreos() {
        return correos;
    }

    public LinkedList<Direccion> getDirecciones() {
        return direcciones;
    }

    
    
    
   

    
    
    
    
}
