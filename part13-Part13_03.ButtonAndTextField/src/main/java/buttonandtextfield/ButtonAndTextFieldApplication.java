package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application{

    @Override
    public void start(Stage window){
        Button button = new Button("Here's a button");
        TextField textField = new TextField("TEXT!!!");
        
        FlowPane components = new FlowPane();
        
        //components.getChildren().add(button);
        //components.getChildren().add(textField);
        components.getChildren().addAll(button, textField);
        
        Scene scene = new Scene(components);
        
        window.setScene(scene);
        window.show();
    }
    
    
    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

}
