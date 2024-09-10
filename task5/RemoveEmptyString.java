package task5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveEmptyString {
    public static void main(String[] args) {
        List <String> string = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

        List <String> nonEmptyString = string.stream().filter(s -> !s.isEmpty()).toList();

        System.out.println(nonEmptyString);
    }
}
