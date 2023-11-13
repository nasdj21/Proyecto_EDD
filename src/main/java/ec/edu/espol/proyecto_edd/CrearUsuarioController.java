/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class CrearUsuarioController implements Initializable {

    @FXML
    private TextField nametext;
    @FXML
    private TextField emailtext;
    @FXML
    private TextField lastnametext;
    @FXML
    private TextField numbertext;
    @FXML
    private TextField directiontext;
    @FXML
    private TextField datetext1;
    @FXML
    private TextField relatedcontactstext2;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField relationshiptext;
    @FXML
    private TextField dateTypetext11;

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto_edd/seleccionarTipoContacto.fxml"));
            Parent root = loader.load();
            SeleccionarTipoContactoController controlador = loader.getController();

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
    private void createContact(MouseEvent event) {
        //1
        if(nametext.getText().isBlank() || numbertext.getText().isBlank())
        {
            Alert a  = new Alert(Alert.AlertType.ERROR, "You should enter a name and a number");
            a.show();
        }else
        {
            //recorrer lista y validar que correo no sea igual
            //falta crear lista de contactos
            
            
            ArrayList<Contacto> contactos = Contacto.readListFromFileSer();
            
            for(Contacto userInList: contactos)
            {
                if(userInList.getNumero().equals(numbertext.getText()))
                {
                    Alert a  = new Alert(Alert.AlertType.ERROR, "This number already exits");
                     a.show();                    
                    
                    //como salir del bucle for sin usar el break;
                    break;
                }
            }
        }
            
        //4
        }

    @FXML
    private void agregarImagen(MouseEvent event) {
    }

    @FXML
    private void chooseFile(MouseEvent event) {
    }
    
}
