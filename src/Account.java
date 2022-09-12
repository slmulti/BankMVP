import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
public class Account {
    //class Variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Class constructor
    Account(String cname, String cid, int bal){
        customerName = cname;
        customerID = cid;
        balance = bal;
    }

    //function for Depositing Money
    void deposit(int amount){
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = +amount;
        }
    }

    //function for Withdrawing Money
    void withdraw(int amount){
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    //function to show previous transaction
    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0){
            System.out.println("Withdrawn: " + previousTransaction);
        } else {
            System.out.println("No Transactions");
        }
    }

    //func to calc interest
    void calculateInterest(int years){
        double interestRate = 0.0185; //decimal version of percentage
        BigDecimal interestRate2D = new BigDecimal(100*interestRate).setScale(2, RoundingMode.HALF_UP);
        double newBalance = (balance*interestRate*years) + balance;
        double interestTotal = newBalance - balance;
        System.out.println("The Current interest rate is " + (interestRate2D)+"%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
        System.out.println("the total interest earned will be: £" + interestTotal);
    }

    void showMenu(){
        char option = '\0'; //do i need this placeholder, can i just do char = option; no placeholder is actually needed
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do today?");
        System.out.println();
        System.out.println("A. Check your Balance");
        System.out.println("B. Make a Deposit");
        System.out.println("C. Make a Withdrawal");
        System.out.println("D. View Previous Transaction");
        System.out.println("E. Calculate Interest");
        System.out.println("F. Exit");

        do{
            System.out.println();
            System.out.println("Enter an Option: ");
            char opt1 = scanner.next().charAt(0);
            option = Character.toUpperCase(opt1);
            System.out.println();

            switch (option){
                //case 'A' check balance
                case 'A':
                    System.out.println("==========================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("==========================");
                    System.out.println();
                    break;
                //case B accepts an amount to deposit
                case 'B':
                    System.out.println("Enter an amount to Deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                //case C accepts Withdrawal
                case 'C':
                    System.out.println("Enter an amount to Withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                //case D shows previous transaction
                case 'D':
                    System.out.println("==========================");
                    getPreviousTransaction();
                    System.out.println("==========================");
                    System.out.println();
                    break;
                //case E Calcs the interest for chosen years
                case 'E':
                    System.out.println("Enter how many years of accured interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                //case F exits
                case 'F':
                    System.out.println("==========================");
                    break;
                //if something invalid is entered
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E or F");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thank you for Banking with us!");
    }
}
