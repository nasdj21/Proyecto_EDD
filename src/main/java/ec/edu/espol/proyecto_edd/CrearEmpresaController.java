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
import javafx.scene.image.ImageView;
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
    private TextField emailtext;
    @FXML
    private TextField numbertext;
    @FXML
    private TextField directiontext;
    @FXML
    private TextField datetext1;
    @FXML
    private TextField relatedContactstext2;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField dateTypetext11;
    @FXML
    private TextField relationshiptext;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createContact(MouseEvent event) {
    }

    @FXML
    private void back(MouseEvent event) {
    }

    @FXML
    private void chooseFile(MouseEvent event) {
    }
    
}
