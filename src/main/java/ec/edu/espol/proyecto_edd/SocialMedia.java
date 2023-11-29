/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

/**
 *
 * @author nicolassierra
 */
public class SocialMedia {
    private String cuenta;
    private String plataforma;

    public SocialMedia(String cuenta, String plataforma) {
        this.cuenta = cuenta;
        this.plataforma = plataforma;
    }
    
    

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
    
}
