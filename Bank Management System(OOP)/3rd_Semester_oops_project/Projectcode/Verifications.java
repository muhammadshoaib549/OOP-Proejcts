import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SuppressWarnings("resource")
public class Verifications {
     public boolean[] verifySenderAcc(String senderAcc, String amount) {
     boolean isAccountFound, isBalanceSufficient;
     isBalanceSufficient = isAccountFound = false;
     try {
     File f = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\accounts.txt");
     Scanner sc = new Scanner(f);
     // verifying whether the account exists
     while (sc.hasNextLine()) {
     String line = sc.nextLine();
     String[] credentials = line.split(",");
     String accNum = credentials[0];
     if (accNum.equals(senderAcc))
     {
     isAccountFound = true;
     double balance = Double.parseDouble(credentials[3]);
     if (credentials[1].equals("current")) { // for current account
     double overdraftLimit = Double.parseDouble(credentials[2]);
     if ((overdraftLimit + balance) >= Double.parseDouble(amount)) {
     isBalanceSufficient = true;
     }
     }
     else
     { // for saving account
     if (balance >= Double.parseDouble(amount)) {
     isBalanceSufficient = true;
     }
     }
     break;
     }
     }
     } catch (FileNotFoundException e) {
     System.out.println("An error occurred! Please try again later");
     System.exit(0);
     }
     return new boolean[] { isAccountFound, isBalanceSufficient };
     }

     public boolean verifyReceiverAcc(String receiverAcc) {
     boolean isAccountFound = false;
     try {
     File f = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\accounts.txt");
     Scanner sc = new Scanner(f);
     // verifying whether the account exists
     while (sc.hasNextLine()) {
     String line = sc.nextLine();
     String[] credentials = line.split(",");
     String accNum = credentials[0];
     if (accNum.equals(receiverAcc)) {
     isAccountFound = true;
     break;
     }
     }
     } catch (FileNotFoundException e) {
     System.out.println("An error occurred! Please try again later");
     System.exit(0);
     }
     return isAccountFound;
     }
    public static int getLastTransactionId() {
        int counter = 0;
        try {
            File file = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\transaction_history.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                counter++;
                sc.nextLine();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Entered the fileNotFoundException block");
            return -1;
        }
        return counter;
    }
}
