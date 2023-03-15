package application;

import java.util.ArrayList;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
    
    @Override
    public void start(Stage stage){
        NumberAxis xAxis = new NumberAxis(1964,2012,4);
        NumberAxis yAxis = new NumberAxis(0,30,2);
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative Support");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of political parties");
        
        FileReader fileReader = new FileReader("partiesdata.tsv");
        Map<String, Map<Integer, Double>> series = fileReader.getSeries();
        
        //need to write the code that adds the data from the values HashMap into a bunch of series and add them into the linechart
        
        for(String s : series.keySet()){
            XYChart.Series data = new XYChart.Series();
            Map<Integer, Double> innerMap = series.get(s);
            data.setName(s);
            for(Integer year : innerMap.keySet()){
                data.getData().add(new XYChart.Data(year,innerMap.get(year)));
            }
            lineChart.getData().add(data);
        }

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

}
