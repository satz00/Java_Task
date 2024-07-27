package task3;

public class Employee implements Taxable{

    int empId;
    String name;
    double salary;

    Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        calcTax();
    }

    @Override
    public void calcTax() {
        double tax = incomeTax * salary;
        System.out.println("Your salary : " + salary);
        System.out.println("Income tax 10.5% : " + tax);
    }
}
