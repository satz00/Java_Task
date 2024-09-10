package task5;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        System.out.println("Enter your birthday (yyyy-mm-dd):");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        LocalDate dob = LocalDate.parse(input);
        calculateAge(dob);
    }

    public static void calculateAge(LocalDate dob) {
        LocalDate curDate = LocalDate.now();
        if (dob != null) {
            Period period = Period.between(dob, curDate);
            System.out.printf("You age is: %d years %d Months %d days. ", period.getYears(), period.getMonths(), period.getDays());
        }
        else
            System.out.println("Enter the correct DOB");
    }
}
