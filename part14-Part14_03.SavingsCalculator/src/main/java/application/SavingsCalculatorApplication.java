package application;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.chart.XYChart;

public class SavingsCalculatorApplication extends Application{

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }
    
    @Override
    public void start(Stage stage){
        //Initialise new ComponentBuilder
        ComponentBuilder cB = new ComponentBuilder();
        
        
        //Create 3 BorderPanes and assign them to variable names
        BorderPane[] borderPanes = cB.buildBorderPanes(3);
            BorderPane mainBorderPane = borderPanes[0];
            BorderPane topSlider = borderPanes[1];
            BorderPane bottomSlider = borderPanes[2];
        
        //Create 4 labels, assign them to label names and set their text values + alignment where need.
        Label[] labels = cB.buildLabels(4);
            Label labelTopLeft = labels[0];
            Label labelTopRight = labels[1];
            Label labelBottomLeft = labels[2];
            Label labelBottomRight = labels[3];
                labelTopLeft.setText("Monthly Savings");
                labelTopRight.setText("xxxx");
                    labelTopRight.setAlignment(Pos.CENTER);
                labelBottomLeft.setText("Yearly interest rate");
                labelBottomRight.setText("x.x%");
                    labelBottomRight.setAlignment(Pos.CENTER);
        
        //Create two sliders then edit their ranges
        Slider[] sliders = cB.buildSliders(2);
            Slider savingSlider = sliders[0];
            Slider interestSlider = sliders[1];
                cB.editSlider(savingSlider, 25, 250, 25);
                cB.editSlider(interestSlider, 0, 10, 0);
        
        //create line chart
        LineChart<Number, Number> lineChart = cB.buildLineChart();
        
        //create the data series for the monthly saving
            //TODO create data series for interest/total
        XYChart.Series monthlySave = new XYChart.Series();
            monthlySave.setName("Monthly Saving");
        XYChart.Series interestSave = new XYChart.Series();
            interestSave.setName("Interest Saving");
        
        //Add functionality 
            //First, data series reading from slider
        savingSlider.valueProperty().addListener((event) -> {
            Double savings = savingSlider.getValue();
            Double interest = interestSlider.getValue()*0.01;
            monthlySave.getData().clear();
            interestSave.getData().clear();
            for(int i = 1; i <= 30; i++) {
                monthlySave.getData().add(new XYChart.Data(i, i * savings));
                interestSave.getData().add(new XYChart.Data(i, i * interest * (Double.parseDouble(((XYChart.Data)monthlySave.
                                            getData().get(i-1)).getYValue().toString())) + (i * savings)));
            }
            lineChart.getData().add(monthlySave);
            lineChart.getData().add(interestSave);
        });
        
        /*interestSlider.valueProperty().addListener((event) -> {
            Double savings = savingSlider.getValue();
            Double interest = interestSlider.getValue()*0.01;
            monthlySave.getData().clear();
            interestSave.getData().clear();
            for(int i = 1; i <= 30; i++) {
                monthlySave.getData().add(new XYChart.Data(i, i * savings));
                interestSave.getData().add(new XYChart.Data(i, i * interest * (Double.parseDouble(((XYChart.Data)monthlySave.
                                            getData().get(i-1)).getYValue().toString())) + (i * savings)));
            }
            lineChart.getData().add(monthlySave);
            lineChart.getData().add(interestSave);
        });*/
        
        
        
        
        
            //Second, labels reading from slideres
        labelTopRight.textProperty().bind(
            Bindings.format(
                "%.0f",
                savingSlider.valueProperty()
            )
        );
        labelBottomRight.textProperty().bind(
            Bindings.format(
                "%.2f",
                interestSlider.valueProperty()
            )
        );
            

        topSlider.setLeft(labelTopLeft);
        topSlider.setCenter(savingSlider);
        topSlider.setRight(labelTopRight);
        
        bottomSlider.setLeft(labelBottomLeft);
        bottomSlider.setCenter(interestSlider);
        bottomSlider.setRight(labelBottomRight);
        
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(15,15,15,15));
        
        vBox.getChildren().add(topSlider);
        vBox.getChildren().add(bottomSlider);
        
        mainBorderPane.setTop(vBox);
        mainBorderPane.setCenter(lineChart);
        
        Scene scene = new Scene(mainBorderPane);
        stage.setTitle("Interest calculator");
        stage.setScene(scene);
        stage.show();
    }

}
