package coe528;
/**
 *
 * @author Sheldon Cerejo
 */
//abstract class
public abstract class Passenger 
{
    //instance variables
    private String name;
    public int age;
    
public Passenger(String name, int age)
{
    //Initialization
    this.name = name;
    this.age = age;
}

//Setter and Getters
//name
public void setName(String name)
{
    this.name = name;
}
public String getName()
{
    return name;
}
//age
public void setAge(int age)
{
    this.age = age;
}
public int getAge()
{
    if(age < 0)
    {
        throw new IllegalArgumentException("You can not have a negative age");
    }
    return age;
}
//abstract method for discount
public abstract double applyDiscount(double p);
}
