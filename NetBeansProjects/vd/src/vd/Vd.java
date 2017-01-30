/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vd;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Damira
 */
public class Vd extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Video Player");
        Group root = new Group();
        Slider slider = new Slider();
        VBox vbox = new VBox();
        ImageView p = new ImageView(new Image("but 2.png", 20, 20, true, true));
        Button pause = new Button("", p);
        pause.setStyle("-fx-background-color: transparent;");
        vbox.getChildren().addAll(slider, pause);
        vbox.setStyle("-fx-background-color: grey;");
        Media our_video = new Media("file:/Users/Damira/NetBeansProjects/vd/src/landscapesvideo.mp4");
        MediaPlayer player = new MediaPlayer(our_video);
        MediaView view = new MediaView(player);
        root.getChildren().addAll(view, vbox);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        player.play();
        player.setOnReady(new Runnable() {
             @Override
             public void run() {
                 int w = player.getMedia().getWidth();
                 int h = player.getMedia().getHeight();
                 primaryStage.setMinWidth(w);
                 primaryStage.setMinHeight(h);
                 slider.setMinWidth(w);
                 slider.setMinHeight(100);
                 slider.setTranslateY(h-100);
                 slider.setMin(0.0);
                 slider.setValue(0.0);
                 slider.setMax(player.getTotalDuration().toSeconds());
                 pause.setTranslateY(h-100);
             }
         });
        pause.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                if(pause.getText().equals("Pause")){
                    player.pause();
                    pause.setText("Resume");
                }
                else{
                    player.play();
                    pause.setText("Pause");
                }
            }
        });
        slider.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                player.seek(Duration.seconds(slider.getValue()));
            }
        });
        slider.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                player.seek(Duration.seconds(slider.getValue()));
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
