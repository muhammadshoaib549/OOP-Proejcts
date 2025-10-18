public class InterestCalculator {

    public static double calculateInterest(SavingAccount savingsAccount) {
        double balance = savingsAccount.getBalance();
        double interestRate = savingsAccount.getInterestRate();
        return balance * (interestRate / 100);
    }
}