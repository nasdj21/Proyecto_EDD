/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import TDA.MyArrayList;
import java.util.Comparator;

/**
 *
 * @author nicolassierra
 */
public interface contactFinder {
    
    default Contacto encontrarContactoPorNombre(String nombre, MyArrayList<Contacto>listaDeContactos) {
    Comparator<Contacto> cmp1 = (Contacto contacto1, Contacto contacto2) -> {
                if (contacto1.equals(contacto2)){
                    return 0; 
                } else
                    return 1;
                
            };
    
    Comparator<String> cmp2 = (String s1, String s2) ->{
                if (s1.equals(s2)){
                    return 0;
                } else
                    return 1;
                
            };
    
    // Recorre la lista de contactos para encontrar el objeto de contacto por su nombre

    for (int i = 0; i < listaDeContactos.size(); i++) {
        Contacto contacto = listaDeContactos.get(i);
        if (cmp2.compare(contacto.getNombres(),nombre) == 0) {
            return contacto;
        }
    }
        return null;
    }
}
