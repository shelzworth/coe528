package coe528.lab3;

/**
 *
 * @author Sheldon Cerejo
 */
public class Odometer implements Counterinterface 
{
    private LinkedDigitCounter[] counters;
    private DigitCounter zero;
    private int numOfCounters;

    public Odometer(int n)
    {
        if (n < 1)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.numOfCounters = n;
            counters = new LinkedDigitCounter[numOfCounters - 1];
            zero = new DigitCounter(0);
            if (n > 1)
            {
                counters[0] = new LinkedDigitCounter(0, zero);
                for (int index = 1; index < n - 1; index++)
                {
                    counters[index] = new LinkedDigitCounter(0, counters[index - 1]);
                }
            }
        }
    }

    @Override
    public String count()
    {
        StringBuilder value = new StringBuilder();
        value.append(zero.count());
        for (int index = 0; index < (numOfCounters - 1); index++)
        {
            value.append(counters[index].count());
        }
        return value.toString();
    }

    @Override
    public void increment()
    {
        if (numOfCounters == 1)
        {
            zero.increment();
        }
        else
        {
            counters[numOfCounters - 2].increment();
            if (counters[numOfCounters - 2].count().equals("0"))
            {
                incrementLeftNeighbor(counters[numOfCounters - 2]);
            }
        }
    }

    private void incrementLeftNeighbor(LinkedDigitCounter currentCounter)
    {
        if (currentCounter.getleftneighbor() instanceof LinkedDigitCounter)
        {
            LinkedDigitCounter leftNeighbor = (LinkedDigitCounter) currentCounter.getleftneighbor();
            leftNeighbor.increment();
            if (leftNeighbor.count().equals("0"))
            {
                incrementLeftNeighbor(leftNeighbor);
            }
        }
        else
        {
            currentCounter.getleftneighbor().increment();
        }
    }

    @Override
    public void decrement()
    {
        if (numOfCounters == 1)
        {
            zero.decrement();
        }
        else
        {
            counters[numOfCounters - 2].decrement();
            if (counters[numOfCounters - 2].count().equals("9"))
            {
                decrementLeftNeighbor(counters[numOfCounters - 2]);
            }
        }
    }

    private void decrementLeftNeighbor(LinkedDigitCounter currentCounter)
    {
        if (currentCounter.getleftneighbor() instanceof LinkedDigitCounter)
        {
            LinkedDigitCounter leftNeighbor = (LinkedDigitCounter) currentCounter.getleftneighbor();
            leftNeighbor.decrement();
            if (leftNeighbor.count().equals("9"))
            {
                decrementLeftNeighbor(leftNeighbor);
            }
        }
        else
        {
            currentCounter.getleftneighbor().decrement();
        }
    }

    @Override
    public void reset()
    {
        zero.reset();
        for (int index = 0; index < (numOfCounters - 1); index++)
        {
            counters[index].reset();
        }
    }
}
