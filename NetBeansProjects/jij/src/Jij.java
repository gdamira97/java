/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package jij;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Damira
 */
public class Jij {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        int m = sc.nextInt();
        int c = 0;
        
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            while(c<m){
                c+=a[i];
            }
        }
        if(c==m){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        
    }
}
