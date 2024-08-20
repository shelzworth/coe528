package Project;

/**
 *
 * @author Sheldon Cerejo
 * 
 * 
 * Overview: Represents the bank account, allowing a customer to deposit, withdraw and functions with balance.
 * 
 * 
 * This class is mutable since balance is constantly being changed.
 * 
 * AF(c) = a bank account with an initial balance that can be altered by 
 * depositing withdrawing or making an online purchase.
 * 
 * 
 * RI(c) = balance >= 0.0.
 */
public abstract class BankAccount 
{
    protected double balance;
    
    public BankAccount()
    {
        balance = 100.00;
    }
    
    public double deposit(double amount)
    {
        balance += amount;
        return balance;
    }
    
    public double withdraw(double amount)
    {
        if (amount >= 0 && amount <= balance)
        {
           balance -= amount;
        }
        return balance;
    }
    
    public void setBalance(double current)
    {
        balance = current;
    }
    
    public double getBalance()
    {
        return balance;   
    }
    
    public abstract double onlinePurchase(double price);
    public abstract String getLevel();
}
