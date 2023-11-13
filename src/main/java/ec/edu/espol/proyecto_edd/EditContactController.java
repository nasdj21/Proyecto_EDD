/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class EditContactController implements Initializable {

    @FXML
    private TextField nametext;
    @FXML
    private TextField lastnametext;
    @FXML
    private TextField numbertext;
    @FXML
    private TextField emailtext;
    @FXML
    private TextField directiontext;
    @FXML
    private TextField datetext1;
    @FXML
    private ImageView imageId;
    @FXML
    private ComboBox<?> relatedcontacts;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void back(MouseEvent event) {
        try {
            
            Button b = (Button)event.getSource();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto_edd/verContacto.fxml"));
            Parent root = loader.load();
            VerContactoController controlador = loader.getController();

            // Pasa el usuario al controlador de cambio de clave            

            Scene scene = new Scene(root);
            Stage stage = (Stage) b.getScene().getWindow(); 
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }


    @FXML
    private void agregarImagen(MouseEvent event) {
    }

    @FXML
    private void SaveContact(MouseEvent event) {
    }

    @FXML
    private void addPhoto(MouseEvent event) {
    }
    
}
