import java.util.Scanner;

class BankAccount 
{
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 100000f;
    int transactions = 0;
    String transactionHistory = "";

    public void Withdraw() 
    {
        System.out.print("Enter amount to Withdraw : ");
        Scanner sc = new Scanner(System.in);
        float amount = 0;
        try {
            amount = sc.nextFloat();
            if (amount < 0) {
                System.out.println("Amount must be positive.");
                return;
            }
            if (balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("Withdraw Successfully.");
                String str = amount + " Rs Withdrawed ";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("Insufficient Balance.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }
    public void Deposit() 
    {
        System.out.print("Enter amount to Deposit : ");
        Scanner sc = new Scanner(System.in);
        float amount = 0;
        try 
        {
            amount = sc.nextFloat();
            if (amount < 0) 
            {
                System.out.println("Amount must be positive.");
                return;
            }
            if (amount <= MAX_DEPOSIT_LIMIT) 
            {
                transactions++;
                balance += amount;
                System.out.println("\nSuccessfully Deposited");
                String str = amount + " Rs Deposited";
                transactionHistory = transactionHistory.concat(str);
            } 
            else 
            {
                System.out.println("Sorry...Limit is " + MAX_DEPOSIT_LIMIT + " Rs");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Invalid input.");
        }
    }
    public void CheckBalance() 
    {
        System.out.println("\n" + balance + " Rs");
    }
    public void TransactionHistory() 
    {
        if (transactions == 0) 
        {
            System.out.println("Empty ");
        } 
        else 
        {
            System.out.println("\n" + transactionHistory);
        }
    }
    private static final float MAX_DEPOSIT_LIMIT = 100000f;
}
public class ATMInterface 
{
    public static void main(String[] args) 
    {
        BankAccount b = new BankAccount();
        Scanner sc = new Scanner(System.in);
        while (true) 
        {
            System.out.println("WELCOME TO ATM MACHINE");
            System.out.println("1. Withdraw 2. Deposit 3. Check Balance 4. Transaction History 5. Exit");
            switch (sc.nextInt()) 
            {
                case 1:
                    b.Withdraw();
                    break;
                case 2:
                    b.Deposit();
                    break;
                case 3:
                    b.CheckBalance();
                    break;
                case 4:
                    b.TransactionHistory();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
