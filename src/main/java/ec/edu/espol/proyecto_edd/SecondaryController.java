package ec.edu.espol.proyecto_edd;

import ec.edu.espol.proyecto_edd.Contacto;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SecondaryController implements Initializable {

    @FXML
    private TableView<Contacto> table;
    @FXML
    private Button filtrarButton;
    @FXML
    private Button ordenarButton;
    @FXML
    private Button crearContactoButton;
    
    private ArrayList<Contacto>contactos;
    
    
    public void setContactos(ArrayList<Contacto>contactos){
        this.contactos = contactos;
    }
    
    
     
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Contacto>contactos1 = new ArrayList<>();
        LinkedList<Foto>lfotosc1 = new LinkedList<>();
        Foto fotoc11 = new Foto("man");
        lfotosc1.add(fotoc11);
        
        LinkedList<Foto>lfotosc2 = new LinkedList<>();
        Foto fotoc21 = new Foto("woman");
        Foto fotoc22 = new Foto("woman2");
        lfotosc2.add(fotoc21);
        lfotosc2.add(fotoc22);
        
        Contacto contacto1 = new Contacto("Juan", "Perez", "123456789", new ArrayList<>(), lfotosc1, new ArrayList<>(), new ArrayList<>(), null);

        Contacto contacto2 = new Contacto("Maria", "Lopez", "987654321", new ArrayList<>(), lfotosc2, new ArrayList<>(), new ArrayList<>(), null);

        Contacto contacto3 = new Contacto("Luis", "Rodriguez", "999888777");
        
        contactos1.add(contacto1);
        contactos1.add(contacto2);
        contactos1.add(contacto3);
        
        mostrar(contactos1);
    }
    
   

    
    public void mostrar(ArrayList<Contacto> contactos){
        this.contactos = contactos;
        TableColumn nombreColumn = new TableColumn("Nombre");
        TableColumn apellidoColumn = new TableColumn("Apellido");
        TableColumn numeroColumn = new TableColumn("Numero");
        ObservableList<Contacto>data = FXCollections.observableArrayList(contactos);
        nombreColumn.setCellValueFactory(new PropertyValueFactory<Contacto,String>("nombres"));
        apellidoColumn.setCellValueFactory(new PropertyValueFactory<Contacto,String>("apellidos"));
        numeroColumn.setCellValueFactory(new PropertyValueFactory<Contacto,String>("numero"));
        
        table.getColumns().addAll(nombreColumn, apellidoColumn, numeroColumn);
        table.setItems(data);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); 
        
    }
    

    @FXML
    private void filtrar(MouseEvent event) {
    }

    @FXML
    private void ordenar(MouseEvent event) {
    }

    @FXML
    private void crearContacto(MouseEvent event) {
    }

    @FXML
    private void verContacto(MouseEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto_EDD/verContacto.fxml"));
            Parent root = loader.load();
            
            VerContactoController verController = loader.getController();
            
            verController.show(table.getSelectionModel().getSelectedItem());
            verController.setContactos(contactos);
            verController.setContacto(table.getSelectionModel().getSelectedItem());
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) filtrarButton.getScene().getWindow(); 
            stage.setScene(scene);
            stage.show();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    
}