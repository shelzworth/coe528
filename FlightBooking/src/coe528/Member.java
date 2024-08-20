
package coe528;
/**
 *
 * @author Sheldon Cerejo
 */
public class Member extends Passenger 
{
    //instance variables
    private final int yearsOfMembership;
    
    public Member(String name, int age, int yearsOfMembership) 
    {
        super(name, age);
        //initialization
        this.yearsOfMembership = yearsOfMembership;
    }
    //Overriding the Abstract apply discount method
    @Override
    public double applyDiscount(double p)
    {
        if (yearsOfMembership > 5)
        {
            return 0.5 * p;//50% discount
        }
        else if (yearsOfMembership > 1 && yearsOfMembership < 5)
        {
            return p - (0.1 * p);//10% discount
        }
        else
        {
            return p;//no discount
        }   
    }
}
