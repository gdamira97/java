/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asdf;


import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import static javafx.scene.text.Font.font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Damira
 */
public class asdf extends Application implements EventHandler<MouseEvent>{
    GraphicsContext gc;
    int chosen = 0;
    double x1, y1;
    double x2, y2;
    TextField text = new TextField();
    WritableImage wim = new WritableImage(300, 250);
//    final static int CANVAS_WIDTH = 900;
//    final static int CANVAS_HEIGHT = 900;
    ColorPicker cp;
    Paint pd;
    String f;
    int h;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Paint");
        final Canvas canvas = new Canvas();
        canvas.setWidth(900);
        canvas.setHeight(900);
        canvas.setOnMousePressed(this);
        canvas.setOnMouseReleased(this);
        canvas.setOnMouseDragged(this);
        gc = canvas.getGraphicsContext2D();
        ImageView rectangle = new ImageView(new Image("rect.png", 50, 50, true, true));
        ImageView circle = new ImageView(new Image("circle.png", 50, 50, true, true));
        ImageView triangle = new ImageView(new Image("triangle.png", 50, 50, true, true));
        ImageView t = new ImageView(new Image("txt.png", 50, 50, true, true));
        ImageView line = new ImageView(new Image("line.png", 50, 50, true, true));
        ImageView pn = new ImageView(new Image("pen.png", 50, 50, true, true));
        ImageView er = new ImageView(new Image("eraser.png", 50, 50, true, true));
        ImageView save = new ImageView(new Image("save.png", 50, 50, true, true));
        Button drawRect = new Button("Rectangle", rectangle);
        drawRect.setMaxWidth(150);
        drawRect.setMaxHeight(100);
        Button drawCirc = new Button("Circle", circle);
        drawCirc.setMaxWidth(150);
        drawCirc.setMaxHeight(100);
        Button txt = new Button("Text", t);
        txt.setMaxWidth(150);
        txt.setMaxHeight(100);
        Button drawTri = new Button("Triangle", triangle);
        drawTri.setMaxWidth(150);
        drawTri.setMaxHeight(100);
        Button drawLine = new Button("Line", line);
        drawLine.setMaxWidth(150);
        drawLine.setMaxHeight(100);
        Button pen = new Button("Pen", pn);
        pen.setMaxWidth(150);
        pen.setMaxHeight(100);
        Button eraser = new Button("Eraser", er);
        eraser.setMaxWidth(150);
        eraser.setMaxHeight(100);
        Button s = new Button("Save", save);
        s.setMaxWidth(150);
        s.setMaxHeight(100);
        s.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(primaryStage);
                if(file != null){
                    try {
                        WritableImage writableImage = new WritableImage(900,900);
                        canvas.snapshot(null, writableImage);
                        RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                        ImageIO.write(renderedImage, "png", file);
                    } catch (IOException ex) {
                        Logger.getLogger(asdf.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        });
        drawRect.setOnAction(e -> chosen=1);
        drawCirc.setOnAction(e -> chosen=2);
        txt.setOnAction(e -> chosen=3);
        drawTri.setOnAction(e -> chosen=4);
        drawLine.setOnAction(e -> chosen=5);
        pen.setOnAction(e -> chosen=6);
        eraser.setOnAction(e -> chosen=7);
        cp = new ColorPicker();
        cp.setMaxWidth(150);
        cp.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                 pd = cp.getValue();
         }
            });
        ComboBox cb1 = new ComboBox();
        cb1.getItems().addAll("Arial", "Times New Roman", "Comic Sans MS", "Consolas", "Georgia");
        cb1.setValue("Arial");
        f = "Arial";
        ComboBox cb2 = new ComboBox();
        for(int i=1; i<=72; i++){
            cb2.getItems().addAll(i);
        }
        cb2.setValue(14);
        h = 14;
        cb1.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                 f = (String) cb1.getValue();
         }
        });
        cb2.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                 h = (int) cb2.getValue();
         }
        });
        VBox vbox = new VBox(10);
        vbox.setMaxWidth(150);
        vbox.setStyle("-fx-background-color: #336699;");
        vbox.setMargin(text, new Insets(10, 0, 0, 0));
        vbox.getChildren().addAll(text,cp, cb1, cb2, drawRect, drawCirc, drawTri, drawLine, txt, pen, eraser, s);
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vbox);
        borderPane.setRight(canvas);
        borderPane.setStyle("-fx-background-color: #FFFFFF;");
        primaryStage.setScene(new Scene(borderPane, 1050, 900));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void handle(MouseEvent event){
        if(event.getEventType()==MouseEvent.MOUSE_PRESSED){
            x1 = event.getX();
            y1 = event.getY();
        }
        if(event.getEventType()==MouseEvent.MOUSE_RELEASED){
            x2 = event.getX();
            y2 = event.getY();
            if(chosen==1){
                gc.setStroke(pd);
                if(y2>y1){
                    gc.strokeRect(x1, y1, Math.abs(x2-x1), Math.abs(y2-y1));
                }
                else{
                    gc.strokeRect(x2, y2, Math.abs(x2-x1), Math.abs(y2-y1));
                }
            }
            if(chosen==2){
                gc.setStroke(pd);
                if(y2>y1){
                    gc.strokeOval(x1, y1, Math.abs(x2-x1), Math.abs(y2-y1));
                }
                else{
                    gc.strokeOval(x2, y2, Math.abs(x2-x1), Math.abs(y2-y1));
                }
            }
            if(chosen==3){
                String t = text.getText();
                gc.setFill(pd);
                gc.setFont(font(f, h));
                gc.fillText(t, x1, y1);
            }
            if(chosen==4){
                gc.setStroke(pd);
                gc.strokeLine(x1, y1, x2, y2);
                gc.strokeLine(x2, y2, x1-(x2-x1), y2);
                gc.strokeLine(x1-(x2-x1), y2, x1, y1);
            }
            if(chosen==5){
                gc.setStroke(pd);
                gc.strokeLine(x1, y1, x2, y2);
            }
//            if(chosen==8){
//                File file = new File("CanvasImage.png");
//        try {
//            ImageIO.write(SwingFXUtils.fromFXImage(wim, null), "png", file);
//        } catch (Exception ex) {
//        }
//            }
        }
//        if(event.getEventType()==MouseEvent.MOUSE_DRAGGED){
//            gc.setFill(pd);
//            gc.fillOval(event.getSceneX(), event.getSceneY(), 0, 0);
//        }
        if(event.getEventType()==MouseEvent.MOUSE_DRAGGED && chosen == 6){
            gc.setFill(pd);
            gc.fillOval(event.getX()-10, event.getY()-10, h, h);
        }
        if(event.getEventType()==MouseEvent.MOUSE_DRAGGED && chosen == 7){
            gc.setFill(Color.WHITE);
            gc.fillOval(event.getX()-10, event.getY()-10, 50, 50);
        }
    }
}
