import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
@SuppressWarnings("resource")
public class CustomerCredentials {
    public double getBalance(String accountNumber) {
        try {
            File f = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\accounts.txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] credentials = line.split(",");
                String accNum = credentials[0];
                if (accNum.equals(accountNumber)) {
                    return Double.parseDouble(credentials[3]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred! Please try again later");
            System.exit(0);
        }
        return 0;
    }

    public String getCustomerName(String accountNumber) {
        try {
            File f = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\accounts.txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] credentials = line.split(",");
                String accNum = credentials[0];
                if (accNum.equals(accountNumber)) {
                    return credentials[5] + " " + credentials[6];
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred! Please try again later");
            System.exit(0);
        }
        return "";
    }

    public double getOverdraftLimit(String accountNumber) {
        try {
            File f = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\accounts.txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] credentials = line.split(",");
                String accNum = credentials[0];
                if (accNum.equals(accountNumber)) {
                    return Double.parseDouble(credentials[2]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred! Please try again later");
            System.exit(0);
        }
        return 0;
    }

    public String getAccType(String accNum) {
        try {
            File file = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\accounts.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] credentials = line.split(",");
                if (credentials[0].equals(accNum)) {
                    return credentials[1];
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred! Please try again later");
            System.exit(0);
        }
        return "";
    }
}
