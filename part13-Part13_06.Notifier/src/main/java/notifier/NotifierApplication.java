package notifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application{

    @Override
    public void start(Stage window){
        //FlowPane layout = new FlowPane();
        
        TextField topText = new TextField();
        Button button = new Button("Update");
        Label label = new Label();
        
        button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                label.setText(topText.getText());
            }
        });
        
        //button.setOnAction((event) -> {
        //    label.setText(topText.getText());
        //        });

         
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(topText, button, label);
        
        //layout.getChildren().add(vbox);
        
        Scene scene = new Scene(vbox);
        
        window.setScene(scene);
        window.show();
        
    }
    
    
    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
