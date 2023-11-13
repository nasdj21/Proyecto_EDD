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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class PrimaryController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private Button signUp;
    @FXML
    private ImageView imagenUsuario;
    @FXML
    private ImageView imagenLocker;
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(MouseEvent event) {
        try {
                FXMLLoader loader = App.loadFXML("Perfil");
                Scene sc = new Scene(loader.load(),1214,590);
                SecondaryController controlador = loader.getController();
//                controlador.setUsuario(usuario);
                App.setScene(sc);

                controlador.setNameperfil(usuario.getNombre());
                controlador.setLastnameperfil(usuario.getApellidos());
                controlador.setOrganizationperfil(usuario.getOrganizacion());
                controlador.setUsernameperfil(usuario.getNombreUsuario());
                controlador.setEmailperfil(usuario.getEmail());
                controlador.setIndiceUsuario(indiceUsuario);
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR,"Archivo no encontrado");
                a.show();
            }
        
    }

    @FXML
    private void SignUp(MouseEvent event) {
    }
    
}
