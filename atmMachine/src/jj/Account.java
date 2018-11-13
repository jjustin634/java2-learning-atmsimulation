package jj;

import java.util.Date;

public class Account {

    private int id = 0;
    private double balance = 0.0;
    private double annualInterestRate = 0.0;
    private Date dateCreated;

    public Account() {}

    public Account(int specifiedId, double intialBalance) {
        id = specifiedId;
        balance = intialBalance;
        dateCreated = new Date();
    }

     public void setBalance(double theBalance) {
         this.balance = theBalance;
     }

    public void setAnnualInterestRate(double TheAnnualInterestRate) {
        this.annualInterestRate = TheAnnualInterestRate;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double withdraw(double withdrawAmount) {

        if (withdrawAmount > balance) {
            this.balance = getBalance();
        } else {
            this.balance = withdrawAmount;
        }

        return withdrawAmount;
    }

    public double deposit(double despositAmount) {
        this.balance = despositAmount;
        return despositAmount;
    }
}
