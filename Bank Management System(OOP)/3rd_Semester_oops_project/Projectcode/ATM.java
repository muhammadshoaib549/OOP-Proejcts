public class ATM {
    private String atmId;
    private String location;
    private double cashAvailable;

    public ATM(String atmId, String location, double initialCash) {
        this.atmId = atmId;
        this.location = location;
        this.cashAvailable = initialCash;
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getCashAvailable() {
        return cashAvailable;
    }

    public void setCashAvailable(double cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public String withdrawCashSavingAcc(double amount, SavingAccount savingAcc) {

        if (cashAvailable >= amount && (savingAcc.getBalance() >= amount)) {
            cashAvailable -= amount;
            savingAcc.setBalance(savingAcc.getBalance()-amount);
            return "Transaction successfull! Please take your Rs." + amount;
        }
        return  "Transaction failed due to insufficient cash in ATM machine";
    }
    public String withdrawCashCurrentAcc(double amount, CurrentAccount currentAcc){
    // for saving account
        if(cashAvailable >= amount){
            if(currentAcc.getBalance() >= amount){
                cashAvailable -= amount;
                currentAcc.setBalance(currentAcc.getBalance()-amount);
                return "Transaction successfull! Please take your Rs." + amount;
            }
            else{
                if(currentAcc.getRemainingOverdraftLimit() >= amount){
                    cashAvailable -= amount;
                    currentAcc.setRemainingOverdraftLimit(currentAcc.getRemainingOverdraftLimit()-amount);
                    return "Transaction successfull! Please take your Rs." + amount;
                }
                return "Transaction failed due to insufficient balance in your account";
            }
        }
        return  "Transaction failed due to insufficient cash in ATM machine";
    }

    public void depositCash(double amount, Account account) {
        cashAvailable += amount;
        double currentBalance = account.getBalance();
        double newBalance = currentBalance + amount;
        account.setBalance(newBalance);
    }
}
