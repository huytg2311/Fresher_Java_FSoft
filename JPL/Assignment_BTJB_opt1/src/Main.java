import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();
        students.add(new Student("Ducky", 6));
        students.add(new Student("Clover", 9));
        students.add(new Student("Hugo", 7));
        students.add(new Student("Clover", 9));
        System. out. println(students) ;


    }}
class Student {
    String name;
    int age;
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString(){
        return "[" + this.name + ", " + this.age + "]";
    }
}
