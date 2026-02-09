import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankService();
        Account account = bankService.loadAccount();

        int choice;

        do {
            System.out.println("\n----- SIMPLE BANKING SYSTEM -----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (account != null) {
                        System.out.println("Account already exists!");
                        break;
                    }
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();

                    account = new Account(accNo, name, bal);
                    bankService.saveAccount(account);
                    break;

                case 2:
                    if (account == null) {
                        System.out.println("Create account first!");
                        break;
                    }
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    bankService.saveAccount(account);
                    System.out.println("Deposit successful!");
                    break;

                case 3:
                    if (account == null) {
                        System.out.println("Create account first!");
                        break;
                    }
                    System.out.print("Enter withdrawal amount: ");
                    double wd = sc.nextDouble();
                    if (account.withdraw(wd)) {
                        bankService.saveAccount(account);
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;

                case 4:
                    if (account == null) {
                        System.out.println("Create account first!");
                        break;
                    }
                    System.out.println("Account Holder: " + account.getAccountHolder());
                    System.out.println("Balance: ₹" + account.getBalance());
                    break;

                case 5:
                    System.out.println("Thank you for using Banking System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
