/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

/**
 *
 * @author Damira
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Calculator c = new Calculator();
            AdvancedCalculator z = new AdvancedCalculator();
            z.multiply(2, 3);
            z.add(3, 4);
            z.add(1,2,3);
        }
}
class Calculator{
    public void add(int a, int b){
        int sum = a+b;
        System.out.println(sum);
    }
}
class AdvancedCalculator extends Calculator {
    public void multiply(int x, int y){
        int mult = x*y;
        System.out.println(mult);
    }
    public void add(int w, int p, int q){
        int sum = w+p+q;
        System.out.println(sum);
    }
}
