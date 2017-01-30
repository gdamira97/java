/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Damira
 */
public class Com extends Application {
//    Rectangle rect = new Rectangle (100, 40, 100, 100);
    ImageView img = new ImageView(new Image("дарвин.gif", 300, 300, true, true));
    @Override
    public void start(Stage primaryStage) {
//     img.setArcHeight(50);
//     img.setArcWidth(50);
//     img.setFill(Color.VIOLET);
 
     TranslateTransition tt = new TranslateTransition(Duration.millis(1000), img);
     tt.setByX(200f);
     tt.setCycleCount((int) 200f);
     tt.setAutoReverse(true);
     tt.play();
     BorderPane borderPane = new BorderPane();
     borderPane.getChildren().add(img);
     primaryStage.setScene(new Scene(borderPane, 1050, 900));
     primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        launch(args);
    }
    
}
