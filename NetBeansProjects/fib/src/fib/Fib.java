/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fib;

import java.util.Scanner;

/**
 *
 * @author Damira
 */
public class Fib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, r = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n>=0 && n<47){
//            if(n==1 || n==0){
//                r=1;
//            }
//            else{
                r = F(n-1)+F(n-2);
                System.out.println(r);
//            }
    }
        else{
            System.out.println("Out of range");
        }
    }
    public static int F(int m){
        if(m<=1){
                return m;
        }
        else{
            return F(m-1)+F(m-2);
        }
    }
}
