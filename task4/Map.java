package task4;

import java.util.HashMap;
import java.util.Scanner;

public class Map {
    public static void main(String[] args) {
        HashMap<String, Integer > hash = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int choice;
        do {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Add a new student press 1 ");
            System.out.println("Remove student press 2");
            System.out.println("Display list all the student press 3");
            System.out.println("Exit press 4");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the student name ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter the Grade in Integer");
                    int grade = sc.nextInt();
                    hash.put(name , grade);
                    System.out.println("Successfully student is added in the list");
                    break;

                case 2:
                    System.out.println("Enter the student name ");
                    sc.nextLine();
                    String reName = sc.nextLine();
                    hash.remove(reName);
                    System.out.println("Successfully student is Removed in the list");
                    break;

                case 3:
                    System.out.println(hash);
                    break;

                case 4:
                    loop = false;
            }

        }while (loop);
    }
}
