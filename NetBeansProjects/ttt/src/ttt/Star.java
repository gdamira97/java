/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt;

/**
 *
 * @author Damira
 */
public class Star extends Thread {
    @Override
    public void run(){
        for(int i=0; i<=4; i++){
            for(int j=0; j<i; j++){
            System.out.print("*");
            }
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println();
        }
        super.run();
    }
}
