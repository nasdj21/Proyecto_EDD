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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField nametext;
    @FXML
    private TextField lastnametext;
    @FXML
    private TextField usernametext;
    @FXML
    private PasswordField verifypasswordtext;
    @FXML
    private PasswordField passwordtext;
    @FXML
    private Label camponame;
    @FXML
    private Label campolastname;
    @FXML
    private Label campousername;
    @FXML
    private Label campopassword;
    @FXML
    private Label campoverifypassword;
    @FXML
    private TextField organizaciontext;
    @FXML
    private Label campoorganizacion;
    
    private ArrayList<Usuario> usuarios; 
    @FXML
    private TextField numbertext;
    @FXML
    private Label camponumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Lista para comprobar que el usuario no exista
        usuarios = Usuario.readListFromFileSer();
        
        // TODO
    }    

    @FXML
    private void registrarusuario(MouseEvent event) {        
        //comprobar que el usuario no exista

        /*
        if(nametext.getText().isBlank())
        {
            camponame.setText("*Required field");
        }else
        {
            camponame.setText("Valido");
        }
        
        
        if(lastnametext.getText().isBlank())
        {
            campolastname.setText("Ok");
        }
*/

        if(usernametext.getText().isBlank())
        {
            campousername.setText("*Required field");
        }else
        {
            for(Usuario userInList: usuarios)
            {
                if(userInList.getName().equals(usernametext.getText()))
                {
                    campousername.setText("Uusario ya existe");
                    break;
                }
                else
                {
                    campousername.setText("Valido");
                }   
            }            
        }
        //5
        if(passwordtext.getText().isBlank())
        {
            campopassword.setText("*Required field");
        }else
        {
            campopassword.setText("Valido");
        }
        //6
        if(verifypasswordtext.getText().isBlank())
        {
            campoverifypassword.setText("*Required field");
        }else if(!verifypasswordtext.getText().equals(passwordtext.getText()))
        {
            campoverifypassword.setText("No Coincidence");
        }else
        {
            campoverifypassword.setText("Valido");        
        }


        /*
        if(organizaciontext.getText().isBlank())
        {
            campoorganizacion.setText("*Ok");
        }else
        {
            campoorganizacion.setText("Valido");
        }
*/
        

        //conditional para crear al usuario 
        //poner todos los label e igualarlos a valido
        if(camponame.getText().equals("Valido") && campopassword.getText().equals("Valido") && campoverifypassword.getText().equals("Valido"))
        {
            //creando el usuario
            Usuario usuarioAgregar = new Usuario(   usernametext.getText(),
                                                    passwordtext.getText()  
            );
            //lista con todos los usuarios
            usuarioAgregar.saveSer();
            
            //el alert solo se muestra cuando si todos los datos son correctos
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Usuario Registrado, inicie sesion para agregar contactos");
            a.show();            
        }
        
    }
    
    
    
    @FXML
    private void loginvolver(MouseEvent event) {
        try{
            Button b = (Button)event.getSource();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto_edd/primary.fxml"));
            Parent root = loader.load();
            PrimaryController controlador = loader.getController();

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


//verificar el usuario, la contraseñas
