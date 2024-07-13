import java.util.Scanner;

public class Main {
    private int acno, withdraw, deposit, bal, password;
    private int n;

    // Constructor to initialize the balance
    public Main() {
        withdraw = 0;
        deposit = 0;
        bal = 100000;
    }

    public void details() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your 12-digit ACCOUNT NUMBER:");
        String acnoStr = sc.nextLine();

        // Check if the account number is 12 digits
        if (acnoStr.length() != 12 || !acnoStr.matches("\\d+")) {
            System.out.println("INVALID ACCOUNT NUMBER! Must be 12 digits.");
            sc.close();
            return;
        } else {
            acno = Integer.parseInt(acnoStr);
        }

        System.out.println("Enter your NAME:");
        String name = sc.nextLine();

        System.out.println("Enter your 4-digit PASSWORD:");
        String passwordStr = sc.nextLine();

        // Check if the password is a 4-digit number between 1111 and 9999
        if (passwordStr.length() == 4 && passwordStr.matches("\\d+")) {
            password = Integer.parseInt(passwordStr);
            if (password >= 1111 && password <= 9999) {
                System.out.println("YOUR PASSWORD IS VERIFIED....");
                System.out.println("Enter 1 for deposit");
                System.out.println("Enter 2 for withdraw");
                n = sc.nextInt();

                switch (n) {
                    case 1:
                        System.out.println("Enter YOUR DEPOSIT AMOUNT");
                        deposit = sc.nextInt();
                        bal = bal + deposit;
                        System.out.println("YOUR CURRENT BALANCE IS: " + bal);
                        break;

                    case 2:
                        System.out.println("Enter YOUR WITHDRAW AMOUNT");
                        withdraw = sc.nextInt();
                        if (withdraw <= bal) {
                            bal = bal - withdraw;
                            System.out.println("YOUR CURRENT BALANCE: " + bal);
                        } else {
                            System.out.println("INSUFFICIENT FUNDS!!");
                        }
                        break;

                    default:
                        System.out.println("INVALID CHOICE!!");
                        break;
                }
            } else {
                System.out.println("YOUR PASSWORD IS INVALID! Must be between 1111 and 9999.");
            }
        } else {
            System.out.println("INVALID PASSWORD! Must be a 4-digit number.");
        }

        sc.close();
    }

    public static void main(String[] args) {
        Main atm = new Main();
        atm.details();
    }
}
