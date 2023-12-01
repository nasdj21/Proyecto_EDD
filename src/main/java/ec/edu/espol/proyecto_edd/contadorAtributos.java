/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

/**
 *
 * @author nicolassierra
 */
public interface contadorAtributos {
    
    default int contadorAtributos(Contacto contacto){
        int totalAtributos = 2; // Considera nombres y apellidos como dos atributos

        totalAtributos += contacto.getNumero().size(); // Añade la cantidad de números en la lista
        totalAtributos += contacto.getCorreos().size(); // Añade la cantidad de correos en la lista
        totalAtributos += contacto.getFotos().size(); // Añade la cantidad de fotos en la lista
        totalAtributos += contacto.getDirecciones().size(); // Añade la cantidad de direcciones en la lista
        totalAtributos += contacto.getRecordatorios().size(); // Añade la cantidad de recordatorios en la lista
        totalAtributos += contacto.getRedes().size(); // Añade la cantidad de redes en la lista

        // Si hay un contacto asociado, suma sus atributos
        if (contacto.getContactoAsociado() != null) {
            totalAtributos++;
        }
        return totalAtributos;
    }
}
