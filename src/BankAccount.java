class Account {
    private String accountNumber;
    private double balance;
    private double annualInterestRate;

    public Account(String accountNumber, double balance, double annualInterestRate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal of $" + amount + " successful.");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, double annualInterestRate, double overdraftLimit) {
        super(accountNumber, balance, annualInterestRate);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void withdraw(double amount) {
        if (getBalance() + overdraftLimit >= amount) {
            super.withdraw(amount);
        } else {
            System.out.println("Exceeds overdraft limit.");
        }
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, double balance, double annualInterestRate) {
        super(accountNumber, balance, annualInterestRate);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            super.withdraw(amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

public class BankAccount {
    public static void main(String[] args) {
        // Testing the Account classes
        CheckingAccount checkingAccount = new CheckingAccount("C123", 1000, 0.02, 500);
        checkingAccount.deposit(200);
        checkingAccount.withdraw(1500);
        checkingAccount.withdraw(600);

        System.out.println("Checking Account Balance: $" + checkingAccount.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount("S456", 2000, 0.03);
        savingsAccount.deposit(500);
        savingsAccount.withdraw(250);
        savingsAccount.withdraw(3000);
        System.out.println("Savings Account Balance: $" + savingsAccount.getBalance());
    }
}
