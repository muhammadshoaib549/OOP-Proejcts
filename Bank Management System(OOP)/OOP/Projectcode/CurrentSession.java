import java.io.*;
import java.util.Scanner;
@SuppressWarnings("resource")
public class CurrentSession {
    public static String accountNumber;
    public static String accountType;
    public static String specificInfo;
    public static String currentbalance;
    public static String customerId;
    public static String firstName;
    public static String lastName;
    public static String email;
    public static String password;
    public static String address;
    public static String phoneNumber;
    public static String ATMpin;

    public static boolean createSession(String email, String password) {
        boolean success = false;
        try {
            File file = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\accounts.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] credentials = line.split(",");
                if (credentials[7].equals(email) && credentials[8].equals(password)) {
                    accountNumber = credentials[0].trim();
                    accountType = credentials[1].trim();
                    specificInfo = credentials[2].trim();
                    currentbalance = credentials[3].trim();
                    customerId = credentials[4].trim();
                    firstName = credentials[5].trim();
                    lastName = credentials[6].trim();
                    CurrentSession.email = credentials[7].trim();
                    CurrentSession.password = credentials[8].trim();
                    address = credentials[9].trim();
                    phoneNumber = credentials[10].trim();
                    ATMpin = credentials[11].trim();
                    success = true;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("An unexpected Error occurred while creating session!");
            e.printStackTrace();
        }
        return success;
    }
    public static String[] getSessionData(){
        String[] sessionData = {accountNumber, accountType, specificInfo, currentbalance, customerId, firstName, lastName, email, password, address, phoneNumber, ATMpin};

        return sessionData;
    }
}