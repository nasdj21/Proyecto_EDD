/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import TDA.LinkedListCircular;
import TDA.MyArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import TDA.LinkedListCircular;

/**
 *
 * @author nicolassierra
 */
public class Contacto implements Serializable{
    private String nombres;
    private String apellidos;
    private LinkedListCircular<Numero> numero;
    private MyArrayList<Correo> correos;
    private LinkedListCircular<Foto> fotos;
    private MyArrayList<Direccion> direcciones;
    private MyArrayList<Recordatorio> recordatorios;
    private ContactoAsociado contactoAsociado;
    private LinkedListCircular<SocialMedia>redes;
    private boolean favorito;
    private String etiqueta;

    public Contacto(String nombres, String apellidos, LinkedListCircular<Numero> numero, MyArrayList<Correo> correos, LinkedListCircular<Foto> fotos, MyArrayList<Direccion> direcciones, MyArrayList<Recordatorio> recordatorios, ContactoAsociado contactoAsociado, LinkedListCircular<SocialMedia> redes, String etiqueta) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numero = numero;
        this.correos = correos;
        this.fotos = fotos;
        this.direcciones = direcciones;
        this.recordatorios = recordatorios;
        this.contactoAsociado = contactoAsociado;
        this.redes = redes;
        this.favorito = false;
        this.etiqueta = null;
    }
    
    

    public Contacto(String nombres, String apellidos, LinkedListCircular<Numero> numero, MyArrayList<Correo> correos, LinkedListCircular<Foto> fotos, MyArrayList<Direccion> direcciones, MyArrayList<Recordatorio> recordatorios, ContactoAsociado contactoAsociado, LinkedListCircular<SocialMedia> redes) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numero = numero;
        this.correos = correos;
        this.fotos = fotos;
        this.direcciones = direcciones;
        this.recordatorios = recordatorios;
        this.contactoAsociado = contactoAsociado;
        this.redes = redes;
        this.favorito = false;
        this.etiqueta = null;
    }
    
    
    

    public Contacto(String nombres, String apellidos, String numero, MyArrayList<Correo> correos, LinkedListCircular<Foto> fotos, MyArrayList<Direccion> direcciones, MyArrayList<Recordatorio> recordatorios, ContactoAsociado contactoAsociado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correos = correos;
        this.fotos = fotos;
        this.direcciones = direcciones;
        this.recordatorios = recordatorios;
        this.contactoAsociado = contactoAsociado;
        this.numero = new LinkedListCircular<>();
        this.numero.add(new Numero(numero));
        this.redes = new LinkedListCircular<>();
        this.favorito = false;
        this.etiqueta = null;
    }


    
    
    public Contacto(String nombres, String apellidos, String numero) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numero = new LinkedListCircular<>();
        this.numero.add(new Numero(numero));
        this.correos = new MyArrayList<>();
        this.fotos = new LinkedListCircular<>();
        this.direcciones = new MyArrayList<>();
        this.recordatorios = new MyArrayList<>();
        this.redes = new LinkedListCircular<>();
        this.favorito = false;
        this.etiqueta = null;
    }
    
    public Contacto(String nombres, String numero) {
        this.nombres = nombres;
        this.numero = new LinkedListCircular<>();
        this.numero.add(new Numero(numero));
        this.correos = new MyArrayList<>();
        this.fotos = new LinkedListCircular<>();
        this.direcciones = new MyArrayList<>();
        this.recordatorios = new MyArrayList<>();
        this.redes = new LinkedListCircular<>();
        this.favorito = false;
        this.etiqueta = null;
    }

    
    

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LinkedListCircular<Numero> getNumero() {
        return numero;
    }

    public void setNumero(LinkedListCircular<Numero> numero) {
        this.numero = numero;
    }

    

    public MyArrayList<Correo> getCorreos() {
        return correos;
    }

    public void setCorreos(MyArrayList<Correo> correos) {
        this.correos = correos;
    }

    public LinkedListCircular<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(LinkedListCircular<Foto> fotos) {
        this.fotos = fotos;
    }

    public MyArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(MyArrayList<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public MyArrayList<Recordatorio> getRecordatorios() {
        return recordatorios;
    }

    public void setRecordatorios(MyArrayList<Recordatorio> recordatorios) {
        this.recordatorios = recordatorios;
    }

    public ContactoAsociado getContactoAsociado() {
        return contactoAsociado;
    }

    public void setContactoAsociado(ContactoAsociado contactoAsociado) {
        this.contactoAsociado = contactoAsociado;
    }

    public LinkedListCircular<SocialMedia> getRedes() {
        return redes;
    }

    public void setRedes(LinkedListCircular<SocialMedia> redes) {
        this.redes = redes;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    
    
    
    
    

    public static MyArrayList<Contacto> readListFromFileSer() {
        MyArrayList<Contacto> contactos = new MyArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("contactos.ser"))) {
            contactos = (MyArrayList<Contacto>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo de contacto: " + e.getMessage());
        }
        return contactos;
    }
   
    public void saveSer(){
        MyArrayList<Contacto>contactos = Contacto.readListFromFileSer();
        contactos.add(this);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contactos.ser"))){
            out.writeObject(contactos);
        }
        catch(IOException e){
            System.out.println("Error al guardar el archivo de contacto: " + e.getMessage());
            
        }   
    }
    
    public static void saveSer(MyArrayList<Contacto>contactos){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contactos.ser"))){
            out.writeObject(contactos);
        }
        catch(IOException e){
            System.out.println("Error al guardar el archivo de contacto: " + e.getMessage());
            
        }   
    }
    
    public static void actualizarContacto(Contacto contactoModificado) {
    MyArrayList<Contacto> contactos = Contacto.readListFromFileSer();

    // Buscar el contacto en la lista
    for (int i = 0; i < contactos.size(); i++) {
        if (contactos.get(i).getNombres().equals(contactoModificado.getNombres()) && contactos.get(i).getApellidos().equals(contactoModificado.getApellidos())) { 
            // Realizar las modificaciones necesarias
            contactos.get(i).setFavorito(contactoModificado.isFavorito()); 

            break;
        }
    }
    
    Contacto.saveSer(contactos);
    }
   
}
