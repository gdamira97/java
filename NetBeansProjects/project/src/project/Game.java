/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Damira
 */
public class Game extends Application {
    int b, c;
    double a = 1, d = 1;
    Image s1, s2;
    Scene scene;
    Random r;
    ImageView img, imgop, player1, player2;
    ProgressBar life1, life2;
    ContentFrame f1, f2;
    HBox hbox1, hbox2;
    Boolean hitted = false;
    
    public Game(int b, int c){
        this.b = b;
        this.c = c;
    }
    @Override
    public void start(Stage primaryStage) {
        Pane group = new Pane();
        life1 = new ProgressBar();
        life1.setPrefSize(200, 50);
        life2 = new ProgressBar();
        life2.setPrefSize(200, 50);
        
        life1.setProgress(a);
        life2.setProgress(d);
        
        Label win = new Label("You win!");
        win.setStyle("-fx-font-size: 68pt;"
                + "-fx-font-family: \"Arial\";" 
                + "-fx-text-fill: red;");
        win.setLayoutX(270);
        win.setLayoutY(400);
        
        if(b == 0){ 
            s1 = new Image("file:/Users/Damira/NetBeansProjects/project/src/java/darwinsprite.png");
            player1 = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/darwinface.gif", 100, 100, true, true));
            f1 = new ContentFrame(player1);
        }
        if(b == 1){
            s1 = new Image("file:/Users/Damira/NetBeansProjects/project/src/java/einstainsprite.png");
            player1 = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/einstainface.gif", 100, 100, true, true));
            f1 = new ContentFrame(player1);
        }
        if(b == 2){
            s1 = new Image("file:/Users/Damira/NetBeansProjects/project/src/java/newtonsprite.png");
            player1 = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/newtonface.gif", 100, 100, true, true));
            f1 = new ContentFrame(player1);
        }
        if(c == 0){
            s2 = new Image("file:/Users/Damira/NetBeansProjects/project/src/java/darwinspr.png");
            player2 = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/darwinfaceop.gif", 100, 100, true, true));
            f2 = new ContentFrame(player2);
        }
        if(c == 1){
            s2 = new Image("file:/Users/Damira/NetBeansProjects/project/src/java/einstainspr.png");
            player2 = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/einstainfaceop.gif", 100, 100, true, true));
            f2 = new ContentFrame(player2);
        }
        if(c == 2){
            s2 = new Image("file:/Users/Damira/NetBeansProjects/project/src/java/newtonspr.png");
            player2 = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/newtonfaceop.gif", 100, 100, true, true));
            f2 = new ContentFrame(player2);
        }
        
        hbox1 = new HBox(f1, life1);
        hbox1.setLayoutX(10);
        hbox1.setLayoutY(20);
        
        hbox2= new HBox(life2, f2);
        hbox2.setLayoutX(588);
        hbox2.setLayoutY(20);
        
        img = new ImageView(s1);
        img.setLayoutX(100);
        img.setLayoutY(500);
        
        if(b == 0){
        Animation animation=new SpriteAnimation(img, Duration.millis(500), 8, 11, 0, 0, 200, 264);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        }
        
        if(b == 1){
        Animation animation=new SpriteAnimation(img, Duration.millis(500), 8, 12, 0, 0, 200, 264);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        }
        
        if(b == 2){
        Animation animation=new SpriteAnimation(img, Duration.millis(500), 8, 11, 0, 0, 264, 300);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        }
        
        imgop = new ImageView(s2);
        imgop.setLayoutX(500);
        imgop.setLayoutY(500);
        
        if(c == 0){
        Animation animation=new SpriteAnimation(imgop, Duration.millis(500), 8, 11, 24, 0, 200, 264);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        }
        
        if(c == 1){
        Animation animation=new SpriteAnimation(imgop, Duration.millis(500), 8, 12, 0, 0, 200, 264);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        }
        
        if(c == 2){
        Animation animation=new SpriteAnimation(imgop, Duration.millis(500), 8, 11, 6, 0, 264, 300);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        }
        
        group.getChildren().addAll(img, imgop, hbox1, hbox2);
        group.setStyle("-fx-background-image: url(\"battle.png\");"
                     + "-fx-background-repeat: stretch;"
                     + "-fx-background-size: 900 800;");
        scene = new Scene(group, 900, 800);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent event) {
                KeyCode k = event.getCode();
                switch (k) {
                    case D:
                        if(img.getTranslateX() < 640){
                        img.setTranslateX(img.getTranslateX() + 20);
                        }
                        break;
                    case A:
                        if(img.getTranslateX() > -120){
                        img.setTranslateX(img.getTranslateX() - 20);
                        }
                        break;
                    case S:
                        if(b == 0){
                        Animation down=new SpriteAnimation(img, Duration.millis(500), 5, 5, 0, 792, 264, 264);
                        down.setCycleCount(1);
                        down.play();
                        }
                        
                        if(b == 1){
                        Animation down=new SpriteAnimation(img, Duration.millis(500), 6, 6,  0, 792, 264, 264);
                        down.setCycleCount(1);
                        down.play();
                        }
                        
                        if(b == 2){
                        Animation down=new SpriteAnimation(img, Duration.millis(500), 4, 4,  0, 900, 264, 300);
                        down.setCycleCount(1);
                        down.play();  
                        }
                        break;
                    case W:
                        if(b == 0){
                        Animation up=new SpriteAnimation(img, Duration.millis(500), 8, 8,  0, 1056, 264, 264);
                        up.setCycleCount(1);
                        up.play();
                        }
                        
                        if(b == 1){
                        Animation up=new SpriteAnimation(img, Duration.millis(500), 7, 7,  0, 1056, 264, 264);
                        up.setCycleCount(1);
                        up.play();
                        }
                        
                        if(b == 2){
                        Animation up=new SpriteAnimation(img, Duration.millis(500), 7, 7,  0, 1200, 264, 320);
                        up.setCycleCount(1);
                        up.play();
                        }
                        
                        img.setTranslateY(img.getTranslateY()-100);
                        Timeline timeline = new Timeline();
                        timeline.getKeyFrames().addAll(
                                new KeyFrame(Duration.ZERO, new KeyValue(img.translateYProperty(),img.getTranslateY())),
                                new KeyFrame(Duration.millis(1000), new KeyValue(img.translateYProperty(), 0))
                        );
                        timeline.play();
                        break;
                    case E:
                        if(b == 0){
                        Animation hit=new SpriteAnimation(img, Duration.millis(500), 7, 7, 0, 264, 264, 264);
                        hit.setCycleCount(1);
                        hit.play();
                        }
                        
                        if(b == 1){
                        Animation hit=new SpriteAnimation(img, Duration.millis(500), 8, 8,  0, 264, 264, 264);
                        hit.setCycleCount(1);
                        hit.play();
                        }
                        
                        if(b == 2){
                        Animation hit=new SpriteAnimation(img, Duration.millis(500), 5, 5,  0, 300, 264, 300);
                        hit.setCycleCount(1);
                        hit.play();
                        }
                        if(img.getBoundsInParent().intersects(imgop.getBoundsInParent())){
                            MediaPlayer mediaPlayer = new MediaPlayer(new Media("file:/Users/Damira/NetBeansProjects/project/src/sound/тыдщ.mp3"));
                            mediaPlayer.play();
                            d -= 0.05;
                            life2.setProgress(d);
                            if(life1.getProgress() < 0){
                                group.getChildren().add(win);
                                group.getChildren().remove(img);
                            }
                            if(life2.getProgress() < 0){
                                group.getChildren().add(win);
                                group.getChildren().remove(imgop);
                            }
                            
                        }
                        break;
                    case R:
                        if(b == 0){
                        Animation hitf=new SpriteAnimation(img, Duration.millis(500), 5, 5, 0, 528, 264, 264);
                        hitf.setCycleCount(1);
                        hitf.play();
                        }
                        
                        if(b == 1){
                        Animation hitf=new SpriteAnimation(img, Duration.millis(500), 8, 8,  0, 528, 264, 264);
                        hitf.setCycleCount(1);
                        hitf.play();
                        }
                        
                        if(b == 2){
                        Animation hitf=new SpriteAnimation(img, Duration.millis(500), 8, 8,  0, 600, 346, 300);
                        hitf.setCycleCount(1);
                        hitf.play();
                        }
                        if(img.getBoundsInParent().intersects(imgop.getBoundsInParent())){
                            MediaPlayer mediaPlayer = new MediaPlayer(new Media("file:/Users/Damira/NetBeansProjects/project/src/sound/тыдщ.mp3"));
                            mediaPlayer.play();
                            d -= 0.1;
                            life2.setProgress(d);
                            if(life1.getProgress() < 0){
                                group.getChildren().add(win);
                                group.getChildren().remove(img);
                            }
                            if(life2.getProgress() < 0){
                                group.getChildren().add(win);
                                group.getChildren().remove(imgop);
                            }
                        }
                        break;
                        
                    case RIGHT:
                        if(imgop.getTranslateX() < 240){
                        imgop.setTranslateX(imgop.getTranslateX() + 20);
                        }
                        break;
                    case LEFT:
                        if(imgop.getTranslateX() > -520){
                        imgop.setTranslateX(imgop.getTranslateX() - 20);
                        }
                        break;
                    case UP:
                        if(c == 0){
                        Animation up=new SpriteAnimation(imgop, Duration.millis(500), 8, 8,  112, 1056, 264, 264);
                        up.setCycleCount(1);
                        up.play();
                        }
                        
                        if(c == 1){
                        Animation up=new SpriteAnimation(imgop, Duration.millis(500), 7, 7,  516, 1056, 264, 264);
                        up.setCycleCount(1);
                        up.play();
                        }
                        
                        if(c == 2){
                        Animation up=new SpriteAnimation(imgop, Duration.millis(500), 7, 7,  1052, 1200, 264, 320);
                        up.setCycleCount(1);
                        up.play();
                        }
                        
                        imgop.setTranslateY(imgop.getTranslateY()-100);
                        
                        Timeline tl = new Timeline();
                        tl.getKeyFrames().addAll(
                                new KeyFrame(Duration.ZERO, new KeyValue(imgop.translateYProperty(),imgop.getTranslateY())),
                                new KeyFrame(Duration.millis(1000), new KeyValue(imgop.translateYProperty(), 0))
                        );
                        tl.play();
                        break;
                    case DOWN:
                        if(c == 0){
                        Animation down=new SpriteAnimation(imgop, Duration.millis(500), 5, 5,  904, 792, 264, 264);
                        down.setCycleCount(1);
                        down.play();
                        }
                        
                        if(c == 1){
                        Animation down=new SpriteAnimation(imgop, Duration.millis(500), 6, 6,  552, 792, 264, 264);
                        down.setCycleCount(1);
                        down.play();
                        }
                        
                        if(c == 2){
                        Animation down=new SpriteAnimation(imgop, Duration.millis(500), 4, 4,  1844, 900, 264, 300);
                        down.setCycleCount(1);
                        down.play();  
                        }
                        break;
                    case N:
                        if(c == 0){
                        Animation hit=new SpriteAnimation(imgop, Duration.millis(500), 7, 7, 375, 264, 264, 264);
                        hit.setCycleCount(1);
                        hit.play();
                        }
                        
                        if(c == 1){
                        Animation hit=new SpriteAnimation(imgop, Duration.millis(500), 8, 8,  288, 264, 264, 264);
                        hit.setCycleCount(1);
                        hit.play();
                        }
                        
                        if(c == 2){
                        Animation hit=new SpriteAnimation(imgop, Duration.millis(500), 5, 5,  1580, 400, 264, 300);
                        hit.setCycleCount(1);
                        hit.play();
                        }
                        if(img.getBoundsInParent().intersects(imgop.getBoundsInParent())){
                            MediaPlayer mediaPlayer = new MediaPlayer(new Media("file:/Users/Damira/NetBeansProjects/project/src/sound/тыдщ.mp3"));
                            mediaPlayer.play();
                            a -= 0.05;
                            life1.setProgress(a);
                            if(life1.getProgress() < 0){
                                group.getChildren().add(win);
                                group.getChildren().remove(img);
                            }
                            if(life2.getProgress() < 0){
                                group.getChildren().add(win);
                                group.getChildren().remove(imgop);
                            }
                        }
                        break;
                    case M:
                        if(c == 0){
                        Animation hitf=new SpriteAnimation(imgop, Duration.millis(500), 5, 5, 904, 528, 264, 264);
                        hitf.setCycleCount(1);
                        hitf.play();
                        }
                        
                        if(c == 1){
                        Animation hitf=new SpriteAnimation(imgop, Duration.millis(500), 8, 8,  288, 528, 264, 264);
                        hitf.setCycleCount(1);
                        hitf.play();
                        }
                        
                        if(c == 2){
                        Animation hitf=new SpriteAnimation(imgop, Duration.millis(500), 8, 8,  132, 600, 346, 300);
                        hitf.setCycleCount(1);
                        hitf.play();
                        }
                        if(img.getBoundsInParent().intersects(imgop.getBoundsInParent())){
                            MediaPlayer mediaPlayer = new MediaPlayer(new Media("file:/Users/Damira/NetBeansProjects/project/src/sound/тыдщ.mp3"));
                            mediaPlayer.play();
                            a -= 0.1;
                            life1.setProgress(a);
                            if(life1.getProgress() < 0){
                                group.getChildren().add(win);
                                group.getChildren().remove(img);
                            }
                            if(life2.getProgress() < 0){
                                group.getChildren().add(win);
                                group.getChildren().remove(imgop);
                            }
                        }
                        break;
                        
                    case ESCAPE:
                        Project p = new Project();
                        p.start(primaryStage);
                        break;
                }
            }
        });

        group.setPrefSize(900, 800);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}

