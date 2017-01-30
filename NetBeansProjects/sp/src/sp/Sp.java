/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Damira
 */
public class Sp extends Application {
    double x = 0, y = 0;
    double width = 90;
    double height = 125;
    Circle c;
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Image s1 = new Image("file:/Users/Damira/NetBeansProjects/sp/src/sonic.png");
        Image s2 = new Image("file:/Users/Damira/NetBeansProjects/sp/src/sonic.png");
        
        ImageView img = new ImageView(s1);
        img.setViewport(new Rectangle2D(x, y, width, height));
        
        c = new Circle((int) (Math.random()*720), (int) (Math.random()*520), 40);
        
        root.getChildren().addAll(img, c);
        Scene scene = new Scene(root, 800, 600);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode k = event.getCode();
                switch (k) {
                    case D:
                        img.setImage(s2);
                        x = (x == 200) ? 0 : x + width;
                        y = 125;
                        img.setViewport(new Rectangle2D(x, y, width, height));
                        img.setTranslateX(img.getTranslateX() + 10);
                        break;
                    case A:
                        img.setImage(s2);
                        x = (x == 200) ? 0 : x + width;
                        y = 125;
                        img.setViewport(new Rectangle2D(x, y, width, height));
                        img.setTranslateX(img.getTranslateX() - 10);
                        break;
                    case S:
                        x =(x == 100) ? 0 : x + width;
                        img.setViewport(new Rectangle2D(x, y, width, height));
                        img.setTranslateY(img.getTranslateY() + 10);
                        break;
                    case W:
                        x = (x == 100) ? 0 : x+ width;
                        img.setViewport(new Rectangle2D(x, y, width, height));
                        img.setTranslateY(img.getTranslateY() - 10);
                        break;
//                    case E:
//                        img.setImage(s2);
                }
                if(img.getBoundsInParent().intersects(c.getBoundsInParent())){
                    c.setTranslateX((int) (Math.random() * 720));
                    c.setTranslateY((int) (Math.random() * 520));
                }
            }
        });
        
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent event) {
                KeyCode k = event.getCode();
                switch (k) {
                    case D:
                        img.setImage(s1);
                        x = 0;
                        img.setViewport(new Rectangle2D(x, y, width, height));
                        break;
                    case A:
                        img.setImage(s1);
                        x = 0;
                        img.setViewport(new Rectangle2D(x, y, width, height));
                        break;
                    case S:
                        img.setImage(s1);
                        x = 0;
                        img.setViewport(new Rectangle2D(x, y, width, height));
                        break;
                    case W:
                        img.setImage(s1);
                        x = 0;
                        img.setViewport(new Rectangle2D(x, y, width, height));
                        break;
//                    case E:
//                        img.setImage(s1);
                }
            }
            
        });
        
        primaryStage.setTitle("Sprite Animation");
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
