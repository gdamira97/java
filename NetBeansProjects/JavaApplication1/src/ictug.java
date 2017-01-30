
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Damira
 */
public class ictug {
    public static void Main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int a = 0;
        int b = 0;
        
        if(n%2 == 0){
            b = n;
            m = m-n;
            if(m%2 == 0){
                a = m;
            }
            else{
                a = m-1;
            }
        }
    }
}
