package pai;
// PAINTER

import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;




public class Pai extends Application  implements EventHandler<MouseEvent>{
	GraphicsContext gc, NewGC;
	int chosen=0;
	double y1;
	double x1;
	double y2;
	double x2;
	String press = "White", press2 = "15";
	ColorPicker colorP;
	Paint cl;
	TextField text;
	int num = 2;
	ComboBox comboBox;
	MediaPlayer mediaplayer;
	@Override
	public void start(Stage primaryStage) throws Exception {
			primaryStage.setTitle("Paint");
			Canvas canvas = new Canvas();
			canvas.setWidth(1300);
			canvas.setHeight(500);
			canvas.setOnMousePressed(this);
			canvas.setOnMouseReleased(this);
			canvas.setOnMouseDragged(this);
			gc = canvas.getGraphicsContext2D();
			Button drawRect = new Button("Rect");
			Button drawCircle = new Button("Circle");
			Button drawPen = new Button("Pen");
			Button Eraser = new Button("Eraser");
			Button Line = new Button("Line");
			Button Triangle = new Button("Triangle");
			Button Text = new Button("Text");
			Button music = new Button("music");
			Button save = new Button("Save");
			
			save.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent t) {
	                FileChooser fileChooser = new FileChooser();
	                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
	                fileChooser.getExtensionFilters().add(extFilter);
	                File file = fileChooser.showSaveDialog(primaryStage);
	                if(file != null){
	                    try {
	                        WritableImage writableImage = new WritableImage(1300,500);
	                        canvas.snapshot(null, writableImage);
	                        RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
	                        ImageIO.write(renderedImage, "png", file);
	                    } catch (IOException ex) {
	                        Logger.getLogger(Pai.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                }
	            }
	            
	        });
			
			Button ToMove = new Button("ToMove");
			ToMove.setOnAction((ActionEvent e) -> {
	            Canvas NewCanvas = new Canvas();
	            NewCanvas.setWidth(900); NewCanvas.setHeight(550);
	            NewGC = NewCanvas.getGraphicsContext2D();
	            Stage NewStage = new Stage();
	            BorderPane NewBorderPane = new BorderPane();
	            Button NewButton = new Button("FallDown");
	            NewGC.setFill(Color.FORESTGREEN);
	            NewGC.fillOval(0, 0, 100, 100);
	            NewBorderPane.setTop(NewButton);
	            NewBorderPane.setCenter(NewCanvas);
	            Scene NewScene = new Scene(NewBorderPane, 900, 550);
	            NewStage.setScene(NewScene);
	            NewStage.show();

	            NewButton.setOnAction(t -> {
	                final double W = 900; // canvas dimensions.
	                final double H = 550;
	                final double D = 100;  // diameter.
	                DoubleProperty x  = new SimpleDoubleProperty();
	                DoubleProperty y  = new SimpleDoubleProperty();

	                Timeline timeline = new Timeline(
	                        new KeyFrame(Duration.seconds(1),
	                                new KeyValue(y, H - D)
	                        )
	                );
	                timeline.setAutoReverse(true);
	                timeline.setCycleCount(1);

	                AnimationTimer timer = new AnimationTimer() {
	                    @Override
	                    public void handle(long now) {
	                        NewGC = NewCanvas.getGraphicsContext2D();
	                        NewGC.setFill(Color.rgb(244, 244, 244));
	                        NewGC.fillRect(0, 0, W, H);
	                        NewGC.setFill(Color.FORESTGREEN);
	                        NewGC.fillOval(0, y.doubleValue(), D, D);
	                    }
	                };
	                NewStage.setScene(new Scene(new Group(NewCanvas)));
	                timer.start();
	                timeline.play();
	            });

	        });
			
			
			Label nameLbl = new Label("Enter your name:");
	        TextField nameFld = new TextField();
	        
	        Label msg = new Label();
	        msg.setStyle("-fx-text-fill: blue;");
	        
	        Button sayHelloBtn = new Button("Say Hello");
	        
	        
	        sayHelloBtn.setOnAction(e -> { 
	            String name = nameFld.getText();
	            if (name.trim().length() > 0) {
	                msg.setText("Hello " + name);
	            }
	            else {
	                msg.setText("Hello there");
	            }           
	        });
			
	        VBox root = new VBox();
	        
	        root.setSpacing(5);
	        root.getChildren().addAll(nameLbl, nameFld, msg);
			
			
			
			
			
			Button saveBtn = new Button("Save Image");
		    saveBtn.setOnAction(e -> saveToFile(canvas));
			
		
			
			
			
			text = new TextField();
			text.setPromptText("Enter your word");
			
			Slider slider = new Slider();
			slider.setMin(0);
			slider.setMax(20);
			slider.setValue(1);
			slider.setShowTickLabels(true);
			slider.setShowTickMarks(true);
			slider.setMajorTickUnit(20);
			slider.setMinorTickCount(5);
			
			slider.valueProperty().addListener(
		            (ObservableValue<? extends Number> ov, Number old_val, 
		            Number new_val) -> {
		            	num = new_val.intValue();
		        });
			
			
			drawRect.setOnAction(e -> chosen=1);
			drawCircle.setOnAction(e -> chosen=2);
			drawPen.setOnAction(e -> chosen=3);
			Eraser.setOnAction(e -> chosen=4);
			Triangle.setOnAction(e -> chosen=5);
			Line.setOnAction(e -> chosen=6);
			Text.setOnAction(e -> chosen=7);
			music.setOnAction(e -> chosen=9);
			
			
			colorP = new ColorPicker();
//			colorP.setValue(Color.GREEN);
			
			colorP.setOnAction(new EventHandler() {
				public void handle (Event t){
					cl = colorP.getValue();
					System.out.println(cl);
				}
			});
			
			comboBox = new ComboBox();
			comboBox.getItems().addAll("Times New Roman","Impact","Lucida Bright","Segoe Print", "Verdana", "Arial", "Helvetica", "Georgia");
			comboBox.setPromptText("Choose your style");
			comboBox.setMaxWidth(125);
			
			comboBox.setOnAction((Event ev) -> {
				 press =  comboBox.getSelectionModel().getSelectedItem().toString();
				 System.out.println(press);
			});
			
			VBox box = new VBox(3);
			box.getChildren().addAll(colorP, comboBox);
			
			
			
			VBox VB = new VBox(3);
			VB.getChildren().addAll(text, slider);

			
			HBox hbox = new HBox(10);
			hbox.getChildren().addAll(sayHelloBtn, root, drawRect, drawCircle, Triangle, drawPen, Eraser, Line, Text, music, box, VB, save, ToMove);
			BorderPane borderPane = new BorderPane();
			borderPane.setTop(hbox);
			borderPane.setCenter(canvas);
			primaryStage.setScene(new Scene(borderPane, 1300, 500));
			primaryStage.show();
			

			
			
			
			
//			drawRect.setOnMouseClicked(event ->{
//				Media sound = new Media(new File("C:\\Users\\User\\workspace\\Paint with Color\\src\\application\\button-46.mp3").toURI().toString());
//				MediaPlayer mediaplayer = new MediaPlayer(sound);
//				mediaplayer.play();
//			});
//			
//			drawCircle.setOnMouseClicked(event ->{
//				Media sound = new Media(new File("C:\\Users\\User\\workspace\\Paint with Color\\src\\application\\button-46.mp3").toURI().toString());
//				MediaPlayer mediaplayer = new MediaPlayer(sound);
//				mediaplayer.play();
//			});
//			drawPen.setOnMouseClicked(event ->{
//				Media sound = new Media(new File("C:\\Users\\User\\workspace\\Paint with Color\\src\\application\\button-46.mp3").toURI().toString());
//				MediaPlayer mediaplayer = new MediaPlayer(sound);
//				mediaplayer.play();
//			});
//			Eraser.setOnMouseClicked(event ->{
//				Media sound = new Media(new File("C:\\Users\\User\\workspace\\Paint with Color\\src\\application\\button-46.mp3").toURI().toString());
//				MediaPlayer mediaplayer = new MediaPlayer(sound);
//				mediaplayer.play();
//			});
//			Triangle.setOnMouseClicked(event ->{
//				Media sound = new Media(new File("C:\\Users\\User\\workspace\\Paint with Color\\src\\application\\button-46.mp3").toURI().toString());
//				MediaPlayer mediaplayer = new MediaPlayer(sound);
//				mediaplayer.play();
//			});
//			Line.setOnMouseClicked(event ->{
//				Media sound = new Media(new File("C:\\Users\\User\\workspace\\Paint with Color\\src\\application\\button-46.mp3").toURI().toString());
//				MediaPlayer mediaplayer = new MediaPlayer(sound);
//				mediaplayer.play();
//			});
//			Text.setOnMouseClicked(event ->{
//				Media sound = new Media(new File("C:\\Users\\User\\workspace\\Paint with Color\\src\\application\\button-46.mp3").toURI().toString());
//				MediaPlayer mediaplayer = new MediaPlayer(sound);
//				mediaplayer.play();
//			});
//			colorP.setOnMouseClicked(event ->{
//				Media sound = new Media(new File("C:\\Users\\User\\workspace\\Paint with Color\\src\\application\\Knock-Neverrai-8113_hifi.mp3").toURI().toString());
//				MediaPlayer mediaplayer = new MediaPlayer(sound);
//				mediaplayer.play();
//			});
//			slider.setOnMouseClicked(event ->{
//				Media sound = new Media(new File("C:\\Users\\User\\workspace\\Paint with Color\\src\\application\\Knock-Neverrai-8113_hifi.mp3").toURI().toString());
//				MediaPlayer mediaplayer = new MediaPlayer(sound);
//				mediaplayer.play();
//			});
//			music.setOnMouseClicked(event ->{
//				Media sound = new Media(new File("C:\\Users\\User\\workspace\\Paint with Color\\src\\application\\button-46.mp3").toURI().toString());
//				MediaPlayer mediaplayer = new MediaPlayer(sound);
//				mediaplayer.play();
//			});
//			text.setOnMouseClicked(event ->{
//				Media sound = new Media(new File("C:\\Users\\User\\workspace\\Paint with Color\\src\\application\\Knock-Neverrai-8113_hifi.mp3").toURI().toString());
//				MediaPlayer mediaplayer = new MediaPlayer(sound);
//				mediaplayer.play();
//			});
//			comboBox.setOnMouseClicked(event ->{
//				Media sound = new Media(new File("C:\\Users\\User\\workspace\\Paint with Color\\src\\application\\Knock-Neverrai-8113_hifi.mp3").toURI().toString());
//				MediaPlayer mediaplayer = new MediaPlayer(sound);
//				mediaplayer.play();
//			});
			
//			MediaView mediaView = new MediaView(mediaplayer);
//			
//			music.setOnAction((ActionEvent e) -> {
//	            FileChooser fc = new FileChooser();
//	            fc.getExtensionFilters().add(new ExtensionFilter("*.flv", "*.mp3", "*.mpeg"));
//	            File file = fc.showOpenDialog(null);
//	            String path = file.getAbsolutePath();
//	            path = path.replace("\\", "/");
//	            Media media = new Media(new File(path).toURI().toString());
//	            mediaplayer.stop();
//	            MediaPlayer toplay = new MediaPlayer(media);
//	            toplay.setAutoPlay(true);
//	            
//				mediaView.setMediaPlayer(toplay);
//			});

	}
	
	

	private Object saveToFile(Canvas canvas) {
		// TODO Auto-generated method stub
		return null;
	}



	public static void main(String[] args) {launch(args);}
	@Override

	public void handle(MouseEvent event){ 
		if(event.getEventType()==MouseEvent.MOUSE_PRESSED){
			x1 = event.getSceneX();
			y1 = event.getSceneY();
			gc.setFill(cl);
			gc.beginPath();
			System.out.println(event.getX()+"/"+ event.getY());
			
		}
		if(event.getEventType()==MouseEvent.MOUSE_RELEASED){
			x2 = event.getSceneX();
			y2 = event.getSceneY();
			gc.setFill(cl);
			if(chosen==1){
				gc.setLineWidth(num);
				gc.setStroke(cl);
//				gc.strokeLine(x1, y1-127, x1, y2-127);
//				gc.strokeLine(x1, y2-127, x2, y2-127);
//				gc.strokeLine(x2, y2-127, x2, y1-127);
//				gc.strokeLine(x1, y1-127, x2, y1-127);
				gc.strokeLine(x1, y1 - 67, x1, y2 - 67);
				gc.strokeLine(x1, y2 - 67, x2, y2 - 67);
				gc.strokeLine(x2, y2 - 67, x2, y1 - 67);
				gc.strokeLine(x1, y1 - 67, x2, y1 - 67);
			}
			

			
			

			if (chosen == 2) {
				gc.setStroke(cl);;
				gc.setLineWidth(num);
				gc.strokeOval(x1, y1- 67, x2 - x1, y2 - y1);
			}
			
			
			if(chosen==5){
				gc.setLineWidth(num);
				gc.setStroke(cl);
				gc.strokeLine(x1, y1-67, x2, y2-67);
				gc.strokeLine(x2, y2-67, Math.abs(x2-2*(x2-x1)), y2-67);
				gc.strokeLine(x1, y1-67, Math.abs(x2-2*(x2-x1)), y2-67);
			}
			if(chosen==6){
				gc.setLineWidth(num);
				gc.setStroke(cl);
				gc.strokeLine(x1, y1-67, x2, y2-67);	
			}
		}
		if(chosen==3){
			gc.setLineWidth(num);
			x1 = event.getSceneX();
			y1 = event.getSceneY();
			if(event.getEventType()==MouseEvent.MOUSE_DRAGGED){
				gc.setFill(cl);
				gc.lineTo(x1, y1-67);
				gc.stroke();
				
			}		
		}		
		
		if(chosen == 4){
			double x = event.getSceneX(), y = event.getSceneY()-26;
			if(event.getEventType() == MouseEvent.MOUSE_DRAGGED){
				gc.setStroke(Color.rgb(244,244,244));
				gc.setLineWidth(num);
				gc.lineTo(x ,y-67);
				gc.stroke();
			}		
		}
		
		if (chosen == 7) {
			if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
				gc.setFill(cl);
				String w = text.getText();
				gc.setFont(new Font(press, num));
				gc.fillText(w, x1, y1 -67);		
			}
		}
	}
}









