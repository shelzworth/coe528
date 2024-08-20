package coe528;
/**
 *
 * @author Sheldon Cerejo
 */
public class Flight 
{
    //variables
    private int flightNumber;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    private String origin;
    private String destination;
    private String departureTime;
    
    public Flight(int flightNumber,int capacity, double originalPrice, String origin, String destination, String departureTime)
    {
        //constructor has the same name as the class
     
        //initialization
       this.flightNumber = flightNumber; this.capacity = capacity; this.numberOfSeatsLeft = capacity; this.originalPrice = originalPrice;
       this.origin = origin; this.destination = destination; this.departureTime = departureTime;  
       
        //comparing destination and origin to see if they are the same
       if(destination.equals(this.origin))
       {
           throw new IllegalArgumentException("You cannot fly to the same place!");
       } 
    }  
    
    //getter and setter methods
    //flightNumber
    public void setflightNumber(int flightNumber)
    {
       this.flightNumber = flightNumber;
       //error message
         if(flightNumber < 0)
       {
           throw new IllegalArgumentException("Flight number can't be negative");
           
       } 
    }
    public int getflightNumber()
    {
        return flightNumber;
    }
    
    //capacity
    public void setcapacity(int capacity)
    {
        //error message
         if(capacity < 0)
       {
           throw new IllegalArgumentException("Capacity can't be can't be less than 0.");
           
       } 
       this.capacity = capacity;
    }
    public int getcapacity()
    {
        return capacity;
    }
    
    
    //numberOfSeatsLeft
    public void setnumberOfSeatsLeft(int numberOfSeatsLeft)
    {
        //error message
         if(numberOfSeatsLeft < 0)
       {
           throw new IllegalArgumentException("No more seats are left.");
           
       } 
       this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
    public int getnumberOfSeatsLeft()
    {
        return numberOfSeatsLeft;
    }
    
    
    //originalPrice
    public void setoriginalPrice(double originalPrice)
    {
         //error message
         if(originalPrice < 0)
       {
           throw new IllegalArgumentException("Price can't be less than free.");
           
       }
       this.originalPrice = originalPrice;
    }
    public double getoriginalPrice()
    {
        return originalPrice;
    }
    
        
    //origin
    public void setorigin(String origin)
    {
        this.origin = origin;
    }
    public String getorigin()
    {
        return origin;
    }
    
    
     //destination
    public void setdestination(String destination)
    {
        this.destination = destination;
    }
    public String getdestination()
    {
        return destination;
    }
    
    
    //departure time
    public void setdepartureTime(String departureTime)
    {
        this.departureTime = departureTime;
    }
    public String getdepartureTime()
    {
        return departureTime;
    }
    
    
    //bookASeat
    public boolean bookASeat(int numberOfSeatsLeft)
    {

        if (numberOfSeatsLeft > 0)
        {
            numberOfSeatsLeft--;
            return true; 
        }
        else
        {
            return false;
        }  
    }
    //override for the ToString
    @Override
    public String toString()
    { 
       return("Flight " + flightNumber + ", " + origin + " to " + destination + ", " + departureTime + " original price: " + originalPrice + " dollars");
    }
}