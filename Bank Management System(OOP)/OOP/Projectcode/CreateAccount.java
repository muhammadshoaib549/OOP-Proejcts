import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
@SuppressWarnings("resource")
public class CreateAccount {
    public void getCustomerCredentials(String accType) {
        Scanner inp = new Scanner(System.in);
        String accNum, fName, lName, email, pass, address, phoneNum, atmPin;
        int custId;
        double balance;
        System.out.println("Account Number:");
        accNum = inp.nextLine();

        System.out.println("Balance: ");
        balance = inp.nextDouble();
        inp.nextLine();

        System.out.println("Customer Id: ");
        custId = inp.nextInt();
        inp.nextLine();

        System.out.println("First Name: ");
        fName = inp.nextLine();
        System.out.println("Last Name: ");
        lName = inp.nextLine();
        System.out.println("Email: ");
        email = inp.nextLine();
        System.out.println("Password: ");
        pass = inp.nextLine();
        System.out.println("Address: ");
        address = inp.nextLine();
        System.out.println("Phone Number: ");
        phoneNum = inp.nextLine();
        System.out.println("Atm Pin");
        atmPin = inp.nextLine();

        Account account;
        if (accType.equalsIgnoreCase("current")) {
            System.out.println("Overdraft Limit:");
            double overdraftLimit = inp.nextDouble();
            account = new CurrentAccount(accNum, balance, accType,
                    new Customer(custId, fName, lName, email, pass, address, phoneNum), overdraftLimit, atmPin);
        } else if (accType.equalsIgnoreCase("saving")) {
            System.out.println("Interest Rate:");
            double interestRate = inp.nextDouble();
            account = new SavingAccount(accNum, balance, accType,
                    new Customer(custId, fName, lName, email, pass, address, phoneNum), interestRate, atmPin);
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        createAccount(account);
    }

    public void createAccount(Account account) {
        DecimalFormat df = new DecimalFormat("0.00");
        try {
            FileWriter fw = new FileWriter("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\accounts.txt", true);
            String accNum, custId, fName, lName, email, pass, address, phoneNum, balance, accType, specificInfo, atmPin;
            Customer accHolder = account.getAccountHolder();
            accNum = account.getAccountNumber();
            balance = Double.toString(account.getBalance());
            accType = account.getAccountType();
            if (account instanceof CurrentAccount) {
                specificInfo = Double.toString(((CurrentAccount) account).getOverdraftLimit());
            } else if (account instanceof SavingAccount) {
                specificInfo = Double.toString(((SavingAccount) account).getInterestRate());
            } else {
                specificInfo = "";
            }
            custId = Integer.toString(accHolder.getCustomerId());
            fName = accHolder.getFirstName();
            lName = accHolder.getLastName();
            email = accHolder.getEmail();
            pass = accHolder.getPassword();
            address = accHolder.getAddress();
            phoneNum = accHolder.getPhoneNumber();
            atmPin = account.getAtmPin();

            fw.write(accNum.trim() + "," + accType.trim() + "," + df.format(Double.parseDouble(specificInfo.trim()))
                    + "," + df.format(Double.parseDouble(balance.trim())) + "," + custId.trim() + "," + fName.trim()
                    + "," + lName.trim() + ","
                    + email.trim() + "," + pass.trim() + "," + address.trim() + "," + phoneNum.trim() + ","
                    + atmPin.trim() + "\n");
            fw.close();
            System.out.println("Your account has successfully been created! You can now login.");
        } catch (IOException e) {
            System.out.println("There was an error creating your account! Please try again later");
            e.printStackTrace();
        }
    }
}
