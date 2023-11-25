package ec.edu.espol.proyecto_edd;

import ec.edu.espol.proyecto_edd.Contacto;
import ec.edu.espol.proyecto_edd.ContactoEmpresa;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class VerContactoController implements Initializable {

    
    @FXML
    private Label numbertext;
    @FXML
    private Label emailtext;
    @FXML
    private Label directiontext;   
    @FXML
    private ImageView imageId;   
    @FXML
    private Label numberLabel;
    @FXML
    private Label directionLabel;    
    @FXML
    private Label mailLabel;
    private ArrayList<Contacto>contactos;
    @FXML
    private Button editButton;
    @FXML
    private Button backButton;    
    @FXML
    private Label labelContact;
    @FXML
    private Label empresaLabel;
    @FXML
    private ImageView telefonoImagen;
    @FXML
    private ImageView correoImagen;
    @FXML
    private ImageView direccionImagen;
    
    private Contacto contacto;

    
    public void setContactos(ArrayList<Contacto>contactos){
        this.contactos = contactos;
    }
    
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

    public void show(Contacto c){
        if(!c.getFotos().isEmpty()){
           String nombreImagen = c.getFotos().getFirst().getDireccion();
            Image perfil = new Image("/img/"+nombreImagen);
            imageId.setImage(perfil); 
        }
        
        if (c instanceof ContactoEmpresa) {
            // Verificar y asignar el nombre
            labelContact.setText(c.getNombres() != null ? c.getNombres() : "N/A");

          

            // Verificar y asignar el número
            numbertext.setText(c.getNumero() != null ? c.getNumero() : "N/A");

            // Desde aquí, los atributos son opcionales
            emailtext.setText(c.getCorreos().isEmpty() ? "N/A" : c.getCorreos().get(0).getDireccion());
            mailLabel.setText(c.getCorreos().isEmpty() ? "N/A" : c.getCorreos().get(0).getLabel());
            directiontext.setText(c.getDirecciones().isEmpty() ? "N/A" : c.getDirecciones().get(0).getDireccion());
            directionLabel.setText(c.getDirecciones().isEmpty() ? "N/A" : c.getDirecciones().get(0).getLabel());
            //Esto va cuando agregue los labels y combobox que faltan//
//            datetext1.setText(c.getRecordatorios().isEmpty() ? "N/A" : c.getRecordatorios().get(0).getDate());
//            dateLabel.setText(c.getRecordatorios().isEmpty() ? "N/A" : c.getRecordatorios().get(0).getLabel());
//            relatedcontacts.getItems().add(c.getContactoAsociado() != null ? "N/A" :
//                    c.getContactoAsociado().getNombre() + " : " + c.getContactoAsociado().getRelacion());
        }else{
            
            empresaLabel.setText("");
            numberLabel.setText("Personal");
            // Verificar y asignar el nombre
            labelContact.setText(c.getNombres() != null && c.getApellidos() != null ? c.getNombres()+" "+c.getApellidos(): "N/A");

            

            // Verificar y asignar el número
            numbertext.setText(c.getNumero() != null ? c.getNumero() : "N/A");

            // Desde aquí, los atributos son opcionales
            emailtext.setText(c.getCorreos().isEmpty() ? "N/A" : c.getCorreos().get(0).getDireccion());
            mailLabel.setText(c.getCorreos().isEmpty() ? "N/A" : c.getCorreos().get(0).getLabel());
            directiontext.setText(c.getDirecciones().isEmpty() ? "N/A" : c.getDirecciones().get(0).getDireccion());
            directionLabel.setText(c.getDirecciones().isEmpty() ? "N/A" : c.getDirecciones().get(0).getLabel());
            //Esto va cuando agregue los labels y combobox que faltan//
//            datetext1.setText(c.getRecordatorios().isEmpty() ? "N/A" : c.getRecordatorios().get(0).getDate());
//            dateLabel.setText(c.getRecordatorios().isEmpty() ? "N/A" : c.getRecordatorios().get(0).getLabel());
//            relatedcontacts.getItems().add(c.getContactoAsociado() == null ? "N/A" :
//                    c.getContactoAsociado().getNombre() + " : " + c.getContactoAsociado().getRelacion());
        }
    }

    @FXML
    private void editContact(MouseEvent event) {
    }

    @FXML
    private void back(MouseEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto_EDD/secondary.fxml"));
            Parent root = loader.load();
            
            SecondaryController secController = loader.getController();
            
            //Cuando ya elimine los contactos del initialize en secondarycontroller, pongo este metodo
//            secController.mostrar(contactos);
            secController.setContactos(contactos);
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) backButton.getScene().getWindow(); 
            stage.setScene(scene);
            stage.show();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void watchGalery(MouseEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto_EDD/mostrarGalería.fxml"));
            Parent root = loader.load();
            
            MostrarGaleríaController mostrarController = loader.getController();
            
            mostrarController.presentar(contacto.getFotos());
            mostrarController.setContactos(contactos);
            mostrarController.setContacto(contacto);
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) backButton.getScene().getWindow(); 
            stage.setScene(scene);
            stage.show();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}