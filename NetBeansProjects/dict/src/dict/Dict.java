/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dict;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Damira
 */
public class Dict {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Scanner r =new Scanner(new File("translator.txt"));
        while(true){
        System.out.print("Enter the word: ");
        String c = sc.next();
        String ff = "";
        while(r.hasNext()){
              String line2 = r.nextLine();  
              String lines2[] = line2.split("-");
              if(line2.contains(c)){
                  
                  ff = lines2[1];
                  break;
              }
    }
        System.out.println(ff);
        }
      
    }
}
