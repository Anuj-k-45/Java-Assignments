import java.util.Scanner;

class ATM {
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ", Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + ", Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw: " + amount + " but insufficient funds!");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private ATM atm;
    private double amount;

    public DepositThread(ATM atm, double amount) {
        this.atm = atm;
        this.amount = amount;
    }

    public void run() {
        atm.deposit(amount);
    }
}

class WithdrawThread extends Thread {
    private ATM atm;
    private double amount;

    public WithdrawThread(ATM atm, double amount) {
        this.atm = atm;
        this.amount = amount;
    }

    public void run() {
        atm.withdraw(amount);
    }
}

public class ATMThreadSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000);

        while (true) {
            System.out.println("\nATM Simulation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");

            System.out.print("Choose an operation (1/2/3): ");
            int choice = scanner.nextInt();

            if (choice == 3) {
                System.out.println("Exiting ATM simulation.");
                break;
            }

            System.out.print("Enter the amount: ");
            double amount = scanner.nextDouble();

            if (choice == 1) {
                Thread depositThread = new DepositThread(atm, amount);
                depositThread.setPriority(Thread.MIN_PRIORITY); 
                depositThread.start();
            } else if (choice == 2) {
                Thread withdrawThread = new WithdrawThread(atm, amount);
                withdrawThread.setPriority(Thread.MAX_PRIORITY);  
                withdrawThread.start();
            } else {
                System.out.println("Invalid choice! Please enter 1 for Deposit, 2 for Withdraw, or 3 to Exit.");
            }

            try {
                Thread.sleep(500);  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close(); 
    }
}