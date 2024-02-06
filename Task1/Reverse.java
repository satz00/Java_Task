public class Reverse {
    public static void main(String[] args) {
        int rev = 876;
        int sum = 0;

        for (int i = 0; rev > 0; i++) {
            int bla = rev % 10;
            sum = (sum*10) + bla;
            rev /= 10;
        }
        System.out.println("Reversed Value :" + sum);

    }
}
