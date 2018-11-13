package jj;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account[] accounts = createAccounts(10, 100.);
        Account currentAccount;

        while (true) {
            System.out.println("Enter the account id: ");
            int id = input.nextInt();

            try {
                currentAccount = accounts[id];
            } catch (Exception e) {
                System.out.println("We could not find that account.");
                continue;
            }

            int mode = 0;
            while (true) {
                boolean shouldExitAccount = false;
                switch (mode) {
                    case 1:
                        checkBalance(currentAccount);
                        mode = 0;
                        break;
                    case 2:
                        withdraw(currentAccount, input);
                        mode = 0;
                        break;
                    case 3:
                        deposit(currentAccount, input);
                        mode = 0;
                        break;
                    case 4:
                        AccountInformation(currentAccount);
                        mode = 0;
                        break;
                    case 5:
                        displayExit(id);
                        mode = 0;
                        shouldExitAccount = true;
                        break;
                    case 0:
                        mode = displayMainMenu(currentAccount, input);
                        break;
                    default:
                        mode = 0;
                        break;
                }
                if (shouldExitAccount) {
                    break;
                }
            }
        }
    }

    private static void displayExit(int id) {
        System.out.println("\nThank you for working with account number: " +  id);
    }

    private static Account[] createAccounts(int n, double intialBalance) {

        Account[] accounts = new Account[n];

        for (int i = 0;  i < n; i++) {
            accounts[i] = new Account(n, intialBalance);
        }

        return accounts;
    }

    private static void AccountInformation(Account currentAccount) {

        System.out.println("Account was created on: " + currentAccount.getDateCreated());
        double theInterestRate = 7.8;
        currentAccount.setAnnualInterestRate(theInterestRate);
        System.out.println("Account interest rate is: " + currentAccount.getMonthlyInterestRate());
        System.out.println("Account Balance is: $" + currentAccount.getBalance());
    }

    private static void deposit(Account currentAccount, Scanner input) {

        System.out.print("Please enter the amount to deposit: ");
        double amountDeposited = input.nextDouble();
        double balance = currentAccount.getBalance();
        currentAccount.deposit(amountDeposited);
        currentAccount.setBalance(balance + amountDeposited);
        System.out.println("Balance after deposit is: $"+ currentAccount.getBalance());
    }

    private static void withdraw(Account currentAccount, Scanner input) {

        System.out.print("Please enter the amount to withdraw: ");
        double amountWithdrawn = input.nextDouble();
        double balance = currentAccount.getBalance();
        if (amountWithdrawn > balance) {
            System.out.println("Amount withdraw is: $" + currentAccount.getBalance());
            currentAccount.withdraw(currentAccount.getBalance());
            currentAccount.setBalance(0.);
        } else {
            currentAccount.withdraw(amountWithdrawn);
            currentAccount.setBalance(balance - amountWithdrawn);
            System.out.println("Amount withdraw is: $" + amountWithdrawn);
        }
    }

    private static void checkBalance(Account currentAccount) {

        double balance = currentAccount.getBalance();
        System.out.println("The current balance is: $" + balance);
    }

    private static int displayMainMenu(Account currentAccount, Scanner input) {

        System.out.println("\nMain Menu");
        System.out.println("\n1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Account Information");
        System.out.println("5. Exit (Choose a different account)");
        System.out.println("Please make a selection: ");
        int mode = input.nextInt();
        currentAccount.getId();

        return mode;
    }
}