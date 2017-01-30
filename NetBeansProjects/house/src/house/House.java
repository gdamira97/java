/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package house;

/**
 *
 * @author Damira
 */
public class House {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Door d = new Door("white");
       // d.ShowData();
        //Houses h = new Houses(500, d);
       // h.ShowData();
       // h.getDoor();
       SmallApartment s = new SmallApartment();
        Person p = new Person("Bob", s);
        p.ShowData();
    }
}
    
class Houses{
    int area;
    private final Door d;
    public Houses(int area, Door d){
        this.area=area;
        this.d=d;
    }
    public void ShowData(){
        System.out.println("I am a house, my area is " + area + " m2");
    }
    public void setArea(int area){
        this.area=area;
    }
    public int getArea(){
        return area;
    }
    public String getDoor(){
        return d.getColor();
    }
}
class Door{
    String color;
    public Door(String color){
        this.color=color;
    }
    public void ShowData(){
        System.out.println("I am a door, my color is " + color);
    }
    public void setColor(String color){
        this.color=color;
    }
    public String getColor(){
        return color;
    }
}
class Person{
    String name;
    private final Houses h;
    public Person(String name, Houses h){
        this.name=name;
        this.h=h;
    }
    public void ShowData(){
        System.out.println("My name is " + name + ", the area of my house is " + h.getArea() + " and the color of my door is " + h.getDoor());
    }
    
}
class SmallApartment extends Houses{
    public SmallApartment() {
       super(50, new Door("brown")); 
    }
}
