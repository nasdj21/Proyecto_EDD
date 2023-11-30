package ec.edu.espol.proyecto_edd;

import ec.edu.espol.proyecto_edd.Contacto;
import ec.edu.espol.proyecto_edd.ContactoEmpresa;
import java.io.IOException;
import java.net.URL;
import TDA.MyArrayList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class VerContactoController implements Initializable, rowHandler {

    private Contacto contacto;
    
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
    
    @FXML
    private Button editButton;
    @FXML
    private Button backButton;    
    @FXML
    private Label labelContact;
    
    @FXML
    private ImageView correoImagen;
    @FXML
    private ImageView direccionImagen;
    
    
    @FXML
    private GridPane centerGrid;
    @FXML
    private GridPane infoGrid;
    @FXML
    private TitledPane contactInfoTitlePane;
    @FXML
    private TitledPane aboutTitlePane;
    @FXML
    private ImageView asociadoImagen;
    @FXML
    private ImageView otrosImagen;
    @FXML
    private Label asociadoTexto;
    @FXML
    private Label otrosText;
    @FXML
    private VBox telefonoVbox;
    @FXML
    private VBox telefonoLabelVbox;
    @FXML
    private VBox correoVbox;
    @FXML
    private VBox correoLabelVbox;
    @FXML
    private VBox direccionVbox;
    @FXML
    private VBox direccionLabelVbox;
    @FXML
    private VBox recordatorioVbox;
    @FXML
    private GridPane aboutGrid;
    @FXML
    private ImageView telefonoImagen;
    @FXML
    private Label redSocialText;
    @FXML
    private Label redSocialLabel;
    @FXML
    private Label recordatorioLabel;
    @FXML
    private ImageView redSocialImagen;
    private VBox redSocialVbox;
    
    @FXML
    private VBox redSocialLabelVbox;
    @FXML
    private ImageView favoriteImageView;
    
    Image imgCorreo = new Image("/img/icons8-gmail-logo-50.png");
    Image imgLocation = new Image("/img/icons8-google-maps-50.png");
    Image imgRecordatorio = new Image("/img/icons8-contacts-50.png");
    Image imgAsociado = new Image("/img/icons8-google-contacts-48.png");
    Image imgRedes = new Image("/img/icons8-instagram-50.png");


   
    public void setContacto(Contacto c){
        this.contacto = c;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public void show(Contacto c){
        if(!c.getFotos().isEmpty()){
           String nombreImagen = c.getFotos().getFirst().getDireccion();
            Image perfil = new Image("/img/"+nombreImagen);
            imageId.setImage(perfil); 
            
            Circle mascara = new Circle((imageId.getFitWidth()) / 2, (imageId.getFitHeight()) / 2, (imageId.getFitWidth()) / 2);
            imageId.setClip(mascara);
        }
        
        if(c.isFavorito()){
            favoriteImageView.setImage(new Image("/img/estrellaLLena.png"));
        }
        else{
            favoriteImageView.setImage(new Image("/img/estrellaVacia.png"));
        }
        
        
        if (c instanceof ContactoEmpresa) {
            labelContact.setText(c.getNombres() != null ? c.getNombres() : "N/A");
        }else{
            
            numberLabel.setText("Personal");
            labelContact.setText(c.getNombres() != null && c.getApellidos() != null ? c.getNombres()+" "+c.getApellidos(): "N/A");
        }
        
        
        //info contact
        
            numbertext.setText(c.getNumero().getFirst().getNumero());
            numberLabel.setText("Por Defecto");
            if(c.getNumero().size() > 1){
                for(int i = 1; i < c.getNumero().size(); i++){
                   addLabelToVbox(telefonoVbox, numbertext, c.getNumero().get(i).getNumero()); 
                   addLabelToVbox(telefonoLabelVbox, numberLabel, c.getNumero().get(i).getLabel());
                }
            }
            
            
           

            // Desde aquí, los atributos son opcionales
            
            if(c.getDirecciones().isEmpty() && c.getCorreos().isEmpty()){
                removeRow(infoGrid,contactInfoTitlePane,2);
                removeRow(infoGrid,contactInfoTitlePane,1);
                
            }else {
                if(!c.getDirecciones().isEmpty()){
                    
                    directiontext.setText(c.getDirecciones().get(0).getDireccion());
                    direccionImagen.setImage(imgLocation);
                    directionLabel.setText("Hogar");
                    if(c.getDirecciones().size() > 1){
                        for(int i = 1; i < c.getDirecciones().size(); i++){
                           addLabelToVbox(direccionVbox, directiontext, c.getDirecciones().get(i).getDireccion()); 
                           addLabelToVbox(direccionLabelVbox, directionLabel, c.getDirecciones().get(i).getLabel()); 
                        }
                    }
                }else{
                    directiontext.setText("");
                    directionLabel.setText("");
                }
                
                if(!c.getCorreos().isEmpty()){
                    correoImagen.setImage(imgCorreo);
                    emailtext.setText(c.getCorreos().get(0).getDireccion());
                    mailLabel.setText("Personal");
                    if(c.getCorreos().size() > 1){
                        for(int i = 1; i < c.getCorreos().size(); i++){
                           addLabelToVbox(correoVbox, emailtext, c.getCorreos().get(i).getDireccion()); 
                           addLabelToVbox(correoLabelVbox, mailLabel, c.getCorreos().get(i).getLabel());
                        }
                    }
                }else{
                    emailtext.setText("");
                    mailLabel.setText("");
                }
           }
            
            //about Contact
            
            if(c.getRecordatorios().isEmpty() && c.getContactoAsociado() == null){
                centerGrid.getChildren().remove(aboutTitlePane);
                
                
            }else{
                if(!c.getRecordatorios().isEmpty()){
                    
                    otrosText.setText(c.getRecordatorios().get(0).getInfo());
                    otrosImagen.setImage(imgRecordatorio);
                    recordatorioLabel.setText(c.getRecordatorios().get(0).getLabel());
                    
                    if(c.getRecordatorios().size() > 1){
                        for(int i = 1; i < c.getRecordatorios().size(); i++){
                           addLabelToVbox(recordatorioVbox, otrosText, c.getRecordatorios().get(i).getInfo());
                           addLabelToVbox(recordatorioVbox, recordatorioLabel, c.getRecordatorios().get(i).getLabel()); 
                        }
                    }
                }else{
                    otrosText.setText("");
                    recordatorioLabel.setText("");
                    
                }
                
                if(c.getContactoAsociado() != null){
                    asociadoTexto.setText(c.getContactoAsociado().getNombre());
                    asociadoImagen.setImage(imgAsociado);
                }else{
                    asociadoTexto.setText("");
                    
                }
                
                if(!c.getRedes().isEmpty()){
                    redSocialText.setText(c.getRedes().getFirst().getCuenta());
                    redSocialImagen.setImage(imgRedes);
                    redSocialLabel.setText(c.getRedes().getFirst().getPlataforma());
                    if(c.getRedes().size() > 1){
                        for(int i = 1; i < c.getRedes().size(); i++){
                           addLabelToVbox(redSocialVbox, redSocialText, c.getRedes().get(i).getCuenta());
                           addLabelToVbox(redSocialLabelVbox, redSocialLabel, c.getRedes().get(i).getPlataforma());
                    }
                }else
                    redSocialText.setText("");
                    redSocialLabel.setText("");
            }
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
            mostrarController.setContacto(contacto);
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) backButton.getScene().getWindow(); 
            stage.setScene(scene);
            stage.show();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void modificarFavorito(MouseEvent event) {
        if(contacto.isFavorito()){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Eliminado de Favoritos");
            alerta.show();
            favoriteImageView.setImage(new Image("/img/estrellaVacia.png"));
            contacto.setFavorito(false);
            
        }else{
            Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Agregado a Favoritos");
            alerta.show();
            favoriteImageView.setImage(new Image("/img/estrellaLLena.png"));
            contacto.setFavorito(true);
            
        }
        Contacto.actualizarContacto(contacto);

        
    }
    
}
