import java.util.Scanner;
import java.util.ArrayList;

class BankAccount {

    String name;
    double balance;
    double dividendRate; // example: 0.05 = 5%

    // Constructor
    public BankAccount(String name, double initialDeposit) {
        this.name = name;
        this.balance = initialDeposit;
        this.dividendRate = 0.0;
    }

    // Deposit money
    public void deposit(double amount) {
        balance = balance + amount;
        // too simple - need refinement
    }

    // Withdraw money
    public void withdraw(double amount) {
        balance = balance - amount;
        // too simple - need refinement
    }

    // Calculate dividend
    public double calculateDividend() {
        return balance * dividendRate;
    }

    // Apply dividend to balance
    public void applyDividend() {
        double dividend = calculateDividend();
        balance = balance + dividend;
    }

    // sorted balanced from high to low
    public double getBalance() {
        return balance;
    }

    // Set dividend rate
    public void setDividendRate(double rate) {
        dividendRate = rate;
        // too simple - need refinement
    }

    // Display account information
    public void printObjectState() {
        System.out.println("\n===== ACCOUNT INFO =====");
        System.out.println("Name          : " + name);
        System.out.println("Balance       : RM " + balance);
        System.out.println("Dividend Rate : " + dividendRate * 100 + "%");
        System.out.println();
    }
}

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        System.out.println("===== BANK ACCOUNT SYSTEM =====");

        boolean running = true;

        while (running) {

            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Apply Dividend");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Sort by Balance");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter initial deposit: RM ");
                    double deposit = sc.nextDouble();
                    sc.nextLine();

                    accounts.add(new BankAccount(name, deposit));
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    displayAccounts(accounts);
                    System.out.print("Select account index: ");
                    int depIndex = sc.nextInt();

                    System.out.print("Enter deposit amount: RM ");
                    double depAmount = sc.nextDouble();

                    accounts.get(depIndex).deposit(depAmount);
                    System.out.println("Deposit successful.");
                    break;

                case 3:
                    displayAccounts(accounts);
                    System.out.print("Select account index: ");
                    int witIndex = sc.nextInt();

                    System.out.print("Enter withdrawal amount: RM ");
                    double witAmount = sc.nextDouble();

                    accounts.get(witIndex).withdraw(witAmount);
                    System.out.println("Withdrawal successful.");
                    break;

                case 4:
                    System.out.print("Enter dividend rate (0.05 for 5%): ");
                    double rate = sc.nextDouble();

                    for (BankAccount acc : accounts) {
                        acc.setDividendRate(rate);
                        acc.applyDividend();
                    }

                    System.out.println("Dividend applied to all accounts.");
                    break;

                case 5:
                    displayAccounts(accounts);
                    break;

                case 6:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                        break;
                    }

                    ArrayList<BankAccount> sortedList = new ArrayList<>(accounts);

                    sortedList.sort((a, b) -> Double.compare(b.getBalance(), a.getBalance()));

                    System.out.println("\nAccounts sorted by balance (High to Low)");
                    displayAccounts(sortedList);
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }

    public static void displayAccounts(ArrayList<BankAccount> accounts) {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("\nIndex: " + (i + 1));
            accounts.get(i).printObjectState();
        }
    }
}

/*
 * import java.util.Scanner;
 * 
 * class BankAccount {
 * 
 * String name;
 * double balance;
 * double dividentRate; // e.g. 0.03 = 3%
 * 
 * // Constructor
 * public BankAccount(String name, double initDeposit) {
 * this.name = name;
 * this.balance = initDeposit;
 * }
 * 
 * // Deposit money
 * public void deposit(double amount) {
 * balance = balance + amount;
 * }
 * 
 * // Withdraw money
 * public void withdraw(double amount) {
 * balance = balance - amount;
 * }
 * 
 * // Calculate divident
 * public double calculateDivident() {
 * return balance * dividentRate;
 * }
 * 
 * // Add divident into balance
 * public void applyDivident() {
 * double divident = calculateDivident();
 * balance += divident;
 * }
 * 
 * public void setDividentRate(double theRate) {
 * this.dividentRate = theRate;
 * }
 * 
 * // Display account info
 * public String printObjState() {
 * return "===== ACCOUNT INFO ===== \n" +
 * "Name          : " + name +
 * "Balance       : RM " + balance +
 * "Divident Rate : " + dividentRate * 100;
 * }
 * }
 * 
 * public class App {
 * public static void main(String[] args) throws Exception {
 * System.out.println("Hello, World!");
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * System.out.println("CREATING NEW BANK ACCOUNT");
 * System.out.print("Enter account holder name: ");
 * String name = sc.nextLine();
 * 
 * System.out.println("Enter initial deposit: ");
 * double initialDeposit = sc.nextDouble();
 * 
 * // Create account
 * BankAccount acc1 = new BankAccount(name, initialDeposit);
 * System.out.println("Acc Successfully created...initial deposit=RM" +
 * initialDeposit);
 * acc1.printObjState();
 * // Perform operations
 * System.out.println("\n--- PERFORMING TRANSACTIONS ---");
 * System.out.println("Enter amount Deposit RM...");
 * double depo = sc.nextDouble();
 * acc1.deposit(depo);
 * System.out.println(acc1.printObjState());
 * System.out.println("Enter amount Withdraw RM...");
 * double wd = sc.nextDouble();
 * acc1.withdraw(wd);
 * acc1.printObjState();
 * System.out.
 * println("\n\n\nEND OF 2026 - CALC DIVIDENT AT END OF FINANTIAL YEAR");
 * System.out.println("Enter div rate (ie 0.5 for 5%");
 * double theRate = sc.nextDouble();
 * acc1.setDividentRate(theRate);
 * acc1.applyDivident();
 * 
 * // Final output
 * acc1.printObjState();
 * 
 * sc.close();
 * }
 * }
 */