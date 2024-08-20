package GUI;

import java.util.HashSet;
import java.util.Set;
//important
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;

import Project.Customer;
import Project.Manager;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.geometry.Insets;



/**
 *
 * @author Sheldon Cerejo
 * Overview: Graphical User Interface(GUI) for the banking system
 * This class is mutable since states are updated in specific scenarios.
 * 
 * AF(c) = GUI for logging in, logging out as well as managing customers and customers managing finances.
 * 
 * 
 * RI(c) = manager is != null && customersList != null
 * 
 * 
 */
public class GUI extends Application
{
    Stage LoginWindow; 
    private static Manager manager = new Manager();
    private static ArrayList<Customer> customersList = new ArrayList<>();
    private Customer online;
    @Override
    public void start(Stage primaryStage) 
    {
        //window
        LoginWindow = primaryStage;
        
        
        //Labels and TextFields
        Label main = new Label();
        main.setStyle("-fx-font-size: 24px;");
        main.setText("Welcome to the Online Banking System");
        Label lblUser = new Label();
        lblUser.setText("Username: ");
        Label lblPass = new Label();
        lblPass.setText("Password: ");
        TextField username = new TextField();
        username.setPromptText("Username");
        TextField password = new TextField();
        password.setPromptText("Password");
        Label balanceLbl = new Label();
        
        //login/signout buttons
        Button loginbtn = new Button();
        loginbtn.setText("Login");
        Button SignOutbtn = new Button();
        SignOutbtn.setText("Sign Out");
        
        GridPane layoutMain = new GridPane();
        layoutMain.setPadding(new Insets(10,10,10,10));
        layoutMain.setVgap(8);
        layoutMain.setHgap(2);
                
        
        
        
        layoutMain.setConstraints(lblUser, 0, 1);
        layoutMain.setConstraints(lblPass, 0, 2);
        layoutMain.setConstraints(password, 1, 2);
        layoutMain.setConstraints(username, 1, 1);
        layoutMain.setAlignment(Pos.CENTER);
        layoutMain.getChildren().addAll( lblUser, username, lblPass,  password);
        
       
        
        
        //Layout Login    
        VBox layoutLogin = new VBox(20);
        layoutLogin.setAlignment(Pos.CENTER);
        
        layoutLogin.getChildren().addAll(main, layoutMain, loginbtn);
        
        Scene Login = new Scene(layoutLogin, 900, 900);
        layoutLogin.setStyle("-fx-background-color: #acd5f4;"); 


        primaryStage.setTitle("Login");
        primaryStage.setScene(Login);
        primaryStage.show();
        
        //Layout Customer
        Button SignOutbtnCustomer = new Button();
        SignOutbtnCustomer.setText("Sign Out");
        SignOutbtnCustomer.setOnAction(e -> 
        {
            if(Confirmation.displayConfirm("Confirmation", "Do you want to sign out?"))
            {
                LoginWindow.setScene(Login);
                primaryStage.setTitle("Login");
            }
        });
       // Layout for Customer
        Label customerTitle = new Label("Logged in as Customer");
        customerTitle.setStyle("-fx-font-size: 24px;");
        Label accountLevelLabel = new Label("Account Level: ");
        Label accountLevelValue = new Label();
        VBox layoutDeposit = new VBox(20);
        VBox layoutWithdraw = new VBox(20);
        VBox layoutPurchase = new VBox(20);

        Label Depositlbl = new Label("Deposit Money");
        TextField DepositTF = new TextField();
        DepositTF.setPromptText("Enter Amount");
        
        //Deposit
        Button Depositbtn = new Button("Deposit");
        Depositbtn.setOnAction(e -> 
        {
        String amountText = DepositTF.getText();
        double depoBalance = Double.parseDouble(balanceLbl.getText());
        online.setBalance(depoBalance);
        if(amountText != null)
        {
            double amount = Double.parseDouble(amountText);
            if (amount > 0)
            {
                if(Confirmation.displayConfirm("Confirmation", "Do you want to deposit $" + amount + "?"))
                {
                     
                      online.deposit(amount);
                      warning.display("Deposit Successful", "You have successfully deposited $" + amount + ".");
                      balanceLbl.setText(Double.toString(online.getBalance()));
                      accountLevelLabel.setText("Account Level: " + online.getAccountLevel());
                      DepositTF.clear();
                }
            }
        }
        });

        Label Withdrawlbl = new Label("Withdraw Money");
        TextField WithdrawTF = new TextField();
        WithdrawTF.setPromptText("Enter Amount");
        
        //Withdraw
        Button Withdrawbtn = new Button("Withdraw");
        Withdrawbtn.setOnAction(e -> 
        {
        String amountTextW = WithdrawTF.getText();
        double withdrawalBalance = Double.parseDouble(balanceLbl.getText());
        online.setBalance(withdrawalBalance);
        if(amountTextW != null)
        {
            double amountW = Double.parseDouble(amountTextW);
            if (amountW > 0)
            {
                if(Confirmation.displayConfirm("Confirmation", "Do you want to withdraw $" + amountW + "?"))
                {
                      
                      online.withdraw(amountW);
                      warning.display("Withdrawl Successful", "You have successfully withdrawn $" + amountW + ".");
                      balanceLbl.setText(Double.toString(online.getBalance()));
                      accountLevelLabel.setText("Account Level: " + online.getAccountLevel());
                      WithdrawTF.clear();
                }
            }
        }
        });

        layoutDeposit.getChildren().addAll(Depositlbl, DepositTF, Depositbtn);
        layoutDeposit.setAlignment(Pos.CENTER);
        layoutWithdraw.getChildren().addAll(Withdrawlbl, WithdrawTF, Withdrawbtn);
        layoutWithdraw.setAlignment(Pos.CENTER);
        
        VBox layoutCustomerMain = new VBox(20);
        layoutCustomerMain.setStyle("-fx-background-color: #c4e09b");
        Label Purchaselbl = new Label("Purchase Online (Must be over $50)");
        //Online Purchase
        Button purchaseButton = new Button("Make Purchase");
        TextField purchaseAmountField = new TextField();
        purchaseAmountField.setPromptText("Purchase Amount");
        
        
        purchaseButton.setOnAction(e -> {
        String purchaseamountText = purchaseAmountField.getText();
        double purchaseBalance = Double.parseDouble(balanceLbl.getText());
        online.setBalance(purchaseBalance);
        if(purchaseamountText != null)
        {
            double amountP = Double.parseDouble(purchaseamountText);
            if (amountP > 0)
            {
                if(Confirmation.displayConfirm("Confirmation", "Do you want to purchase an item for $" + amountP + "? Fees may apply, Silver - $20, Gold - $10, Platinum - No Fee."))
                {
                      
                      online.onlinePurchase(amountP);
                      warning.display("Purchase Successful", "You have successfully purchased an item for $" + amountP + ".");
                      balanceLbl.setText(Double.toString(online.getBalance()));
                      accountLevelLabel.setText("Account Level: " + online.getAccountLevel());
                      purchaseAmountField.clear();
                }
            }
        }
        });


        layoutPurchase.getChildren().addAll(Purchaselbl, purchaseAmountField, purchaseButton);
        layoutPurchase.setAlignment(Pos.CENTER);

        GridPane Customerrow = new GridPane();
        Customerrow.setPadding(new Insets(10, 10, 10, 10));
        Customerrow.setHgap(20);
        Customerrow.setVgap(20);
        Customerrow.setAlignment(Pos.CENTER);

        
        Customerrow.add(layoutDeposit, 0, 0); 
        Customerrow.add(layoutPurchase, 1, 0);  
        Customerrow.add(layoutWithdraw, 2, 0); 
        
        
        
        
        layoutCustomerMain.getChildren().addAll(customerTitle, accountLevelLabel, balanceLbl, accountLevelValue, Customerrow, SignOutbtnCustomer);

        Scene CustomerScene = new Scene(layoutCustomerMain, 900, 900);

        
        
        layoutCustomerMain.setAlignment(Pos.CENTER);
        
        
        //Layout Manager
        Label managerTitle = new Label("Logged in as Manager");
        managerTitle.setStyle("-fx-font-size: 24px;");
        VBox managerMain = new VBox(10);
        //Contents
        Label addUserM = new Label ("Add Customers");
        Label deleteUserM = new Label ("Delete Customers");
        TextField addUser = new TextField();
        addUser.setPromptText("New Customer");
        TextField addPass = new TextField();
        addPass.setPromptText("New Customer Password");
        TextField deleteUser = new TextField();
        deleteUser.setPromptText("Delete Customer");
        Button addCustomerbtn = new Button("Add Customer");
        Button deleteCustomerbtn = new Button("Remove Customer");

        VBox managerAddCustomer = new VBox(5);
        managerAddCustomer.getChildren().addAll(addUserM, addUser, addPass, addCustomerbtn);
        managerAddCustomer.setAlignment(Pos.CENTER);
        VBox managerDeleteCustomer = new VBox(5);
        managerDeleteCustomer.getChildren().addAll(deleteUserM, deleteUser, deleteCustomerbtn);
        managerDeleteCustomer.setAlignment(Pos.CENTER);

        
        GridPane row = new GridPane();
        row.setPadding(new Insets(10,10,10,10));
        row.setHgap(20);
        row.setConstraints(managerAddCustomer, 0, 1);
        row.setConstraints(managerDeleteCustomer, 1, 1);
        row.setAlignment(Pos.CENTER);
        row.getChildren().addAll( managerAddCustomer, managerDeleteCustomer);
        
        
        managerMain.getChildren().addAll(managerTitle, row, SignOutbtn);
        Scene ManagerScene = new Scene(managerMain, 900, 900);
        managerMain.setAlignment(Pos.CENTER);
        managerMain.setStyle("-fx-background-color: #e0c39b");

        
        addCustomerbtn.setOnAction(e -> {
            String addedUser = addUser.getText();
            String addedPass = addPass.getText();
            Manager.addCustomer(addedUser, addedPass);
            warning.display("Successful Added Customer", "You have successfully added " + addedUser + ".");
            addUser.clear();
            addPass.clear();
        
            //debugging statements
            System.out.println("Customer list after addition:");
            for (Customer customerList : Manager.getCustomers()) {
                System.out.println("Username: " + customerList.getUsername());
            }
        });
        
            deleteCustomerbtn.setOnAction(e -> {
            String deletedUser = deleteUser.getText();
            if(deletedUser != null)
            {
                if(Confirmation.displayConfirm("Confirmation", "Do you want to delete " + deletedUser + "?"))
                {
                Manager.deleteCustomer(deletedUser);
                deleteUser.clear();
                }
                else {
                deleteUser.clear();
                }
            }
        });
        
        //Login
        loginbtn.setOnAction(e -> {
        String user = username.getText();
        String pass = password.getText();

        System.out.println("Attempting login with Username: " + user + ", Password: " + pass);

    if (user.equals(manager.getUsername()) && pass.equals(manager.getPassword())) 
    {
        LoginWindow.setScene(ManagerScene);
        System.out.println("Logged in as Manager");
         primaryStage.setTitle("Admin");
    } else {
        Customer customer = findCustomer(user, pass);

        if (customer != null) 
        {
            online = customer;
            LoginWindow.setScene(CustomerScene);
            accountLevelLabel.setText("Account Level: " + customer.getAccountLevel());
            String balanceText = Double.toString(online.getBalance());
            balanceLbl.setText(balanceText);
            customerTitle.setText("Logged in as " + customer.getUsername());
            System.out.println("Logged in as Customer: " + customer.getUsername());
             primaryStage.setTitle(customer.getUsername());
        } 
        else 
        {
            warning.display("Login Error", "Invalid username or password.");
        }
    }
         username.clear();
         password.clear();
            });
        
        //signOut
        SignOutbtn.setOnAction(e -> 
        {
            if(Confirmation.displayConfirm("Confirmation", "Do you want to sign out?"))
            {
                LoginWindow.setScene(Login);
                primaryStage.setTitle("Login");
            }
        });
        // Load customers from files
        loadCustomersFromFiles();
    }
    private Customer findCustomer(String username, String password) {
        for (Customer customer : manager.getCustomers()) {
            System.out.println("Checking customer: " + customer.getUsername() + ", " + customer.getPassword());
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }
 
 private void loadCustomersFromFiles() {
        File directory = new File(System.getProperty("user.dir"));
        for (File file : directory.listFiles()) {
            if (file.getName().endsWith(".txt")) {
                try {
                    Customer customer = Customer.loadFile(file.getName());
                    customersList.add(customer);
                } catch (IOException e) {
                    System.err.println("Error retrieving customer file.");
                }
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
