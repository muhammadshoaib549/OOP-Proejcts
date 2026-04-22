public  class Account {
    private String accountNumber;
    private double balance;
    private String accountType;
    private final Customer accountHolder;
    private String atmPin;

    public Account(String accountNumber, double balance, String accountType, Customer accountHolder, String atmPin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.accountHolder = accountHolder;

        this.atmPin = atmPin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }
public void setAccountNumber(String accountNumber) {
    if (accountNumber == null || accountNumber.isEmpty()) {
        throw new IllegalArgumentException("Account number cannot be null or empty.");
    }
    this.accountNumber = accountNumber;
}

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Customer getAccountHolder() {
        return accountHolder;
    }

    public void setAtmPin(String atmPin) {
        this.atmPin = atmPin;
    }

    public String getAtmPin() {
        return this.atmPin;
    }



}
