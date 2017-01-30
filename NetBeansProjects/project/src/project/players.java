/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author Damira
 */
public class players extends Application {
    int b;
    int currentScientist = 0, currentScientist1 = 0;
    VBox players, opponents;
    boolean player1chosen = false, player2chosen = false;
    ImageView img, imgop;
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPrefSize(900, 800);
        pane.setStyle("-fx-background-image: url(\"background.png\");"
                    + "-fx-background-repeat: stretch;"
                    + "-fx-background-size: 900 800;");
        Media media1 = new Media("file:/Users/Damira/NetBeansProjects/project/src/sound/poof.mp3");
        Media media2 = new Media("file:/Users/Damira/NetBeansProjects/project/src/sound/тык.mp3");
        
        
        ContentFrame f1 = new ContentFrame(new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/darwinface.gif", 100, 100, true, true)));
        ContentFrame f2 = new ContentFrame(new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/einstainface.gif", 100, 100, true, true)));
        ContentFrame f3 = new ContentFrame(new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/newtonface.gif", 100, 100, true, true)));
        
        ContentFrame f4 = new ContentFrame(new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/darwinfaceop.gif", 100, 100, true, true)));
        ContentFrame f5 = new ContentFrame(new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/einstainfaceop.gif", 100, 100, true, true)));
        ContentFrame f6 = new ContentFrame(new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java//faces/newtonfaceop.gif", 100, 100, true, true)));
        
        Brr frame1 = new Brr(f1);
        Brr frame2 = new Brr(f2);
        Brr frame3 = new Brr(f3);
        
        Brr frame4 = new Brr(f4);
        Brr frame5 = new Brr(f5);
        Brr frame6 = new Brr(f6);
        
        players = new VBox(50, frame1, frame2, frame3);
        players.setTranslateX(50);
        players.setTranslateY(200);
        
        opponents = new VBox(50, frame4, frame5, frame6);
        opponents.setTranslateX(750);
        opponents.setTranslateY(200);
        
        pane.getChildren().addAll(players, opponents);
        Scene scene = new Scene(pane, 900, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        getContent(0).setActive(true);
                scene.setOnKeyPressed(event -> {
                    if(player1chosen == false){
if (event.getCode() == KeyCode.UP) {
    pane.getChildren().remove(img);
if (currentScientist > 0) {
    MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
    mediaPlayer2.play();
                    getContent(currentScientist).setActive(false);
                    getContent(--currentScientist).setActive(true);
                }
            }
if (event.getCode() == KeyCode.DOWN) {
    pane.getChildren().remove(img);
if (currentScientist < players.getChildren().size() - 1) {
    MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
    mediaPlayer2.play();
                    getContent(currentScientist).setActive(false);
                    getContent(++currentScientist).setActive(true);
                }
            }
if (event.getCode() == KeyCode.ENTER) {
                getContent(currentScientist).activate();
                player1chosen = true;
                getContent1(0).setActive(true);
                if(getContent(currentScientist) == frame1){
                                img = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/darwinop.gif", 500, 500, true, true));
                                img.setLayoutX(200);
                                img.setLayoutY(80);
                            }
                            if(getContent(currentScientist) == frame2){
                                img = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/einstainop.gif", 500, 500, true, true));
                                img.setLayoutX(180);
                                img.setLayoutY(80);
                            }
                            if(getContent(currentScientist) == frame3){
                                img = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/newtonop.gif", 500, 550, true, true));
                                img.setLayoutX(170);
                                img.setLayoutY(90);
                            }
                            pane.getChildren().add(img);
                    }
                    }
                    else{
                        if (event.getCode() == KeyCode.UP) {
                            pane.getChildren().remove(imgop);
                            if (currentScientist1 > 0) {
                                MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
                                mediaPlayer2.play();
                                getContent1(currentScientist1).setActive(false);
                                getContent1(--currentScientist1).setActive(true);
                            }
                        }
                        if (event.getCode() == KeyCode.DOWN) {
                            pane.getChildren().remove(imgop);
                            if (currentScientist1 < players.getChildren().size() - 1) {
                                MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
                                mediaPlayer2.play();
                                getContent1(currentScientist1).setActive(false);
                                getContent1(++currentScientist1).setActive(true);
                            }
                        }
                        if (event.getCode() == KeyCode.ENTER) {
                            pane.getChildren().remove(imgop);
                            getContent1(currentScientist1).activate();
                            if(getContent1(currentScientist1) == frame4){
                                imgop = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/darwinopop.gif", 500, 500, true, true));
                                imgop.setLayoutX(350);
                                imgop.setLayoutY(80);
                            }
                            if(getContent1(currentScientist1) == frame5){
                                imgop = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/einstainopop.gif", 500, 500, true, true));
                                imgop.setLayoutX(370);
                                imgop.setLayoutY(80);
                            }
                            if(getContent1(currentScientist1) == frame6){
                                imgop = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/newtonopop.gif", 500, 550, true, true));
                                imgop.setLayoutX(320);
                                imgop.setLayoutY(80);
                            }
                            pane.getChildren().add(imgop);
                            player2chosen = true;
                            Label label = new Label("Press G");
                            label.setStyle("-fx-font-size: 24pt;"
                                         + "-fx-font-family: \"Arial\";" 
                                         + "-fx-text-fill: white;");
                            label.setLayoutX(350);
                            label.setLayoutY(20);
                            pane.getChildren().add(label);
                        }
                        if(event.getCode() == KeyCode.G && player1chosen == true && player2chosen == true){
                            MediaPlayer mp = new MediaPlayer(media1);
                            mp.play();
                            Game game = new Game(currentScientist, currentScientist1);
                            game.start(primaryStage);
                        }
                        }
                    if(event.getCode() == KeyCode.ESCAPE){
                        MediaPlayer mp = new MediaPlayer(media1);
                        mp.play();
                        Project p = new Project();
                        p.start(primaryStage);
                    }
    });
                        }
                    
    public Brr getContent(int index) {
        return (Brr)players.getChildren().get(index);
    }
     public Brr getContent1(int index) {
        return (Brr)opponents.getChildren().get(index);
    }
     
    /**
     * @param args the command line arguments
     */
     
    public static void main(String[] args) {
        launch(args);
    }
    
}
