package Project;


/**
 *
 * @author Sheldon Cerejo
 * 
 * Overview: Represents a Gold level account that allows online purchases using
 * a specified fee if the money is available.
 * 
 * This class is mutable since balance is modified.
 * 
 * 
 * AF(c) = A Gold level bank account that charges a fixed fee when making online
 * purchases of at least $50
 * 
 * RI(c) = balance <= 0, price < 50
 * 
 */
public class Gold extends BankAccount
{
    private final double fee = 10.00;
    public Gold()
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
        double total = price + fee;
        
        if(balance >= total)
        {
            balance = balance - total;
            return total;
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
        return "Gold";
    }
}
