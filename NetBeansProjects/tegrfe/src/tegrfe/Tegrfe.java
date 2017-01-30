/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tegrfe;
import java.util.Scanner;

/**
 *
 * @author Damira
 */
public class Tegrfe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 1;
        int r = 0;
        while(c != t){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }
            int s1 = 0;
            int s2 = 0;
            for(int i=0; i<n; i++){
                for(int j = 0; j<i; j++){
                    s1+=a[j];
                }
                for(int k=n-1; k>i; k--){
                    s2+=a[k];
                }
                if(s1==s2){
                    r = 1;
                    break;
                }
            }
            if(r == 1){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            c++;
        }
    }
    
}
