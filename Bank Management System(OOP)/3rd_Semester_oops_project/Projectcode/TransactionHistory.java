import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

@SuppressWarnings("resource")
public class TransactionHistory {

    public static boolean createTransactionHistory(int transactionId, String accNum, String action, double amount,
            String description, String dateTime) {
        DecimalFormat df = new DecimalFormat("0.00");
        String tId, acc, act, amnt, desc, dt;
        tId = (Integer.toString(transactionId)).trim();
        acc = accNum.trim();
        act = action.trim();
        amnt = df.format(amount).trim();
        desc = description.trim();
        dt = dateTime.trim();
        try (FileWriter fw = new FileWriter("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\transaction_history.txt", true)) {
            fw.write(tId + "," + acc + "," + act + "," + amnt + "," + desc + "," + dt + "\n");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred! Please try again later");
            System.exit(0);
        }
        return false;
    }

    public static void generateTransactionHistory(String accountNumber) {

        try {
            File file = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\transaction_history.txt");
            Scanner sc = new Scanner(file);
            System.out.println("");
            System.out.println("---Transaction History---");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] credentials = line.split(",");
                if (credentials[1].equals(accountNumber)) {
                    System.out.println("");
                    System.out.println("Transaction Id: " + credentials[0]);
                    System.out.println("Action: " + credentials[2]);
                    System.out.println("Amount Paid: " + credentials[3]);
                    System.out.println("Description: " + credentials[4]);
                    System.out.println("Transaction date: " + credentials[5]);
                    System.out.println("");
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("");
            System.out.println("An unexpected error occurred while generating transaction history! Try again later");
            System.out.println("");
            App.runner();
        }
    }
}