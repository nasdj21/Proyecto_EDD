/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import java.io.IOException;
import java.net.URL;
import TDA.MyArrayList;
import TDA.LinkedListCircular;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JOSUE
 */
public class MostrarGaleríaController implements Initializable {

    @FXML
    private Button previousButton;
    @FXML
    private Button backButton;
    @FXML
    private Button nextButton;
    @FXML
    private ImageView imagepanel;
    
    private MyArrayList<Contacto>contactos = Contacto.readListFromFileSer();
    
    private LinkedListCircular<Foto> fotos;
    
    private int indiceActual;
    
    private Contacto contacto;
    
   
    
    public void setContacto(Contacto c){
        this.contacto = c;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void prev(MouseEvent event) {
        if (fotos.size() > 1) {
            indiceActual = (indiceActual - 1 + fotos.size()) % fotos.size();
            mostrarImagenActual();
        }else{
            Alert alerta = new Alert(Alert.AlertType.WARNING, "Estas en la primera imagen");
            alerta.show();
        }
    }

    

    @FXML
    private void next(MouseEvent event) {
        if (fotos.size() > 1) {
            indiceActual = (indiceActual + 1) % fotos.size();
            mostrarImagenActual();
        }else{
            Alert alerta = new Alert(Alert.AlertType.WARNING, "No hay más imagenes");
            alerta.show();
        }
    }
    
    public void presentar(LinkedListCircular<Foto>fotos){
        
        if(fotos.isEmpty()){
            Alert alerta = new Alert(Alert.AlertType.WARNING, "El contacto no tiene foto");
            alerta.show();
        }else{
            this.fotos = fotos;
            this.indiceActual = 0;
            mostrarImagenActual();
            
        }
    }
    
    public void mostrarImagenActual(){
        String nombreImagen = fotos.get(indiceActual).getDireccion();
        Image imagen = new Image("/img/" + nombreImagen);
        imagepanel.setImage(imagen);
    }
    
    @FXML
    private void back(MouseEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto_EDD/verContacto.fxml"));
            Parent root = loader.load();
            
            VerContactoController verController = loader.getController();
            

            verController.setContacto(contacto);
            verController.show(contacto);
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) backButton.getScene().getWindow(); 
            stage.setScene(scene);
            stage.show();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}