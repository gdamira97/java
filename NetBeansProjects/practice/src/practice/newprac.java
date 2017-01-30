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
public class newprac {
    
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1; i<=n;i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    for(int r=1; r<=n; r++){
                        if(i+j==k+r){
//                            System.out.println(i+" "+j+"\n"+k+" "+r);
                        }
                    }
                }
            }
        }
    }
}
