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
public class ContactoEmpresa extends Contacto{
    
    public ContactoEmpresa(String nombres, String apellidos, String numero, ArrayList<Correo> correos, LinkedList<Foto> fotos, ArrayList<Direccion> direcciones, ArrayList<Recordatorio> recordatorios, ContactoAsociado contactoAsociado) {
        super(nombres, apellidos, numero, correos, fotos, direcciones, recordatorios, contactoAsociado);
    }
    
    
    
    
    
}
