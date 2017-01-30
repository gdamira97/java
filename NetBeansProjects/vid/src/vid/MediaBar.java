/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vid;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Damira
 */
public class MediaBar extends HBox {
    Slider time = new Slider();
    Slider vol = new Slider();
    
    ImageView pl = new ImageView(new Image("whiteplay.png", 30, 30, true, true));
    ImageView ps = new ImageView(new Image("whitepause.png", 30, 30, true, true));
    ImageView s = new ImageView(new Image("whitestop.png", 30, 30, true, true));
    ImageView f = new ImageView(new Image("whiteforward.png", 30, 30, true, true));
    ImageView b = new ImageView(new Image("whitebackword.png", 30, 30, true, true));
    ImageView m = new ImageView(new Image("whitemute.png", 30, 30, true, true));
//    ImageView i = new ImageView(new Image("whiteopen.png", 30, 30, true, true));
    
    Button playButton = new Button("", ps);
    Button stopButton = new Button("", s);
    Button forw = new Button("", f);
    Button back = new Button("", b);
    Button mute = new Button("", m);
//    Button open = new Button("", i);
    
    MediaPlayer player;
    
    public MediaBar(MediaPlayer play){
        player = play;
        
        playButton.setStyle("-fx-background-color: transparent;");
        stopButton.setStyle("-fx-background-color: transparent;");
        forw.setStyle("-fx-background-color: transparent;");
        back.setStyle("-fx-background-color: transparent;");
        mute.setStyle("-fx-background-color: transparent;");
//        open.setStyle("-fx-background-color: transparent;");
        
        setAlignment(Pos.BASELINE_CENTER);
        setPadding(new Insets(600, 400, 20, 400));
        
        time.setPrefWidth(350);
        
        vol.setPrefWidth(70);
        vol.setMinWidth(30);
        vol.setValue(100);
        
        HBox.setHgrow(time, Priority.ALWAYS);
        
        HBox hbox1 = new HBox(back, playButton, stopButton, forw, mute, vol);
        hbox1.setAlignment(Pos.CENTER);
        HBox hbox2 = new HBox(time, vol);
        VBox vbox = new VBox(hbox1, hbox2);
        getChildren().add(vbox);
        
        playButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                MediaPlayer.Status status = player.getStatus();
                
                if(status == MediaPlayer.Status.PLAYING){
                    if(player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())){
                        player.seek(player.getStartTime());
                        player.play();
                    }
                    else{
                        player.pause();
                        playButton.setGraphic(pl);
                    }
                }
                if(status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.HALTED || status == MediaPlayer.Status.STOPPED){
                    player.play();
                    playButton.setGraphic(ps);
                }
            }
        });
        
        stopButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                player.stop();
                playButton.setGraphic(pl);
            }
        });
        
        mute.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(player.getVolume() != 0){
                player.setVolume(0);
                }
                else{
                    player.setVolume(vol.getValue()/100);
                }
            }
        });
        
        forw.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                player.seek(player.getMedia().getDuration().multiply(time.getValue()*1.5/100));
            }
        });
        
        back.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                player.seek(player.getMedia().getDuration().multiply(time.getValue()*0.5/100));
            }
        });
        
        player.currentTimeProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                updatesValue();
            }
        });
        
        time.valueProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                if(time.isPressed()){
                    player.seek(player.getMedia().getDuration().multiply(time.getValue()/100));
                }
            } 
        });
        
        vol.valueProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(Observable observable) {
                if(vol.isPressed()){
                    player.setVolume(vol.getValue()/100);
                }
            }
        });
    }
    public void updatesValue(){
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                time.setValue(player.getCurrentTime().toMillis()/player.getTotalDuration().toMillis()*100);
            }
        });  
    }
}
