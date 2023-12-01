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
import javafx.event.ActionEvent;
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

public class SecondaryController implements Initializable, rowHandler, contactFinder, contadorAtributos, cloners{

    
    @FXML
    private Button crearContactoButton;
    
    private MyArrayList<Contacto>contactos = Contacto.readListFromFileSer();
    private MyArrayList<Contacto>contactosMostrados;
    
    @FXML
    private ComboBox<String> ordenarComboBox;
    @FXML
    private ComboBox<String> filtrarComboBox;
    
    @FXML
    private Label nombres;
    private Label ogNombres;
    @FXML
    private ImageView contactFoto;
    private ImageView ogContactFoto;
    @FXML
    private ImageView favoritoFoto;
    private ImageView ogFavoritoFoto;
    @FXML
    private VBox favoritoVbox;
    @FXML
    private VBox fotoVbox;
    @FXML
    private VBox nombresVbox;
    
    Image imgFavorito = new Image("/img/estrellaLLena.png");
    Image imgNoFavorito = new Image("/img/estrellaVacia.png");
    
    Comparator<Contacto> cmpFavoritos = (Contacto contacto1, Contacto contacto2) -> {
                if (contacto1.isFavorito() && !contacto2.isFavorito()) {
                    return -1; // contacto1 favorito, contacto2 no favorito, contacto1 va antes
                } else if (!contacto1.isFavorito() && contacto2.isFavorito()) {
                    return 1; // contacto2 favorito, contacto1 no favorito, contacto2 va antes
                } else {
                    // Si ambos son favoritos o no favoritos, ordena por la primera letra del nombre
                    return contacto1.compareTo(contacto2);
                }
                
            };
    
    Comparator<Contacto> cmpNumAtributos = (Contacto contacto1, Contacto contacto2) -> {
        int atributosContacto1 = contadorAtributos(contacto1);
        int atributosContacto2 = contadorAtributos(contacto2);

        if (atributosContacto1 > atributosContacto2) {
            return 1; // contacto1 tiene más atributos, va después en la cola de prioridad
        } else if (atributosContacto1 < atributosContacto2) {
            return -1; // contacto1 tiene menos atributos, va antes en la cola de prioridad
        } else {
            // Si ambos tienen la misma cantidad de atributos, comparar por orden natural
            return contacto1.compareTo(contacto2);
        }
};
    
  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MyArrayList<Contacto>contactos1 = Contacto.readListFromFileSer();
        ordenarComboBox.getItems().addAll("Todo","# de Atributos", "Tipo de Contacto", "Favoritos", "Muchos Números"); //Todo es filtrar por primera letra del nombre
        ogNombres = cloneLabel(nombres);
        ogContactFoto = cloneImageView(contactFoto);
        ogFavoritoFoto = cloneImageView(favoritoFoto);
        
        if(contactos1.isEmpty()){
        LinkedListCircular<Foto>lfotosc1 = new LinkedListCircular<>();
        Foto fotoc11 = new Foto("man.png");
        lfotosc1.add(fotoc11);
        
        LinkedListCircular<Foto>lfotosc2 = new LinkedListCircular<>();
        Foto fotoc21 = new Foto("woman.png");
        Foto fotoc22 = new Foto("woman2.png");
        lfotosc2.add(fotoc21);
        lfotosc2.add(fotoc22);
        
        
        Correo correo1 = new Correo("personal", "juancorreo@gmail.com");
        Correo correo2 = new Correo("trabajo", "josql@sdl.com");
        MyArrayList<Correo>correosJuan = new MyArrayList<>();
        correosJuan.add(correo1);
        correosJuan.add(correo2);
        
        SocialMedia ig = new SocialMedia("pepito123","Instagram");
        LinkedListCircular<SocialMedia>RedesJuan = new LinkedListCircular<>();
        RedesJuan.add(ig);
       
        
        Contacto contacto1 = new Contacto("Juan", "Perez", "123456789", correosJuan, lfotosc1, new MyArrayList<>(), new MyArrayList<>(), null, RedesJuan);
        
        Contacto contacto2 = new Contacto("Angela", "Lopez", "987654321", new MyArrayList<>(), lfotosc2, new MyArrayList<>(), new MyArrayList<>(), null);
        
        Contacto contacto3 = new Contacto("Luis", "Rodriguez", "999888777");
        
        contactos1.add(contacto1);
        contactos1.add(contacto2);
        contactos1.add(contacto3);
        Contacto.saveSer(contactos1);
        }
        
        
        mostrar(contactos1);
    }
    
   

    
    public void mostrar(MyArrayList<Contacto> contactos){
        refresher();
       
        contactosMostrados = contactos;
        
        
        if(contactos.isEmpty()){
            nombres.setText("");
        }else{
            PriorityQueue<Contacto> ordenamiento = new PriorityQueue<>(cmpFavoritos);
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
        Contacto contactoSeleccionado = encontrarContactoPorNombre(nombreContacto, Contacto.readListFromFileSer());
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

    @FXML
    private void ordenarPor(ActionEvent event) {
        String seleccion = ordenarComboBox.getValue();
        contactosMostrados.clear();
        if(seleccion.compareToIgnoreCase("Todo") == 0){ //si se selecciona todo
            contactosMostrados = Contacto.readListFromFileSer();
            mostrar(contactosMostrados);
            
        }else if(seleccion.compareToIgnoreCase("# de Atributos") == 0){
            PriorityQueue<Contacto> ordenamientoatr = new PriorityQueue<>(cmpNumAtributos);
            for(int i = 0; i < contactos.size(); i++){
                ordenamientoatr.add(contactos.get(i));
            }
           while (!ordenamientoatr.isEmpty()) {
            contactosMostrados.add(ordenamientoatr.poll());
        }
        
        mostrar(contactosMostrados);
        }
        
    }

    @FXML
    private void filtrarPor(ActionEvent event) {
        
    }
    
    private void refresher(){
        favoritoVbox.getChildren().clear();
        fotoVbox.getChildren().clear();
        nombresVbox.getChildren().clear();

        // Agregar copias de los elementos originales a los Vbox
        favoritoVbox.getChildren().add(cloneImageView(ogFavoritoFoto));
        fotoVbox.getChildren().add(cloneImageView(ogContactFoto));
        nombresVbox.getChildren().add(cloneLabel(ogNombres));

        // Actualizar las referencias a los elementos clonados
        favoritoFoto = (ImageView) favoritoVbox.getChildren().get(0);
        contactFoto = (ImageView) fotoVbox.getChildren().get(0);
        nombres = (Label) nombresVbox.getChildren().get(0);
        
        
    }
    
    
}