package ec.edu.espol.proyecto_edd;

import ec.edu.espol.proyecto_edd.Contacto;
import java.io.IOException;
import java.net.URL;
import TDA.MyArrayList;
import TDA.LinkedListCircular;
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
    
    private MyArrayList<Contacto>contactos;
    
    
    public void setContactos(MyArrayList<Contacto>contactos){
        this.contactos = contactos;
    }
    
    
     
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MyArrayList<Contacto>contactos1 = Contacto.readListFromFileSer();
        if(contactos1.isEmpty()){
        LinkedListCircular<Foto>lfotosc1 = new LinkedListCircular<>();
        Foto fotoc11 = new Foto("man.png");
        lfotosc1.add(fotoc11);
        
        LinkedListCircular<Foto>lfotosc2 = new LinkedListCircular<>();
        Foto fotoc21 = new Foto("woman.png");
        Foto fotoc22 = new Foto("woman2.png");
        lfotosc2.add(fotoc21);
        lfotosc2.add(fotoc22);
        
        //Borrar despues de probar//
        Correo correo1 = new Correo("personal", "juancorreo@gmail.com");
        Correo correo2 = new Correo("trabajo", "josql@sdl.com");
        MyArrayList<Correo>correosJuan = new MyArrayList<>();
        correosJuan.add(correo1);
        correosJuan.add(correo2);
        //Borrar despues de probar//
        
        Contacto contacto1 = new Contacto("Juan", "Perez", "123456789", correosJuan, lfotosc1, new MyArrayList<>(), new MyArrayList<>(), null);
        
        Contacto contacto2 = new Contacto("Maria", "Lopez", "987654321", new MyArrayList<>(), lfotosc2, new MyArrayList<>(), new MyArrayList<>(), null);
        
        Contacto contacto3 = new Contacto("Luis", "Rodriguez", "999888777");
        
        contactos1.add(contacto1);
        contactos1.add(contacto2);
        contactos1.add(contacto3);
        Contacto.saveSer(contactos1);
        }
        
        
        mostrar(contactos1);
    }
    
   

    
    public void mostrar(MyArrayList<Contacto> contactos){
        this.contactos = contactos;
        TableColumn nombreColumn = new TableColumn("Nombre");
        TableColumn apellidoColumn = new TableColumn("Apellido");
        TableColumn numeroColumn = new TableColumn("Numero");
        ObservableList<Contacto>data = FXCollections.observableMyArrayList(contactos);
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
        //cargar pantalla del nuevo contacto
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
    private void verContacto(MouseEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto_EDD/verContacto.fxml"));
            Parent root = loader.load();
            
            VerContactoController verController = loader.getController();
            
            verController.show(table.getSelectionModel().getSelectedItem());
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