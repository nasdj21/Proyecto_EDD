package ec.edu.espol.proyecto_edd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("secondary"), 640, 480);
        stage.setScene(scene);
        stage.show();
        
    }
    

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        
        Contacto contacto1 = new Contacto("Juan", "Perez", "123456789", new ArrayList<>(), new LinkedList<>(), new ArrayList<>(), new ArrayList<>(), null);

        Contacto contacto2 = new Contacto("Maria", "Lopez", "987654321");

        Contacto contacto3 = new Contacto("Carlos", "Gomez", "555555555", new ArrayList<>(), new LinkedList<>(), new ArrayList<>(), new ArrayList<>(), new ContactoAsociado("Juan","Amigo"));

        Contacto contacto4 = new Contacto("Ana", "Martinez", "111223344", new ArrayList<>(), new LinkedList<>(), new ArrayList<>(), new ArrayList<>(), new ContactoAsociado("Juan","Amigo"));

        Contacto contacto5 = new Contacto("Luis", "Rodriguez", "999888777");
        
        
        contacto1.saveSer();
        contacto2.saveSer();
        contacto3.saveSer();
        contacto4.saveSer();
        contacto5.saveSer();        
        
        launch();
    }

}