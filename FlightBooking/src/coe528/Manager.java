package coe528;
import java.util.ArrayList;
/**
 *
 * @author Sheldon Cerejo
 */
public class Manager 
{
    //array lists for tickets and flights
    private final ArrayList<Flight> flights;
    private final ArrayList<Ticket> issuedtickets;
    
public Manager()
    {
        //Initialization
         this.flights = new ArrayList<>();
         this.issuedtickets = new ArrayList<>();       
    }
public void createFlights()
    {
        //added flights
        flights.add(new Flight(1030, 300, 1000.0, "Toronto", "Kolkata", "03/02/99 7:50pm"));
        flights.add(new Flight(1031, 350, 1200.0, "Toronto", "Tokyo", "03/03/99 2:30am"));
        flights.add(new Flight(1032, 275, 950.0, "Toronto", "Munich", "03/03/99 6:30am"));
    }
public void displayAvailableFlights(String origin, String destination)
    {
        boolean flightFinder = false;
        //for loop that loops through every object flight of class Flight in the array flights
        //then prints out the corresponding flight information, if the flight is not full//
        for (Flight flight : flights)
        {
            if (flight.getorigin().equals(origin) && flight.getdestination().equals(destination) && flight.getnumberOfSeatsLeft() > 0)
            {
                System.out.println("Available: Flight -  " + flight.getflightNumber() + " " + flight.getorigin() + " to " + flight.getdestination() + " at " + flight.getdepartureTime());
                flightFinder = true;
            }
        }
        //Error message if the flight is unavailable based on the origin and destination
         if (!flightFinder)
            {
                System.out.println("Flight Unavailable.");
            }
    }
public Flight getFlight(int flightNumber)
    {
        //uses the flight number to loop through the flight list and returns the flight details
        for (Flight flight : flights)
        {
            if(flight.getflightNumber() == flightNumber) 
            {
                return flight;
            } 
        }
        return null;
    }
public void bookSeat(int flightNumber, Passenger p)
    {
        for(Flight flight : flights)
        {
            if(flight.getflightNumber() == flightNumber)
            {
                if (flight.bookASeat(flightNumber) && flight != null)
                {
                    double flightPrice = p.applyDiscount(flight.getoriginalPrice());
                    Ticket ticket = new Ticket(p, flight, flightPrice);
                    issuedtickets.add(ticket);
                    System.out.println("\n" + "Ticket booking successful!: " + ticket);
                }
                else 
                   System.out.println("Ticket booking unsuccessful." + "\n");
            }
        }
    }
public static void main(String[] args)
    {
        //manager and flights creation
        Manager manager = new Manager();
        manager.createFlights();
        
        manager.getFlight(1030);
        manager.getFlight(1031);
        manager.getFlight(1032);
        
        //displaying available flights from Toronto to Kolkata
        System.out.println("Flights Currently Available");
        manager.displayAvailableFlights("Toronto", "Kolkata");
        manager.displayAvailableFlights("Toronto", "Tokyo");
        manager.displayAvailableFlights("Toronto", "Munich");
        
        //Purposefully incorrect flights
        manager.displayAvailableFlights("Toronto", "London");
        manager.displayAvailableFlights("Toronto", "Toronto");
        manager.displayAvailableFlights("Toronto", "Rio de Janeiro");
        

        
        //Passengers
        Passenger member1 = new Member("Julia Chow", 32, 6);
        Passenger member2 = new Member("Julian Chow", 33, 4);
        Passenger nonmember1 = new NonMember("George Lucas", 80);
        Passenger nonmember2 = new NonMember("Hayden Christensen", 43);
        
        //Seat bookings
        manager.bookSeat(1030, member1);
        System.out.println("Seat booked for: " + member1.getName() + "\n");
        manager.bookSeat(1030, member2);
        System.out.println("Seat booked for: " + member2.getName() + "\n");
        manager.bookSeat(1031, nonmember1);
        System.out.println("Seat booked for: " + nonmember1.getName() + "\n");
        manager.bookSeat(1032, nonmember2);
        System.out.println("Seat booked for: " + nonmember2.getName() + "\n");

    }
}
