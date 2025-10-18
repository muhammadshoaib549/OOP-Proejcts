public class Administrator {
    private String adminId;
    private String adminName;
    private String adminEmail;
    private String adminPass;

    public Administrator(String adminId, String adminName, String adminEmail, String adminPass) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPass = adminPass;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public void approveAccount(Account account) {
    }

    public void blockAccount(Account account) {
    }

    public void generateReports() {
    }
}
