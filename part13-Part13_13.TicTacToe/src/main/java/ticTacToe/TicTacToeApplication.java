package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.geometry.Insets;


public class TicTacToeApplication extends Application {
    private String currentPlayer = "X";
    private ArrayList<Button> buttons = new ArrayList<>();
    
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
    
    @Override
    public void start(Stage stage){
        //Specify the elements that will be part of the UI
        BorderPane layout = new BorderPane();
        Label status = new Label("Turn: " + currentPlayer);
        status.setFont(Font.font("Monospaced", 25));

        GridPane gameBoard = new GridPane();
        gameBoard.setPadding(new Insets(10, 10, 10, 10));
        gameBoard.setHgap(10);
        gameBoard.setVgap(10);
        
        for(int i = 0; i < 9; i++){
            Button button = new Button();
            button.setFont(Font.font("Monospaced", 25));
            button.setMinSize(70,70);
            button.setMaxSize(70,70);
            
            ///this is where I'll build all the logic about what the button do
            button.setOnMouseClicked((event) -> {
               if(isBlank(button)){
                   //enter the appropriate marker (x/o)
                   button.setText(currentPlayer);
                   //check to see if there is a winner
                   if(checkIfWinner()){
                       status.setText("The end! " + currentPlayer + " wins!");
                       gameEnd();
                   } else if(checkIfDraw()){ //check to see if there is a draw
                       status.setText("It's a draw!");
                       gameEnd();
                   } else { //if the game continues, switch the marker for current turn
                       switchPlayer();
                       status.setText("Turn: " + currentPlayer);
                   }
               }
            });
            
            //add buttons to arrayList
            buttons.add(button);
        }
        
        //add buttons from arrayList to GridPane
        int count = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                gameBoard.add(buttons.get(count),i,j);
                count++;
            }
        }
        
        Button resetButton = new Button("Reset");
        resetButton.setMinSize(70,40);
        resetButton.setMaxSize(70,40);
        resetButton.setPadding(new Insets(10, 10, 10, 10));
        resetButton.setFont(Font.font("Monospaced", 14));
        //resetButton. setStyle("-fx-background-color: #ff0000; ");
        
        
        resetButton.setOnMouseClicked((event) -> {
            for(Button button : buttons){
                button.setText("");
                button.setDisable(false);
                currentPlayer = "X";
                status.setText("Turn: " + currentPlayer);
            }
        });
        
        
        
        layout.setTop(status);
        layout.setCenter(gameBoard);
        layout.setBottom(resetButton);
        layout.setAlignment(resetButton, Pos.BOTTOM_RIGHT);
        
        Scene scene = new Scene(layout);
        
        stage.setScene(scene);
        stage.show();

    }
    
    public boolean isBlank(Button button){
        return button.getText().isEmpty();
    }
    
    public boolean checkVerticals(){
        if(threeFilledAndMatch(0,3,6) ||
            threeFilledAndMatch(1,4,7) ||
                threeFilledAndMatch(2,5,8)){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkHorizontals(){
        if(threeFilledAndMatch(0,1,2) ||
            threeFilledAndMatch(3,4,5) ||
                threeFilledAndMatch(6,7,8)){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkDiagonals(){
        if (threeFilledAndMatch(0,4,8) || threeFilledAndMatch(2,4,6)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkIfWinner(){
        return (checkDiagonals() || checkVerticals() || checkHorizontals());
    }
    
    public boolean checkIfDraw(){
        for(Button button:buttons){
            if(button.getText().isEmpty()){
                return false;
            }
        }
        return true;
    }
    
    public boolean threeFilledAndMatch(int a, int b, int c){
        if(!buttons.get(b).getText().isEmpty() && 
                buttons.get(a).getText().equals(buttons.get(b).getText()) && 
                buttons.get(a).getText().equals(buttons.get(c).getText())){
            return true;
        } else {
            return false;
        }
    }
    
    public void gameEnd(){
        for(Button button: buttons){
            button.setDisable(true);
        }
    }
    
    public void switchPlayer(){
        if(currentPlayer.equals("X")){
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
        
    }
    
    
}
