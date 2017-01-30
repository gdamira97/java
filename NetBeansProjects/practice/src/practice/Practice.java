/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.Scanner;

/**
 *
 * @author Damira
 */
public class Practice {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long l1;
        long l2;
        long r1;
        long r2;
        long k;
        long t=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input l1, r1, l2, r2, k:");
        l1 = sc.nextLong();
        r1 = sc.nextLong();
        l2 = sc.nextLong();
        r2 = sc.nextLong();
        k = sc.nextLong();
        
        if(k>=l1 && k<=r2 || k>=r1 && k<=l2){
//            if(k == l1)
//                t= Math.abs(l2-(r1+1));
//            else
                t= Math.abs(l2-(r1+1))-1;
        }
        else{
            t = Math.abs(l2-(r1+1));
        }
        System.out.println(t);
    }
    
}
