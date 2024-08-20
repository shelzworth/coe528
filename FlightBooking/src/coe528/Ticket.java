package coe528;
/**
 *
 * @author Sheldon Cerejo
 */
public class Ticket 
{
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int number;
    private static int counter = 0;
    
public Ticket(Passenger p, Flight flight, double price)
{
    //initialization
    this.passenger = p;
    this.flight = flight;
    this.price = price;
    this.number = counter++;
    
}
//Setters and Getters
//Passenger 
public void setPassenger(Passenger p)    
{
    this.passenger = p;

}
public Passenger getPassenger()
{
    return passenger;
}

//Flight
public void setFlight(Flight flight)
{
    this.flight = flight;
}
public Flight getFlight()
{
    return flight;
}

//Price
public void setPrice(double price)
{
    if(price < 0)
    {
        throw new IllegalArgumentException("Price can't be less than free.");
    }
    this.price = price;
}
public double getPrice()
{
    return price;
}
//override for the ToString
@Override
public String toString()
{
    return("\n" + passenger.getName() + ", Flight " + flight.getflightNumber() + ", " + flight.getorigin() + " to " + flight.getdestination()
            + ", " + flight.getdepartureTime() + ", original price: " + flight.getoriginalPrice() + "$, Discounted Price: " + price);
}
}
