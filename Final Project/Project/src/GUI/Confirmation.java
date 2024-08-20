package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Sheldon
 * Overview: Class that displays a choice box for the user. This box presents the user with
 * two choices, "Yes" and "No" during an action this allows the user to choose to proceed or 
 * cancel the action by choosing "Yes" or "No"
 * 
 * AF(c) = Confirmation box with a title and message that allows the user to proceed or 
 * cancel an action by selecting "Yes" or "No"
 * 
 * 
 * RI(c) = "Yes" or "No" is selected
 * 
 */
public class Confirmation 
{
    static boolean close;
    
    public static boolean displayConfirm(String title, String message)
    {
        Stage Cwindow = new Stage();
        Cwindow.initModality(Modality.APPLICATION_MODAL);
        Cwindow.setTitle(title);
        Cwindow.setMinWidth(200);
        Label label = new Label();
        label.setText(message);
        
        Button yes = new Button("Yes");
        Button no = new Button("No");

        yes.setOnAction(e -> {
           close = true;
           Cwindow.close();
        });
        no.setOnAction(e -> {
           close = false;
           Cwindow.close();
        }); 
        if (close)
        {
            
        }
        
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yes, no);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        Cwindow.setScene(scene);
        Cwindow.showAndWait();
        
        return close;
    }
}
