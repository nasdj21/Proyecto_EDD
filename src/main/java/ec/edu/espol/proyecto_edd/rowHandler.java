/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/**
 *
 * @author nicolassierra
 */
public interface rowHandler {
    default void removeRow(GridPane gridPane, TitledPane titledPane, int rowIndex) {
    if (rowIndex >= 0 && rowIndex < gridPane.getRowCount()) {
        gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == rowIndex);
        gridPane.getRowConstraints().remove(rowIndex);

        double newPrefHeight = gridPane.getChildren().stream().mapToDouble(node -> GridPane.getRowIndex(node) == null ? 0 : GridPane.getRowIndex(node)).max().orElse(0) * 25 + 40; // Ajusta el valor para hacer la fila un poco más alta

        titledPane.setPrefHeight(newPrefHeight);
        }
    }
    
    default void addLabelToVbox(VBox vbox, Label originalLabel, String nuevoTexto){
        Label clonedLabel = new Label(nuevoTexto);

        // Copiar las propiedades visuales del label original al clonado
        clonedLabel.setStyle(originalLabel.getStyle());
        clonedLabel.setFont(originalLabel.getFont());
        clonedLabel.setTextFill(originalLabel.getTextFill());
        
        // Agregar el label clonado al VBox
        vbox.getChildren().add(clonedLabel);

    }
    
}
