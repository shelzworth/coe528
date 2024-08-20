package coe528.lab3;

/**
 *
 * @author Sheldon Cerejo
 */
public class LinkedDigitCounter extends AbstractCounter
{
    private final Counterinterface leftneighbor;
    private final int counter;

    public LinkedDigitCounter(int counter, Counterinterface leftneighborCounter)
    {
        this.counter = counter;
        this.leftneighbor = leftneighborCounter;
    }

    public Counterinterface getleftneighbor()
    {
        return leftneighbor;
    }
}


    