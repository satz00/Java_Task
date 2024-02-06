package task2;

public class Student {
    String name;
    int age = 18;

    Student (String name ) {
        this.name = name;
    }
    void display() {
        System.out.println("Name : " + this.name );
        System.out.println("Age : " + this.age );
    }

    public static void main(String[] args) {
        Student s1 = new Student("Jack");
        Student s2 = new Student("Rose");
        s1.display();
        s2.display();
    }
}
