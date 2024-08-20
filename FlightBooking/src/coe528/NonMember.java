/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528;
/**
 *
 * @author Sheldon Cerejo
 */
public class NonMember extends Passenger
{
     public NonMember(String name, int age)
     {
         super(name, age);
     }
     @Override
     public double applyDiscount(double p)
    {
        if (age > 65)
        {
            return p - (0.1 * p);//50% discount
        }
        else
        {
            return p;//no discount
        }   
    }
}
