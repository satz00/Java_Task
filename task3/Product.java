package task3;

public class Product implements Taxable{
    int pid;
    double price;
    int quantity;

    Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
        calcTax();
    }

    @Override
    public void calcTax() {
        price *= quantity;
        double tax = saleTax * price;
        System.out.println("Product quantity : " + quantity);
        System.out.println("Product cost : " + price);
        System.out.println("sales tax 7% : " + tax);
    }
}
