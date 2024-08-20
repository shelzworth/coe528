package Project;

/**
 *
 * @author Sheldon Cerejo
 * 
 * Overview: Represents a Platinum level account that allows online 
 * purchases if the money is available.
 * 
 * This class is mutable since balance is modified.
 * 
 * 
 * AF(c) = A Platinum level bank account that charges no fee when making online
 * purchases of at least $50
 * 
 * RI(c) = balance <= 0, price < 50
 * 
 */
public class Platinum extends BankAccount
{
    public Platinum()
    {
        super();
    }
   @Override
    public double onlinePurchase(double price)
    {
        if(50 > price)
        {
            //must be 50$
            return 0.0;
        }
        
        if(balance >= price)
        {
            balance = balance - price;
            return price;
        }
        else 
        {
            //insufficient funds
            return 0.0;
        }
    }
    
    @Override
    public String getLevel()
    {
        return "Platinum";
    }
}