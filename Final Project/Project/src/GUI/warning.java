package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.*;


/**
 *
 * @author Sheldon Cerejo
 * This class is a warning box, displaying a message to the user when a change happens.
 * This class is immutable state does not change.
 * 
 * Abstraction Function
 * AF(c) = a warning box that allows the program to communicate to the user through a title and message which can be closed.
 * 
 * 
 * RI = title is != null || empty, message is != null.
 * 
 * 
 */

public class warning
{
    public static void display(String title, String message)
    {
        
        assert repOk(title, message);
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        
        Label label = new Label();
        label.setText(message);
        Button exit = new Button("Close");
        exit.setOnAction(e -> window.close());
        
        VBox layout = new VBox(8);
        layout.getChildren().addAll(label, exit);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, 300, 100);
        window.setScene(scene);
        window.showAndWait();
        
    }
    private static boolean repOk(String title, String message) 
    {
        return title != null && !title.isEmpty() && message != null;
    }
}
