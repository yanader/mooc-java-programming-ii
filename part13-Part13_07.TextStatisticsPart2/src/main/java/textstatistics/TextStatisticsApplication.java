package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class TextStatisticsApplication extends Application {
    
    @Override
    public void start(Stage window){
        BorderPane layout = new BorderPane();
        
        HBox bottomTextComponents = new HBox();
        
        bottomTextComponents.setSpacing(20);
        
        Label letterCount = new Label("Letters: 0");
        Label wordCount = new Label("Words: 0");
        Label longestWord = new Label("The longest word is:");
        
        bottomTextComponents.getChildren().add(letterCount);
        bottomTextComponents.getChildren().add(wordCount);
        bottomTextComponents.getChildren().add(longestWord);
        
        layout.setBottom(bottomTextComponents);
        
        TextArea textArea = new TextArea("");
        
        textArea.textProperty().addListener((change, oldvalue, newValue) -> {
        int characters = newValue.length();
        String[] parts = newValue.split(" ");
        int words = parts.length;
        String longest = Arrays.stream(parts).sorted((s1, s2) -> s2.length() - s1.length()).findFirst().get();
        
        letterCount.setText("Letters: " + characters);
        wordCount.setText("Words: " + words);
        longestWord.setText("The longest word is: " + longest);
        
    });
        
        layout.setCenter(textArea);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
