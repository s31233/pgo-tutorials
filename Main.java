import java.util.Calendar;
//Zadanie 3
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Jan", "Kowalski", 1990, 2010, "Pjatk", 2000d, 100d);
        System.out.println(manager);
    }
}
//Abstrakcyjna klasa Person
abstract class Person {
    protected String firstName;
    protected String lastName;
    protected int birthdayYear;

    public Person(String firstName, String lastName, int birthdayYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayYear = birthdayYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public abstract int getAge();
}
//Klasa Employee
class Employee extends Person {
    private int hireDate;
    private String companyName;
    private double salary;

    public Employee(String firstName, String lastName, int birthdayYear, int hireDate, String companyName, double salary) {
        super(firstName, lastName, birthdayYear);
        this.hireDate = hireDate;
        this.companyName = companyName;
        this.salary = salary;
    }

    public int getJobSeniority() {
        return Calendar.getInstance().get(Calendar.YEAR) - hireDate;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - birthdayYear;
    }
}
//Klasa Manager
class Manager extends Employee {
    private double bonus;

    public Manager(String firstName, String lastName, int birthdayYear, int hireDate, String companyName, double salary, double bonus) {
        super(firstName, lastName, birthdayYear, hireDate, companyName, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public String toString() {
        return "Manager with lastName " + getLastName() + " and age " + getAge() + " has salary " + getSalary();
    }
}