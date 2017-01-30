/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.util.Scanner;

/**
 *
 * @author Damira
 */
public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter course name: ");
//        String name = sc.next();
//        System.out.print("Enter e period: ");
//        int per = sc.nextInt();
//        System.out.print("Enter cdits No: ");
//        int cr = sc.nextInt();
//        System.out.println(name + " " + period + " " + cr);
          Course c = new Course("Java", 2016, 3);
          c.list();
    }
}
class Course{
    String name;
    int per;
    int cr;
    public Course(String name, int per, int cr){
        this.name=name;
        this.per=per;
        this.cr=cr;
    }
    public void list(){
        System.out.println(name + " " + per + " " + cr);
    }
}
