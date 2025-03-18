package model;

public class Account {
    private String account;
    private String pass;
    private String lastName;
    private String firstName;
    private String birthday;
    private boolean gender;
    private String phone;
    private boolean isUse;
    private String roleInSystem;
    private String sessionId; // Để kiểm soát đăng nhập duy nhất

    public Account(String account, String pass, String lastName, String firstName, String birthday, boolean gender, String phone, boolean isUse, String roleInSystem) {
        this.account = account;
        this.pass = pass;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.isUse = isUse;
        this.roleInSystem = roleInSystem;
    }

    public String getAccount() { return account; }
    public String getPass() { return pass; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getFullName() { return lastName + " " + firstName; }
    public String getBirthday() { return birthday; }
    public boolean isGender() { return gender; }
    public String getPhone() { return phone; }
    public boolean isUse() { return isUse; }
    public String getRoleInSystem() { return roleInSystem; }
    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
}