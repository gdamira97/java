/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import static java.lang.System.in;
import java.util.Scanner;


/**
 *
 * @author Damira
 */
public class JavaApplication15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, r = 1;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n>=0 && n<13){
//            if(n==0){
//                r=1;
//            }
//            for(int i=1; i<=n; i++){
//                r*=i;
//            }
            System.out.println(fact(n));
//            System.out.println(r);
        } else {
            System.out.println("Out of range");
        }
    }
    public static int fact(int m) { 
    if (m == 1 || m == 0)
    {
        return 1; 
    }
    else
    return m * fact(m-1); 
} 
    
}
