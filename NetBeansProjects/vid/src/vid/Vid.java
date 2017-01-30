/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vid;

import java.io.File;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Damira
 */

public class Vid extends Application {
    Player player;
    String filePath = "file:/Users/Damira/NetBeansProjects/vid/src/video.mp4";
    Scene scene;
    @Override
    public void start(Stage primaryStage) {
        
        player = new Player(filePath);
        scene = new Scene(player);
        
//        Player player = new Player("file:/Users/Damira/NetBeansProjects/vid/src/video.mp4");        
        scene.setOnMouseClicked(new EventHandler<MouseEvent> (){
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2){
                    primaryStage.setFullScreen(true);
                }
            }
    });
        
        scene.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {
                    event.acceptTransferModes(TransferMode.COPY);
                } else {
                    event.consume();
                }
            }
        });
        scene.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasFiles()) {
                    success = true;
                    String filePath = null;
                    for (File file:db.getFiles()) {
                        filePath = file.getAbsolutePath();
                        filePath = "file:" + filePath;
                        System.out.println(filePath);
                        player = new Player(filePath);
                        scene.setRoot(player);
                    }
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });
        
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setMinWidth(player.getW());
        primaryStage.setHeight(player.getH()-100);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
class Player extends BorderPane{
    Media media;
    MediaPlayer player;
    MediaView view;
    Pane mpane;
    public Player(String file){
        
        media = new Media(file);
        player = new MediaPlayer(media);
        view = new MediaView(player);
        mpane = new Pane();
        
        MediaBar mb = new MediaBar(player);
        mpane.getChildren().addAll(view, mb);
        
        setCenter(mpane);
        
        player.play();
    }
    public int getW(){
        int w = player.getMedia().getWidth();
        return w;
    }
    public int getH(){
        int h = player.getMedia().getHeight();
        return h;
    }
}
