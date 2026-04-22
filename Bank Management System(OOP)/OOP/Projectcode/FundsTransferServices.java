import java.io.*;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FundsTransferServices {
    private static String senderName;
    private static String receiverName;
    private static String remainingBalance;

    public void fundstransfer(String senderAccNum, String recipientAccNum, double amount, String description) {
        boolean[] isDebitSuccessful = this.debitSenderAcc(senderAccNum, String.valueOf(amount));
        boolean[] isCreditSuccessful = this.creditReceiverAcc(recipientAccNum, String.valueOf(amount));
        if (isDebitSuccessful[0] && isDebitSuccessful[1] && isDebitSuccessful[2] && isCreditSuccessful[0]
                && isCreditSuccessful[1]) {

            int lastTransactionId = Verifications.getLastTransactionId();
            if (lastTransactionId == -1) {
                System.out.println("");
                System.out.println("----An error occurred! Please try again later---");
                System.out.println("");
                App.runner();
            } else {
                String action = "Funds transfer to " + receiverName;
                TransactionHistory.createTransactionHistory(lastTransactionId + 1, senderAccNum, action, amount, description, GenerateReceipt.getFormattedCurrentDateTime());
                System.out.println("");
                System.out.println("---Transaction successful----");
                System.out.println(" ");
                System.out.println("---Funds Transfer Receipt----");
                System.out.println("");
                GenerateReceipt gr = new GenerateReceipt();
                gr.generateFundsTransferReceipt(senderAccNum, recipientAccNum, amount, senderName, receiverName,
                        description, remainingBalance);
            }

        } else {
            if (!isDebitSuccessful[0]) {
                System.out.println("Transaction failed: Sender account not found");
            } else if (!isDebitSuccessful[1]) {
                System.out.println("Transaction failed: Insufficient balance in sender account");
            } else if (!isCreditSuccessful[0]) {
                System.out.println("Transaction failed: Receiver account not found");
            } else {
                System.out.println("Transaction failed: An error occurred while performing transaction");
            }
        }
    }

    public boolean[] debitSenderAcc(String accNum, String amount) {
        DecimalFormat df = new DecimalFormat("0.00");
        boolean success = false;
        boolean accountFound = false;
        boolean balanceSufficient = false;
        double amountD = Double.parseDouble(amount);
        File tempFile = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\temp.txt");
        try {
            File file = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\accounts.txt");
            Scanner sc = new Scanner(file);
            FileWriter fw = new FileWriter(tempFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                StringBuilder modifiedLine = new StringBuilder();
                String[] credentials = line.split(",");
                if (credentials[0].equals(accNum)) {
                    accountFound = true;
                    if (credentials[1].equals("saving")) {
                        if (Double.parseDouble(credentials[3]) >= amountD) {
                            double oldBalance = Double.parseDouble(credentials[3]);
                            double newBalance = oldBalance - amountD;
                            credentials[3] = df.format(newBalance);

                            balanceSufficient = true;
                            success = true;
                            FundsTransferServices.senderName = credentials[5] + " " + credentials[6];
                            FundsTransferServices.remainingBalance = credentials[3];
                        }
                    } else {
                        double balance = Double.parseDouble(credentials[3]);
                        double overdraftLimit = Double.parseDouble(credentials[2]);
                        if (balance >= amountD) {
                            balance -= amountD;
                            credentials[3] = df.format(balance);
                            balanceSufficient = true;
                            success = true;
                            FundsTransferServices.senderName = credentials[5] + " " + credentials[6];
                            FundsTransferServices.remainingBalance = credentials[3];

                        } else if (balance == 0 && overdraftLimit >= 0) {
                            overdraftLimit -= amountD;
                            credentials[2] = df.format(overdraftLimit);
                            balanceSufficient = true;
                            success = true;
                            FundsTransferServices.senderName = credentials[5] + " " + credentials[6];
                            FundsTransferServices.remainingBalance = credentials[3];
                        } else if (balance < amountD && balance > 0 && overdraftLimit >= amountD) {
                            double remainingAmount = amountD - balance;
                            overdraftLimit -= remainingAmount;
                            balance = 0.0;
                            credentials[2] = df.format(overdraftLimit);
                            credentials[3] = df.format(balance);
                            balanceSufficient = true;
                            success = true;
                            FundsTransferServices.senderName = credentials[5] + " " + credentials[6];
                            FundsTransferServices.remainingBalance = credentials[3];
                        }
                    }
                }
                for (String val : credentials) {
                    modifiedLine.append(val).append(",");
                }
                modifiedLine.deleteCharAt(modifiedLine.length() - 1);
                line = modifiedLine.toString();
                fw.write(line + "\n");
            }
            fw.close();
            sc.close();
            if (accountFound && balanceSufficient && success) {
                try (FileChannel src = new FileInputStream(tempFile).getChannel();
                        FileChannel dest = new FileOutputStream(file).getChannel()) {
                    dest.transferFrom(src, 0, src.size());
                } catch (IOException e) {
                    System.out.println("An exception occurred while performing transaction");
                }
            }
        } catch (IOException e) {
            System.out.println("An exception occurred in debiting sender");
        } finally {
            tempFile.delete();
        }
        return new boolean[] { accountFound, balanceSufficient, success };
    }

    public boolean[] creditReceiverAcc(String accNum, String amount) {
        DecimalFormat df = new DecimalFormat("0.00");
        boolean success = false;
        boolean accountFound = false;
        double amountD = Double.parseDouble(amount);
        File tempFile = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\temp.txt");
        try {
            File file = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\accounts.txt");
            Scanner sc = new Scanner(file);
            FileWriter fw = new FileWriter(tempFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                StringBuilder modifiedLine = new StringBuilder();
                String[] credentials = line.split(",");
                if (credentials[0].equals(accNum)) {
                    accountFound = true;
                    double oldBalance = Double.parseDouble(credentials[3]);
                    double newBalance = oldBalance + amountD;
                    credentials[3] = df.format(newBalance);
                    success = true;
                    FundsTransferServices.receiverName = credentials[5] + " " + credentials[6];
                }
                for (String val : credentials) {
                    modifiedLine.append(val).append(",");
                }
                modifiedLine.deleteCharAt(modifiedLine.length() - 1);
                line = modifiedLine.toString();
                fw.write(line + "\n");
            }
            fw.close();
            sc.close();
            if (accountFound && success) {
                try (FileChannel src = new FileInputStream(tempFile).getChannel();
                        FileChannel dest = new FileOutputStream(file).getChannel()) {
                    dest.transferFrom(src, 0, src.size());
                } catch (IOException e) {
                    System.out.println("An exception occurred while transferring data");
                }
            }
        } catch (IOException e) {
            System.out.println("An exception occurred in crediting receiver");
        } finally {
            tempFile.delete();

        }
        return new boolean[] { accountFound, success };
    }

    public String[] debitSavingAccount(String accNum, String amount) {
        DecimalFormat df = new DecimalFormat("0.00");
        boolean success = false;
        boolean accountFound = false;
        boolean balanceSufficient = false;
        double amountD = Double.parseDouble(amount);
        File tempFile = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\temp.txt");
        try {
            File file = new File("C:\\Program Files\\2nd_Semester_oops_project\\Projectcode\\accounts.txt");
            Scanner sc = new Scanner(file);
            FileWriter fw = new FileWriter(tempFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                StringBuilder modifiedLine = new StringBuilder();
                String[] credentials = line.split(",");
                if (credentials[0].equals(accNum)) {
                    accountFound = true;
                    double currentBalance = Double.parseDouble(credentials[3]);
                    if (currentBalance >= amountD) {
                        currentBalance -= amountD;
                        credentials[3] = df.format(currentBalance);
                        FundsTransferServices.remainingBalance = credentials[3];
                        balanceSufficient = true;
                        success = true;
                    }
                }
                for (String val : credentials) {
                    modifiedLine.append(val).append(",");
                }
                modifiedLine.deleteCharAt(modifiedLine.length() - 1);
                line = modifiedLine.toString();
                fw.write(line + "\n");
            }
            fw.close();
            sc.close();
            if (accountFound && balanceSufficient && success) {
                try (FileChannel src = new FileInputStream(tempFile).getChannel();
                        FileChannel dest = new FileOutputStream(file).getChannel()) {
                    dest.transferFrom(src, 0, src.size());
                } catch (IOException e) {
                    System.out.println("An exception occurred while performing transaction");
                }
            }
        } catch (IOException e) {
            System.out.println("An exception occurred in debiting sender");
        } finally {
            tempFile.delete();
        }
        return new String[] { Boolean.toString(accountFound), Boolean.toString(balanceSufficient),
                Boolean.toString(success), FundsTransferServices.remainingBalance };
    }
}