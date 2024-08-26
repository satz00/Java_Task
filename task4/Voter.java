package task4;

public class Voter {
    int voterId = 0;
    String name;
    int age;

    Voter(String name, int age) throws InvalidAgeException {
        this.name = name;
        if (age < 18) {
            throw new InvalidAgeException("Invalid age for voter");
        } else
            this.age = age;
        System.out.println("Successfully voter id is create");
        voterId++;
    }
    public void printVoterDetails() {
        System.out.println("Voter id: " + voterId );
        System.out.println("Voter name: " + name);
        System.out.println("Voter age: " + age);
    }
}
