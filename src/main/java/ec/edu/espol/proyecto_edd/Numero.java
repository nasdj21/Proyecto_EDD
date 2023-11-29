/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

/**
 *
 * @author nicolassierra
 */
public class Numero {
    private String numero;
    private String label;

    public Numero(String numero, String label) {
        this.numero = numero;
        this.label = label;
    }

    public Numero(String numero) {
        this.numero = numero;
        this.label = "Otro";
    }
    
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    
}
