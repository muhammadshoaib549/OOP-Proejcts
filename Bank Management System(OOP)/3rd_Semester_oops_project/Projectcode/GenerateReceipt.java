import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateReceipt {

    public void generateFundsTransferReceipt(String senderAcc, String receiverAcc, double amount, String senderName,
                                                         String receiverName, String description, String remainingBalance) {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Sender Account Number: " + senderAcc);
        System.out.println("Sender Name: " + senderName);
        System.out.println("Recipient Account Number : " + receiverAcc);
        System.out.println("Recipient Name: " + receiverName);
        System.out.println("Amount Sent: " + df.format(amount));
        System.out.println("Remaining Balance: " + remainingBalance);
        System.out.println("Description: " + description);
        System.out.println("Transaction Date: " + getFormattedCurrentDateTime());
        System.out.println("");

    }

    public void generateBillPaymentReceipt(String billType, String providerName, double amount, String description,
            String remainingBalance) {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Bill Type: " + billType);
        System.out.println("Provider Name: " + providerName);
        System.out.println("Bill amount: " + df.format(amount));
        System.out.println("Remaining Balance: " + remainingBalance);
        System.out.println("Description: " + description);
        System.out.println("Transaction Date: " + getFormattedCurrentDateTime());
        System.out.println("");
    }

    public static String getFormattedCurrentDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDateTime = currentDateTime.format(formatter);

        return formattedDateTime;
    }
}
