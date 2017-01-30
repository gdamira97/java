/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translator;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Damira
 */
public class Translator extends Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    ListView<String> list = new ListView<String>();
    ObservableList<String> items = FXCollections.observableArrayList (
            "apple-яблоко-алма", "flower-цветок-гүл", "girl-девушка-қыз", "boy-мальчик-ұл", "laptop-ноутбук-ноутбук", "phone-телефон-телефон", "banana-банан-банан", "dictionary-словарь-сөздік", "star-звезда-жұлдыз");
    TextField txt = new TextField();
    final ToggleGroup group = new ToggleGroup();
    final ToggleGroup gr = new ToggleGroup();
    RadioButton a = new RadioButton();
    RadioButton b = new RadioButton();
    RadioButton c = new RadioButton();
    RadioButton d = new RadioButton();
    RadioButton e = new RadioButton();
    RadioButton f = new RadioButton();
    ListView<String> t = new ListView<>();
    Label l1 = new Label("From:");
    Label l2 = new Label("To:");
    @Override
    public void start(Stage primaryStage) {
        for(int j=0; j<0; j++){
            String[] s = items.get(j).split("-");
            items.add(s[0]);
        }
        primaryStage.setTitle("Dictionary");
        l1.setLayoutX(0);
        l1.setLayoutY(0);
        l2.setLayoutX(0);
        l2.setLayoutY(20);
        a.setText("English");
        a.setSelected(true);
        a.setLayoutX(40);
        a.setLayoutY(0);
        a.setToggleGroup(group);
        b.setText("Русский");
        b.setLayoutX(110);
        b.setLayoutY(0);
        b.setToggleGroup(group);
        c.setText("Қазақша");
        c.setLayoutX(190);
        c.setLayoutY(0);
        c.setToggleGroup(group);
        d.setText("English");
        d.setLayoutX(40);
        d.setLayoutY(20);
        d.setToggleGroup(gr);
        e.setText("Русский");
        e.setSelected(true);
        e.setLayoutX(110);
        e.setLayoutY(20);
        e.setToggleGroup(gr);
        f.setText("Қазақша");
        f.setLayoutX(190);
        f.setLayoutY(20);
        f.setToggleGroup(gr);
        txt.setLayoutX(0);
        txt.setLayoutY(40);
        txt.setPrefHeight(15);
        txt.setPrefWidth(500);
        list.setLayoutX(0);
        list.setLayoutY(70);
        list.setPrefWidth(250);
        t.setLayoutX(250);
        t.setLayoutY(70);
        t.setPrefWidth(250);
        Pane x = new Pane();
        list.setItems(items);
        x.getChildren().addAll(l1, l2, a, b, c, d, e, f, txt,list, t);
        Scene s = new Scene(x);
        primaryStage.setScene(s);
        primaryStage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }
    void update(){
        ObservableList<String> items2 = FXCollections.observableArrayList ();
        String stroke=txt.getText();
//        if(stroke.equals("")){
//            list.setItems(items);
//        }
//        else{
    list.setOnMouseClicked(e-> some());
    if(a.isSelected()){
    for(int i=0;i<items.size();i++){
        if(items.get(i).toLowerCase().contains(stroke.toLowerCase())){
            String[] z = items.get(i).split("-");
            items2.add(z[0]);
        }
    }
    }
    if(b.isSelected()){
    for(int i=0;i<items.size();i++){
        if(items.get(i).toLowerCase().contains(stroke.toLowerCase())){
            String[] z = items.get(i).split("-");
            items2.add(z[1]);
        }
    }
    }
    if(c.isSelected()){
    for(int i=0;i<items.size();i++){
        if(items.get(i).toLowerCase().contains(stroke.toLowerCase())){
            String[] z = items.get(i).split("-");
            items2.add(z[2]);
        }
    }
    }
            list.setItems(items2);
//            t.setItems(items3);
//for(int i=0;i<items.size();i++){
//    if(items.get(i).toLowerCase().contains(list.getSelectionModel().getSelectedItem())){
//        String[] z = items.get(i).split("-");
//        items3.add(z[1]);
//    }
//}
//t.setItems(items3);
//        }
    }
    void some(){
        ObservableList<String> items3 = FXCollections.observableArrayList ();
        if(d.isSelected()){
        for(int i=0;i<items.size();i++){
        if(items.get(i).toLowerCase().contains(list.getSelectionModel().getSelectedItem())){
            String[] z = items.get(i).split("-");
            items3.add(z[0]);
        }
    }
        }
        if(e.isSelected()){
        for(int i=0;i<items.size();i++){
        if(items.get(i).toLowerCase().contains(list.getSelectionModel().getSelectedItem())){
            String[] z = items.get(i).split("-");
            items3.add(z[1]);
        }
    }
        }
        if(f.isSelected()){
        for(int i=0;i<items.size();i++){
        if(items.get(i).toLowerCase().contains(list.getSelectionModel().getSelectedItem())){
            String[] z = items.get(i).split("-");
            items3.add(z[2]);
        }
    }
        }
        t.setItems(items3);
}
}