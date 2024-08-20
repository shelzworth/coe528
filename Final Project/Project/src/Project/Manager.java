package Project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sheldon Cerejo
 * 
 * Overview: Represents a manager, allows the manager to create and delete users.
 * 
 * 
 * Mutable since the list of customers can be modified and altered.
 * 
 * 
 * AF(c) = A manager with username and password and a list of customer accounts with passwords and usernames.
 * 
 * 
 * 
 * RI(c) = customerList is != null and is populated with objects of type Customer.
 *         username = password = "admin"
 */
public class Manager {
    private static String username = "admin";
    private static String password = "admin";
    private static List<Customer> customerList = new ArrayList<Customer>();
    
    public static String getUsername() 
    {
        return username;
    }

    public static String getPassword() 
    {
        return password;
    }

    public static void deleteCustomer(String username)
    {
        customerList.removeIf(customerList -> customerList.getUsername().equals(username));
    }
    public static void addCustomer(String user, String pass)
    {
        customerList.add(new Customer(user, pass));
    }
    public static List<Customer> getCustomers()
    {
        return customerList;
    }
}
