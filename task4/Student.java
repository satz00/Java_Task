package task4;

import java.sql.SQLOutput;
import java.util.regex.Pattern;

public class Student {
    int rollNo;
    String name;
    int age;
    String course;

    Student(int rollNo, String name, int age, String course ) throws InvalidNameException, InvalidAgeException{
        this.rollNo = rollNo;
        if(name == null || name.isEmpty() || Pattern.matches(".*[^a-zA-Z].*", name)) {
            throw new InvalidNameException("Name not Valid" );
        }else {
            this.name= name;
        }
        if(age < 15 || age > 21){
            throw new InvalidAgeException("Age not within the Range ");
        }else {
            this.age = age;
        }
        this.course = course;
    }

}

