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

    
    private ArrayList<Usuario> usuarios;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //archivo con todos los usuarios
        //obteniendo las lista con todos los usuarios
       ArrayList<Usuario> usuarios = Usuario.readListFromFileSer();
        
        
        // TODO
    }    
   
    @FXML
    public Usuario Login(MouseEvent event) {
        

        Usuario usuarioRetornar = null;
        try {
            String usuarioTexto = user.getText();
            String clave = password.getText();

            for (Usuario usuario : usuarios) {
                if (usuario.getName().equals(usuarioTexto) && usuario.getPassword().equals(clave)) {
//                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Usuario correcto");
//                    a.show();
                    usuarioRetornar = usuario;
                    
                    int i =usuarios.indexOf(usuario);
                    try{
                        Button b = (Button)event.getSource();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto_edd/secondary.fxml"));
                        Parent root = loader.load();
                        SecondaryController controlador = loader.getController();

                        // Pasa el usuario al controlador de cambio de clave            

                        Scene scene = new Scene(root);
                        Stage stage = (Stage) b.getScene().getWindow(); 
                        stage.setScene(scene);
                        stage.show();
                        
                        
                        
                        //ya no es necesaria porque el usuario que se seleccione va a ser un singleton


                    }catch(IOException e){
                        Alert x = new Alert(Alert.AlertType.INFORMATION,"Error");
                        x.show();
                    }
                    
                    return usuarioRetornar;
                }
            }
            //implementar codigo para que el codigo no use banderas
//                Alert a = new Alert(Alert.AlertType.ERROR, "Usuario Incorrecto");
//                a.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioRetornar;
    }


    @FXML
    private void SignUp(MouseEvent event) {
       // Alert a = new Alert(Alert.AlertType.INFORMATION,"Alert funciona");
        //a.show
        
        try{
            Button b = (Button)event.getSource();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto_edd/signUp.fxml"));
            Parent root = loader.load();
            SignUpController controlador = loader.getController();

            // Pasa el usuario al controlador de cambio de clave            

            Scene scene = new Scene(root);
            Stage stage = (Stage) b.getScene().getWindow(); 
            stage.setScene(scene);
            stage.show();
                        
        }catch(IOException e){
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Error");
            a.show();
        }
          
    }

}
