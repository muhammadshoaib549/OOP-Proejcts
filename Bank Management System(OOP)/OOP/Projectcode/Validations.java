public class Validations {

    public boolean isEmailValid(String email) {

        String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        return email.matches(emailRegex);
    }

    public boolean isPhoneNumberValid(String phoneNumber) {

        String phoneRegex = "^\\d{10}$";
        return phoneNumber.matches(phoneRegex);
    }

    public boolean isAmountValid(double amount) {
        return amount >= 0;
    }

    public boolean isAccountNumberValid(String accountNumber) {
        return accountNumber.matches("^\\d{10}$");
    }

    public boolean isPasswordValid(String password) {

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

        return password.matches(regex);
    }

    public boolean isATMPinValid(String pin) {
        // Check if the pin is not null and has exactly 4 characters
        if(pin != null){
            if(pin.length() == 4){

            }
            else{
                System.out.println("Pin must be of exactly four digits: ");
            }
        }
        else{
            System.out.println("Invalid Pin");
            return false;
        }
        // If pin is null or not of length 4, return false
        return false;
    }

    public boolean isNameValid(String name) {
        if (name.length() >= 4 && name.matches("^[a-zA-Z]+$")) {
            return true;
        }
        return false;
    }
}
