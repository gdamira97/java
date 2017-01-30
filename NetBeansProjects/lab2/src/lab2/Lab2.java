/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Damira
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person p = new Person("Damira", "Gabdrash", 15, "F");
        p.setAge(18);
        p.getAge();
        String a = p.toString();
        System.out.println(a);
        Student s = new Student("Yessen", "Alimtayev", 18, "M", 15951,4.0);
        String b = s.toString();
        System.out.println(b);
        Teacher t = new Teacher("Darkhan", "Kuanyshbay", 22, "M", 100000);
        t.setSalary(200000);
        t.getSalary();
        String c = t.toString();
        System.out.println(c);
        CollegeStudent cs = new CollegeStudent("Ffvs", "Gfghd", 17, "F", 14034, 3.8, "eng");
        cs.setLanguage("rus");
        cs.getLanguage();
        String d = cs.toString();
        System.out.println(d);
    }

}
class Person {
    String name;
    String surname;
    int age;
    String gender;
    public Person(String name, String surname, int age, String gender){
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.gender=gender;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public String getSurname(){
        return surname;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getGender(){
        return gender;
    }
    @Override
    public String toString(){
        return name + " " + surname + " " + age + " " + gender;
    }
}
class Student extends Person{
    int id;
    double GPA;
    public Student(String name, String surname, int age, String gender, int id, double GPA) {
        super(name, surname, age, gender);
        this.id=id;
        this.GPA=GPA;
    }
    public void setID(int id){
        this.id=id;
    }
    public int getID(){
        return id;
    }
    public void setGPA(float GPA){
        this.GPA=GPA;
    }
    public double getGPA(){
        return GPA;
    }
    @Override
    public String toString(){
        return name + " " + surname + " " + age + " " + gender + " "+ id + " " + GPA;
    }
}
class Teacher extends Person{
    int salary;
    public Teacher(String name, String surname, int age, String gender, int salary) {
        super(name, surname, age, gender);
        this.salary = salary;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public int getSalary(){
        return salary;
    }
    @Override
    public String toString(){
        return name + " " + surname + " " + age + " " + gender + " "+ salary;
    }
}
class CollegeStudent extends Student{
    String language;
    public CollegeStudent(String name, String surname, int age, String gender, int id, double GPA, String language) {
        super(name, surname, age, gender, id, GPA);
        this.language=language;
    }
    public void setLanguage(String language){
        this.language=language;
    }
    public String getLanguage(){
        return language;
    }
    @Override
    public String toString(){
        return name + " " + surname + " " + age + " " + gender + " "+ id + " " + GPA + " " + language;
    }
}
