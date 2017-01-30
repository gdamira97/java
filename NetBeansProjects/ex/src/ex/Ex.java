/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *-
 * @author Damira
 */
public class Ex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try (
//        while(true){
//        try{
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the first number: ");
//        int number1 = sc.nextInt();
//        System.out.print("Enter the second number: ");
//        int number2 = sc.nextInt();
//        int result = number1/number2;
//        System.out.println(result);
//        }catch(ArithmeticException e){
//            System.out.println("You cannot divide 2by 0. Try again!");
//        }
//        }
//          try{
//          String names[] = new String[]{"Saule", "Yerassyl", "Dayana", "Medet", "Zangar", "Agai"};
//          for(int i=0; i<7; i++){
//              System.out.println(names[i]);
//          }}catch(ArrayIndexOutOfBoundsException e){
//                  System.out.println("You pointed to unexisting index!"+e.getMessage());
//                  }
//            FileWriter writer = new FileWriter("names.txt")) {
//            PrintWriter pw = new PrintWriter(writer);
//            pw.println("Saule");
//            pw.println("Yerassyl");
//            pw.println("Medet");
//        }
            FileReader reader = new FileReader("names.txt")) {
            BufferedReader br = new BufferedReader(reader);
            String line;
            do{
                line = br.readLine();
                System.out.println(line);
            }while(line!=null);
        }
                
    }
    
}
