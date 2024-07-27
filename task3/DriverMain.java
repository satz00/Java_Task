package task3;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class DriverMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int choise;
        do {
            System.out.println("============================================");
            System.out.println("You want to calculate Income tax pres 1");
            System.out.println();
            System.out.println("You want to calculate sales tax press 2");
            System.out.println();
            System.out.println("Exit press 3");
            System.out.println("=============================================");
            choise = sc.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("Welcome to Income tax Calculation");
                    System.out.println("Enter your Employee Id");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Employee name");
                    String name = sc.nextLine();
                    System.out.println("Enter your salary");
                    double salary = sc.nextDouble();

                    Employee em = new Employee(id, name, salary);
                    break;

                case 2:
                    System.out.println("Welcome to sales tax Calculation");
                    System.out.println("Enter your product Id");
                    int pId = sc.nextInt();
                    System.out.println("Enter the Product price");
                    double price = sc.nextDouble();
                    System.out.println("Enter the Product quantity");
                    int quantity = sc.nextInt();

                    Product pr = new Product(pId, price, quantity);
                    break;

                case 3:
                    loop = false;
                    break;
            }
        }while (loop);
    }
}
