/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author nicolassierra
 */
public class Contacto implements Serializable{
    private String nombres;
    private String apellidos;
    private LinkedList<Numero> numero;
    private ArrayList<Correo> correos;
    private LinkedList<Foto> fotos;
    private ArrayList<Direccion> direcciones;
    private ArrayList<Recordatorio> recordatorios;
    private ContactoAsociado contactoAsociado;
    private LinkedList<SocialMedia>redes;
    private boolean favorito;

    public Contacto(String nombres, String apellidos, LinkedList<Numero> numero, ArrayList<Correo> correos, LinkedList<Foto> fotos, ArrayList<Direccion> direcciones, ArrayList<Recordatorio> recordatorios, ContactoAsociado contactoAsociado, LinkedList<SocialMedia> redes) {
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
    }
    
    
    

    public Contacto(String nombres, String apellidos, String numero, ArrayList<Correo> correos, LinkedList<Foto> fotos, ArrayList<Direccion> direcciones, ArrayList<Recordatorio> recordatorios, ContactoAsociado contactoAsociado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correos = correos;
        this.fotos = fotos;
        this.direcciones = direcciones;
        this.recordatorios = recordatorios;
        this.contactoAsociado = contactoAsociado;
        this.numero = new LinkedList<>();
        this.numero.add(new Numero(numero));
        this.redes = new LinkedList<>();
        this.favorito = false;
    }


    
    
    public Contacto(String nombres, String apellidos, String numero) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numero = new LinkedList<>();
        this.numero.add(new Numero(numero));
        this.correos = new ArrayList<>();
        this.fotos = new LinkedList<>();
        this.direcciones = new ArrayList<>();
        this.recordatorios = new ArrayList<>();
        this.redes = new LinkedList<>();
        this.favorito = false;
    }
    
    public Contacto(String nombres, String numero) {
        this.nombres = nombres;
        this.numero = new LinkedList<>();
        this.numero.add(new Numero(numero));
        this.correos = new ArrayList<>();
        this.fotos = new LinkedList<>();
        this.direcciones = new ArrayList<>();
        this.recordatorios = new ArrayList<>();
        this.redes = new LinkedList<>();
        this.favorito = false;
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

    public LinkedList<Numero> getNumero() {
        return numero;
    }

    public void setNumero(LinkedList<Numero> numero) {
        this.numero = numero;
    }

    

    public ArrayList<Correo> getCorreos() {
        return correos;
    }

    public void setCorreos(ArrayList<Correo> correos) {
        this.correos = correos;
    }

    public LinkedList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(LinkedList<Foto> fotos) {
        this.fotos = fotos;
    }

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ArrayList<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public ArrayList<Recordatorio> getRecordatorios() {
        return recordatorios;
    }

    public void setRecordatorios(ArrayList<Recordatorio> recordatorios) {
        this.recordatorios = recordatorios;
    }

    public ContactoAsociado getContactoAsociado() {
        return contactoAsociado;
    }

    public void setContactoAsociado(ContactoAsociado contactoAsociado) {
        this.contactoAsociado = contactoAsociado;
    }

    public LinkedList<SocialMedia> getRedes() {
        return redes;
    }

    public void setRedes(LinkedList<SocialMedia> redes) {
        this.redes = redes;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
    
    
    
    

    public static ArrayList<Contacto> readListFromFileSer() {
        ArrayList<Contacto> contactos = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("contactos.ser"))) {
            contactos = (ArrayList<Contacto>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo de contacto: " + e.getMessage());
        }
        return contactos;
    }
   
    public void saveSer(){
        ArrayList<Contacto>contactos = Contacto.readListFromFileSer();
        contactos.add(this);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contactos.ser"))){
            out.writeObject(contactos);
        }
        catch(IOException e){
            System.out.println("Error al guardar el archivo de contacto: " + e.getMessage());
            
        }
        
        
    }

    
    
    
    
   

    
    
    
    
}
