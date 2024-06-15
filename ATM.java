import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = getUserChoice();
            performAction(choice);
        }
    }

    private void showMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private int getUserChoice() {
        int choice = scanner.nextInt();
        return choice;
    }

    private void performAction(int choice) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void checkBalance() {
        double balance = account.getBalance();
        System.out.println("Current balance: $" + balance);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    private void exit() {
        System.out.println("Thank you for using the ATM. Goodbye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(500); // Initial balance of $500
        ATM atm = new ATM(account);
        atm.start();
    }
}
