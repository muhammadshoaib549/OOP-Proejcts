
// Collections.sort(employees, new Comparator<Employee>() {
import java.io.Serializable;

// Comparable<Employee> For the Sorting Purposes
// Serializable for the Serialization purposes
public class Employee implements Serializable, Comparable<Employee> {
    // Comparable<Employee> =new Comparable<Employee>();
    // this is the Full object of the Comparable Class ANd Half of it Will be in the GUI class for the Compariosn of the IDS AND THE names

    private int id;
    private String name;
    private int age;
    private String position;
    private String Email;

    // A fully Parameterized Construtor for the Employee Attributes
    public Employee(int id, String name, int age, String position, String Email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.Email = Email;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return Email;
    }

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    // Override toString() for the Printing Purposes
    @Override
    public String toString() {
        // For having the Gap of the Two lines i used the "\n" "\n"
        return "ID of the Employee :: " + id + "\n" + "\n"
                + "Name of the Employee :: " + name + "\n" + "\n"
                + "Age of the Employee :: " + age + "\n" + "\n"
                + "Position of the Employee :: " + position + "\n" + "\n"
                + "Email of the Employee :: " + Email + "\n" + "\n"
                + ".......................................................\n";
    }

    // Implement compareTo() for sorting by employee ID
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    // But if we Want to Compare On the Basis OF the Names Of the Employees
    // .compareToIgnoreCase(String str) is a built-in method in Java that compares two strings without considering uppercase or lowercase differences
    public int compareTo1(Employee other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}
