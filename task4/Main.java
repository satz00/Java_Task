package task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackExample se = new StackExample();
        se.addInStack(15);
        se.poppingInStack();
        se.checkEmpty();


        /*
        System.out.println("Enter the Name");
        String name= sc.next();
        System.out.println("Enter the Age");
        int age = sc.nextInt();

        try{
            Voter vo = new Voter( name, age);
            vo.printVoterDetails();
        }
        catch (InvalidAgeException e) {
            System.err.println(e.getMessage());
        }
         */

    }
}
