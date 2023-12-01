/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espol.proyecto_edd;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author nicolassierra
 */
public interface cloners {
    default Label cloneLabel(Label originalLabel){
        Label clonedLabel = new Label(originalLabel.getText());

        // Copiar las propiedades visuales del label original al clonado
        clonedLabel.setStyle(originalLabel.getStyle());
        clonedLabel.setFont(originalLabel.getFont());
        clonedLabel.setTextFill(originalLabel.getTextFill());
        clonedLabel.setEventDispatcher(originalLabel.getEventDispatcher());
        
       
        return clonedLabel;

    }
    
     default ImageView cloneImageView(ImageView originalImageView){
        ImageView clonedImageView = new ImageView();

        // Copiar algunas propiedades visuales del ImageView original al clonado
        clonedImageView.setFitWidth(originalImageView.getFitWidth());
        clonedImageView.setFitHeight(originalImageView.getFitHeight());
        clonedImageView.setPreserveRatio(originalImageView.isPreserveRatio());
        clonedImageView.setSmooth(originalImageView.isSmooth());

        return clonedImageView;
    }
}
