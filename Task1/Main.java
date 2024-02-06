import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total amount");
        int n = sc.nextInt();
        double discount = 0;

        if (n >= 1000) {
            discount = (.20 * n);
            n = (int) (n - discount);
            System.out.println("You will get 20% Discount in your total amount is :" + n);
        } else if (n > 500 && n <= 1000) {
            discount = (.10 * n);
            n = (int) (n - discount);
            System.out.println("You will get  10% Discount in your total amount is :" + n);
        } else
            System.out.println("You purchase below 500 so no Discount is apply ");

    }
    }

