import java.util.Scanner;

@SuppressWarnings("resource")
public class App {
    static {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println(" ");
        System.out.println("---Welcome to Online Banking System---");
        System.out.println(" ");
        System.out.println("1-Login");
        System.out.println("2-Signup");
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();
        if (choice == 1)
        {
            login();
        }
        else
        {
            openAccount();
        }

    }

    public static void main(String[] args) {
        login();
    }

    public static void openAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What type of account you want to open? ");
        System.out.println("1) Current Account");
        System.out.println("2) Saving Account");
        CreateAccount createAccount = new CreateAccount();
        int choice;
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();
        if (choice == 1) {
            createAccount.getCustomerCredentials("current");
        } else {
            createAccount.getCustomerCredentials("saving");
        }
        System.out.println("");
        login();
        startAgain();
    }

    public static void transferFunds() {
        Scanner sc = new Scanner(System.in);
        String senderAccNum, receiverAccNum, description;
        double amount;
        senderAccNum = CurrentSession.accountNumber;
        System.out.println("Enter the account number of recipient:");
        receiverAccNum = sc.nextLine();
        while (receiverAccNum.equals(CurrentSession.accountNumber)) {
            System.out.println();
            System.out.println("---The recipient account number can\'t be same as yours---");
            System.out.println();
            System.out.println("Please again enter the recipient account number: ");
            receiverAccNum = sc.nextLine();
        }

        System.out.println("Enter the amount to send: ");
        amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the description for payment: ");
        description = sc.nextLine();
        FundsTransferServices fs = new FundsTransferServices();
        fs.fundstransfer(senderAccNum, receiverAccNum, amount, description);

        startAgain();
    }

    public static void payBills() {
        Scanner sc = new Scanner(System.in);
        int choice;
        double amount;
        String accNum, providerName, description, billType = "";

        System.out.println("Which type of bill do you want to pay: ");
        System.out.println("1-Electricity Bill");
        System.out.println("2-Education Bill");
        System.out.println("3-Water Bill");
        System.out.println("4-Gas Bill");
        System.out.println("5-Internet Bill");
        System.out.println("6-Other Bill");
        System.out.println("Enter your choice: ");

        choice = sc.nextInt();
        sc.nextLine();
        accNum = CurrentSession.accountNumber;
        System.out.println("Enter the amount of the bill: ");
        amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the provider name:");
        providerName = sc.nextLine();
        System.out.println("Enter the description for the bill: ");
        description = sc.nextLine();
        BillPaymentServices bps = new BillPaymentServices();
        switch (choice) {
            case 1:
                billType = "Electricity Bill";
                break;
            case 2:
                billType = "Education Bill";
                break;
            case 3:
                billType = "Water Bill";
                break;
            case 4:
                billType = "Gas Bill";
                break;
            case 5:
                billType = "Internet Bill";
                break;
            case 6:
                billType = "Other Bill";
                break;
            default:
                break;
        }
        bps.makeBillPayment(accNum, providerName, amount, billType, description);
        startAgain();
    }

    public static void viewProfile() {
        String[] sessionData = CurrentSession.getSessionData();
        System.out.println(" ");
        System.out.println("---" + sessionData[5] + " " + sessionData[6] + "\'s " + "Profile---");
        System.out.println("");
        System.out.println("Customer Id: " + sessionData[4]);
        System.out.println("Account Number: " + sessionData[0]);
        System.out.println("Account Type: " + sessionData[1]);
        if (sessionData[1].equals("current")) {
            System.out.println("Overdraft Limit: " + sessionData[2]);
        } else {
            System.out.println("Ineterest Rate: " + sessionData[2]);

        }
        System.out.println("Current Balance: " + sessionData[3]);
        System.out.println("First Name: " + sessionData[5]);
        System.out.println("Last Name: " + sessionData[6]);
        System.out.println("Email: " + sessionData[7]);
        System.out.println("Password: " + sessionData[8]);
        System.out.println("Address: " + sessionData[9]);
        System.out.println("Phone Number: " + sessionData[10]);
        System.out.println("ATM Pin: " + sessionData[11]);
        System.out.println("----------------------------------");
        System.out.println("");
        runner();
    }

    public static void viewTransactionHistory() {
        TransactionHistory.generateTransactionHistory(CurrentSession.accountNumber);
        startAgain();
    }

    public static void login() {
        Scanner sc = new Scanner(System.in);
        Login lg = new Login();
        String email = "", password = "";
        boolean isLoginSuccessful = false;
        while (!isLoginSuccessful) {
            System.out.println("Please enter your email: ");
            email = sc.nextLine();
            System.out.println("Please enter your password: ");
            password = sc.nextLine();
            if (lg.verifyLoginCredentials(email, password)) {
                System.out.println("");
                System.out.println("----Login Successful---- ");
                System.out.println(" ");
                isLoginSuccessful = true;
            } else {
                System.out.println("Incorrect email or password. Please try again!");
            }
        }
        if (!(CurrentSession.createSession(email, password)))
            login();
        else {
            runner();
        }
    }

    public static void runner() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("What do you want to do:");
        System.out.println("1-Open an account");
        System.out.println("2-Transfer funds");
        System.out.println("3-Pay a bill");
        System.out.println("4-View Profile");
        System.out.println("5-View Transaction History");
        System.out.println("6-Logout");
        System.out.println("Enter your choice: ");
        int choice;
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                openAccount();
                break;
            case 2:
                transferFunds();
                break;
            case 3:
                payBills();
                break;
            case 4:
                viewProfile();
                break;
            case 5:
                viewTransactionHistory();
                break;
            case 6:
                System.out.println("You have successfully logout!");
                System.exit(0);
        }
    }

    public static void startAgain() {
        Scanner sc = new Scanner(System.in);
        int startAgain = 0;
        System.out.println("Thanks for using our online banking system");
        System.out.println("Do you want to start again?");
        System.out.println("Press 1 to start again");
        System.out.println("Press 0 to logout");
        System.out.println("Enter your choice: ");
        startAgain = sc.nextInt();
        if (startAgain == 1) {
            runner();
        } else {
            System.out.println("");
            System.out.println("---You have successfully logout---");
            System.exit(0);
        }}}