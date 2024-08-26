package task4;

import java.util.Scanner;

public class Weekdays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String week [] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        boolean choice = true;
        do {
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println("Enter the number between 0-6");
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            if (choice) {
                try {
                    System.out.println("Enter the number ");
                    int index = sc.nextInt();
                    System.out.println("Enter number Day: " + week[index]);
                    System.out.println();
                }catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Enter the number 0-6 only. Don't enter more then that.");
                }
            }
        }while (choice);
    }
}
