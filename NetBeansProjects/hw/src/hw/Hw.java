/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author Damira
 */
public class Hw {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws  IOException {
                FileWriter w = new FileWriter("Копия names.txt");
                PrintWriter pw = new PrintWriter(w);
                Scanner r = new Scanner(new File("names.txt"));
                String line;
                while(r.hasNext()){
                line = r.nextLine();
                line = line.toLowerCase();
                line = line.replace("hello", "hi");
                System.out.println(line);
                pw.println(line);
                }
             w.close();
                }
            
    }       