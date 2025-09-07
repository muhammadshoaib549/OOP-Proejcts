
//What is Serialization
//Matlab kay Appa Aik aik Entity No Store karvaan dee bajaye Sarayan entetiyan no Beyak Waqat Store karva Daye Daa Vaa Serialization
//Deserialization hundi vee kay Ussy hee Object No Retrieve kar lena Dobara Aur ethy vee Apa Aik aik de bjaye Poree Object he kari Daa Va
import java.io.*;
import java.util.ArrayList;

public class EmployeeDataHandler {

    // Lets Set the Design of the File here
    //Static Final may Mane File ko Already Fixed Position may kar dya ha So that I can Operate All the Crud operations on it
    private static final String FILE_NAME = "S:\\Discrete Maths\\employees.ser"; // ✅ kept same

    // Write all employees to the file using Serialization
    private static void writeAll(ArrayList<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.err.println("Error while writing the Data to the file " + e.getMessage());
        }
    }

    //Adding the employee Now
    public static void addEmployee(Employee emp) throws IOException {
        ArrayList<Employee> employees = readEmployees();
        employees.add(emp);
        writeAll(employees);
    }

    // Read all employees from the file using Serialization
    public static ArrayList<Employee> readEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return employees;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (ArrayList<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while reading data from the file: " + e.getMessage());
        }
        return employees;
    }

    // Update an existing employee
    public static boolean updateEmployee(Employee updatedEmp) throws IOException {
        ArrayList<Employee> employees = readEmployees();
        boolean found = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == updatedEmp.getId()) {
                employees.set(i, updatedEmp);
                found = true;
                break;
            }
        }
        if (found) {
            writeAll(employees);
        }
        return found;
    }

    // Performing the Deleting on the Basis of the Identifying the ID
    public static boolean deleteEmployee(int id) throws IOException {
        ArrayList<Employee> employees = readEmployees();
        boolean removed = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                removed = true;
                break;
            }
        }
        if (removed) {
            writeAll(employees);
        }
        return removed;
    }
}
