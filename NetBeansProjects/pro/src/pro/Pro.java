/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Pro extends Application {
static Font FONT = Font.font("", FontWeight.BOLD, 18);
VBox menuBox;
int currentItem = 0;
MenuItem one;
MenuItem two;
MenuItem op;
private final ScheduledExecutorService bgThread = Executors.newSingleThreadScheduledExecutor();

public Parent createContent() {
Pane root = new Pane();
root.setPrefSize(900, 600);
Rectangle bg = new Rectangle(900, 600);
ImageView img1 = new ImageView(new Image("darwinop.gif", 300, 300, true, true));
ContentFrame frame2 = new ContentFrame(createMiddleContent());
ImageView img2 = new ImageView(new Image("pythagorusop.gif", 300, 350, true, true));
HBox hbox = new HBox(img1, frame2, img2);
        hbox.setTranslateX(108);
        hbox.setTranslateY(50);
MenuItem itemExit = new MenuItem("EXIT");
        itemExit.setOnActivate(() -> System.exit(0));
        menuBox = new VBox(10);
        one = new MenuItem("ONE PLAYER");
        two = new MenuItem("TWO PLAYER");
        op = new MenuItem("OPTIONS");
menuBox.getChildren().addAll(one, two, op, itemExit);
        menuBox.setAlignment(Pos.TOP_CENTER);
        menuBox.setTranslateX(360);
        menuBox.setTranslateY(360);
//        menuBox.setMargin(one, new Insets(50, 0, 0, 0));
        getMenuItem(0).setActive(true);
        root.getChildren().addAll(bg, hbox, menuBox);
return root;
    }

public Node createMiddleContent() {
String title = "Science Kombat";
HBox letters = new HBox(0);
        letters.setAlignment(Pos.CENTER);
for (int i = 0; i < title.length(); i++) {
Text letter = new Text(title.charAt(i) + "");
            letter.setFont(FONT);
            letter.setFill(Color.WHITE);
            letters.getChildren().add(letter);
TranslateTransition tt = new TranslateTransition(Duration.seconds(2), letter);
            tt.setDelay(Duration.millis(i * 50));
            tt.setToY(-25);
            tt.setAutoReverse(true);
            tt.setCycleCount(TranslateTransition.INDEFINITE);
            tt.play();
        }
return letters;
    }

public MenuItem getMenuItem(int index) {
return (MenuItem)menuBox.getChildren().get(index);
    }

public static class ContentFrame extends StackPane {
public ContentFrame(Node content) {
            setAlignment(Pos.CENTER);
Rectangle frame = new Rectangle(200, 200);
            frame.setArcWidth(25);
            frame.setArcHeight(25);
            frame.setStroke(Color.WHITESMOKE);
            getChildren().addAll(frame, content);
        }
    }

public static class MenuItem extends HBox {
public final TriCircle c1 = new TriCircle(), c2 = new TriCircle();
public final Text text;
public Runnable script;
public MenuItem(String name) {
super(15);
            setAlignment(Pos.CENTER);
            text = new Text(name);
            text.setFont(FONT);
            text.setEffect(new GaussianBlur(2));
            getChildren().addAll(c1, text, c2);
            setActive(false);
            setOnActivate(() -> System.out.println(name + " activated"));
        }
public void setActive(boolean b) {
            c1.setVisible(b);
            c2.setVisible(b);
            text.setFill(b ? Color.WHITE : Color.GREY);
        }
public void setOnActivate(Runnable r) {
            script = r;
        }
public void activate() {
if (script != null)
                script.run();
        }
    }
public static class TriCircle extends Parent {
public TriCircle() {
Shape shape1 = Shape.subtract(new Circle(5), new Circle(2));
            shape1.setFill(Color.WHITE);
Shape shape2 = Shape.subtract(new Circle(5), new Circle(2));
            shape2.setFill(Color.WHITE);
            shape2.setTranslateX(5);
Shape shape3 = Shape.subtract(new Circle(5), new Circle(2));
            shape3.setFill(Color.WHITE);
            shape3.setTranslateX(2.5);
            shape3.setTranslateY(-5);
            getChildren().addAll(shape1, shape2, shape3);
            setEffect(new GaussianBlur(2));
        }
    }
@Override
public void start(Stage primaryStage) throws Exception {
Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(event -> {
if (event.getCode() == KeyCode.UP) {
if (currentItem > 0) {
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(--currentItem).setActive(true);
                }
            }
if (event.getCode() == KeyCode.DOWN) {
if (currentItem < menuBox.getChildren().size() - 1) {
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(++currentItem).setActive(true);
                }
            }
if (event.getCode() == KeyCode.ENTER) {
                getMenuItem(currentItem).activate();
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> {
            bgThread.shutdownNow();
        });
        primaryStage.setResizable(false);
        primaryStage.show();
//        Scene scene1 = new Scene(createContent());
//        Label ch = new Label();
//        ch.setText("Choose a scientist");
//        one.setOnActivate(() -> primaryStage.setScene(scene1));
    }
public static void main(String[] args) {
        launch(args);
    }
}
