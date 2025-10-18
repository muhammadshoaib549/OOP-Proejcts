public class CurrentAccount extends Account {
    private double overdraftLimit;
    private double remainingOverdraftLimit;

    public CurrentAccount(String accountId, double balance, String accountType, Customer owner, double overdraftLimit, String atmPin) {
        super(accountId, balance, accountType, owner, atmPin);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
    public double getRemainingOverdraftLimit() {
        return remainingOverdraftLimit;
    }

    public void setRemainingOverdraftLimit(double remainingOverdraftLimit) {
        this.remainingOverdraftLimit = remainingOverdraftLimit;
    }



}
