package task5;

import java.util.Arrays;
import java.util.List;

public class Gift {
    public static void main(String[] args) {
        List <String> names = Arrays.asList("Alice", "Bob", "Anna", "Steve", "Abe", "Charlie", "Alex", "Angela", "Brian", "Ava");

        List <String> selectedNames = names.stream().filter(name -> name.startsWith("A")).toList();
        System.out.println("Selected student names: " + selectedNames);

    }
}
