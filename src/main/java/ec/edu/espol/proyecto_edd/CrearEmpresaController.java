/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class CrearEmpresaController implements Initializable {

    @FXML
    private TextField nametext;
    @FXML
    private TextField usernametext;
    @FXML
    private TextField emailtext;
    @FXML
    private TextField organizaciontext;
    @FXML
    private TextField organizaciontext1;
    @FXML
    private TextField organizaciontext2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registrarusuario(MouseEvent event) {
    }

    @FXML
    private void loginvolver(MouseEvent event) {
    }
    
}
