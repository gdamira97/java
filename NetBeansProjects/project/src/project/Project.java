/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import static javafx.scene.layout.StackPane.setMargin;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Damira
 */
public class Project extends Application {
  
    int currentItem = 0;
    int currentScientist = 0;
    double a = 100;
    int b = 0, q = 0;
    VBox vbox;
    VBox scientists;
    MediaPlayer mp;
    Label pl1;
    ScheduledExecutorService bgThread = Executors.newSingleThreadScheduledExecutor();
    
    public class MenuItem extends HBox{
        Font FONT = Font.font("", FontWeight.BOLD, 24);
        Text text;
        Runnable script;
      
      public MenuItem(String name) {
          setAlignment(Pos.CENTER);
          text = new Text(name);
          text.setFont(FONT);
          text.setEffect(new GaussianBlur(2));
          getChildren().addAll(text);
          setActive(false);
      }  
      
      public void setActive(boolean b) {
          text.setFill(b ? Color.WHITE : Color.LIGHTGREY);
      }
      
      public void setOnActivate(Runnable r) {
          script = r;
      }

      public void activate() {
          if (script != null)
              script.run();
      }
    }
    public MenuItem getMenuItem(int index) {
        return (MenuItem)vbox.getChildren().get(index);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Media media1 = new Media("file:/Users/Damira/NetBeansProjects/project/src/sound/poof.mp3");
        Media media2 = new Media("file:/Users/Damira/NetBeansProjects/project/src/sound/тык.mp3");
        Media media = new Media("file:/Users/Damira/NetBeansProjects/project/src/sound/MortalKombat.mp3");
        mp = new MediaPlayer(media);
        mp.play();
        mp.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mp.seek(Duration.ZERO);
            }
            
        });
            
        Pane root = new Pane();
        root.setPrefSize(900, 800);
        ImageView img1 = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/darwinop.gif", 300, 300, true, true));
        ImageView img2 = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/einstainopop.gif", 300, 300, true, true));
        vbox = new VBox(10);
        MenuItem play = new MenuItem("Play");
        MenuItem one = new MenuItem("Instructions");
        MenuItem settings = new MenuItem("Settings");
        MenuItem exit = new MenuItem("Exit");
        vbox.getChildren().addAll(play, one, settings, exit);
        HBox hbox = new HBox(vbox);
        HBox hbox1 = new HBox(img1);
        HBox hbox2 = new HBox(img2);
        
        root.getChildren().addAll(hbox1,hbox, hbox2);
        
        hbox.setLayoutX(380);
        hbox.setLayoutY(550);
        hbox1.setLayoutX(180);
        hbox1.setLayoutY(450);
        hbox2.setLayoutX(480);
        hbox2.setLayoutY(450);
        
        root.setStyle("-fx-background-image: url(\"op.jpg\");"
                    + "-fx-background-repeat: stretch;"
                    + "-fx-background-size: 900 800;");
        
        getMenuItem(currentItem).setActive(true);
        
        Scene scene = new Scene(root, 900, 800, Color.ORANGE);
        primaryStage.setTitle("Science Kombat");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        
        ImageView back = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/back.png", 50, 50, true, true));
        Button backButton = new Button("", back);
        backButton.setStyle("-fx-background-color: transparent;");
        backButton.setOnMouseClicked(event -> {
        MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        mediaPlayer1.setVolume(a);
        mediaPlayer1.play();
        primaryStage.setScene(scene);
        });
        
//Instructions
        Pane root1 = new Pane();
        root1.setPrefSize(900, 800);
        root1.setStyle("-fx-background-image: url(\"background.png\");"
                    + "-fx-background-repeat: stretch;"
                    + "-fx-background-size: 900 800;");
        
        ImageView darwin = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/darwinface.gif", 100, 100, true, true));
        ImageView einstain = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/einstainface.gif", 100, 100, true, true));
        ImageView newton = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/java/faces/newtonface.gif", 100, 100, true, true));
        
        ContentFrame f1 = new ContentFrame(darwin);
        ContentFrame f2 = new ContentFrame(einstain);
        ContentFrame f3 = new ContentFrame(newton);
        
        Brr frame1 = new Brr(f1);
        Brr frame2 = new Brr(f2);
        Brr frame3 = new Brr(f3);
        
        scientists = new VBox(50, frame1, frame2, frame3);
        scientists.setTranslateX(50);
        scientists.setTranslateY(200);
        getContent(currentScientist).setActive(true);
        root1.getChildren().addAll(backButton, scientists);
        Scene scene1 = new Scene(root1, 900, 800);
        
//Scene2
        Pane root2 = new Pane();
        root2.setPrefSize(900, 800);
        root2.setStyle("-fx-background-color: orange;"
                     + "-fx-background-repeat: stretch;"
                     + "-fx-background-size: 900 800;");
        
        Label v = new Label("Music:");
        v.setStyle("-fx-font-size: 20pt;"
                + "-fx-font-family: \"Arial\";" 
                + "-fx-text-fill: white;");
        Slider volume = new Slider();
        volume.setValue(100);
        Label s = new Label("Sound:");
        s.setStyle("-fx-font-size: 20pt;"
                + "-fx-font-family: \"Arial\";" 
                + "-fx-text-fill: white;");
        Slider sound = new Slider();
        sound.setValue(100);
        
        Button sb = new Button("", back);
        sb.setStyle("-fx-background-color: transparent;");
        sb.setOnMouseClicked(event -> {
            MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
            mediaPlayer1.setVolume(a);
            mediaPlayer1.play();
            primaryStage.setScene(scene);
        });
        
        volume.valueProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(Observable observable) {
                if(volume.isPressed()){
                    mp.setVolume(volume.getValue()/100);
                }
            }
        });
        
        sound.valueProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(Observable observable) {
                if(sound.isPressed()){
                    a = sound.getValue()/100;
                }
            }
        });
        
        VBox vb = new VBox();
        vb.getChildren().addAll(v, volume, s, sound);
        vb.setLayoutX(400);
        vb.setLayoutY(400);
        root2.getChildren().addAll(sb, vb);
        Scene scene2 = new Scene(root2, 900, 800);

//Actions Scene   
        play.setOnActivate(() -> {
            MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
            mediaPlayer1.setVolume(a);
            mediaPlayer1.play();
            mp.stop();
            players pl = new players();
            pl.start(primaryStage);
                });
        one.setOnActivate(() -> {
            MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
            mediaPlayer1.setVolume(a);
            mediaPlayer1.play();
            primaryStage.setScene(scene1);
                });
        settings.setOnActivate(() -> {
            MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
            mediaPlayer1.setVolume(a);
            mediaPlayer1.play();
            primaryStage.setScene(scene2);
                });
        exit.setOnActivate(() -> {
            MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
            mediaPlayer1.setVolume(a);
            mediaPlayer1.play();
            System.exit(0);
                });
        
        play.setOnMouseEntered(event -> {
            MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
            mediaPlayer2.setVolume(a);
            mediaPlayer2.play();
            getMenuItem(0).setActive(true);
            getMenuItem(1).setActive(false);
            getMenuItem(2).setActive(false);
            getMenuItem(3).setActive(false);
        });
        play.setOnMouseExited(event -> {
            getMenuItem(0).setActive(false);
        });
        play.setOnMouseClicked(event -> {
            MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
            mediaPlayer1.setVolume(a);
            mediaPlayer1.play();
            players pl = new players();
            pl.start(primaryStage);
                });
        
        one.setOnMouseEntered(event -> {
            MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
            mediaPlayer2.setVolume(a);
            mediaPlayer2.play();
            getMenuItem(0).setActive(false);
            getMenuItem(1).setActive(true);
            getMenuItem(2).setActive(false);
            getMenuItem(3).setActive(false);
        });
        one.setOnMouseExited(event -> {
            getMenuItem(1).setActive(false);
        });
        one.setOnMouseClicked(event -> {
            MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
            mediaPlayer1.setVolume(a);
            mediaPlayer1.play();
            primaryStage.setScene(scene1);
                });

        settings.setOnMouseEntered(event -> {
            MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
            mediaPlayer2.setVolume(a);
            mediaPlayer2.play();
            getMenuItem(0).setActive(false);
            getMenuItem(1).setActive(false);
            getMenuItem(2).setActive(true);
            getMenuItem(3).setActive(false);
        });
        settings.setOnMouseExited(event -> {
            getMenuItem(2).setActive(false);
        });
        
        exit.setOnMouseEntered(event -> {
            MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
            mediaPlayer2.setVolume(a);
            mediaPlayer2.play();
            getMenuItem(0).setActive(false);
            getMenuItem(1).setActive(false);
            getMenuItem(2).setActive(false);
            getMenuItem(3).setActive(true);
        });
        exit.setOnMouseExited(event -> {
            getMenuItem(3).setActive(false);
        });
        exit.setOnMouseClicked(event -> System.exit(0));
        
//Actions Scene1
        Label d = new Label("Charles Darwin");
        Label dy = new Label("12 February 1809 – 19 April 1882");
        Label di = new Label("Darwin published his theory of evolution with compelling evidence in \n     his 1859 book On the Origin of Species, overcoming scientific \nrejection of earlier concepts of transmutation of species. By the 1870s, \n the scientific community and much of the general public had accepted \n evolution as a fact. However, many favoured competing explanations \n               and it was not until the emergence of the modern \n     evolutionary synthesis from the 1930s to the 1950s that a broad \n                 consensus developed in which natural selection was \n the basic mechanism of evolution. In modified form, Darwin's scientific \n                  discovery is the unifying theory of the life sciences, \n                               explaining the diversity of life.");
        Label e = new Label("Albert Einstein");
        Label ey = new Label("14 March 1879 – 18 April 1955");
        Label ei = new Label("Albert Einstein developed the general theory of relativity, one of the \n   two pillars of modern physics (alongside quantum mechanics). \n  Einstein's work is also known for its influence on the philosophy \n     of science. Einstein is best known in popular culture for his \n       mass–energy equivalence formula E = mc2. He received \n the 1921 Nobel Prize in Physics for his \"Services To Theoretical \n               Physics\", in particular his discovery of the law of \n         the photoelectric effect, a pivotal step in the evolution \n                                  of quantum theory.");
        Label n = new Label("Isaac Newton");
        Label ny = new Label("25 December 1642 – 20 March 1726/27");
        Label ni = new Label("    Newton's Principia formulated the laws of motion and universal \n     gravitation, which dominated scientists' view of the physical \n    universe for the next three centuries. By deriving Kepler's laws \n of planetary motion from his mathematical description of gravity, and \n       then using the same principles to account for the trajectories \n    of comets, the tides, the precession of the equinoxes, and other \n     phenomena, Newton removed the last doubts about the validity \n     of the heliocentric model of the Solar System. This work also \n    demonstrated that the motion of objects on Earth and of celestial \n               bodies could be described by the same principles. ");
        
        d.setStyle("-fx-font-size: 14pt;"
                + "-fx-font-family: \"Arial\";" 
                + "-fx-text-fill: white;");
        dy.setStyle("-fx-font-size: 14pt;"
                + "-fx-font-family: \"Arial\";" 
                + "-fx-text-fill: white;");
        di.setStyle("-fx-font-size: 14pt;"
                + "-fx-font-family: \"Arial\";" 
                + "-fx-text-fill: white;");
        e.setStyle("-fx-font-size: 14pt;"
                + "-fx-font-family: \"Arial\";" 
                + "-fx-text-fill: white;");
        ey.setStyle("-fx-font-size: 14pt;"
                + "-fx-font-family: \"Arial\";" 
                + "-fx-text-fill: white;");
        ei.setStyle("-fx-font-size: 14pt;"
                + "-fx-font-family: \"Arial\";" 
                + "-fx-text-fill: white;");
        n.setStyle("-fx-font-size: 14pt;"
                + "-fx-font-family: \"Arial\";" 
                + "-fx-text-fill: white;");
        ny.setStyle("-fx-font-size: 14pt;"
                + "-fx-font-family: \"Arial\";" 
                + "-fx-text-fill: white;");
        ni.setStyle("-fx-font-size: 14pt;"
                + "-fx-font-family: \"Arial\";" 
                + "-fx-text-fill: white;");
        
        d.setLayoutX(510);
        d.setLayoutY(400);
        dy.setLayoutX(430);
        dy.setLayoutY(430);
        di.setLayoutX(300);
        di.setLayoutY(460);
        
        e.setLayoutX(520);
        e.setLayoutY(400);
        ey.setLayoutX(440);
        ey.setLayoutY(430);
        ei.setLayoutX(300);
        ei.setLayoutY(460);
        
        n.setLayoutX(530);
        n.setLayoutY(400);
        ny.setLayoutX(430);
        ny.setLayoutY(430);
        ni.setLayoutX(300);
        ni.setLayoutY(460);
        
ImageView d1 = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/darwinop.gif", 300, 300, true, true));
ImageView e1 = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/einstainop.gif", 300, 300, true, true));
ImageView n1 = new ImageView(new Image("file:/Users/Damira/NetBeansProjects/project/src/newtonop.gif", 300, 300, true, true));

d1.setX(500);
d1.setY(100);
e1.setX(470);
e1.setY(100);
n1.setX(450);
n1.setY(130);

frame1.setOnActivate(() -> {
MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.setVolume(a);
            mediaPlayer2.play();
            root1.getChildren().removeAll(e1, e, ey, ei, n1, n, ny, ni);
            root1.getChildren().addAll(d1, d, dy, di);
                });
frame1.setOnMouseEntered(event -> {
MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.setVolume(a);
            mediaPlayer2.play();
            getContent(0).setActive(true);
            getContent(1).setActive(false);
            getContent(2).setActive(false);
            root1.getChildren().removeAll(e1, e, ey, ei, n1, n, ny, ni);
            root1.getChildren().addAll(d1, d, dy, di);
});
frame1.setOnMouseExited(event -> {
            getMenuItem(2).setActive(false);
            root1.getChildren().removeAll(d1, d, dy, di);
        });

frame2.setOnActivate(() -> {
MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.setVolume(a);
            mediaPlayer2.play();
            root1.getChildren().removeAll(d1, d, dy, di, n1, n, ny, ni);
            root1.getChildren().addAll(e1, e, ey, ei);
                });
frame2.setOnMouseEntered(event -> {
MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.setVolume(a);
            mediaPlayer2.play();
            getContent(0).setActive(false);
            getContent(1).setActive(true);
            getContent(2).setActive(false);
            root1.getChildren().removeAll(d1, d, dy, di, n1, n, ny, ni);
            root1.getChildren().addAll(e1, e, ey, ei);
});
frame2.setOnMouseExited(event -> {
            getMenuItem(2).setActive(false);
            root1.getChildren().removeAll(e1, e, ey, ei);
        });

frame3.setOnActivate(() -> {
MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.setVolume(a);
            mediaPlayer2.play();
            root1.getChildren().removeAll(d1, d, dy, di, e1, e, ey, ei);
            root1.getChildren().addAll(n1, n, ny, ni);
                });
frame3.setOnMouseEntered(event -> {
MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.setVolume(a);
            mediaPlayer2.play();
            getContent(0).setActive(false);
            getContent(1).setActive(false);
            getContent(2).setActive(true);
            root1.getChildren().removeAll(d1, d, dy, di, e1, e, ey, ei);
            root1.getChildren().addAll(n1, n, ny, ni);
});
frame3.setOnMouseExited(event -> {
            getMenuItem(2).setActive(false);
            root1.getChildren().removeAll(n1, n, ny, ni);
        });

//Scene
        scene.setOnKeyPressed(event -> {
if (event.getCode() == KeyCode.UP) {
if (currentItem > 0) {
MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.setVolume(a);
    mediaPlayer2.play();
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(--currentItem).setActive(true);
                }
            }
if (event.getCode() == KeyCode.DOWN) {
if (currentItem < vbox.getChildren().size() - 1) {
MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.setVolume(a);
    mediaPlayer2.play();
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(++currentItem).setActive(true);
                }
            }
if (event.getCode() == KeyCode.ENTER) {
                getMenuItem(currentItem).activate();
            }
if(event.getCode() == KeyCode.ESCAPE){
    System.exit(0);
}
        });

//Scene1        
        scene1.setOnKeyPressed(event -> {
if (event.getCode() == KeyCode.UP) {
if (currentScientist > 0) {
MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.setVolume(a);
    mediaPlayer2.play();
                    getContent(currentScientist).setActive(false);
                    getContent(--currentScientist).setActive(true);
                }
            }
if (event.getCode() == KeyCode.DOWN) {
if (currentScientist < scientists.getChildren().size() - 1) {
MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.setVolume(a);
    mediaPlayer2.play();
                    getContent(currentScientist).setActive(false);
                    getContent(++currentScientist).setActive(true);
                }
            }

if (event.getCode() == KeyCode.ENTER) {
                getContent(currentScientist).activate();
            }

if(event.getCode() == KeyCode.ESCAPE) {
MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        mediaPlayer1.setVolume(a);
                mediaPlayer1.play();
                currentItem = 0;
                primaryStage.setScene(scene);
}
        });
        scene2.setOnKeyPressed(event ->{
            if(event.getCode() == KeyCode.ESCAPE){
MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        mediaPlayer1.setVolume(a);
                mediaPlayer1.play();
                primaryStage.setScene(scene);
            }
        });
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
public Brr getContent(int index) {
        return (Brr)scientists.getChildren().get(index);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
class ContentFrame extends StackPane {
    Rectangle frame;
public ContentFrame(Node content) {
            setAlignment(Pos.CENTER);
            frame = new Rectangle(102, 72);
            setMargin(content, new Insets(-30, 0, 0, 0));
            frame.setStroke(Color.WHITESMOKE);
            getChildren().addAll(frame, content);
        }
}
class Brr extends VBox{
        Node a;
        Runnable script;
        public Brr(Node c){
            this.a = c;
            getChildren().add(c);
            a.setStyle("-fx-opacity: 0.6;");
        }
    public void setActive(boolean b) {
          if(b == true){
              a.setStyle("-fx-opacity: 1;");
          }
          else{
              a.setStyle("-fx-opacity: 0.6;");
          }
      }
    public void setOnActivate(Runnable r) {
          script = r;
      }
    public void activate() {
        if (script != null){
              script.run();
    }
    }
    }
    