/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import TDA.MyArrayList;
import TDA.LinkedListCircular;

/**
 *
 * @author nicolassierra
 */
public class ContactoEmpresa extends Contacto{
    
    public ContactoEmpresa(String nombres, String numero, MyArrayList<Correo> correos, LinkedListCircular<Foto> fotos, MyArrayList<Direccion> direcciones, MyArrayList<Recordatorio> recordatorios, ContactoAsociado contactoAsociado) {
        super(nombres, null, numero, correos, fotos, direcciones, recordatorios, contactoAsociado);
    }
    public ContactoEmpresa(String nombres, String apellidos, String numero, MyArrayList<Correo> correos, LinkedListCircular<Foto> fotos, MyArrayList<Direccion> direcciones, MyArrayList<Recordatorio> recordatorios, ContactoAsociado contactoAsociado) {
        super(nombres, apellidos, numero, correos, fotos, direcciones, recordatorios, contactoAsociado);
    }
    
    
    
    
    
}
