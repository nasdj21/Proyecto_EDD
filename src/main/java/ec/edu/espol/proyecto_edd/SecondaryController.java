package ec.edu.espol.proyecto_edd;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

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
    }
}

