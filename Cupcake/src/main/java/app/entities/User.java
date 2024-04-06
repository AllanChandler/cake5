package app.entities;

public class User {
    private int UserId;
    private String email;
    private String password;
    private String role;
    private int balance;

    public User(int UserId, String email, String password, String role, int balance) {
        this.UserId = UserId;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public int getUserId() {
        return UserId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", balance=" + balance +
                '}';
    }
}