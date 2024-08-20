package coe528;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlightTest {

    @Test
    public void testConstructor() {
        Flight flight = new Flight(1030, 150, 1000.0, "Toronto", "Kolkata", "03/02/99 7:50 pm");
        assertNotNull(flight);
        assertEquals(1030, flight.getflightNumber());
        assertEquals("Toronto", flight.getorigin());
        assertEquals("Kolkata", flight.getdestination());
        assertEquals("03/02/99 7:50 pm", flight.getdepartureTime());
        assertEquals(150, flight.getcapacity());
        assertEquals(150, flight.getnumberOfSeatsLeft());
        assertEquals(1000.0, flight.getoriginalPrice(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor()
    {
        Flight flight2 = new Flight(1030, 150, 1000.0, "Toronto", "Toronto", "03/02/99 7:50 pm");
        assertEquals("You cannot fly to the same place!", flight2.toString());

    }

    @Test
    public void testGettersAndSetters() 
    {
        Flight flight = new Flight(1030, 150, 1000.0, "Toronto", "Kolkata", "03/02/99 7:50 pm");

        flight.setflightNumber(3030);
        assertEquals(3030, flight.getflightNumber());

        flight.setcapacity(400);
        assertEquals(400, flight.getcapacity());

        flight.setnumberOfSeatsLeft(200);
        assertEquals(200, flight.getnumberOfSeatsLeft());

        flight.setorigin("Halifax");
        assertEquals("Halifax", flight.getorigin());

        flight.setdestination("Hawaii");
        assertEquals("Hawaii", flight.getdestination());

        flight.setdepartureTime("03/03/99 8:30 pm");
        assertEquals("03/03/99 8:30 pm", flight.getdepartureTime());

        flight.setoriginalPrice(1500.0);
        assertEquals(1500.0, flight.getoriginalPrice(), 0.001);
    }

    @Test
    public void testBookASeat() 
    {
        Flight flight = new Flight(1030, 150, 1000.0, "Toronto", "Kolkata", "03/02/99 7:50 pm");
        assertTrue(flight.bookASeat(150));
        assertEquals(149, flight.getnumberOfSeatsLeft() - 1);

        for (int i = 1; i < flight.getcapacity(); i++) 
        {
            assertTrue(flight.bookASeat(flight.getnumberOfSeatsLeft() - i));
        }
        assertEquals(150, flight.getnumberOfSeatsLeft());
        //assertFalse(flight.bookASeat(flight.getnumberOfSeatsLeft()));
    }

    @Test
    public void testToString() 
    {
        Flight flight = new Flight(1030, 150, 1000.0, "Toronto", "Kolkata", "03/02/99 7:50 pm");
        assertEquals("Flight 1030, Toronto to Kolkata, 03/02/99 7:50 pm original price: 1000.0 dollars", flight.toString());
    }
}
