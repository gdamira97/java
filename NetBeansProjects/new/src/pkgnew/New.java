/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

/**
 *
 * @author Damira
 */
public class New {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws IOException {
//        Person p = new Person("Saule", 20);
//        ObjectOutputStream outputstream = new ObjectOutputStream(new FileOutputStream("data.bin"));
//        outputstream.writeObject(p);
//    }
//    
//}
//class Person implements Serializable{
//    String name;
//    int age;
//    public Person(String name, int age){
//        this.name=name;
//        this.age=age;
//    }
//}
//    public static void main(String[] args) throws IOException, ClassNotFoundException{
//        ObjectInputStream input = new ObjectInputStream(new FileInputStream("data.bin"));
//        Person p = (Person) input.readObject();
//        System.out.println(p.name+", "+p.age);
//    }
//}
    public static void main(String[] args){
        String[] array = new String[]{"A", "B", "C", "D"};
        printArray(array);
        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};
        printArray(numbers);
        Double[] num = new Double[]{1.1, 2.2, 3.3, 4.4, 5.5};
        printArray(num);
        System.out.println(max("A", "B", "C"));
    }
    public static < E > void printArray(E[] array){
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]+", ");
        }
        System.out.println();
    }
    public static <T extends Comparable<T> > T max(T a, T b, T z){
        T max=a;
        if(b.compareTo(max) > 0){
            max=b;
        }
        if(z.compareTo(max) > 0){
            max=z;
        }
        return max;
    }
}