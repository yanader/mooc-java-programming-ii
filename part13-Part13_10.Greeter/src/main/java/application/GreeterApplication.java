package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application{
    
    @Override
    public void start(Stage window){
        // - 1 - Scene 1
        Label label = new Label("Enter your name and start.");
        PasswordField passwordField = new PasswordField();
        Button buttonViewOne = new Button("Start");
        
        GridPane layoutOne = new GridPane();
        layoutOne.add(label,0,0);
        layoutOne.add(passwordField,0,1);
        layoutOne.add(buttonViewOne,0,2);
        
        layoutOne.setPrefSize(300, 180);
        layoutOne.setAlignment(Pos.CENTER);
        layoutOne.setVgap(10);
        layoutOne.setHgap(10);
        layoutOne.setPadding(new Insets(20,20,20,20));
        
        Scene sceneOne = new Scene(layoutOne);
        
        Label labelGreeting = new Label("Welcome ");
        
        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(labelGreeting);
        welcomeLayout.setAlignment(Pos.CENTER);
        
        
        Scene sceneTwo = new Scene(welcomeLayout);
        
        buttonViewOne.setOnAction((event) -> {
           labelGreeting.setText("Welcome " + passwordField.getText() + "!");
           window.setScene(sceneTwo);
        });
        
        window.setScene(sceneOne);
        window.show();
        
        
    }

    
    
    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
