package task2;

public class Employee extends Person{
    double salary;
    int employeeId;

    Employee(String name, int age, double salary, int employeeId){
        super.name = name;
        super.age = age;
        this.salary = salary;
        this.employeeId = employeeId;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Employee Id: " + employeeId);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        Employee em = new Employee("Jack", 26, 15000, 124);
        em.print();
    }
}
