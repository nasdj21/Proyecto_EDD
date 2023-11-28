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

/**
 *
 * @author JOSUE
 */
public class Usuario implements Serializable {
    private String name;
    private String password;
    private String fileName;
    private ArrayList<Contacto> contactos = new ArrayList<>();

    public Usuario(String name, String password, String fileName)  {
        this.name = name;
        this.password = password;
        this.fileName = fileName;
    }
    
    //crear el archivo con los contactos:
    //usar el nombreDeUsuario como nombre del archivo.ser

    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
    
    
    public static ArrayList<Usuario> readListFromFileSer() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuarios.ser"))) {
            usuarios = (ArrayList<Usuario>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo de usuario: " + e.getMessage());
        }
        return usuarios;
    }
   
    public void saveSer(){
        ArrayList<Usuario> usuarios = Usuario.readListFromFileSer();
        usuarios.add(this);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.ser"))){
            out.writeObject(usuarios);
        }
        catch(IOException e){
            System.out.println("Error al guardar el archivo de usuario: " + e.getMessage());
            
        }
        
        
    }
    
    
    
    
}
