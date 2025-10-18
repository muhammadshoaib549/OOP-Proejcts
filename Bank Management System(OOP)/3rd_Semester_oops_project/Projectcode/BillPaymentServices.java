public class BillPaymentServices {

    public void makeBillPayment(String accNum, String providerName, double amount, String billType,
            String description) {
        CustomerCredentials cc = new CustomerCredentials();
        FundsTransferServices fts = new FundsTransferServices();
        String accType = cc.getAccType(accNum);
        if (accType.equals("current")) {
            boolean[] isSuccessful = fts.debitSenderAcc(accNum, String.valueOf(amount));
            if (isSuccessful[0] && isSuccessful[1] && isSuccessful[2]) {
                int lastTransactionId = Verifications.getLastTransactionId();
                if (lastTransactionId == -1) {
                    System.out.println("");
                    System.out.println("----An error occurred! Please try again later---");
                    System.out.println("");
                    App.runner();
                } else {
                    String action = billType+ " payment to " + providerName;
                    TransactionHistory.createTransactionHistory(lastTransactionId + 1, accNum, action, amount, description,
                            GenerateReceipt.getFormattedCurrentDateTime());

                    GenerateReceipt gr = new GenerateReceipt();
                    System.out.println("---The bill has successfully been payed---");
                    System.out.println("");
                    System.out.println("---Bill Payment Receipt---");
                    System.out.println("");
                    gr.generateBillPaymentReceipt(billType, providerName, amount, description,
                            Double.toString(cc.getBalance(accNum)));
                }

            } else {
                if (!(isSuccessful[0])) {
                    System.out.println("Transaction failed: Account not found");
                } else if (!(isSuccessful[1])) {
                    System.out.println("Transaction failed: Balance insufficient");
                } else {
                    System.out.println("An error occurred while paying the bill! Please try again");
                }
            }
        } else if (accType.equals("saving")) {
            String[] isSuccessful = fts.debitSavingAccount(accNum, String.valueOf(amount));
            if (Boolean.parseBoolean(isSuccessful[0]) && Boolean.parseBoolean(isSuccessful[1])
                    && Boolean.parseBoolean(isSuccessful[2])) {
                GenerateReceipt gr = new GenerateReceipt();
                System.out.println("---The bill has successfully been payed---");
                System.out.println("");
                System.out.println("---Bill Payment Receipt---");
                System.out.println("");
                gr.generateBillPaymentReceipt(billType, providerName, amount, description, isSuccessful[3]);

            } else {
                if (!(Boolean.parseBoolean(isSuccessful[0]))) {
                    System.out.println("Transaction failed: Account not found");
                } else if (!(Boolean.parseBoolean(isSuccessful[1]))) {
                    System.out.println("Transaction failed: Balance insufficient");
                } else {
                    System.out.println("An error occurred while paying the bill! Please try again");
                }
            }
        } else {
            System.out.println("An unexpected error occurred! Please try again later");
        }
    }
}
