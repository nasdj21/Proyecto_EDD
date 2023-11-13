package ec.edu.espol.proyecto_edd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage st;
    
    @Override
    public void start(Stage stage) throws IOException {
        st = stage;        
        scene = new Scene(loadFXML("secondary"), 640, 480);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void setScene(Scene sc) throws IOException {
        st.setScene(sc);
    }    

    
    
    
    
    public static void main(String[] args) {
        launch();
    }

}