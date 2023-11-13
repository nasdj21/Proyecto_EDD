package ec.edu.espol.proyecto_edd;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SecondaryController {

    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
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
}

