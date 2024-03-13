package task2;

public class Account {

    String name;
    int accNo;
    double amount = 0;

    Account() {
        name = "sathish";
        accNo = 12345678;
    }

    Account(String name, int accNo) {
        this.name  = name;
        this.accNo = accNo;

    }

    public double deposit(double deposit) {
        amount += deposit;
        System.out.println("=============================================");
        System.out.println("Amount is successfully Created in your Account");
        System.out.println("==============================================");
        return amount;
    }

    public double withdraw(double withdraw) {
        amount -= withdraw;
        System.out.println("=============================================");
        System.out.println("Amount is successfully debited in your account");
        System.out.println("==============================================");
        return amount;
    }

    public void balance() {
        System.out.println("Account Name : " + name);
        System.out.println("Account Number : "+ accNo);
        System.out.println("Your account balance is : "+ amount);
    }

    public static void main(String[] args) {
        Account ac = new Account();
        ac.balance();
        ac.deposit(2000);
        ac.balance();
        ac.withdraw(1000);
        ac.balance();
    }
}
