public class SavingAccount extends Account {
    private double interestRate;

    public SavingAccount(String accountId, double balance, String accountType, Customer owner, double interestRate, String atmPin) {
        super(accountId, balance, accountType, owner, atmPin);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

}
