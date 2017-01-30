/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Damira
 */
public class Calcul extends Application {
    int a=0, b=0;
    float r = 0;
    boolean firstnumber = false;
    int k = 0;
    String s = "";
    
    @Override
    public void start(Stage primaryStage) {
        
        TextField txt = new TextField();
        Button c = new Button("C");
        Button n = new Button("+/-");
        Button p = new Button("%");
        Button div = new Button("/");
        Button mult = new Button("*");
        Button sub= new Button("-");
        Button add = new Button("+");
        Button result = new Button("=");
        Button zero = new Button("0");
        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        
        txt.setPrefWidth(200);
        txt.setPrefHeight(50);
        c.setPrefWidth(50);
        c.setPrefHeight(50);
        n.setPrefWidth(50);
        n.setPrefHeight(50);
        p.setPrefWidth(50);
        p.setPrefHeight(50);
        div.setPrefWidth(50);
        div.setPrefHeight(50);
        mult.setPrefWidth(50);
        mult.setPrefHeight(50);
        sub.setPrefWidth(50);
        sub.setPrefHeight(50);
        add.setPrefWidth(50);
        add.setPrefHeight(50);
        result.setPrefWidth(100);
        result.setPrefHeight(50);
        zero.setPrefWidth(100);
        zero.setPrefHeight(50);
        one.setPrefWidth(50);
        one.setPrefHeight(50);
        two.setPrefWidth(50);
        two.setPrefHeight(50);
        three.setPrefWidth(50);
        three.setPrefHeight(50);
        four.setPrefWidth(50);
        four.setPrefHeight(50);
        five.setPrefWidth(50);
        five.setPrefHeight(50);
        six.setPrefWidth(50);
        six.setPrefHeight(50);
        seven.setPrefWidth(50);
        seven.setPrefHeight(50);
        eight.setPrefWidth(50);
        eight.setPrefHeight(50);
        nine.setPrefWidth(50);
        nine.setPrefHeight(50);
        
        HBox box1 = new HBox(c, n, p, div);
        HBox box2 = new HBox(seven, eight, nine, mult);
        HBox box3 = new HBox(four, five, six, sub);
        HBox box4 = new HBox(one, two, three, add);
        HBox box5 = new HBox(zero, result);
        
        VBox vbox = new VBox(txt, box1, box2, box3, box4, box5);
        
        Pane root = new Pane(vbox);
        root.getChildren().addAll();
        
        primaryStage.setScene(new Scene(root, 200, 300));
        primaryStage.show();
        
        c.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                s = "";
                txt.setText(s);
//                r = 0;
            }
        });
        
        one.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                s = s + 1;
                txt.setText(s);
                a = Integer.parseInt(s);
            }
        });
        two.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                s = s + 2;
                txt.setText(s);
                a = Integer.parseInt(s);
            }
        });
        three.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                s = s + 3;
                txt.setText(s);
                a = Integer.parseInt(s);
            }
        });
        four.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                s = s + 4;
                txt.setText(s);
                a = Integer.parseInt(s);
            }
        });
        five.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                s = s + 5;
                txt.setText(s);
                a = Integer.parseInt(s);
            }
        });
        six.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                s = s + 6;
                txt.setText(s);
                a = Integer.parseInt(s);
            }
        });
        seven.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                s = s + 7;
                txt.setText(s);
                a = Integer.parseInt(s);
            }
        });
        eight.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                s = s + 8;
                txt.setText(s);
                a = Integer.parseInt(s);
            }
        });
        nine.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                s = s + 9;
                txt.setText(s);
                a = Integer.parseInt(s);
            }
        });
        
        n.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                int e = a * (-1);
                txt.setText(Integer.toString(e));
            }
        });
        p.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                r = (float) (a * 0.01);
                txt.setText(Float.toString(r));
            }
        });
        div.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                k = 1;
            }
        });
        mult.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                k = 2;
            }
        });
        sub.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                k = 3;
            }
        });
        add.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                k = 4;
            }
        });
        
        if(k!=0){
            txt.setText("");
            firstnumber = true;
        }
        if(firstnumber == true){
           one.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                b = 1;
                s = s + 1;
                txt.setText(s);
            }
        });
        two.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                b = 2;
                s = s + 2;
                txt.setText(s);
            }
        });
        three.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                b = 3;
                s = s + 3;
                txt.setText(s);
            }
        });
        four.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                b = 4;
                s = s + 4;
                txt.setText(s);
            }
        });
        five.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                b = 5;
                s = s + 5;
                txt.setText(s);
            }
        });
        six.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                b = 6;
                s = s + 6;
                txt.setText(s);
            }
        });
        seven.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                b = 7;
                s = s + 7;
                txt.setText(s);
            }
        });
        eight.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                b = 8;
                s = s + 8;
                txt.setText(s);
            }
        });
        nine.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                b = 9;
                s = s + 9;
                txt.setText(s);
            }
        }); 
        }
        
        result.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                switch (k){
                    case 1:
                        r = a/b;
                        txt.setText(Float.toString(r));
                        break;
                    case 2:
                        r = a*b;
                        txt.setText(Float.toString(r));
                        break;
                    case 3:
                        r = a-b;
                        txt.setText(Float.toString(r));
                        break;
                    case 4:
                        r = a+b;
                        txt.setText(Float.toString(r));
                        break;
                }
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
