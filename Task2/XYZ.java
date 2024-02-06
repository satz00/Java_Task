package task2;

public class XYZ {
    public static int findProductIdWithHighestPrice(Product[] products) {
        double maxPrice = Double.MIN_VALUE;
        System.out.println(maxPrice);
        int maxPid = -1;

        for (Product product : products) {
            if (product.price > maxPrice) {
                maxPrice = product.price;
                maxPid = product.pid;
            }
        }

        return maxPid;
    }

    public static double calculateTotalAmountSpent(Product[] products) {
        double totalAmount = 0;

        for (Product product : products) {
            totalAmount += product.price * product.quantity;
        }

        return totalAmount;
    }
}
