package coe528.lab3;

public abstract class AbstractCounter implements Counterinterface
{
    protected int value;
    public AbstractCounter()
    {
        value = 0;
    }
    @Override
    public String count()
    {
        return Integer.toString(value);
    }
    @Override
    public void increment()
    {
        if(value < 9)
        {
            value++;
        }
        else
        {
            value = 0;
        }
    }
    @Override
    public void decrement()
    {
        if(value > 0)
        {
            value--;
        }
        else
        {
            value = 9;
        }
    }
    @Override
    public void reset()
    {
        value = 0;
    }
}
