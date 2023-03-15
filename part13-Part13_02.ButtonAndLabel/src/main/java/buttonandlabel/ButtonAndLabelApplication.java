package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application{
    
    public void start(Stage window){
        Label textLabel = new Label("Here's my text!");
        Button button = new Button("Check out this button");
        
        FlowPane components = new FlowPane();
        
        components.getChildren().add(textLabel);
        components.getChildren().add(button);
        
        Scene view = new Scene(components);
        
        window.setScene(view);
        window.show();
    }
    
    
    
    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
