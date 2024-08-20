package Project;

import java.io.*;
/**
 * 
 * @author Sheldon Cerejo
 * Overview: Represents a customer in the system, holding all of a customers necessary information.
 * 
 * This class is mutable since properties can be modified after creation.
 * 
 * AF(c) = A customer with a username, password, bank account of level Silver Gold or Platinum, role = "Customer"
 * and account level based on balance.
 * 
 * RI(c) = Strings Username, Password, and Role != null.
 *     account is a non-null BankAccount object (Silver, Gold, or Platinum).
 *  
 * 
 * 
 */
public class Customer {
    private String Username;
    private String Password;
    private BankAccount account;
    private String Role = "Customer";
    private String Level;

    public Customer(String user, String pass) {
        this.Username = user;
        this.Password = pass;
        this.account = new Silver();
        File CustomerAccountData = new File(user + ".txt");
    }

    public void setUsername(String user) {
        this.Username = user;
    }

    public String getUsername() {
        return Username;
    }

    public void setPassword(String pass) {
        this.Password = pass;
    }

    public String getPassword() {
        return Password;
    }

    public double deposit(double amount) {
        return this.account.deposit(amount);
    }

    public double withdraw(double amount) {
        return this.account.withdraw(amount);
    }

    public void setBalance(double balance) {
        this.account.setBalance(balance);
    }

    public double getBalance() {
        return this.account.getBalance();
    }

    public double onlinePurchase(double price) {
        return this.account.onlinePurchase(price);
    }

    public void setAccountLevel() {
        this.Level = this.account.getLevel();
    }

    public void setRole(String role) {
        this.Role = role;
    }

    public String getRole() {
        return Role;
    }

    public String getAccountLevel() {
        double balance = this.account.getBalance();

        if (balance < 10000.0) {
            this.account = new Silver();
        } else if (balance < 20000.0) {
            this.account = new Gold();
        } else {
            this.account = new Platinum();
        }

        return this.account.getLevel();
    }
    public void saveInfo() throws IOException
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(Username + ".txt")))
        {
            writer.write(Username);
            writer.write(Password);
            writer.write(Role);
            writer.write(Double.toString(account.getBalance()));

        }
    }
    public static Customer loadFile(String nameOfFile) throws IOException
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(nameOfFile)))
        {
            String user = reader.readLine();
            String pass = reader.readLine();
            double balance = Double.parseDouble(reader.readLine());
            Customer customer = new Customer(user, pass);
            customer.setBalance(balance);
            customer.setAccountLevel();
            return customer;
        }
    }
}

