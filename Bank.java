// Program to create a Bank Class



import java.util.Scanner;

// Base Account class
class Account {
    protected String customerName;
    protected String accountNumber;
    protected double balance;
    protected String accountType;

    // Constructor to initialize the account details
    public Account(String customerName, String accountNumber, double initialBalance, String accountType) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountType = accountType;
    }

    // Method to accept deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to display the balance
    public void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
}

// Savings Account Class (Subclass of Account)
class SavAcct extends Account {
    private double interestRate;

    // Constructor to initialize a savings account
    public SavAcct(String customerName, String accountNumber, double initialBalance, double interestRate) {
        super(customerName, accountNumber, initialBalance, "Savings");
        this.interestRate = interestRate;
    }

    // Method to compute and deposit interest
    public void computeAndDepositInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest of " + interest + " has been credited to your savings account.");
    }
}

// Current Account Class (Subclass of Account)
class CurAcct extends Account {
    private static final double MIN_BALANCE = 500.0;
    private static final double SERVICE_CHARGE = 50.0;

    // Constructor to initialize a current account
    public CurAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, initialBalance, "Current");
    }

    // Method to apply service charge if the balance is below the minimum
    public void checkAndApplyServiceCharge() {
        if (balance < MIN_BALANCE) {
            double charge = SERVICE_CHARGE;
            balance -= charge;
            System.out.println("Your balance is below the minimum limit. A service charge of " + charge + " has been applied.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating instances for savings and current accounts
        Account savAccount = new SavAcct("John Doe", "S12345", 1000.0, 5.0);
        Account curAccount = new CurAcct("Alice Smith", "C98765", 2000.0);

        // Menu-driven interface
        int choice;
        do {
            System.out.println("\nBank Menu:");
            System.out.println("1. Deposit to Savings Account");
            System.out.println("2. Withdraw from Savings Account");
            System.out.println("3. Compute and Deposit Interest for Savings Account");
            System.out.println("4. Display Savings Account Balance");
            System.out.println("5. Deposit to Current Account");
            System.out.println("6. Withdraw from Current Account");
            System.out.println("7. Apply Service Charge if Necessary (Current Account)");
            System.out.println("8. Display Current Account Balance");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter deposit amount for Savings Account: ");
                    double amount = scanner.nextDouble();
                    savAccount.deposit(amount);
                    break;
                }
                case 2: {
                    System.out.print("Enter withdrawal amount for Savings Account: ");
                    double amount = scanner.nextDouble();
                    savAccount.withdraw(amount);
                    break;
                }
                case 3: {
                    ((SavAcct) savAccount).computeAndDepositInterest();
                    break;
                }
                case 4: {
                    savAccount.displayBalance();
                    break;
                }
                case 5: {
                    System.out.print("Enter deposit amount for Current Account: ");
                    double amount = scanner.nextDouble();
                    curAccount.deposit(amount);
                    break;
                }
                case 6: {
                    System.out.print("Enter withdrawal amount for Current Account: ");
                    double amount = scanner.nextDouble();
                    curAccount.withdraw(amount);
                    break;
                }
                case 7: {
                    ((CurAcct) curAccount).checkAndApplyServiceCharge();
                    break;
                }
                case 8: {
                    curAccount.displayBalance();
                    break;
                }
                case 9: {
                    System.out.println("Exiting the program.");
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } while (choice != 9);

        scanner.close();
    }
}
