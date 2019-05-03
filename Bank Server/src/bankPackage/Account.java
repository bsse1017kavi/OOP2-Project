package bankPackage;

import java.io.Serializable;

public class Account implements Serializable
{
    private String username;
    private String password;
    private double balance;

    public Account(String username, String password, double balance)
    {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public void withdraw(double ammount)
    {
        if(balance>=ammount && ammount>0) balance-=ammount;
    }

    public void deposit(double ammount)
    {
        if(ammount>0) balance+=ammount;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
