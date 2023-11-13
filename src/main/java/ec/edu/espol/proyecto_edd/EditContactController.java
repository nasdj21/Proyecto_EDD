/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
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
    
    private String urlImagen;

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
        
        //cambiar los valores predeterminados por los nuevos valores del edit contact
        if(nametext.getText().isBlank() || numbertext.getText().isBlank())
        {
            Alert a  = new Alert(Alert.AlertType.ERROR, "You should enter a name and a number");
            a.show();
        }else
        {
            ArrayList<Contacto> contactos = Contacto.readListFromFileSer();
            
            for(Contacto userInList: contactos)
            {
                if(userInList.getNumero().equals(numbertext.getText()))
                {
                    Alert a  = new Alert(Alert.AlertType.ERROR, "This number already exits");
                     a.show();                                        
                    break;
                }
            }
            //creando el usuario 
        ArrayList<Correo> correosAgregar = new ArrayList<>();
        Correo correo = new Correo("Personal",emailtext.getText());
        correosAgregar.add(correo);
        
        ArrayList<Direccion> direccionAgregar = new ArrayList<>();
        Direccion direccion = new Direccion("Hogar",directiontext.getText());
        direccionAgregar.add(direccion);
        


        ContactoAsociado contAsoc = new ContactoAsociado("","");
        
        ArrayList<Recordatorio> recordatorios = new ArrayList<>();
        Recordatorio recor = new Recordatorio(datetext1.getText()," ");
        recordatorios.add(recor);
        
        
        //Agregar Imagenes
        LinkedList<Foto> fotos = new LinkedList<Foto>();
        
        //falta validar que no este vacia la foto
        Foto fotoAgregar = new Foto(urlImagen);
        //nota: validar que al agregar la foto se tenga en cuenta el directorio y no solo el nombre de la imagen
        fotos.add(fotoAgregar);
        
        ContactoEmpresa contactoAgregar = new ContactoEmpresa(nametext.getText(), numbertext.getText(), correosAgregar, fotos, direccionAgregar, recordatorios, contAsoc); 
        contactoAgregar.saveSer();
            
        //4 Regresar al menu principal
        try {
            
            Button b = (Button)event.getSource();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto_edd/secondary.fxml"));
            Parent root = loader.load();
            SecondaryController controlador = loader.getController();

            // Pasa el usuario al controlador de cambio de clave            

            Scene scene = new Scene(root);
            Stage stage = (Stage) b.getScene().getWindow(); 
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error");
        }
        }
    }

    @FXML
    private void addPhoto(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Imagen: ");
        File selectedFile  = fileChooser.showOpenDialog(null);

        if(selectedFile !=  null){
            Image selectedImage = new Image(selectedFile.toURI().toString());
            imageId.setImage(selectedImage);
            System.out.println(selectedFile.getName());

            // Set the relative path for the directory where you want to save the images
            String relativePath = "src/main/resources/img/";
            File directory = new File(relativePath);

                   if (!directory.exists()) {
                directory.mkdirs();
            }

                   File outputFile = new File(relativePath + selectedFile.getName());

            try{
                Files.copy(selectedFile.toPath(),outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Copia de imagen guardada en: " + outputFile.getAbsolutePath());
                System.out.println(selectedFile.getName());
                urlImagen = selectedFile.getName();


            }catch(IOException e){
                e.printStackTrace();
            }
            
            
            //Agregar contacto a la linkedList de usuario
        }
    }
    
}
