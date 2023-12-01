package ec.edu.espol.proyecto_edd;

import ec.edu.espol.proyecto_edd.Contacto;
import java.io.IOException;
import java.net.URL;
import TDA.MyArrayList;
import TDA.LinkedListCircular;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecondaryController implements Initializable, rowHandler, contactFinder{

    
    @FXML
    private Button crearContactoButton;
    
    private MyArrayList<Contacto>contactos = Contacto.readListFromFileSer();
    private MyArrayList<Contacto>contactosMostrados;
    
    @FXML
    private ComboBox<?> ordenarComboBox;
    @FXML
    private ImageView favoritoFoto;
    @FXML
    private ImageView contactFoto;
    @FXML
    private Label nombres;
    @FXML
    private VBox favoritoVbox;
    @FXML
    private VBox fotoVbox;
    @FXML
    private VBox nombresVbox;
    
    Image imgFavorito = new Image("/img/estrellaLLena.png");
    Image imgNoFavorito = new Image("/img/estrellaVacia.png");
    
    

    
    
     
    
    
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
        
        if(contactos.isEmpty()){
            nombres.setText("");
        }else{
            
            Comparator<Contacto> cmp = (Contacto contacto1, Contacto contacto2) -> {
                if (contacto1.isFavorito() && !contacto2.isFavorito()) {
                    return -1; // contacto1 favorito, contacto2 no favorito, contacto1 va antes
                } else if (!contacto1.isFavorito() && contacto2.isFavorito()) {
                    return 1; // contacto2 favorito, contacto1 no favorito, contacto2 va antes
                } else {
                    // Si ambos son favoritos o no favoritos, ordena por la primera letra del nombre
                    return contacto1.compareTo(contacto2);
                }
                
            };
            
            PriorityQueue<Contacto> ordenamiento = new PriorityQueue<>(cmp);
            for(int i = 0; i < contactos.size(); i++){
                ordenamiento.add(contactos.get(i));
            }
            
            
            
            Contacto c0 = ordenamiento.poll();
          
            nombres.setText(c0.getNombres()); 
            contactFoto.setImage(new Image("/img/"+c0.getNombres().toUpperCase().charAt(0)+".png"));
            
            
            if(c0.isFavorito())
                favoritoFoto.setImage(imgFavorito);
            else
                favoritoFoto.setImage(imgNoFavorito);
            
            while(!ordenamiento.isEmpty()){
                Contacto c = ordenamiento.poll();
                Image imgC = new Image("/img/"+c.getNombres().toUpperCase().charAt(0)+".png");
                
                addLabelToVbox(nombresVbox, nombres, c.getNombres());
                
                
                addImageViewToVbox(fotoVbox, contactFoto, imgC);
                if(c.isFavorito())
                    addImageViewToVbox(favoritoVbox, favoritoFoto, imgFavorito);
                else
                    addImageViewToVbox(favoritoVbox, favoritoFoto, imgNoFavorito);
                
            }
        }
        
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
        PickResult pickResult = event.getPickResult();
        Node nodoSeleccionado = pickResult.getIntersectedNode();
        System.out.println("Entro verContacto");
        System.out.println(nodoSeleccionado.getClass());
        
        if (nodoSeleccionado.getParent() instanceof Label) {
        Label labelPadre = (Label) nodoSeleccionado.getParent();
        String nombreContacto = labelPadre.getText();
        Contacto contactoSeleccionado = encontrarContactoPorNombre(nombreContacto, contactos);
        System.out.println("Entro al if");

            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto_EDD/verContacto.fxml"));
                Parent root = loader.load();

                VerContactoController verController = loader.getController();

                verController.show(contactoSeleccionado);
                verController.setContacto(contactoSeleccionado);
                Scene scene = new Scene(root);
                Stage stage = (Stage) crearContactoButton.getScene().getWindow(); 
                stage.setScene(scene);
                stage.show();

            }catch(IOException e) {
                e.printStackTrace();
            }
       }
    }
    
    
}