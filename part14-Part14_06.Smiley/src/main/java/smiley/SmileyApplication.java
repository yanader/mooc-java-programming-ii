package smiley;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class SmileyApplication extends Application{

    @Override
    public void start(Stage stage) {
        BorderPane borderPane = new BorderPane();
        Canvas canvas = new Canvas (400,400);
        borderPane.setCenter(canvas);
        
        GraphicsContext painter = canvas.getGraphicsContext2D();
        
        painter.setFill(Color.WHITE);
        painter.setFill(Color.BLACK);
        painter.fillRect(100, 75, 50, 50);
        painter.fillRect(250, 75, 50, 50);
        
        painter.fillRect(50, 200, 50, 50);
        painter.fillRect(300, 200, 50, 50);
        
        painter.fillRect(100, 250, 200, 50);
        
        canvas.setOnMouseDragged((event) -> {
            double xLocation = event.getX();
            double yLocation = event.getY();
            painter.setFill(Color.BLACK);
            painter.fillOval(xLocation, yLocation, 4, 4);
        });
        
        Scene view = new Scene(borderPane);

        stage.setScene(view);
        stage.show();
    }    
    
    
    
    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }



}
