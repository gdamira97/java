/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Damira
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Stack a = new Stack();
//        a.push(3);
//        a.push(4);
//        a.show();
//        a.pop();
//        a.show();
//        Queue q = new Queue();
//        q.insert(2);
//        q.insert(1);
//        q.insert(5);
//        q.insert(4);
//        q.show();
//        q.indexOf(1);
//        q.contains(5);
//        q.remove();
//        q.show();
//        q.isEmpty();
//        q.size();
//        q.clear();
//        q.size();
//        q.isEmpty();
        Queue q = new Queue();
        q.insert(5);
        q.insert(4);
        q.insert(1);
        q.insert(6);
        q.show();
        q.indexOf(6);
        q.contains(6);
        q.remove();
        q.show();
        q.isEmpty();
        q.size();
        q.clear();
        q.size();
        q.isEmpty();
    }
}

//class Stack{
//    int []numbers = new int[100];
//    int size = 0;
//    public Stack(){
//        
//    }
//    public void push(int var){
//        size++;
//        numbers[size-1] = var;
//    }
//    public void pop(){
//        size--;
//    }
//    public void show(){
//        for(int i=0;i<size;i++){
//            System.out.println(numbers[i]);
//        }
//    }
//    public void clear(){
//        size =0;
//    }
//}
class  Queue{
    int[] numbers = new int[100];
    int size = 0; 
    public Queue(){
    }
    public void insert(int a){
        size++;
        numbers[size-1] = a;
    }
    public void remove(){
        for(int i=0; i<size; i++){
            numbers[i]=numbers[i+1];
        }
        size--;
    }
    public void clear(){
        size = 0;   
    }
    public void contains(int b){
        boolean c = Boolean.FALSE;
        for(int i=0; i<size; i++){
            if(numbers[i]==b){
                c = Boolean.TRUE;
            }
        }
        if(c==Boolean.TRUE){
            System.out.println("TRUE");
        }
        else{
            System.out.println("FALSE");
        }
    }
    public void isEmpty(){
    if(size==0){
        System.out.println("TRUE");
    }
    else{
        System.out.println("FALSE");
    }
    }
    public void indexOf(int a){
        for(int i=0; i<size; i++){
            if(a!=numbers[i]){
                System.out.println("Index is " + (i+1));
            }
        }
    }
    public void size(){
        System.out.println(size);
    }
    public int[] toArray(){
        int a = 0;
        int[] q = new int[size];
        for(int i=0; i<size; i++){
            q[a] = numbers[i];
            a++;
        }
        return q;
    }
    public void show(){
        for(int i=0;i<size;i++){
            System.out.println(numbers[i]);
        }
    }
}