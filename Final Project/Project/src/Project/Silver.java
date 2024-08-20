package Project;

/**
 *
 * @author Sheldon Cerejo
 * 
 * Overview: Represents a Silver level account that allows online purchases using
 * a specified fee if the money is available.
 * 
 * This class is mutable since balance is modified.
 * 
 * 
 * AF(c) = A silver level bank account that charges a fixed fee when making online
 * purchases of at least $50
 * 
 * RI(c) = balance <= 0, price < 50
 * 
 */
public class Silver extends BankAccount
{
    private final double fee = 20.00;
    public Silver()
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
        return "Silver";
    }
}
