package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{

    @Override
    public void start(Stage window){
        
        BorderPane borderPaneFirstView = new BorderPane();
        Button buttonFirstView = new Button("To the second view!");
        
        borderPaneFirstView.setTop(new Label("First view!"));
        borderPaneFirstView.setCenter(buttonFirstView);
        
        Scene firstScene = new Scene(borderPaneFirstView);
        
        
        VBox vBoxSecondView = new VBox();
        Button buttonSecondView = new Button("To the third view!");
        
        vBoxSecondView.getChildren().addAll(buttonSecondView, new Label("Second view!"));
        
        Scene secondScene = new Scene(vBoxSecondView);
        
        GridPane gridPaneThirdView = new GridPane();
        Button buttonThirdView = new Button("To the first view!");
        Label labelThirdView = new Label("Third view!");
        
        gridPaneThirdView.setConstraints(labelThirdView,0,0);
        gridPaneThirdView.setConstraints(buttonThirdView,1,1);
        gridPaneThirdView.getChildren().addAll(labelThirdView, buttonThirdView);
        
        Scene thirdScene = new Scene(gridPaneThirdView);
        
        buttonFirstView.setOnAction((event) -> {window.setScene(secondScene);});
        buttonSecondView.setOnAction((event) -> {window.setScene(thirdScene);});
        buttonThirdView.setOnAction((event) -> {window.setScene(firstScene);});
        
        window.setScene(firstScene);
        window.show();
    }
    
    
    
    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
