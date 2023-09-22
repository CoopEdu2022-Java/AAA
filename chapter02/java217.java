import java.util.ArrayList;

class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " into account #" + accountNumber);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " from account #" + accountNumber);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

class Bank {
    private static int instanceCount = 0; // 静态变量用于记录实例化个数
    private ArrayList<Account> accounts;

    public Bank() {
        instanceCount++; // 每次实例化Bank对象时递增实例化个数
        accounts = new ArrayList<>();
    }

    public void addAccount(int accountNumber, String accountHolderName, double balance) {
        // 在addAccount方法中实例化Account对象并添加到accounts列表中
        Account account = new Account(accountNumber, accountHolderName, balance);
        accounts.add(account);
        System.out.println("Account #" + account.getAccountNumber() + " added.");
    }

    public void removeAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                accounts.remove(account);
                System.out.println("Account #" + accountNumber + " removed.");
                return;
            }
        }
        System.out.println("Account #" + accountNumber + " not found.");
    }

    public void displayAccounts() {
        System.out.println("Accounts in the bank:");
        for (Account account : accounts) {
            System.out.println("Account #" + account.getAccountNumber() + " - " + account.getAccountHolderName() + " - Balance: $" + account.getBalance());
        }
    }

    public static int getInstanceCount() {
        return instanceCount; // 静态方法返回实例化个数
    }
}

public class java217 {

}
