module ec.edu.espol.proyecto_edd {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.proyecto_edd to javafx.fxml;
    exports ec.edu.espol.proyecto_edd;
}
